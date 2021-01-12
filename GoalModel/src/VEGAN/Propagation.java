package VEGAN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import goalModel.*;

public class Propagation {

	public static Map<IntentionalElement, Integer> ieToPosition = new HashMap<IntentionalElement, Integer>();
	
	//METHOD FOR TESTING, WILL BE REMOVED
	public static double[][] propagate(GoalModel goalModel)
	{
		return propagate(goalModel, false);
	}
	
	public static double[][] propagate(GoalModel goalModel, boolean verbose)
	{
		List<IntentionalElement> toVisitIE = new ArrayList<IntentionalElement>();
		ieToPosition.clear();
		
		int ieP = 0;
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
		
			for (Iterator<IntentionalElement> ieIterator =actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				toVisitIE.add(ie);
				ieToPosition.put(ie, ieP++);
			}
		}
		
		double[][] result = new double[ieP][ieP];
		
		//Inicializamos la matriz
		//EL ARRAY ESTA MAL los elementos que se descomponen NO deberian aparecer en el array ya que estan COMPUESTOS por sus hijos
		for(int i=0;i<ieP;i++)
		{
			for(int j=0;j<ieP;j++)
			{
				if(i==j)	//Un elemento CONSIGO MISMO tiene MAXIMO impacto
					result[i][j] = Double.MAX_VALUE;
				else
					result[i][j] = 0;
			}
		}
		
		if(verbose)
			System.out.println("Amount of IE: " + toVisitIE.size());
		
		int forceStop = ieP*ieP + 100;
		
		while (!toVisitIE.isEmpty()) {
			
			if(forceStop-- == 0 )
			{
				System.out.println("Force to Stop propagation due Loop");
				break;
			}
			
			IntentionalElement ie = toVisitIE.remove(0);

			boolean puede_propagar = true;

			
			//Comprobacion de dependencias
			if(ie.getTrgLinks().stream().anyMatch(link -> link instanceof Dependency && toVisitIE.contains(link.getSrc())))
				puede_propagar = false;

			//Comprobacion de contribucciones
			if(ie.getSrcLinks().stream().anyMatch(link -> link instanceof Contribution && toVisitIE.contains(link.getTrgs().get(0))))
				puede_propagar = false;

			//Comprobacion de descomposiciones
			//Hay que IMPLEMENTAR varios cambios:
				//1- Un HIJO no puede propagar SIN su padre
				//2- Un PADRE no puede propagar si TODOS sus hijos no han propagado
				//3- Un PADRE puede PROPAGAR PARCIALMENTE solo a sus hijos cuando no puede impactar a nadie mas
			
			if(ie.getSrcLinks().stream().anyMatch(link -> link instanceof Decomposition && link.getTrgs().stream().anyMatch(children -> toVisitIE.contains(children))))
				puede_propagar = false;
			
			if(!puede_propagar)
			{
				if(verbose)
					System.out.println("SIN Propagar: "+ie.getName());
				
				toVisitIE.add(ie);
				continue;
			}
			
			if(verbose)
				System.out.println("Propagando: "+ie.getName());
			
			//Propagamos Dependencias
			for (Iterator<Link> linkIterator = ie.getSrcLinks().iterator(); linkIterator.hasNext();)
			{		
				Link link = (Link) linkIterator.next();
				if(!(link instanceof Dependency))
					continue;
				
				int eiSrc = ieToPosition.get(link.getSrc());
				int eiTrg = ieToPosition.get(link.getTrgs().get(0));
				
				result[eiTrg][eiSrc] = result[eiSrc][eiTrg]+100;
				
				for(int i=0;i<ieP;i++)
				{
					if(i!=eiTrg && i!=eiSrc)
						result[eiTrg][i] = result[eiTrg][i] + result[eiSrc][i];
				}
			}
			
			//Propagamos Contribuciones
			for (Iterator<Link> linkIterator = ie.getTrgLinks().iterator(); linkIterator.hasNext();)
			{		
				Link link = (Link) linkIterator.next();
				if(!(link instanceof Contribution))
					continue;
				
				int eiSrc = ieToPosition.get(link.getSrc());
				int eiTrg = ieToPosition.get(link.getTrgs().get(0));
				
				double impact = getImpact(((Contribution)link).getContributionType());
				
				result[eiSrc][eiTrg] = result[eiSrc][eiTrg] + impact;
				
				impact=impact/100;
				
				for(int i=0;i<ieP;i++)
				{
					if(i!=eiTrg && i!=eiSrc)
						result[eiSrc][i] = result[eiSrc][i] + result[eiTrg][i]*impact;
				}
			}
			
			//Falta añadir la Propagacion de las descomposiciones: Padres e Hijos
			
			//Decomposicion de HIJOS a PADRES
			if(ie.getTrgLinks().stream().anyMatch(link -> link instanceof Decomposition))
			{
				int iePos = ieToPosition.get(ie);
				
				Decomposition dec = (Decomposition)ie.getTrgLinks().stream().filter(link -> link instanceof Decomposition).findFirst().get();
				
				IntentionalElement father = dec.getSrc();
				
				int ieFather = ieToPosition.get(father);
				
				for(int i=0;i<ieP;i++)
				{
					if(i!=ieFather && i!=iePos)
						result[ieFather][i] = result[ieFather][i] + result[iePos][i];
				}
			}
			
			//Descomposicion de PADRES a HIJOS
			if(ie.getSrcLinks().stream().anyMatch(link -> link instanceof Decomposition))
			{
				int iePos = ieToPosition.get(ie);
				
				//SIEMPRE va a ser distinto de NULL debido a la condicion anterior
				Decomposition dec = (Decomposition)ie.getSrcLinks().stream().filter(link -> link instanceof Decomposition).findFirst().get();
				
				for (Iterator<IntentionalElement> ieIterator = dec.getTrgs().iterator(); ieIterator.hasNext();)
				{
					IntentionalElement child = (IntentionalElement) ieIterator.next();
					
					int ieChildPos = ieToPosition.get(child);
					
					for(int i=0;i<ieP;i++)
					{
						if(i!=ieChildPos && i!=iePos)
							result[ieChildPos][i] = result[ieChildPos][i] + result[iePos][i];
					}
				}
			}
		}
		
		return result;
	}
	
	public static double getImpact(EContribution contributionType)
	{
		switch (contributionType) {
		case P100:	return 100;
		case P75: 	return 75;
		case P50:	return 50;
		case P25:	return 25;
		case P0:	return 0;
		case N25:	return -25;
		case N50:	return -50;
		case N75:	return -75;
		case N100:	return -100;
		}
		
		return 0;
	}
	
}
