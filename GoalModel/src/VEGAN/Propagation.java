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
		
		//Forzar que la propagacion pare debido a que tarda demasiado. Detecta LOOPS, ¿ Posible error ?
		int forceStop = ieP*ieP*ieP + 100;
		
		List<Link> propagatedLinks = new ArrayList<Link>();
		
		while (!toVisitIE.isEmpty()) {
			
			if(forceStop-- == 0 )
			{
				System.out.println("Force to Stop due too many cicles. Possible Loop");
				break;
			}
			
			IntentionalElement ie = toVisitIE.remove(0);

			boolean puede_propagar = true;
			
			//Comprobacion de dependencias
			if(ie.getTrgLinks().stream().anyMatch(link -> link instanceof Dependency && toVisitIE.contains(link.getSrc())))
				{
					if(verbose)
						System.out.println("NOT propagate " + ie.getName() + " due Dependency");
					
					puede_propagar = false;
				}

			//Comprobacion de contribucciones
			if(ie.getSrcLinks().stream().anyMatch(link -> link instanceof Contribution && toVisitIE.contains(link.getTrgs().get(0))))
			{
				if(verbose)
					System.out.println("NOT propagate " + ie.getName() + " due Contribution");
				
				puede_propagar = false;
			}

			//Comprobacion de descomposiciones
			//Un HIJO no debe propagar ANTES que su padre
			if(ie.getTrgLinks().stream().anyMatch(link -> link instanceof Decomposition && !propagatedLinks.contains(link)))
				{
				if(verbose)
					System.out.println("NOT propagate " + ie.getName() + " due Decomposition");
				
				puede_propagar = false;
				}
			
			if(!puede_propagar)
			{
				toVisitIE.add(ie);
				continue;
			}
			
			if(verbose)
				System.out.println("Propagating: "+ie.getName());
			
			//Descomposicion de PADRES a HIJOS
			if(ie.getSrcLinks().stream().anyMatch(link -> link instanceof Decomposition))
			{
				int iePos = ieToPosition.get(ie);
				
				//SIEMPRE va a ser distinto de NULL debido a la condicion anterior
				Decomposition dec = (Decomposition)ie.getSrcLinks().stream().filter(link -> link instanceof Decomposition).findFirst().get();
				
				if(!propagatedLinks.contains(dec))
				{
					if(verbose)
						System.out.println("Decomposition");
					
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
					
					propagatedLinks.add(dec);
				}
			}
			
			//Un elemento intencional NO puede propagar SI todos sus hijos no han propagado
			if(ie.getSrcLinks().stream().anyMatch(link -> link instanceof Decomposition && link.getTrgs().stream().anyMatch(children -> toVisitIE.contains(children))))
				{
					if(verbose)
						System.out.println("NOT propagate " + ie.getName() + " due Decomposition");
					
					toVisitIE.add(ie);
					continue;
				}
			
			boolean fin_propagacion = true;
			
			//Propagate Dependencies
			for (Iterator<Link> linkIterator = ie.getSrcLinks().iterator(); linkIterator.hasNext();)
			{
				if(verbose)
					System.out.println("Dependency");
				
				Link link = (Link) linkIterator.next();
				if(!(link instanceof Dependency) || propagatedLinks.contains(link))
					continue;
				
				//NO PROPAGAR A TARGET PERTENECIENTE A UNA DESCOMPOSICION SIN PROPAGAR				
				if(link.getTrgs().get(0).getTrgLinks().stream().anyMatch(dec -> dec instanceof Decomposition && !propagatedLinks.contains(dec)))
				{
					fin_propagacion = false;
					continue;
				}
					
				int eiSrc = ieToPosition.get(link.getSrc());
				int eiTrg = ieToPosition.get(link.getTrgs().get(0));
				
				result[eiTrg][eiSrc] = result[eiSrc][eiTrg]+100;
				propagateFather(result, 100, eiSrc, link.getTrgs().get(0));
				
				for(int i=0;i<ieP;i++)
				{
					if(i!=eiTrg && i!=eiSrc) {
						result[eiTrg][i] = result[eiTrg][i] + result[eiSrc][i];
						propagateFather(result, result[eiSrc][i], i, ie);
					}
				}
				
				
				propagatedLinks.add(link);
			}
			
			//Propagate Contributions
			for (Iterator<Link> linkIterator = ie.getTrgLinks().iterator(); linkIterator.hasNext();)
			{
				if(verbose)
					System.out.println("Contribution");
				
				Link link = (Link) linkIterator.next();
				if(!(link instanceof Contribution) || propagatedLinks.contains(link))
					continue;
				
				//NO PROPAGAR A SOURCE PERTENECIENTE A UNA DESCOMPOSICION SIN PROPAGAR				
				if(link.getSrc().getTrgLinks().stream().anyMatch(dec -> dec instanceof Decomposition && !propagatedLinks.contains(dec)))
				{
					fin_propagacion = false;
					continue;
				}
				
				int eiSrc = ieToPosition.get(link.getSrc());
				int eiTrg = ieToPosition.get(link.getTrgs().get(0));
				
				double impact = getImpact(((Contribution)link).getContributionType());
				
				result[eiSrc][eiTrg] = result[eiSrc][eiTrg] + impact;
				propagateFather(result, impact, eiTrg, link.getSrc());
				
				impact=impact/100;
				
				for(int i=0;i<ieP;i++)
				{
					if(i!=eiTrg && i!=eiSrc)
					{
						result[eiSrc][i] = result[eiSrc][i] + result[eiTrg][i]*impact;
						propagateFather(result, result[eiTrg][i]*impact, i, link.getSrc());
					}
				}
				
				propagatedLinks.add(link);
			}
						
			if(!fin_propagacion)
			{
				if(verbose)
					System.out.println("Partial propagation");
				
				toVisitIE.add(ie);
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
	
	private static void propagateFather(double[][] result, double impact, int target, IntentionalElement child)
	{
		if(!child.getTrgLinks().stream().anyMatch(link -> link instanceof Decomposition) || impact == 0)
			return;
		
		System.out.println("Propagando a PADRE de "+child.getName() + " valor de " + impact);
		
		IntentionalElement father = child.getTrgLinks().stream().filter(link -> link instanceof Decomposition).findFirst().get().getSrc();
		
		int fatherPos = ieToPosition.get(father);
		
		result[fatherPos][target] = result[fatherPos][target] + impact;
		
		if(father.getTrgLinks().stream().anyMatch(link -> link instanceof Decomposition))
			propagateFather(result, impact, target, father);
	}
}
