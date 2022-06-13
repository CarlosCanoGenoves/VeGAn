package VISUAL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Toolkit;

public class Visual3 extends JFrame {

	private JPanel contentPane;

	private GoalModel goalModel = null;
	private String goalModelFile;
	private ArrayList<Actor> actors = new ArrayList<Actor>();
	private ArrayList<JTable> tables = new ArrayList<JTable>();

	private JCheckBoxMenuItem imageOnTop;
	
	private JPanel mainPanel;
	private JLabel imageLabel;
	private JLabel bottomInfoLabel;
	private JPanel bottomPanel;
	private String[] lookAndFeel = {"Metal", "Nimbus", "CDE/Motif", "Windows","Windows Classic"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual3 frame = new Visual3();
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
	public Visual3() {
		//COPYRIGHT ICON: De Peepal Farm Foundation - File:Vegan friendly icon.png, CC BY-SA 4.0, https://commons.wikimedia.org/w/index.php?curid=81745546
		setIconImage(Toolkit.getDefaultToolkit().getImage(Visual3.class.getResource("/VISUAL/icons/vegan_white.png")));
		setTitle("VeGAn");
		setBounds(100, 100, 562, 418);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel toolBarPanel = new JPanel();
		contentPane.add(toolBarPanel, BorderLayout.NORTH);
		toolBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton loadGoalModelButton = new JButton("New button");
		loadGoalModelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadGoalModel();
			}
		});
		toolBarPanel.add(loadGoalModelButton);
		loadGoalModelButton.setHorizontalAlignment(SwingConstants.LEFT);
		loadGoalModelButton.setMargin(new Insets(1,1,1,1));
		loadGoalModelButton.setText(null);
		loadGoalModelButton.setIcon(new ImageIcon(getClass().getResource("icons/goalModel.png")));
		
		JButton loadImageButton = new JButton("New button");
		loadImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadImage();
			}
		});
		toolBarPanel.add(loadImageButton);
		loadImageButton.setHorizontalAlignment(SwingConstants.LEFT);
		loadImageButton.setMargin(new Insets(1,1,1,1));
		loadImageButton.setText(null);
		loadImageButton.setIcon(new ImageIcon(getClass().getResource("icons/image2.jpg")));
		
		JButton PrioritizationButton = new JButton("New button");
		toolBarPanel.add(PrioritizationButton);
		PrioritizationButton.setHorizontalAlignment(SwingConstants.LEFT);
		PrioritizationButton.setMargin(new Insets(1,1,1,1));
		PrioritizationButton.setText(null);
		PrioritizationButton.setIcon(new ImageIcon(getClass().getResource("icons/ToolTip.gif")));
		
		JButton PropagationButton = new JButton("New button");
		toolBarPanel.add(PropagationButton);
		PropagationButton.setHorizontalAlignment(SwingConstants.LEFT);
		PropagationButton.setMargin(new Insets(1,1,1,1));
		PropagationButton.setText(null);
		PropagationButton.setIcon(new ImageIcon(getClass().getResource("icons/ToolTip.gif")));
		
		JButton importFrompiStarButton = new JButton("New button");
		importFrompiStarButton.setEnabled(false);
		toolBarPanel.add(importFrompiStarButton);
		importFrompiStarButton.setHorizontalAlignment(SwingConstants.LEFT);
		importFrompiStarButton.setMargin(new Insets(1,1,1,1));
		importFrompiStarButton.setText(null);
		importFrompiStarButton.setIcon(new ImageIcon(getClass().getResource("icons/piStar.jpg")));
		
		JButton importFromjUCMNavButton = new JButton("New button");
		importFromjUCMNavButton.setEnabled(false);
		importFromjUCMNavButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toolBarPanel.add(importFromjUCMNavButton);
		importFromjUCMNavButton.setHorizontalAlignment(SwingConstants.LEFT);
		importFromjUCMNavButton.setMargin(new Insets(1,1,1,1));
		importFromjUCMNavButton.setText(null);
		importFromjUCMNavButton.setIcon(new ImageIcon(getClass().getResource("icons/jUCMNav.gif")));
		
					
		JScrollPane mainScrollPanel = new JScrollPane();
		mainScrollPanel.setBorder(new EtchedBorder());
		contentPane.add(mainScrollPanel, BorderLayout.CENTER);
		
		mainPanel = new JPanel();
		mainScrollPanel.setViewportView(mainPanel);

		mainPanel.setLayout(new GridLayout(1,1)); /* little trick ;) and believe me that this step is important to the automatic all columns resize! A import is also needed for using GridLayout*/

		bottomPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) bottomPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		bottomInfoLabel = new JLabel("Goal Model not loaded");
		bottomPanel.add(bottomInfoLabel);
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem openGoalModelMenu = new JMenuItem("Open Goal Model");
		openGoalModelMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadGoalModel();
			}
		});
		fileMenu.add(openGoalModelMenu);
		
		JMenuItem openImageMenu = new JMenuItem("Open Image");
		openImageMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadImage();
			}
		});
		
		fileMenu.add(openImageMenu);
		
		fileMenu.addSeparator();
		
		JMenuItem importFromPiStarMenu = new JMenuItem("Import Goal Model from piStar");
		importFromPiStarMenu.setEnabled(false);
		fileMenu.add(importFromPiStarMenu);
		
		JMenuItem importFromJUCMNavMenu = new JMenuItem("Import Goal Model from jUCMNav");
		importFromJUCMNavMenu.setEnabled(false);
		fileMenu.add(importFromJUCMNavMenu);
		
		fileMenu.addSeparator();
		
		JMenuItem saveMenu = new JMenuItem("Save");
		saveMenu.setEnabled(false);
		fileMenu.add(saveMenu);
		
		JMenuItem quitMenu = new JMenuItem("Quit");
		quitMenu.setEnabled(false);
		fileMenu.add(quitMenu);
		
		JMenu settingsMenu = new JMenu("Settings");
		menuBar.add(settingsMenu);
		
		JMenuItem propagationSettings = new JMenuItem("Propagation Settings");
		propagationSettings.setEnabled(false);
		settingsMenu.add(propagationSettings);
		
		settingsMenu.addSeparator();
		
		JMenuItem selectWorkingDirectory = new JMenuItem("Select Working Directory");
		selectWorkingDirectory.setEnabled(false);
		settingsMenu.add(selectWorkingDirectory);
		
		JCheckBoxMenuItem autoSaveMenu = new JCheckBoxMenuItem("Auto Save Model");
		autoSaveMenu.setEnabled(false);
		settingsMenu.add(autoSaveMenu);
		
		settingsMenu.addSeparator();
		
		JCheckBoxMenuItem showToolbarSetting = new JCheckBoxMenuItem("Show Toolbar");
		showToolbarSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toolBarPanel.setVisible(showToolbarSetting.getState());
			}
		});
		showToolbarSetting.setSelected(true);
		settingsMenu.add(showToolbarSetting);
		
		imageOnTop = new JCheckBoxMenuItem("Show Imaget at the Top");
		imageOnTop.setSelected(true);
		settingsMenu.add(imageOnTop);
		
		settingsMenu.addSeparator();
		
		JMenu selectThemeMenu = new JMenu("Select Theme");
		settingsMenu.add(selectThemeMenu);
		
		JRadioButtonMenuItem javaThemeMenu = new JRadioButtonMenuItem("Java Theme");
		javaThemeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTheme(0);
			}
		});
		selectThemeMenu.add(javaThemeMenu);
		
		JRadioButtonMenuItem nimbusThemeMenu = new JRadioButtonMenuItem("Nimbus Theme");
		nimbusThemeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTheme(1);
			}
		});
		nimbusThemeMenu.setSelected(true);
		selectThemeMenu.add(nimbusThemeMenu);
		
		JRadioButtonMenuItem motifThemeMenu = new JRadioButtonMenuItem("Motif Theme");
		motifThemeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTheme(2);
			}
		});
		selectThemeMenu.add(motifThemeMenu);
		
		JRadioButtonMenuItem windowsThemeMenu = new JRadioButtonMenuItem("Windows Theme");
		windowsThemeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTheme(3);
			}
		});
		selectThemeMenu.add(windowsThemeMenu);
		
		JRadioButtonMenuItem windowsClasicThemeMenu = new JRadioButtonMenuItem("Windows Clasic Theme");
		windowsClasicThemeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTheme(4);
			}
		});
		selectThemeMenu.add(windowsClasicThemeMenu);
		
		ButtonGroup group = new ButtonGroup();
		group.add(javaThemeMenu);
		group.add(nimbusThemeMenu);
		group.add(motifThemeMenu);
		group.add(windowsThemeMenu);
		group.add(windowsClasicThemeMenu);
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem about = new JMenuItem("About VeGAn");
		about.setEnabled(false);
		helpMenu.add(about);
		
		//Default Theme -> Save on file
		setTheme(1);
		
		toolBarPanel.setVisible(showToolbarSetting.getState());
	}

private void setTheme(int i)
{
	if(i > lookAndFeel.length)
		return;
	
	try {
        for (javax.swing.UIManager.LookAndFeelInfo info :  javax.swing.UIManager.getInstalledLookAndFeels()) {
            if (lookAndFeel[i].equals(info.getName())) {
            	Dimension d = this.getSize();
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                SwingUtilities.updateComponentTreeUI(this);
        		pack();
        		this.setSize(d);
                break;
            };
        }
     } catch (Exception ex) {
        System.out.println(ex);
    }
}
	
private void loadGoalModel()
{
	JFileChooser jfc = new JFileChooser();
	jfc.setCurrentDirectory(new File("."));
    jfc.setDialogTitle("Select a Goal Model");
    jfc.setAcceptAllFileFilterUsed(false);
    FileNameExtensionFilter filter = new FileNameExtensionFilter("XMI file", "xmi");
    jfc.addChoosableFileFilter(filter);
	
    int returnValue = jfc.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
    	goalModelFile = "file://" + jfc.getSelectedFile().getAbsolutePath();
    	goalModel = UsingEMFModel.load(goalModelFile);
    	
    	prioritization();
    }
}

private void loadImage()
{
	JFileChooser jfc = new JFileChooser();
	jfc.setCurrentDirectory(new File("."));
    jfc.setDialogTitle("Select a Image");
    jfc.setAcceptAllFileFilterUsed(false);
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Image file", "jpg");
    jfc.addChoosableFileFilter(filter);
	
    int returnValue = jfc.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
    	 ImageIcon image = new ImageIcon(jfc.getSelectedFile().getAbsolutePath());
    	 imageLabel = new JLabel(image);
    	 
    	 if(goalModel == null)
    	 {
    		 mainPanel.add(imageLabel);
    		 setVisible(true);
    	 }
    	 else
    	 {
    		 saveGoalModel();
    		 prioritization();
    	 }
    }
}

//Saves the goalModel LOCAL MEMORY NOT FILE
private void saveGoalModel()
{
	if(goalModel == null)
		return;
	
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
}

//Saves the goal model in a FILE
private void saveGoalModelFile()
{
	if(goalModel == null)
		return;
		
	saveGoalModel();
	
	//NOT TESTED
	if(!goalModelFile.substring(goalModelFile.length()-4).equals(".xmi"))
		goalModelFile += ".xmi";
	
	UsingEMFModel.save(goalModel, goalModelFile );
}


private void prioritization()
{
	mainPanel.removeAll();
	
	actors = new ArrayList<Actor>();
	tables = new ArrayList<JTable>();
	
	ArrayList<String> cols = new ArrayList<String>();

	cols.add("Intentional Element");
	cols.add("Importance level");
	cols.add("Confidence level");
	
	
	JPanel jpanel = new JPanel();
	jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
	
	Dimension d = getMaximumSize();
	d.height = 100;
	
	jpanel.add(Box.createVerticalStrut(10));
	
	if(imageLabel != null && imageOnTop.getState())
	{
		jpanel.add(imageLabel);
	}
	
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
		                if(value.toString().equals("Not Defined"))
		                	setBackground(new Color(255,127,127));
		                else
		                	setBackground(new Color(137,186,255));
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
		                if(value.toString().equals("Not Defined"))
		                	setBackground(new Color(255,127,127));
		                else
		                	setBackground(new Color(137,186,255));
		                return this;
		            }
		        });
		
		JPanel testHideTable = new JPanel();
		testHideTable.setLayout(new BoxLayout(testHideTable, BoxLayout.Y_AXIS));
		
		Box  b1 = Box.createHorizontalBox();
		b1.add( new JLabel("Actor: " + actor.getElementName()));
		
		JButton showHideButton = new JButton("Show / Hide");
		showHideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testHideTable.setVisible(!testHideTable.isVisible());
			}
		});
		b1.add(showHideButton);
		b1.add( Box.createHorizontalGlue() );
		
		jpanel.add( b1 );
		
		testHideTable.add(table.getTableHeader());
		testHideTable.add(table);
		jpanel.add(testHideTable);
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
	                if(value.toString().equals("Not Defined"))
	                	setBackground(new Color(255,127,127));
	                else
	                	setBackground(new Color(137,186,255));
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
	                if(value.toString().equals("Not Defined"))
	                	setBackground(new Color(255,127,127));
	                else
	                	setBackground(new Color(137,186,255));
	                return this;
	            }
	        });
	
	jpanel.add(Box.createVerticalStrut(40));
	
	JPanel testHideTable2 = new JPanel();
	testHideTable2.setLayout(new BoxLayout(testHideTable2, BoxLayout.Y_AXIS));
	
	Box  b2 = Box.createHorizontalBox();
	b2.add( new JLabel("Prioritize actors:") );
	JButton showHideButton2 = new JButton("Show / Hide");
	showHideButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			testHideTable2.setVisible(!testHideTable2.isVisible());
		}
	});
	b2.add(showHideButton2);
	b2.add( Box.createHorizontalGlue() );
	jpanel.add( b2 );
	
	
	testHideTable2.add(table.getTableHeader());
	testHideTable2.add(table);
	jpanel.add(testHideTable2);
	//jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
	jpanel.add(Box.createVerticalStrut(40));
	
	
	if(imageLabel != null && !imageOnTop.getState())
	{
		jpanel.add(imageLabel);
	}
	
	
	tables.add(table);
	actors.add(null);

	mainPanel.add(jpanel);
	
	mainPanel.validate();
	mainPanel.repaint();
	
	
	
	bottomPanel.removeAll();
	
	int amountOfIE = 0;

	for(Actor actor : actors)
	{
		if(actor!= null && actor.getIntentionalelements() != null)
			amountOfIE += actor.getIntentionalelements().size();
	}
	
	bottomInfoLabel = new JLabel("Actors: "+actors.size() + ", Intentional Elements: " + amountOfIE );
	bottomPanel.add(bottomInfoLabel);
	
	bottomPanel.validate();
	bottomPanel.repaint();
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
