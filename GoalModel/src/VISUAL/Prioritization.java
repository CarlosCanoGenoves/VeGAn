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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import VEGAN.UsingEMFModel;
import goalModel.Actor;
import goalModel.EConfidence;
import goalModel.EImportance;
import goalModel.Goal;
import goalModel.GoalModel;
import goalModel.IntentionalElement;
import goalModel.SoftGoal;
import goalModel.Task;

public class Prioritization extends JFrame{

	public String pictureFile = "";
	public String goalModelFile = "hope.xmi";
	public GoalModel goalModel;
	
	private ArrayList<Actor> actors = new ArrayList<Actor>();
	private ArrayList<JTable> tables = new ArrayList<JTable>();
	
	public Prioritization(String goalModelFile)
	{
		this(goalModelFile, "None");
	}
	
	public Prioritization(String goalModelFile, String pictureFile)
	{
		this.goalModelFile = goalModelFile;
		this.pictureFile = pictureFile;
		setTitle("VeGAn");
		setSize(800, 400);
		
		goalModel = UsingEMFModel.load(goalModelFile);

		add(new JScrollPane(generateTables()));
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	saveGoalModel();            }
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
    		
    		if(actor == null)
    		{
    			for(int j = 0;j< table.getRowCount();j++)
        		{
        			String aName = (String) table.getValueAt(j, 0);
        		
        			String importance = (String) table.getValueAt(j, 1);
        			String confidence = (String) table.getValueAt(j, 2);
        			
        			
        			for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
        				actor = (Actor) actorIterator.next();
						
						if(actor.getElementName().equals(aName))
						{
							switch(importance)
							{
								case "Very High":	actor.setImportance(EImportance.VERY_HIGH);		break;
								case "High":		actor.setImportance(EImportance.HIGH);			break;
								case "Medium":		actor.setImportance(EImportance.MEDIUM);		break;
								case "Low":			actor.setImportance(EImportance.LOW);			break;
								case "Very Low":	actor.setImportance(EImportance.VERY_LOW);		break;
								default:			actor.setImportance(EImportance.NOT_DEFINED);	break;
							}
							
							switch(confidence)
							{
								case "Possibly More":	actor.setConfidence(EConfidence.POSSIBLY_MORE);	break;
								case "Confident":		actor.setConfidence(EConfidence.CONFIDENT);		break;
								case "Possibly Less":	actor.setConfidence(EConfidence.POSSIBLY_LESS);	break;
								default:				actor.setConfidence(EConfidence.NOT_DEFINED);	break;
							}
							
							break;
						}
					}
        		}
    		}
    		else
    		{
    			for(int j = 0;j< table.getRowCount();j++)
        		{
        			String ieName = (String) table.getValueAt(j, 0);
        			ieName = ieName.substring(0, ieName.lastIndexOf(" ")).trim();
        		
        			String importance = (String) table.getValueAt(j, 1);
        			String confidence = (String) table.getValueAt(j, 2);
        			
        			
        			for (Iterator<IntentionalElement> ieIterator = actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
					{
						IntentionalElement ie = (IntentionalElement) ieIterator.next();
						
						if(ie.getElementName().equals(ieName))
						{
							switch(importance)
							{
								case "Very High":	ie.setImportance(EImportance.VERY_HIGH);	break;
								case "High":		ie.setImportance(EImportance.HIGH);			break;
								case "Medium":		ie.setImportance(EImportance.MEDIUM);		break;
								case "Low":			ie.setImportance(EImportance.LOW);			break;
								case "Very Low":	ie.setImportance(EImportance.VERY_LOW);		break;
								default:			ie.setImportance(EImportance.NOT_DEFINED);	break;
							}
							
							switch(confidence)
							{
								case "Possibly More":	ie.setConfidence(EConfidence.POSSIBLY_MORE);	break;
								case "Confident":		ie.setConfidence(EConfidence.CONFIDENT);		break;
								case "Possibly Less":	ie.setConfidence(EConfidence.POSSIBLY_LESS);	break;
								default:				ie.setConfidence(EConfidence.NOT_DEFINED);		break;
							}
							
							break;
						}
					}
        		}
    		}
    		
    	}
		
		UsingEMFModel.save(goalModel, goalModelFile);
	}
	
	private JPanel generateTables() {
		
		ArrayList<String> cols = new ArrayList<String>();

		cols.add("Intentional Element");
		cols.add("Importance level");
		cols.add("Confidence level");
		
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		
		JPanel topPanel = new JPanel();
		Dimension d = getMaximumSize();
		d.height = 100;
		topPanel.setMaximumSize(d);
		
		JButton buttonBack = new JButton("Back to Goal Model selection");
		JButton buttonPropagation = new JButton("Propagation of Goal Model");
		JButton buttonExit = new JButton("Save and Exit");
		
		buttonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveGoalModel();
				
				new LoadFile(goalModelFile);
				dispose();
			}
		});
		
		buttonPropagation.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						saveGoalModel();
						
						boolean allPrioritized = true;
						
						for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
							Actor actor = (Actor) actorIterator.next();
							
							if(actor.getImportance() == EImportance.NOT_DEFINED || actor.getConfidence() == EConfidence.NOT_DEFINED)
							{
								System.out.println("Not prioritized: "+ actor.getElementName());
								allPrioritized = false;
								break;
							}
							
							for (Iterator<IntentionalElement> ieIterator = actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
							{
								IntentionalElement ie = (IntentionalElement) ieIterator.next();
								
								if(ie.getImportance() == EImportance.NOT_DEFINED || ie.getConfidence() == EConfidence.NOT_DEFINED)
								{
									System.out.println("Not prioritized: "+ actor.getElementName() + " - " + ie.getElementName());
									allPrioritized = false;
									break;
								}
							}
						}
						
						if(!allPrioritized)
						{
							 JOptionPane.showMessageDialog(null, "A level of importance and confidence must be assigned to all intentional elements and actors.");
						}
						else
						{
							new Propagation(goalModelFile, pictureFile);
							dispose();
						}
						
					}
				});
		
		buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveGoalModel();
				int result= JOptionPane.showConfirmDialog(null, "Are you sure you want to save and close the application?", null, JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION)
				{
					dispose();
				}
				
			}
		});
		
		topPanel.add(buttonBack);
		topPanel.add(buttonPropagation);
		topPanel.add(buttonExit);
		
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
				
				tableModel.addRow(objs.toArray());
			}
			
			JTable table = new JTable(tableModel);
			table.setName(actor.getElementName());
			table.setAutoCreateRowSorter(true);
			
			table.setDefaultRenderer(String.class, new MultilineTableCellRenderer());
			
			
			//Aling without actor
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);	//Importance
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);	//Confidence

			String[] importances = {"Very High", "High", "Medium", "Low", "Very Low", "Not Defined"};
			JComboBox comboImportance = new JComboBox<String>(importances);
			
			TableColumn colImportance = table.getColumnModel().getColumn(1);
			colImportance.setCellEditor(new DefaultCellEditor(comboImportance));
			
			colImportance.setCellRenderer(
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
			
			String[] confidences = {"Possibly More", "Confident", "Possibly Less", "Not Defined"};
			JComboBox comboConfidence = new JComboBox<String>(confidences);
			
			
			
			TableColumn colConfident = table.getColumnModel().getColumn(2);
			colConfident.setCellEditor(new DefaultCellEditor(comboConfidence));
			
			colConfident.setCellRenderer(
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
			b1.add( new JLabel("Prioritize the intentional elements of actor: " + actor.getElementName()));
			b1.add( Box.createHorizontalGlue() );
			jpanel.add( b1 );
			
			jpanel.add(table.getTableHeader());
			jpanel.add(table);
			//jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
			jpanel.add(Box.createVerticalStrut(20));
			
			actors.add(actor);
			tables.add(table);
		}
		
		ArrayList<String> cols2 = new ArrayList<String>();

		cols2.add("Actor");
		cols2.add("Importance level");
		cols2.add("Confidence level");
		
		DefaultTableModel tableModel = new DefaultTableModel(cols2.toArray(), 0) {
			//This make the shorter work correctly
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if(columnIndex < 3 || columnIndex > 4)	//4 if actor name is included
					return String.class;
				
				return Double.class;
			}
		};
		
		
		
		for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
			Actor actor = (Actor) actorIterator.next();
			
			ArrayList<Object> objs = new ArrayList<Object>();
			
			objs.add(actor.getElementName());
			objs.add(actor.getImportance().toString().replace('_', ' '));
			objs.add(actor.getConfidence().toString().replace('_', ' '));
			
			tableModel.addRow(objs.toArray());
		}
		
		
		
		JTable table = new JTable(tableModel);
		table.setName("Actors");
		table.setAutoCreateRowSorter(true);
		
		//Aling without actor
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);	//Importance
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);	//Confidence
		
		String[] importances = {"Very High", "High", "Medium", "Low", "Very Low", "Not Defined"};
		JComboBox comboImportance = new JComboBox<String>(importances);
		
		TableColumn colImportance = table.getColumnModel().getColumn(1);
		colImportance.setCellEditor(new DefaultCellEditor(comboImportance));
		
		colImportance.setCellRenderer(
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
		
		String[] confidences = {"Possibly More", "Confident", "Possibly Less", "Not Defined"};
		JComboBox comboConfidence = new JComboBox<String>(confidences);
		
		TableColumn colConfident = table.getColumnModel().getColumn(2);
		colConfident.setCellEditor(new DefaultCellEditor(comboConfidence));
		
		colConfident.setCellRenderer(
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
		
		jpanel.add(Box.createVerticalStrut(40));
		
		Box  b2 = Box.createHorizontalBox();
		b2.add( new JLabel("Prioritize the actors of the goal model:") );
		b2.add( Box.createHorizontalGlue() );
		jpanel.add( b2 );
		
		jpanel.add(table.getTableHeader());
		jpanel.add(table);
		//jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
		jpanel.add(Box.createVerticalStrut(40));
		
		if(!pictureFile.equals("None"))
		{
			  ImageIcon image = new ImageIcon(pictureFile);
			jpanel.add(new JLabel(image));
		}
		
		tables.add(table);
		actors.add(null);
		
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
			
			Prioritization prio = new Prioritization("file://" + "C:\\Users\\Kenov\\Desktop\\Kindle.xmi");
	
		}
}