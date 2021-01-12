package VEGAN;
import java.util.List;
import java.util.ArrayList;

//import GRL.*;

public class OLDPropagation
{
	public static void main()
	{
		GRLspec model = new GRLspec();

		//Lista con elementos intencionales
		List<IntentionalElement> elementos = new ArrayList<IntentionalElement>();

		//Propagacion de actores
		for(Actor actor : model.actors)
		{
			if(null == actor)
				continue;

			actor.elems.stream().filter(elem -> elem instanceof IntentionalElement).
			forEach(elem -> 
			{
				elem.value = elem.importance * actor.importance; 
				elementos.add((IntentionalElement) elem);
			});
		}
		
		/*
		 * ESTE CODIGO TIENE UN ERROR CON PROPAGAR DE HIJOS A PADRES CUANDO HAY MÁS DE UN PADRE
		 * */

		//Propagacion a traves de relaciones
		while(!elementos.isEmpty())
		{
			//Extraemos uno de forma ordenada
			IntentionalElement ie = elementos.remove(0);
			if(null == ie)
				continue;

			boolean puede_propagar = true;

			//Comprobacion de dependencias
			if(ie.linksDest.stream().anyMatch(relationship -> relationship instanceof Dependency && !relationship.propagado))
				puede_propagar = false;

			//Comprobacion de contribucciones
			if(ie.linkSrc.stream().anyMatch(relationship -> relationship instanceof Contribution && !relationship.propagado))
				puede_propagar = false;

			//ERROR?
			//Comprobacion de descomposiciones
			if(ie.type == IntentionalElementType.Softgoal && ie.linkSrc.stream().anyMatch(relationship -> relationship instanceof Decomposition && ((Decomposition)relationship).estado == EstadoPropagacion.Nada))
				puede_propagar = false;

			if(false == puede_propagar)
			{
				elementos.add(ie);
				continue;
			}
			
			//Propagar descomposiciones P -> H
			
			//No se propaga a softgoals, PERO se cambia el estado
			ie.linksDest.stream().filter(relationship -> relationship instanceof Decomposition && ((Decomposition)relationship).estado == EstadoPropagacion.Nada && ((IntentionalElement)relationship.src).type == IntentionalElementType.Softgoal).
			forEach(decomp ->
			{
				((Decomposition)decomp).estado = EstadoPropagacion.Padre2Hijo;
				decomp.propagado = true;
			});
			
			//Suma de elementos hijos
			double sum = ie.linksDest.stream().filter(relationship -> relationship instanceof Decomposition && ((Decomposition)relationship).estado == EstadoPropagacion.Nada && ((IntentionalElement)relationship.src).type != IntentionalElementType.Softgoal).mapToDouble(relationship -> relationship.src.value).sum();
			
			//Se propaga a no softgoals
			ie.linksDest.stream().filter(relationship -> relationship instanceof Decomposition && ((Decomposition)relationship).estado == EstadoPropagacion.Nada && ((IntentionalElement)relationship.src).type != IntentionalElementType.Softgoal).
			forEach(decomp ->
			{
				decomp.src.value = decomp.src.value/sum * ie.value;
				((Decomposition)decomp).estado = EstadoPropagacion.Padre2Hijo;
			});
			
			if(ie.linksDest.stream().anyMatch(relationship -> relationship instanceof Decomposition && !relationship.propagado))
			{
				elementos.add(ie);
				continue;
			}
			
			//Propagar dependencias
			//PROBLEMA: ¿Existe o no Depemdum?
			//PROBLEMA2: Propagar a padre de padre (loop)
			ie.linkSrc.stream().
			filter(relationship -> relationship instanceof Dependency && !relationship.propagado).
			forEach(dependency -> 
			{
				//Excepcion: no propagar a un elemento que no ha recibido valor de su padre
				if(! dependency.dest.linkSrc.stream().anyMatch(desc -> desc instanceof Decomposition && ((Decomposition)desc).estado == EstadoPropagacion.Nada))
				{
					dependency.dest.value += ((Dependency)dependency).degreeOfDependency * ie.value;
					dependency.propagado = true;
					
					//Propagar de hijo a padre
					dependency.dest.linkSrc.stream().filter(desc -> desc instanceof Dependency && !desc.propagado).
					forEach(desc -> 
					{
						desc.dest.value += ((Dependency)dependency).degreeOfDependency * ie.value;
					});
				}
			});

			//Propagar contribuciones
			//PROBLEMA: Propagar a padre de padre (loop)
			ie.linksDest.stream().
			filter(relationship -> relationship instanceof Contribution && !relationship.propagado).
			forEach(contribution -> 
			{
				//Excepcion: no propagar a un elemento que no ha recibido valor de su padre
				if(! contribution.dest.linkSrc.stream().anyMatch(desc -> desc instanceof Decomposition && ((Decomposition)desc).estado == EstadoPropagacion.Nada))
				{
					contribution.src.value += ((Contribution)contribution).quantitativeContribution * ie.value;
					contribution.propagado = true;
					
					
					//Propagar de hijo a padre
					contribution.dest.linkSrc.stream().filter(desc -> desc instanceof Decomposition  && !desc.propagado).
					forEach(desc -> 
					{
						desc.dest.value += ((Contribution)contribution).quantitativeContribution * ie.value;
					});

				}
			});

			boolean fin_propagar = true;
			
			if(ie.linksDest.stream().anyMatch(relationship -> relationship instanceof Contribution && !relationship.propagado))
				fin_propagar = false;
			
			if(ie.linkSrc.stream().anyMatch(relationship -> relationship instanceof Dependency && !relationship.propagado))
				fin_propagar = false;
			
			if(!fin_propagar)
			{
				elementos.add(ie);
				continue;
			}

			//Confirmar propagacion de padre a hijo (Si se ha llegado aquí es porque ya no puede recibir más de nadie
			ie.linkSrc.stream().filter(relationship -> relationship instanceof Decomposition && ((Decomposition)relationship).estado == EstadoPropagacion.Padre2Hijo).
			forEach(decomp ->
			{
				((Decomposition)decomp).estado = EstadoPropagacion.Hijo2Padre;
				decomp.propagado = true;
			});


		} //While

	}	//Main

}	//Class

