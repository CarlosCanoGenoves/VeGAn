package piStar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import VEGAN.UsingEMFModel;
import goalModel.*;

//https://www.cin.ufpe.br/~jhcp/pistar/tool/

public class jsonTest
{

	public static void main(String[] args) throws JsonParseException, IOException {
		JsonFactory jsonFactory = new JsonFactory();
		JsonParser jp = jsonFactory.createJsonParser(new File("./piStar/MeetingScheduler2.txt"));
		jp.setCodec(new ObjectMapper());

		JsonNode jsonNode = jp.readValueAsTree();

		GoalModel goalModel = generateGoalModel(jsonNode);
		UsingEMFModel.save(goalModel, "./piStar/MeetingScheduler2.xmi");
	}

	public static GoalModel generateGoalModel(JsonNode jsonNode)
	{
		GoalModelFactory factory = GoalModelFactory.eINSTANCE;
		
		GoalModel goalModel = factory.createGoalModel();
		goalModel.setName("TESTGoalModel1");
		
		JsonNode actors = jsonNode.get("actors");
		
		for(int i=0;i< actors.size();i++)
		{
			JsonNode actor = actors.get(i);

			Actor actorGM = factory.createActor();
			actorGM.setElementName(actor.get("text").asText());
			
			goalModel.getActors().add(actorGM);
			
			JsonNode nodes = actor.get("nodes");
			
			for(int j = 0; j < nodes.size();j++)
			{
				JsonNode node = nodes.get(j);
				IntentionalElement ie;
						
				switch (node.get("type").asText()) {
				case "istar.Goal":
					ie = factory.createGoal();
				break;
				case "istar.Task":
					ie = factory.createTask();
					break;
				case "istar.Quality":
					ie = factory.createSoftGoal();
					break;
				
					default:
						continue;
				}
				
				ie.setElementName(node.get("text").asText());

				actorGM.getIntentionalelements().add(ie);
			}
		}
		
		goalModel = generateLinks(goalModel, jsonNode);
		
		return goalModel;
	}
	
	private static GoalModel generateLinks(GoalModel goalModel, JsonNode jsonNode)
	{
		GoalModelFactory factory = GoalModelFactory.eINSTANCE;
		
		JsonNode links = jsonNode.get("links");
		
		for(int i=0;i< links.size();i++)
		{
			JsonNode link = links.get(i);

			IntentionalElement ieS = getIE(goalModel, jsonNode, link.get("source").asText());
			IntentionalElement ieT = getIE(goalModel, jsonNode, link.get("target").asText());
			
			if(ieS == null || ieT == null)
				continue;
			
			switch (link.get("type").asText()) {
			case "istar.AndRefinementLink":		//Decomposition
			{
					Decomposition dec = null;
					
					if(ieT.getSrcLinks().stream().anyMatch(dc -> dc instanceof Decomposition))
						dec = (Decomposition) ieT.getSrcLinks().stream().filter(dc -> dc instanceof Decomposition).findFirst().get();
					
					if(dec==null)
					{
						dec = factory.createDecomposition();
						dec.setDecompositionType(EDecomposition.AND);
						dec.setSrc(ieT);
					}
					
					dec.getTrgs().add(ieS);
			}
				break;
			case "istar.OrRefinementLink":		//Decomposition
			{
				Decomposition dec = null;
				
				if(ieT.getSrcLinks().stream().anyMatch(dc -> dc instanceof Decomposition))
					dec = (Decomposition) ieT.getSrcLinks().stream().filter(dc -> dc instanceof Decomposition).findFirst().get();
				
				if(dec==null)
				{
					dec = factory.createDecomposition();
					dec.setDecompositionType(EDecomposition.IOR);
					dec.setSrc(ieT);
				}
				
				dec.getTrgs().add(ieS);
			}
			break;
			
			//i* (i-star) don't have XOR decomposition
			
			case "istar.ContributionLink":
			{
				Contribution cont = factory.createContribution();
				
				cont.setSrc(ieS);
				cont.getTrgs().add(ieT);
				
				switch (link.get("label").asText()) {
				case "make":
					cont.setContributionType(EContribution.P100);
					break;
				case "help":
					cont.setContributionType(EContribution.P25);
					break;
				case "hurt":
					cont.setContributionType(EContribution.N25);
					break;
				case "break":
					cont.setContributionType(EContribution.N100);
					break;
					
				default:
					cont.setContributionType(EContribution.P0);
					break;
				}
			}
				break;
			default:
				break;
			}
		}
		
		links = jsonNode.get("dependencies");
		
		for(int i=0;i< links.size();i++)
		{
			JsonNode link = links.get(i);

			IntentionalElement ieS = getIE(goalModel, jsonNode, link.get("source").asText());
			IntentionalElement ieT = getIE(goalModel, jsonNode, link.get("target").asText());
			
			if(ieS == null || ieT == null)
				continue;
			
			Dependency dep = factory.createDependency();
			dep.setSrc(ieS);
			dep.getTrgs().add(ieT);
		}
		
		return goalModel;
	}

	
	public static IntentionalElement getIE(GoalModel goalModel, JsonNode jsonNode, String ieId)
	{
		JsonNode actors = jsonNode.get("actors");

		for(int i=0;i< actors.size();i++)
		{
			JsonNode actor = actors.get(i);

			JsonNode nodes = actor.get("nodes");
			for(int j = 0; j < nodes.size();j++)
			{
				JsonNode node = nodes.get(j);

				if(node.get("id").asText().equals(ieId))
				{
					return goalModel.getActors().stream().filter(ac -> ac.getElementName().equals(actor.get("text").asText())).findFirst().get()
							.getIntentionalelements().stream().filter(ie -> ie.getElementName().equals(node.get("text").asText())).findFirst().get();
				}
			}
		}
		
		return null;
	}
	
}
