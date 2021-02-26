package VISUAL;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import VEGAN.FTOPSIS;
import VEGAN.UsingEMFModel;
import goalModel.Actor;
import goalModel.EValueFrom;
import goalModel.Goal;
import goalModel.GoalModel;
import goalModel.IntentionalElement;
import goalModel.Iteration;
import goalModel.SoftGoal;
import goalModel.Task;
import goalModel.ValueFrom;

public class Visual {
	public static void main(String[] argv) throws Exception {
		GoalModel goalModel = UsingEMFModel.load("hope.xmi");

		goalModel = FTOPSIS.calculateValue(goalModel).Item1;
		
		UsingEMFModel.save(goalModel, "hope.xmi");
				
		JFrame frame = new JFrame();
		frame.add(new JScrollPane(showLastIteration(goalModel)));
		frame.pack();
		
		frame.setVisible(true);
	}
	
	public static void showVisual(String location)
	{
		GoalModel goalModel = UsingEMFModel.load(location);

		goalModel = FTOPSIS.calculateValue(goalModel).Item1;
		
		UsingEMFModel.save(goalModel, location);
				
		JFrame frame = new JFrame();
		frame.add(new JScrollPane(showLastIteration(goalModel)));
		frame.pack();
		
		frame.setVisible(true);
	}

	/*
	 * By default SHOW the LAST iteration
	 */
	private static JPanel showLastIteration(GoalModel goalModel) {
		return showIteration(goalModel, goalModel.getIteration());
	}
	
	private static JPanel showIteration(GoalModel goalModel, int selectedIteration) {
		ArrayList<String> cols = new ArrayList<String>();

		cols.add("Intentional Element");
		cols.add("Importance");
		cols.add("Confidence");
		cols.add("Global Value");
		cols.add("Local Value");
		cols.add("Value intra-actor");
		cols.add("Value inter-actor");
		
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		
		JComboBox myList = new JComboBox();
		
		 for(int i = 1; i <= goalModel.getIteration(); i++)
			 myList.addItem("Iteration: "+i);
		 
		 myList.setSelectedIndex(selectedIteration-1);
		 
		 myList.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(myList.getSelectedIndex());
					
					JPanel newJpanel = showIteration(goalModel, myList.getSelectedIndex()+1);
					
					JFrame jframe = (JFrame)SwingUtilities.getRoot(myList);
					jframe.getContentPane().removeAll();
					jframe.getContentPane().add(new JScrollPane(newJpanel));
					jframe.update(jframe.getGraphics());
					
					jframe.setVisible(true);

				}
			});

		 
		 jpanel.add(myList);
		
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
				objs.add(ie.getName() + " " + getIntentionalType(ie));
				objs.add(ie.getImportance().toString());
				objs.add(ie.getConfidence().toString());
				objs.add(Math.round(ie.getGlobalValue()*100.0)/100.0);
				objs.add(Math.round(ie.getLocalValue()*100.0)/100.0);
				
				String intra_actor = "";
				String inter_actor = "";
				
				for (Iterator<Iteration> iterationIterator = ie.getIterations().iterator(); iterationIterator.hasNext();)
				{
					Iteration iteration = iterationIterator.next();
					
					if(iteration.getIteration() != selectedIteration)
						continue;
					
					for (Iterator<ValueFrom> valueFromIterator = iteration.getValuefrom().iterator(); valueFromIterator.hasNext();)
					{
						ValueFrom valueFrom = valueFromIterator.next();
						
						if(valueFrom.getValueFrom()==EValueFrom.LOCAL)
						{
							intra_actor += Math.round(valueFrom.getValue()*100.0)/100.0 + " - " + valueFrom.getIntentionalelement().getName() + " " + getIntentionalType(valueFrom.getIntentionalelement()) + "\r\n";
						}
						else
						{
							inter_actor += Math.round(valueFrom.getValue()*100.0)/100.0 + " - " + valueFrom.getIntentionalelement().getName() + " " + getIntentionalType(valueFrom.getIntentionalelement()) + "\r\n";

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
		
		return jpanel;
	}
	
	private static String getIntentionalType(IntentionalElement ie)
	{
		if(ie instanceof Goal)
			return "(G)";
		else if(ie instanceof SoftGoal)
			return "(S)";
		else if(ie instanceof Task)
			return "(T)";
		
		return "(U)";	//Unknown
	}
}
