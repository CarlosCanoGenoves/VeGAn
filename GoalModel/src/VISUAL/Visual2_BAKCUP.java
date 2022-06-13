package VISUAL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import goalModel.GoalModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import VEGAN.UsingEMFModel;
import goalModel.Actor;
import goalModel.EConfidence;
import goalModel.EImportance;
import goalModel.Goal;
import goalModel.GoalModel;
import goalModel.IntentionalElement;
import goalModel.SoftGoal;
import goalModel.Task;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;

public class Visual2_BAKCUP extends JFrame {

	private JPanel contentPane;
	
	private GoalModel goalModel;
	private ArrayList<Actor> actors = new ArrayList<Actor>();
	private ArrayList<JTable> tables = new ArrayList<JTable>();

	private JScrollPane mainScrollPanel;
	private JPanel mainPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual2_BAKCUP frame = new Visual2_BAKCUP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Visual2_BAKCUP() {
		setTitle("VeGAn");
		setBounds(100, 100, 562, 418);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel toolBarPanel = new JPanel();
		contentPane.add(toolBarPanel, BorderLayout.NORTH);
		toolBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setMargin(new Insets(1,1,1,1));
		btnNewButton.setText(null);
		
		String path = "ToolTip.gif";
		btnNewButton.setIcon(new ImageIcon(getClass().getResource(path)));
		
		toolBarPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		toolBarPanel.add(btnNewButton_1);
		
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setMargin(new Insets(1,1,1,1));
		btnNewButton_1.setText(null);
		
		String path2 = "JDesktop.gif";
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource(path2)));
					
		mainScrollPanel = new JScrollPane();
		contentPane.add(mainScrollPanel, BorderLayout.CENTER);
		
		mainPanel = new JPanel();
		mainScrollPanel.setViewportView(mainPanel);
		mainPanel.resize(mainPanel.getMaximumSize());

		JPanel bottomPanel= new JPanel();
		FlowLayout flowLayout = (FlowLayout) bottomPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Actors: 3, Intentional Elements: 13");
		bottomPanel.add(lblNewLabel);
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open Goal Model");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser();
				jfc.setCurrentDirectory(new File("."));
		        jfc.setDialogTitle("Select a Goal Model");
		        jfc.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("XMI file", "xmi");
		        jfc.addChoosableFileFilter(filter);
				
		        int returnValue = jfc.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		        	goalModel = UsingEMFModel.load("file://" + jfc.getSelectedFile().getAbsolutePath());
		        	
		        	mainPanel.add(generateTables());
		        	//mainScrollPanel = new JScrollPane(generateTables());
		        	setVisible(true);
		        }
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open Image");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setCurrentDirectory(new File("."));
		        jfc.setDialogTitle("Select a Image");
		        jfc.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image file", "jpg");
		        jfc.addChoosableFileFilter(filter);
				
		        int returnValue = jfc.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		        	 ImageIcon image = new ImageIcon(jfc.getSelectedFile().getAbsolutePath());
		        	 //Image.setIcon(image);
		        	 //contentPane.add(new JLabel(image));
		        	 setVisible(true);
		        	 System.out.println("Image loaded");
		        }
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Quit");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Settings");
		menuBar.add(mnNewMenu_1);
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem about = new JMenuItem("About VeGAn");
		helpMenu.add(about);

	}
	
private JPanel generateTables() {
		
		ArrayList<String> cols = new ArrayList<String>();

		cols.add("Intentional Element");
		cols.add("Importance level");
		cols.add("Confidence level");
		
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		
		Dimension d = getMaximumSize();
		d.height = 100;
		
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
			b1.add( new JLabel("Actor: " + actor.getElementName()));
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
		b2.add( new JLabel("Prioritize actors:") );
		b2.add( Box.createHorizontalGlue() );
		jpanel.add( b2 );
		
		jpanel.add(table.getTableHeader());
		jpanel.add(table);
		//jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
		jpanel.add(Box.createVerticalStrut(40));
		
		/*
		if(!pictureFile.equals("None"))
		{
			  ImageIcon image = new ImageIcon(pictureFile);
			jpanel.add(new JLabel(image));
		}
		*/
		
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
}
