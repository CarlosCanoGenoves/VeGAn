package VEGAN;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import goalModel.Actor;
import goalModel.GoalModel;
import goalModel.IntentionalElement;

public class Visual {
	public static void main(String[] argv) throws Exception {
		GoalModel goalModel = UsingEMFModel.load("testModels/FPIS_FNIS.xmi");

		double[][] output = FTOPSIS.calculateValueToCriteria(goalModel);
		
		ArrayList<String> cols = new ArrayList<String>();
		Map<Integer, IntentionalElement> posToIE = new HashMap<Integer, IntentionalElement>();

		cols.add("Actor");
		cols.add("Intentional Element");
		cols.add("Importance");
		cols.add("Confidence");
		cols.add("Value");
		
		int ieP = 0;
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();

			for (Iterator<IntentionalElement> ieIterator = actor.getIntentionalelements().iterator(); ieIterator
					.hasNext();) {
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				cols.add(ie.getName());
				posToIE.put(ieP++, ie);

				/*
				 * THIS SHOULD NOT BE HERE
				 * */
				double value = 0;
				for (int j = 0; j < output.length; j++) {
					value = value + output[ieP-1][j];
				}
				ie.setValue(value);
			}
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(cols.toArray(), 0) {
			//This make the shorter work correctly
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if(columnIndex < 4)
					return String.class;
				
				return Double.class;
			}
			
		};
		
		for (int i = 0; i < output.length; i++) {
			ArrayList<Object> objs = new ArrayList<Object>();
			
			objs.add(posToIE.get(i).getActor().getName());
			objs.add(posToIE.get(i).getName());
			objs.add(posToIE.get(i).getImportance().toString());
			objs.add(posToIE.get(i).getConfidence().toString());
			objs.add(posToIE.get(i).getValue());
			
			for (int j = 0; j < output.length; j++) {
				objs.add(Math.round(output[i][j] * 100.0)/100.0); //Round before adding
			}
			tableModel.addRow(objs.toArray());
		}

		JTable table = new JTable(tableModel);
		Font font = new Font("Verdana", Font.PLAIN, 12);
		table.setFont(font);
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);

		JFrame frame = new JFrame();
		frame.setSize(600, 400);
		frame.add(new JScrollPane(table));
		frame.setVisible(true);
	}
}
