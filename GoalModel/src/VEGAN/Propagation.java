package VEGAN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import goalModel.*;

public class Propagation {

	public static Map<IntentionalElement, Integer> eiToPosition = new HashMap<IntentionalElement, Integer>();
	
	public static double[][] propagate(GoalModel goalModel)
	{
		List<IntentionalElement> toVisitIE = new ArrayList<IntentionalElement>();
		eiToPosition.clear();
		
		int eiP = 0;
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
		
			for (Iterator<IntentionalElement> ieIterator =actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				toVisitIE.add(ie);
				eiToPosition.put(ie, eiP++);
			}
		}
		
		//System.out.println("Amount of IE: " + toVisitIE.size());
		
		double[][] result = new double[eiP][eiP];
		
		//Inicializamos la matriz
		//EL ARRAY ESTA MAL los elementos que se descomponen NO deberian aparecer en el array ya que estan COMPUESTOS por sus hijos
		for(int i=0;i<eiP;i++)
		{
			for(int j=0;j<eiP;j++)
			{
				if(i==j)	//Un elemento CONSIGO MISMO tiene MAXIMO impacto
					result[i][j] = Double.MAX_VALUE;
				else
					result[i][j] = 0;
			}
		}
		
		while (!toVisitIE.isEmpty()) {
			
			IntentionalElement ie = toVisitIE.remove(0);
			if(null == ie)
				continue;

			boolean puede_propagar = true;

			
			//Comprobacion de dependencias
			if(ie.getTrgLinks().stream().anyMatch(link -> link instanceof Dependency && toVisitIE.contains(link.getSrc())))
				puede_propagar = false;

			//Comprobacion de contribucciones
			if(ie.getSrcLinks().stream().anyMatch(link -> link instanceof Contribution && toVisitIE.contains(link.getTrgs().get(0))))
				puede_propagar = false;

			/*
			//ERROR?
			//Comprobacion de descomposiciones
			if(ie.type == IntentionalElementType.Softgoal && ie.linkSrc.stream().anyMatch(relationship -> relationship instanceof Decomposition && ((Decomposition)relationship).estado == EstadoPropagacion.Nada))
				puede_propagar = false;
			 */
			
			if(false == puede_propagar)
			{
				toVisitIE.add(ie);
				continue;
			}
			
			System.out.println("Propagando: "+ie.getName());
			
			//Propagamos Dependencias
			for (Iterator<Link> linkIterator = ie.getSrcLinks().iterator(); linkIterator.hasNext();)
			{		
				Link link = (Link) linkIterator.next();
				if(!(link instanceof Dependency))
					continue;
				
				int eiSrc = eiToPosition.get(link.getSrc());
				int eiTrg = eiToPosition.get(link.getTrgs().get(0));
				
				result[eiTrg][eiSrc] = result[eiSrc][eiTrg]+100;
				
				for(int i=0;i<eiP;i++)
				{
					if(i!=eiTrg && i!=eiSrc)
						result[eiTrg][i] = result[eiTrg][i] + result[eiSrc][i];
				}
				
				//AÑADIR PROPAGACION A PADRE
			}
			
			//Propagamos Contribuciones
			for (Iterator<Link> linkIterator = ie.getTrgLinks().iterator(); linkIterator.hasNext();)
			{		
				Link link = (Link) linkIterator.next();
				if(!(link instanceof Contribution))
					continue;
				
				int eiSrc = eiToPosition.get(link.getSrc());
				int eiTrg = eiToPosition.get(link.getTrgs().get(0));
				
				double impact = getImpact(((Contribution)link).getContributionType());
				
				result[eiSrc][eiTrg] = result[eiSrc][eiTrg] + impact;
				
				impact=impact/100;
				
				for(int i=0;i<eiP;i++)
				{
					if(i!=eiTrg && i!=eiSrc)
						result[eiSrc][i] = result[eiSrc][i] + result[eiTrg][i]*impact;
				}
				
				//AÑADIR PROPAGACION A PADRE
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
