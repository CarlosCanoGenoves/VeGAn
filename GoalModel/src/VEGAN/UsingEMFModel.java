package VEGAN;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import goalModel.*;
import goalModel.impl.*;
import goalModel.util.*;

public class UsingEMFModel {

	public static void main(String[] args) {
		// GoalModelPackage.eINSTANCE;

		// Retrieve the default factory singleton
		GoalModelFactory factory = GoalModelFactory.eINSTANCE;

		// create an instance of GoalModel
		GoalModel myGoalModel = factory.createGoalModel();
		myGoalModel.setName("myGoalModel");

		Actor actor = factory.createActor();
		actor.setElementName("Actor");
		myGoalModel.getActors().add(actor);

		System.out.println("GoalModelName: " + myGoalModel.getName());
		System.out.println("AmountOfActors: " + myGoalModel.getActors().size());
		System.out.println("ActorName: " + myGoalModel.getActors().get(0).getElementName());

		myGoalModel = load("test.xmi");

		System.out.println("GoalModelName: " + myGoalModel.getName());

		System.out.println("Actors:");

		// Iteration test:

		myGoalModel.getActors().forEach((temp) -> {
			System.out.println(temp.getElementName());
		});

		for (Iterator iterator = myGoalModel.getActors().iterator(); iterator.hasNext();) {
			Actor type = (Actor) iterator.next();

			System.out.println(type.getElementName());
		}
		
		Propagation.propagate(myGoalModel);
		
		save(myGoalModel, "test2.xmi");
	}

	public static GoalModel load(String file) {
		ResourceSet resourceSet = new ResourceSetImpl();

		// register URI
		Map packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(GoalModelPackage.eNS_URI, GoalModelPackage.eINSTANCE);

		// Register XML resource as UMLResource.Factory.Instance
		Map extensionFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionFactoryMap.put("xmi", new XMIResourceFactoryImpl());

		XMIResource resource = new XMIResourceImpl(URI.createURI(file));

		// try to load the file into resource
		try {
			resource.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (GoalModel) resource.getContents().get(0);

	}
	
	
	public static void save(GoalModel goalmodel, String file) {
		ResourceSet resourceSet = new ResourceSetImpl();

		// register URI
		Map packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(GoalModelPackage.eNS_URI, GoalModelPackage.eINSTANCE);

		// Register XML resource as UMLResource.Factory.Instance
		Map extensionFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		extensionFactoryMap.put("xmi", new XMIResourceFactoryImpl());
		
		XMIResource resource = new XMIResourceImpl(URI.createURI(file));
		
		resource.getContents().add(goalmodel);
		
		 try {
	            resource.save(Collections.EMPTY_MAP);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
