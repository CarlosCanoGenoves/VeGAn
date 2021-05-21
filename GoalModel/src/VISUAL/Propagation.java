package VISUAL;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import goalModel.EConfidence;
import goalModel.EEvaluation;
import goalModel.EImportance;
import goalModel.EValueFrom;
import goalModel.Goal;
import goalModel.GoalModel;
import goalModel.IntentionalElement;
import goalModel.Iteration;
import goalModel.SoftGoal;
import goalModel.Task;
import goalModel.ValueFrom;

public class Propagation extends JFrame{

	public String pictureFile = "";
	public String goalModelFile = "hope.xmi";
	public GoalModel goalModel;
	
	private ArrayList<Actor> actors = new ArrayList<Actor>();
	private ArrayList<JTable> tables = new ArrayList<JTable>();
	
	public Propagation(String goalModelFile)
	{
		this(goalModelFile, "None");
	}
	
	public Propagation(String goalModelFile, String pictureFile)
	{
		this.goalModelFile = goalModelFile;
		this.pictureFile = pictureFile;
		setTitle("VeGAn");
		setSize(800, 400);
		
		goalModel = UsingEMFModel.load(goalModelFile);
		
		goalModel = FTOPSIS.calculateValue(goalModel).Item1;
		
		UsingEMFModel.save(goalModel, goalModelFile);
		
		add(new JScrollPane(generateTables()));
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	saveGoalModel();
            }
        });
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void saveGoalModel()
	{
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
								case "Strongly Disagree":	ie.setEvaluation(EEvaluation.STRONGLY_DISAGREE);	break;
								default:					ie.setEvaluation(EEvaluation.NOT_DEFINED);			break;
							}
							
							break;
						}
					}
        		
    		}
    		
    	}
		
		UsingEMFModel.save(goalModel, goalModelFile);
	}
	
	private JPanel generateTables() {
		
		int selectedIteration = goalModel.getIteration();
		
		ArrayList<String> cols = new ArrayList<String>();

		cols.add("Intentional element");
		cols.add("Importance level");
		cols.add("Confidence level");
		cols.add("Global value");
		cols.add("Local value");
		cols.add("Value intra-actor");
		cols.add("Value inter-actor");
		cols.add("Evaluation");
		
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		
		
		JPanel topPanel = new JPanel();
		Dimension d = getMaximumSize();
		d.height = 100;
		topPanel.setMaximumSize(d);
		
		JButton buttonBack = new JButton("Back to Prioritization of Goal Model");
		JButton buttonSave = new JButton("Save Goal Model");
		JButton buttonSaveExit = new JButton("Save Goal Model and Exit");
		
		buttonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveGoalModel();
				
				new Prioritization(goalModelFile, pictureFile);
				dispose();
			}
		});
		
		buttonSave.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						saveGoalModel();
						
						boolean allEvaluated = true;
						
						for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
							Actor actor = (Actor) actorIterator.next();
							
							for (Iterator<IntentionalElement> ieIterator = actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
							{
								IntentionalElement ie = (IntentionalElement) ieIterator.next();
								
								if(ie.getEvaluation() == EEvaluation.NOT_DEFINED)
								{
									allEvaluated = false;
									break;
								}
							}
						}
						
						if(!allEvaluated)
						{
							 JOptionPane.showMessageDialog(null, "All intentional elements of all actors must be evaluated.");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "The Goal Model has been saved.");
						}
					}
				});
		
		buttonSaveExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				saveGoalModel();
				
				boolean allEvaluated = true;
				
				for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
					Actor actor = (Actor) actorIterator.next();
					
					for (Iterator<IntentionalElement> ieIterator = actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
					{
						IntentionalElement ie = (IntentionalElement) ieIterator.next();
						
						if(ie.getEvaluation() == EEvaluation.NOT_DEFINED)
						{
							allEvaluated = false;
							break;
						}
					}
				}
				
				if(!allEvaluated)
				{
					 JOptionPane.showMessageDialog(null, "Saved. However, all the intentional elements of all the actors must be evaluated.");
				}
				
				int result= JOptionPane.showConfirmDialog(null, "Are you sure you want to save and close the application?", null, JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION)
				{
					dispose();
				}
				
			}
		});
		
		topPanel.add(buttonBack);
		topPanel.add(buttonSave);
		topPanel.add(buttonSaveExit);
		
		jpanel.add(topPanel);
		jpanel.add(Box.createVerticalStrut(20));
		
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
				objs.add(ie.getElementName() + " " + getIntentionalType(ie));
				objs.add(ie.getImportance().toString().replace('_', ' '));
				objs.add(ie.getConfidence().toString().replace('_', ' '));
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
				
				if(inter_actor.equals(""))
					inter_actor = "None";
				
				objs.add(intra_actor.trim());
				objs.add(inter_actor.trim());
				objs.add(ie.getEvaluation().toString().replace('_', ' '));
				
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

			String[] evaluations = {"Strongly Agree", "Agree", "Neutral", "Disagree", "Strongly Disagree", "Not Defined"};
			JComboBox combo = new JComboBox<String>(evaluations);
			
			TableColumn colEvaluation = table.getColumnModel().getColumn(7);
			colEvaluation.setCellEditor(new DefaultCellEditor(combo));
			
			colEvaluation.setCellRenderer(
			        new DefaultTableCellRenderer() {			        	
			            public Component getTableCellRendererComponent(JTable table, 
			                                                           Object value, 
			                                                           boolean isSelected, 
			                                                           boolean hasFocus, 
			                                                           int row, 
			                                                           int column) {
			                setText(value.toString());
			                setBackground(Color.CYAN);
			                return this;
			            }
			        });
			
			Box  b1 = Box.createHorizontalBox();
			b1.add( new JLabel("Actor: " + actor.getElementName() + " ( Importance level: " + actor.getImportance().toString().replace('_', ' ') + ", Confidence level: " + actor.getConfidence().toString().replace('_', ' ') + " )") );
			b1.add( Box.createHorizontalGlue() );
			jpanel.add( b1 );
			
			jpanel.add(table.getTableHeader());
			jpanel.add(table);
			//jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
			jpanel.add(Box.createVerticalStrut(20));
			
			actors.add(actor);
			tables.add(table);
		}
		
		if(!pictureFile.equals("None"))
		{
			ImageIcon image = new ImageIcon(pictureFile);
			jpanel.add(new JLabel(image));
		}
		
		jpanel.add(new JPanel());
		
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