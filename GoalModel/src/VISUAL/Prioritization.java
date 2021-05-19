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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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

	public String location = "hope.xmi";
	public GoalModel goalModel;
	
	private ArrayList<Actor> actors = new ArrayList<Actor>();
	private ArrayList<JTable> tables = new ArrayList<JTable>();
	
	
	public Prioritization(String location)
	{
		this.location = location;
		setTitle("VeGAn");
		setSize(800, 400);
		
		goalModel = UsingEMFModel.load(location);

		add(new JScrollPane(generateTables()));
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	
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
        								case "Very_High":	actor.setImportance(EImportance.VERY_HIGH);		break;
        								case "High":		actor.setImportance(EImportance.HIGH);			break;
        								case "Medium":		actor.setImportance(EImportance.MEDIUM);		break;
        								case "Low":			actor.setImportance(EImportance.LOW);			break;
        								case "Very_Low":	actor.setImportance(EImportance.VERY_LOW);		break;
        								default:			actor.setImportance(EImportance.NOT_DEFINED);	break;
        							}
        							
        							switch(confidence)
        							{
        								case "Possibly_More":	actor.setConfidence(EConfidence.POSSIBLY_MORE);	break;
        								case "Confident":		actor.setConfidence(EConfidence.CONFIDENT);		break;
        								case "Possibly_Less":	actor.setConfidence(EConfidence.POSSIBLY_LESS);	break;
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
        								case "Very_High":	ie.setImportance(EImportance.VERY_HIGH);	break;
        								case "High":		ie.setImportance(EImportance.HIGH);			break;
        								case "Medium":		ie.setImportance(EImportance.MEDIUM);		break;
        								case "Low":			ie.setImportance(EImportance.LOW);			break;
        								case "Very_Low":	ie.setImportance(EImportance.VERY_LOW);		break;
        								default:			ie.setImportance(EImportance.NOT_DEFINED);	break;
        							}
        							
        							switch(confidence)
        							{
        								case "Possibly_More":	ie.setConfidence(EConfidence.POSSIBLY_MORE);	break;
        								case "Confident":		ie.setConfidence(EConfidence.CONFIDENT);		break;
        								case "Possibly_Less":	ie.setConfidence(EConfidence.POSSIBLY_LESS);	break;
        								default:				ie.setConfidence(EConfidence.NOT_DEFINED);		break;
        							}
        							
        							break;
        						}
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
		
		ArrayList<String> cols = new ArrayList<String>();

		cols.add("Intentional Element");
		cols.add("Importance");
		cols.add("Confidence");
		
		
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
				objs.add(ie.getElementName() + " " + getIntentionalType(ie));
				objs.add(ie.getImportance().toString());
				objs.add(ie.getConfidence().toString());
				
				tableModel.addRow(objs.toArray());
			}
			
			JTable table = new JTable(tableModel);
			table.setName(actor.getElementName());
			table.setAutoCreateRowSorter(true);
			
			table.setDefaultRenderer(String.class, new MultilineTableCellRenderer());
			
			
			//Aling without actor
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);	//Importance
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);	//Confidence

			String[] importances = {"Very_High", "High", "Medium", "Low", "Very_Low"};
			JComboBox comboImportance = new JComboBox<String>(importances);
			
			TableColumn colImportance = table.getColumnModel().getColumn(1);
			colImportance.setCellEditor(new DefaultCellEditor(comboImportance));
			
			String[] confidences = {"Possibly_More", "Confident", "Possibly_Less"};
			JComboBox comboConfidence = new JComboBox<String>(confidences);
			
			TableColumn colConfident = table.getColumnModel().getColumn(2);
			colConfident.setCellEditor(new DefaultCellEditor(comboConfidence));
			
			
			jpanel.add(new JLabel("Actor: " + actor.getElementName()));
			jpanel.add(table.getTableHeader());
			jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
			//jpanel.add(Box.createVerticalStrut(20));
			
			actors.add(actor);
			tables.add(table);
		}
		
		ArrayList<String> cols2 = new ArrayList<String>();

		cols2.add("Actor");
		cols2.add("Importance");
		cols2.add("Confidence");
		
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
			objs.add(actor.getImportance().toString());
			objs.add(actor.getConfidence().toString());
			
			tableModel.addRow(objs.toArray());
		}
		
		
		
		JTable table = new JTable(tableModel);
		table.setName("Actors");
		table.setAutoCreateRowSorter(true);
		
		//Aling without actor
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);	//Importance
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);	//Confidence
		
		String[] importances = {"Very_High", "High", "Medium", "Low", "Very_Low"};
		JComboBox comboImportance = new JComboBox<String>(importances);
		
		TableColumn colImportance = table.getColumnModel().getColumn(1);
		colImportance.setCellEditor(new DefaultCellEditor(comboImportance));
		
		String[] confidences = {"Possibly_More", "Confident", "Possibly_Less"};
		JComboBox comboConfidence = new JComboBox<String>(confidences);
		
		TableColumn colConfident = table.getColumnModel().getColumn(2);
		colConfident.setCellEditor(new DefaultCellEditor(comboConfidence));
		
		jpanel.add(table.getTableHeader());
		jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
		jpanel.add(Box.createVerticalStrut(20));
		
		tables.add(table);
		actors.add(null);
		
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