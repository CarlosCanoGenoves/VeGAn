package VISUAL;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import VEGAN.FTOPSIS;
import VEGAN.UsingEMFModel;
import goalModel.Actor;
import goalModel.EEvaluation;
import goalModel.EValueFrom;
import goalModel.Goal;
import goalModel.GoalModel;
import goalModel.IntentionalElement;
import goalModel.Iteration;
import goalModel.SoftGoal;
import goalModel.Task;
import goalModel.ValueFrom;

public class Propagation extends JFrame{

	public String location = "hope.xmi";
	public GoalModel goalModel;
	
	private ArrayList<Actor> actors = new ArrayList<Actor>();
	private ArrayList<JTable> tables = new ArrayList<JTable>();
	
	
	public Propagation(String location)
	{
		this.location = location;
		setTitle("VeGAn");
		setSize(800, 400);
		
		goalModel = UsingEMFModel.load(location);
		
		goalModel = FTOPSIS.calculateValue(goalModel).Item1;
		
		UsingEMFModel.save(goalModel, location);
		
		add(new JScrollPane(generateTables()));
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	
            	for(int i=0;i< actors.size();i++)
            	{
            		Actor actor = actors.get(i);
            		JTable table = tables.get(i);
            		
            		
            			for(int j = 0;j< table.getRowCount();j++)
                		{
                			String ieName = (String) table.getValueAt(j, 0);
                			ieName = ieName.substring(0, ieName.lastIndexOf(" ")).trim();
                		
                			String evaluation = (String) table.getValueAt(j, 7);
                			
                			for (Iterator<IntentionalElement> ieIterator = actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
        					{
        						IntentionalElement ie = (IntentionalElement) ieIterator.next();
        						
        						if(ie.getElementName().equals(ieName))
        						{
        							switch(evaluation)
        							{
        								case "Strongly Agree":		ie.setEvaluation(EEvaluation.STRONGLY_AGREE);		break;
        								case "Agree":				ie.setEvaluation(EEvaluation.AGREE);				break;
        								case "Neutral":				ie.setEvaluation(EEvaluation.NEUTRAL);				break;
        								case "Disagree":			ie.setEvaluation(EEvaluation.DISAGREE);				break;
        								case "Strongly disagree":	ie.setEvaluation(EEvaluation.STRONGLY_DISAGREE);	break;
        								default:					ie.setEvaluation(EEvaluation.NOT_DEFINED);			break;
        							}
        							
        							break;
        						}
        					}
                		
            		}
            		
            	}
            	
                	UsingEMFModel.save(goalModel, location);
            }
        });
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private JPanel generateTables() {
		
		int selectedIteration = goalModel.getIteration();
		
		ArrayList<String> cols = new ArrayList<String>();

		cols.add("Intentional Element");
		cols.add("Importance");
		cols.add("Confidence");
		cols.add("Global Value");
		cols.add("Local Value");
		cols.add("Value intra-actor");
		cols.add("Value inter-actor");
		cols.add("Evaluation");
		
		
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
			
			tableModel.addTableModelListener(new TableModelListener() {
				
				@Override
				public void tableChanged(TableModelEvent e) {
					
					//JOptionPane.showMessageDialog(null, combo.getSelectedItem());
					
				}
			});
			
			for (Iterator<IntentionalElement> ieIterator = actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
			{
				IntentionalElement ie = (IntentionalElement) ieIterator.next();
				
				ArrayList<Object> objs = new ArrayList<Object>();
				objs.add(ie.getElementName() + " " + getIntentionalType(ie));
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
							intra_actor += Math.round(valueFrom.getValue()*100.0)/100.0 + " - " + valueFrom.getIntentionalelement().getElementName() + " " + getIntentionalType(valueFrom.getIntentionalelement()) + "\r\n";
						}
						else
						{
							inter_actor += Math.round(valueFrom.getValue()*100.0)/100.0 + " - " + valueFrom.getIntentionalelement().getElementName() + " " + getIntentionalType(valueFrom.getIntentionalelement()) + "\r\n";

						}
					}
				}
				
				objs.add(intra_actor.trim());
				objs.add(inter_actor.trim());
				objs.add(ie.getEvaluation().toString());
				
				tableModel.addRow(objs.toArray());
			}
			
			JTable table = new JTable(tableModel);
			table.setName(actor.getElementName());
			table.setAutoCreateRowSorter(true);
			
			table.setDefaultRenderer(String.class, new MultilineTableCellRenderer());
			
			
			//Aling without actor
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);	//Importance
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);	//Confidence
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);	//Global Value
			table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);	//Local Value

			String[] evaluations = {"Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly disagree"};
			JComboBox combo = new JComboBox<String>(evaluations);
			
			
			TableColumn col = table.getColumnModel().getColumn(7);
			col.setCellEditor(new DefaultCellEditor(combo));
			
			
			jpanel.add(new JLabel("Actor: " + actor.getElementName()));
			jpanel.add(table.getTableHeader());
			jpanel.add(table);
			//jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
			jpanel.add(Box.createVerticalStrut(20));
			
			actors.add(actor);
			tables.add(table);
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
	
	public static void main(String[] argv) throws Exception {
			
			Propagation prop = new Propagation("hope.xmi");
	
		}
}