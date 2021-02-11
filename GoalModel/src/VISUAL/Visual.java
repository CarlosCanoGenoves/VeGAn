package VISUAL;


import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import VEGAN.FTOPSIS;
import VEGAN.Tuple;
import VEGAN.UsingEMFModel;
import goalModel.Actor;
import goalModel.EValueFrom;
import goalModel.GoalModel;
import goalModel.IntentionalElement;
import goalModel.Iteration;
import goalModel.ValueFrom;

public class Visual {
	public static void main(String[] argv) throws Exception {
		GoalModel goalModel = UsingEMFModel.load("test.xmi");

		goalModel = FTOPSIS.calculateValue(goalModel).Item1;
		
		ArrayList<String> cols = new ArrayList<String>();

		cols.add("Intentional Element");
		cols.add("Importance");
		cols.add("Confidence");
		cols.add("Global Value");
		cols.add("Local Value");
		cols.add("Value intra-actor");
		cols.add("Value inter-actor");
		
		JFrame frame = new JFrame();
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
		
			DefaultTableModel tableModel = new DefaultTableModel(cols.toArray(), 0) {
				//This make the shorter work correctly
				@Override
				public Class<?> getColumnClass(int columnIndex) {
					if(columnIndex < 3 || columnIndex > 4)	//4 if actor name is included
						return String.class;
					
					return Double.class;
				}
			};
			
			for (Iterator<IntentionalElement> ieIterator = actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				
				ArrayList<Object> objs = new ArrayList<Object>();
				objs.add(ie.getName());
				objs.add(ie.getImportance().toString());
				objs.add(ie.getConfidence().toString());
				objs.add(Math.round(ie.getGlobalValue()*100.0)/100.0);
				objs.add(Math.round(ie.getLocalValue()*100.0)/100.0);
				
				String intra_actor = "";
				String inter_actor = "";
				
				for (Iterator<Iteration> iterationIterator = ie.getIterations().iterator(); iterationIterator.hasNext();)
				{
					Iteration iteration = iterationIterator.next();
					
					if(iteration.getIteration() != goalModel.getIteration())
						continue;
					
					for (Iterator<ValueFrom> valueFromIterator = iteration.getValuefrom().iterator(); valueFromIterator.hasNext();)
					{
						ValueFrom valueFrom = valueFromIterator.next();
						
						if(valueFrom.getValueFrom()==EValueFrom.LOCAL)
						{
							intra_actor += Math.round(valueFrom.getValue()*100.0)/100.0 + " - " + valueFrom.getIntentionalelement().getName() + "\r\n";
						}
						else
						{
							inter_actor += Math.round(valueFrom.getValue()*100.0)/100.0 + " - " + valueFrom.getIntentionalelement().getName() + "\r\n";

						}
					}
				}
				
				objs.add(intra_actor.trim());
				objs.add(inter_actor.trim());
				
				tableModel.addRow(objs.toArray());
			}
			
			JTable table = new JTable(tableModel);
			table.setAutoCreateRowSorter(true);
			
			table.setDefaultRenderer(String.class, new MultilineTableCellRenderer());
			
			
			//Aling without actor
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);	//Importance
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);	//Confidence
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);	//Global Value
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);	//Local Value

			jpanel.add(new JLabel(actor.getName()));
			jpanel.add(table.getTableHeader());
			jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
			jpanel.add(Box.createVerticalStrut(20));
		}
		
		frame.add(new JScrollPane(jpanel));
		frame.pack();
		
		frame.setVisible(true);
	}
}