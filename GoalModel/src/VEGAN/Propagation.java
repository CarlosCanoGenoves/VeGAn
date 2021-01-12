package VEGAN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import goalModel.*;

public class Propagation {

	public static List<IntentionalElement> toVisitIE = new ArrayList<IntentionalElement>();
	
	public static Map<IntentionalElement, Double> propagate(GoalModel goalModel)
	{
		toVisitIE.clear();
		
		HashMap<IntentionalElement, Double> result = new HashMap<IntentionalElement, Double>();
		
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
		
			for (Iterator<IntentionalElement> ieIterator =actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				toVisitIE.add(ie);
			}
		}
		
		System.out.println("Amount of IE: "+toVisitIE.size());
		
		/*
		while (!toVisitIE.isEmpty()) {
			
		}
		*/
		return result;
	}
	
	public static double getModificador(EContribution contributionType)
	{
		switch (contributionType) {
		case P100:	return 1;
		case P75: 	return 0.75;
		case P50:	return 0.50;
		case P25:	return 0.25;
		case P0:	return 0;
		case N25:	return -0.25;
		case N50:	return -0.50;
		case N75:	return -0.75;
		case N100:	return -1;
		}
		
		return 0;
	}
}
