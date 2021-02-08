package VEGAN;

import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import goalModel.Actor;
import goalModel.GoalModel;
import goalModel.IntentionalElement;

public class Visual {
	public static void main(String[] argv) throws Exception {
		GoalModel goalModel = UsingEMFModel.load("test.xmi");

		goalModel = FTOPSIS.calculateValue(goalModel);
		
		ArrayList<String> cols = new ArrayList<String>();

		//cols.add("Actor");
		cols.add("Intentional Element");
		cols.add("Importance");
		cols.add("Confidence");
		cols.add("Global Value");
		cols.add("Local Value");
		
		
		
		JFrame frame = new JFrame();
		//frame.setSize(600, 400);
		Container c = frame.getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
		
			DefaultTableModel tableModel = new DefaultTableModel(cols.toArray(), 0) {
				//This make the shorter work correctly
				@Override
				public Class<?> getColumnClass(int columnIndex) {
					if(columnIndex < 3)	//4 if actor name is included
						return String.class;
					
					return Double.class;
				}
				
			};
			
			for (Iterator<IntentionalElement> ieIterator =actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				
				ArrayList<Object> objs = new ArrayList<Object>();
				//objs.add(ie.getActor().getName());
				objs.add(ie.getName());
				objs.add(ie.getImportance().toString());
				objs.add(ie.getConfidence().toString());
				objs.add(Math.round(ie.getGlobalValue()*100.0)/100.0);
				objs.add(Math.round(ie.getLocalValue()*100.0)/100.0);
				
				tableModel.addRow(objs.toArray());
			}
			
			JTable table = new JTable(tableModel);
			table.setAutoCreateRowSorter(true);
			
			//Aling without actor
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);	//Importance
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);	//Confidence
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);	//Global Value
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);	//Local Value
			
			c.add(new JLabel(actor.getName()));
			c.add(table.getTableHeader());
			c.add(table);
			c.add(Box.createVerticalStrut(20));
		}
		

		frame.pack();
		
		frame.setVisible(true);
	}
}
