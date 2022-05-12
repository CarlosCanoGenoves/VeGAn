import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;

import VEGAN.UsingEMFModel;
import goalModel.Actor;
import goalModel.EEvaluation;
import goalModel.EImportance;
import goalModel.GoalModel;
import goalModel.IntentionalElement;
import goalModel.Iteration;

public class compareedX {

	public static void main(String[] args) {
		GoalModel expectedGoalModel = UsingEMFModel.load("Experimento/Sol/edX.xmi");
		GoalModel goalmodel = UsingEMFModel.load("Experimento/Check/edX.xmi");
		
		int totalNumberOfIE = 0;
		int totalNumberOfCorrectIE = 0;
		
		ArrayList<String> tableHead = new ArrayList<String>();
		ArrayList<Double> tableRow = new ArrayList<Double>();
		
		for(int i = 0; i < expectedGoalModel.getActors().size();i++)
		{
			Actor expectedActor = expectedGoalModel.getActors().get(i);
			Actor actor = goalmodel.getActors().get(i);
			
			
			if(!expectedActor.getElementName().equals(actor.getElementName()))
			{
				System.out.println("The actors do not match");
				break;
			}
			
			int numberOfIE = 0;
			int numberOfCorrectIE = 0;
			
			for(int j =0; j < expectedActor.getIntentionalelements().size();j++)
			{
				IntentionalElement expectedIe = expectedActor.getIntentionalelements().get(j);
				IntentionalElement ie = actor.getIntentionalelements().get(j);
				
				if(!expectedIe.getElementName().equals(ie.getElementName()))
				{
					System.out.println("The Intentional elements do not match");
					break;
				}
				
				if(rightPrioritization(ie.getImportance(), expectedIe.getImportance()))
					numberOfCorrectIE++;
				numberOfIE++;
			}
			
			tableHead.add(actor.getElementName() +" PA:");
			tableRow.add((double)numberOfCorrectIE/(double)numberOfIE);
			
			totalNumberOfIE += numberOfIE;
			totalNumberOfCorrectIE += numberOfCorrectIE;
		}
		
		tableHead.add("Total PA:");
		tableRow.add((double)totalNumberOfCorrectIE/(double)totalNumberOfIE);
		
		int totalEvaluation = 0;
		totalNumberOfIE = 0;
		
		for(int i = 0; i < goalmodel.getActors().size();i++)
		{
			Actor actor = goalmodel.getActors().get(i);

			
			int numberOfIE = 0;
			int numberOfEvaluation = 0;
			
			for(int j =0; j < actor.getIntentionalelements().size();j++)
			{
				IntentionalElement ie = actor.getIntentionalelements().get(j);
								
				numberOfEvaluation += getValue(ie.getEvaluation());
				numberOfIE++;
			}
			
			tableHead.add("Eval " + actor.getElementName());
			tableRow.add((double)numberOfEvaluation/(double)numberOfIE);
			
			totalNumberOfIE += numberOfIE;
			totalEvaluation += numberOfEvaluation;
		}
		
		tableHead.add("Eval Total:");
		tableRow.add((double)totalEvaluation/(double)totalNumberOfIE);
		
		for(int i=0;i<tableHead.size();i++)
			if(i==tableHead.size()-1)
				System.out.print(tableHead.get(i));
			else
				System.out.print(tableHead.get(i) + "\t");
		
		System.out.println();
		
		for(int i=0;i<tableRow.size();i++)
			if(i==tableRow.size()-1)
				System.out.print(tableRow.get(i).toString().replace('.', ','));
			else
				System.out.print(tableRow.get(i).toString().replace('.', ',') + "\t");
		
		System.out.println();
		
		String[] tableHead2 = {"P2 1", "P2 2", "P2 3", "P2 4", "P2 5", "P2 6", "P2 6"};
		Double[] tableRow2 = 
			{
				/* HOPE
				getValueFrom(goalmodel, "Usuario", "Telefono", "Atencion inmediata"),
				getValueFrom(goalmodel, "Usuario", "VideoChat", "Anonimato"),
				getValueFrom(goalmodel, "Orientador", "Chat", "Ayudar a muchos"),
				getValueFrom(goalmodel, "Orientador", "Telefono", "Ayuda de calidad"),
				getValueFrom(goalmodel, "Telefono de la esperanza", "VideoChat", "Evitar escandalos"),
				getValueFrom(goalmodel, "Telefono de la esperanza", "Chat", "Ofrecer ayuda de calidad")
				*/
					
					getValueFrom(goalmodel, "Usuario", "Presencial", "Evitar desplazamiento"),
					getValueFrom(goalmodel, "Usuario", "Aprender", "Satisfacion con el curso"),
					getValueFrom(goalmodel, "Compañia", "Formar trabajadores", "Aumentar productividad"),
					getValueFrom(goalmodel, "Compañia", "Online", "Reducir costes"),
					getValueFrom(goalmodel, "Profesor", "Presencial", "Mejorar acceso a la educacion"),
					getValueFrom(goalmodel, "Profesor", "Proveer curso", "Participacion alumnos en clase")
					
			};
		
		System.out.println();
		
		for(int i=0;i<tableHead2.length;i++)
			if(i==tableHead2.length-1)
				System.out.print(tableHead2[i]);
			else
				System.out.print(tableHead2[i] + "\t");
		
		System.out.println();
		
		for(int i=0;i<tableRow2.length;i++)
			if(i==tableRow2.length-1)
				System.out.print(tableRow2[i].toString().replace('.', ','));
			else
				System.out.print(tableRow2[i].toString().replace('.', ',') + "\t");
		
		System.out.println();
	}
	
	//There is some degree of freedom, it is consider right if it is equal or ONE greater. For example. If expected is MEDIMUM, it would be right MEDIUM and HIGH
	public static boolean rightPrioritization(EImportance source, EImportance expected)
	{
		if(source.equals(expected))
			return true;
		
		switch(expected)
		{
			case VERY_HIGH: 	return false;
			case HIGH: 			return source.equals(EImportance.VERY_HIGH);
			case MEDIUM: 		return source.equals(EImportance.HIGH);
			case LOW: 			return source.equals(EImportance.MEDIUM);
			case VERY_LOW: 		return source.equals(EImportance.LOW);
			case NOT_DEFINED:	return false;
			default:			return false;
		}
	}

	public static double getValueFrom(GoalModel goalmodel, String Actor, String Ie, String GetFrom)
	{
		EList<Iteration> iterations = goalmodel.getActors().stream().filter(ac -> ac.getElementName().equals(Actor)).findFirst().get()
				.getIntentionalelements().stream().filter(ie -> ie.getElementName().equals(Ie)).findFirst().get().getIterations();
		
		Iteration iter = iterations.get(iterations.size()-1);
		
		return iter.getValuefrom().stream().filter(vf -> vf.getIntentionalelement().getElementName().equals(GetFrom)).findFirst().get().getValue();
	}

	public static int getValue(EEvaluation evaluation)
	{
		switch (evaluation) {
		case STRONGLY_AGREE: 		return 5;
		case AGREE: 				return 4;
		case NEUTRAL: 				return 3;
		case DISAGREE: 				return 2;
		case STRONGLY_DISAGREE: 	return 1;
		case NOT_DEFINED: 			return 0;
		default:					return 0;
		}
	}
}
