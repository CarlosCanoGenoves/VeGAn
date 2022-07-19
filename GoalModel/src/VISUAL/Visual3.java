package VISUAL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
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

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Toolkit;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Visual3 extends JFrame {

	private JPanel contentPane;

	private GoalModel goalModel = null;
	private String goalModelFile;
	private ArrayList<Actor> actors = new ArrayList<Actor>();
	private ArrayList<JTable> tables = new ArrayList<JTable>();

	private JCheckBoxMenuItem imageOnTop;
	
	private JPanel toolBarPanel;
	private JPanel mainPanel;
	private JLabel imageLabel;
	private JLabel bottomInfoLabel;
	private JPanel bottomPanel;
	private String[] lookAndFeel = {"Metal", "Nimbus", "CDE/Motif", "Windows","Windows Classic"};
	private boolean prioritization = true;
	JButton prioritizationButton;
	JButton propagationnButton;
	
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
		        int resp = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to exit?",
		            "Exit?", JOptionPane.YES_NO_OPTION);

		        if (resp == JOptionPane.YES_OPTION) {
		            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        } else {
		            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		        }
		    }
		});
		
		//ICON COPYRIGHT: De Peepal Farm Foundation - File:Vegan friendly icon.png, CC BY-SA 4.0, https://commons.wikimedia.org/w/index.php?curid=81745546
		setIconImage(Toolkit.getDefaultToolkit().getImage(Visual3.class.getResource("/VISUAL/icons/vegan_white.png")));
		setTitle("VeGAn");
		setBounds(100, 100, 562, 418);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		toolBarPanel = generateToolbar();
		
		contentPane.add(toolBarPanel, BorderLayout.NORTH);
					
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
			
		
		JMenuBar menuBar = generateMenu();
		setJMenuBar(menuBar);
		
		//Default Theme -> Save on file
		setTheme(1);
	}

	private JMenuBar generateMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem openGoalModelMenu = new JMenuItem("Open Goal Model...");
		openGoalModelMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		openGoalModelMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadGoalModel();
			}
		});
		fileMenu.add(openGoalModelMenu);
		
		JMenuItem openImageMenu = new JMenuItem("Open Goal Model Picture...");
		openImageMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		openImageMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loadPicture();
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
		
		JMenuItem saveMenu = new JMenuItem("Save Goal Model");
		saveMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		saveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				saveGoalModelFile();
				if(goalModel!=null)
					JOptionPane.showMessageDialog(mainPanel, "Goal Model saved.");
				
			}
		});
		fileMenu.add(saveMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save Goal Model As...");
		mntmNewMenuItem.setEnabled(false);
		fileMenu.add(mntmNewMenuItem);
		
		JMenuItem quitMenu = new JMenuItem("Quit");
		quitMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//KHANX MODIFY THIS
				
				int resp = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to exit?",
			            "Exit?", JOptionPane.YES_NO_OPTION);

			        if (resp == JOptionPane.YES_OPTION) {
			            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        } else {
			            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			        }
			}
		});
		quitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
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
		
		toolBarPanel.setVisible(showToolbarSetting.getState());
		
		imageOnTop = new JCheckBoxMenuItem("Show Image on top");
		imageOnTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(null == goalModel || imageLabel.getIcon() == null)
					return;
				
				if(prioritization)
					prioritization();
				else
					propagation();
			}
		});
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
		
		JMenuItem about = new JMenuItem("About VeGAn...");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frame = new JFrame("About VeGAn");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Visual3.class.getResource("/VISUAL/icons/vegan_white.png")));
                frame.setTitle("About VeGAn");
                frame.setBounds(100, 100, 400, 225);
                frame.setSize(400, 225);

                JPanel panel = new JPanel();
                panel.setBorder(new EmptyBorder(5, 5, 5, 5));
                frame.setContentPane(panel);
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        		JLabel titleLabel = new JLabel(new ImageIcon(getClass().getResource("icons/aboutVegan.png")));
        		panel.add(titleLabel);
        		
        		panel.add(Box.createVerticalStrut(10));
        		panel.add(new JLabel("VeGAn v2.0.1"));
        		panel.add(Box.createVerticalStrut(10));
        		
        		panel.add(new JLabel("<html>Copyright "+ Character.toString(169) + " 2022 Universitat Politècnica de València,<br> Valencia, Spain</html>"));
        		panel.add(Box.createVerticalStrut(5));
        		panel.add(new JLabel("VeGAn Icon - De Peepal Farm Foundation"));       		        		

        		JHyperlink iconLink = new JHyperlink("File:Vegan friendly, CC BY-SA 4.0");
        		iconLink.setURL("https://commons.wikimedia.org/w/index.php?curid=81745546");
        		panel.add(iconLink);
        		panel.add(Box.createVerticalStrut(10));

        		panel.add(new JLabel("More information and examples:"));
        		JHyperlink webLink = new JHyperlink("https://research.webs.upv.es/vegan/");
        		webLink.setURL("https://research.webs.upv.es/vegan/");
        		panel.add(webLink);
        		       		
        		frame.setLocationRelativeTo(contentPane);
                frame.setVisible(true);
                frame.setResizable(false);
			}
		});
		helpMenu.add(about);
		
		return menuBar;
	}
	
	private JPanel generateToolbar() {
		JPanel toolBarPanel = new JPanel();
		toolBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton openGoalModelButton = new JButton("Open Goal Model...");
		openGoalModelButton.setToolTipText("Load Goal Model");
		openGoalModelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadGoalModel();
			}
		});
		
		toolBarPanel.add(openGoalModelButton);
		openGoalModelButton.setHorizontalAlignment(SwingConstants.LEFT);
		openGoalModelButton.setMargin(new Insets(1,1,1,1));
		openGoalModelButton.setText(null);
		openGoalModelButton.setIcon(new ImageIcon(getClass().getResource("icons/xmi.png")));
		
		JButton openImageButton = new JButton("Open Goal Model Picture...");
		openImageButton.setToolTipText("Load Picture");
		openImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPicture();
			}
		});
		toolBarPanel.add(openImageButton);
		openImageButton.setHorizontalAlignment(SwingConstants.LEFT);
		openImageButton.setMargin(new Insets(1,1,1,1));
		openImageButton.setText(null);
		openImageButton.setIcon(new ImageIcon(getClass().getResource("icons/image.png")));
		
		JButton saveButton = new JButton("Save");
		saveButton.setToolTipText("Save Goal Model");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveGoalModelFile();
				
				if(null == goalModel)
					JOptionPane.showMessageDialog(contentPane, "Goal Model not loaded.");
				else
					JOptionPane.showMessageDialog(contentPane, "Goal Model saved.");
			}
		});
		
		toolBarPanel.add(saveButton);
		saveButton.setHorizontalAlignment(SwingConstants.LEFT);
		saveButton.setMargin(new Insets(1,1,1,1));
		saveButton.setText(null);
		saveButton.setIcon(new ImageIcon(getClass().getResource("icons/save.png")));
		
		prioritizationButton = new JButton("Prioritization");
		prioritizationButton.setToolTipText("Prioritization");

		toolBarPanel.add(prioritizationButton);
		prioritizationButton.setHorizontalAlignment(SwingConstants.LEFT);
		prioritizationButton.setMargin(new Insets(1,1,1,1));
		prioritizationButton.setText(null);
		prioritizationButton.setIcon(new ImageIcon(getClass().getResource("icons/prioritization.png")));
		prioritizationButton.setEnabled(!prioritization);
		
		prioritizationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				saveGoalModel();
				prioritization();
				prioritization = true;
				
				prioritizationButton.setEnabled(!prioritization);
				propagationnButton.setEnabled(prioritization);

			}
		});
		
		propagationnButton = new JButton("Propagation");
		propagationnButton.setToolTipText("Propagation");

		toolBarPanel.add(propagationnButton);
		propagationnButton.setHorizontalAlignment(SwingConstants.LEFT);
		propagationnButton.setMargin(new Insets(1,1,1,1));
		propagationnButton.setText(null);
		propagationnButton.setIcon(new ImageIcon(getClass().getResource("icons/propagation.png")));
		propagationnButton.setEnabled(prioritization);
		
		propagationnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(goalModel==null)
				{
					JOptionPane.showMessageDialog(contentPane, "Goal Model not loaded.");
					return;
				}
				
				if(!canPropagate())
				{
					JOptionPane.showMessageDialog(contentPane, "A level of importance and confidence must be assigned to all intentional elements and actors.");
					return;
				}
						
				saveGoalModel();
				goalModel = FTOPSIS.calculateValue(goalModel).Item1;
				propagation();
				prioritization = false;
				
				prioritizationButton.setEnabled(!prioritization);
				propagationnButton.setEnabled(prioritization);
				
			}
		});
		
		JButton importFrompiStarButton = new JButton("Import Goal Model from piStar");
		importFrompiStarButton.setToolTipText("Import Goal Model from piStar");
		importFrompiStarButton.setEnabled(false);
		toolBarPanel.add(importFrompiStarButton);
		importFrompiStarButton.setHorizontalAlignment(SwingConstants.LEFT);
		importFrompiStarButton.setMargin(new Insets(1,1,1,1));
		importFrompiStarButton.setText(null);
		importFrompiStarButton.setIcon(new ImageIcon(getClass().getResource("icons/piStar.jpg")));
		
		JButton importFromjUCMNavButton = new JButton("Import Goal Model from jUCMNav");
		importFromjUCMNavButton.setToolTipText("Import Goal Model from jUCMNav");
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
		return toolBarPanel;
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
    	
    	prioritization = true;
    	prioritization();
    }
}

private void loadPicture()
{
	JFileChooser jfc = new JFileChooser();
	jfc.setCurrentDirectory(new File("."));
    jfc.setDialogTitle("Select a Picture");
    jfc.setAcceptAllFileFilterUsed(false);
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Picture file", "jpg", "jpeg", "png", "gif");
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
    		 if(prioritization)
    			 prioritization();
    		 else
    			 propagation();
    	 }
    }
}

//Saves the goalModel LOCAL MEMORY NOT FILE
private void saveGoalModel()
{
	if(goalModel == null)
		return;
	if(prioritization)
	{
		for(int i=0;i < actors.size();i++)
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
	else
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
			
			@Override
			   public boolean isCellEditable(int row, int column) {
			       //Only the third column
			       return column != 0;
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
		                	setBackground(null);	//new Color(137,186,255)
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
		                	setBackground(null);
		                return this;
		            }
		        });
		
		JPanel hideTable = new JPanel();
		hideTable.setLayout(new BoxLayout(hideTable, BoxLayout.Y_AXIS));
		
		Box  b1 = Box.createHorizontalBox();
		
		JLabel actorLabel = new JLabel("Actor: ");
		actorLabel.setFont(new Font(actorLabel.getName(), Font.BOLD, 16));

		JLabel actorLabel2 = new JLabel(actor.getElementName().trim());
		actorLabel2.setFont(new Font(actorLabel.getName(), Font.PLAIN, 16));
		
		b1.add(actorLabel);
		b1.add(actorLabel2);
		
		
		
		JButton showHideButton = new JButton("Show / Hide");
		showHideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideTable.setVisible(!hideTable.isVisible());
			}
		});
		
		b1.add(Box.createHorizontalStrut(10));
		b1.add(showHideButton);
		b1.add( Box.createHorizontalGlue() );
		
		jpanel.add( b1 );
		
		hideTable.add(table.getTableHeader());
		hideTable.add(table);
		jpanel.add(hideTable);
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
		
		@Override
		   public boolean isCellEditable(int row, int column) {
		       //Only the third column
		       return column != 0;
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
	                	setBackground(null);
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
	                	setBackground(null);
	                return this;
	            }
	        });
	
	JPanel testHideTable2 = new JPanel();
	testHideTable2.setLayout(new BoxLayout(testHideTable2, BoxLayout.Y_AXIS));
	
	Box  b2 = Box.createHorizontalBox();
	JLabel actorsLabel = new JLabel("Prioritize actors:");
	actorsLabel.setFont(new Font(actorsLabel.getName(), Font.BOLD, 16));
	
	b2.add(actorsLabel);
	
	JButton showHideButton2 = new JButton("Show / Hide");
	showHideButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			testHideTable2.setVisible(!testHideTable2.isVisible());
		}
	});
	b2.add(Box.createHorizontalStrut(10));
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
	actors.add(null);	//It is used when saving

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
	
	bottomInfoLabel = new JLabel("Actors: " + (actors.size()-1) + ", Intentional Elements: " + amountOfIE );
	bottomPanel.add(bottomInfoLabel);
	
	bottomPanel.validate();
	bottomPanel.repaint();
}

private boolean canPropagate()
{
	if(goalModel==null)
		return false;
		
	saveGoalModel();
	
	for (Iterator<Actor> actorIterator = goalModel.getActors().iterator(); actorIterator.hasNext();) {
		Actor actor = (Actor) actorIterator.next();
		
		if(actor.getImportance() == EImportance.NOT_DEFINED || actor.getConfidence() == EConfidence.NOT_DEFINED)
		{
			System.out.println("Not prioritized: "+ actor.getElementName());
			return false;
		}
		
		for (Iterator<IntentionalElement> ieIterator = actor.getIntentionalelements().iterator(); ieIterator.hasNext();)
		{
			IntentionalElement ie = (IntentionalElement) ieIterator.next();
			
			if(ie.getImportance() == EImportance.NOT_DEFINED || ie.getConfidence() == EConfidence.NOT_DEFINED)
			{
				System.out.println("Not prioritized: "+ actor.getElementName() + " - " + ie.getElementName());
				return false;
			}
		}
	}
	
	return true;
}

private void propagation() {
	mainPanel.removeAll();
	
	actors = new ArrayList<Actor>();
	tables = new ArrayList<JTable>();
		
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
	
	jpanel.add(Box.createVerticalStrut(10));
	
	if(imageLabel != null && imageOnTop.getState())
	{
		jpanel.add(imageLabel);
	}
		
	JPanel topPanel = new JPanel();
	Dimension d = getMaximumSize();
	d.height = 100;
	topPanel.setMaximumSize(d);

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
			
			@Override
			   public boolean isCellEditable(int row, int column) {
			       //Only the third column
			       return column == 7;
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
		                if(value.toString().equals("Not Defined"))
		                	setBackground(new Color(255,127,127));
		                else
		                	setBackground(null);
		                return this;
		            }
		        });
		
		JPanel hideTable = new JPanel();
		hideTable.setLayout(new BoxLayout(hideTable, BoxLayout.Y_AXIS));
		
		Box  b1 = Box.createHorizontalBox();
		
		
		JLabel actorLabel = new JLabel("Actor: ");
		actorLabel.setFont(new Font(actorLabel.getName(), Font.BOLD, 16));

		JLabel actorLabel2 = new JLabel(actor.getElementName().trim() + " ( ");
		actorLabel2.setFont(new Font(actorLabel.getName(), Font.PLAIN, 16));
		
		JLabel actorLabel3 = new JLabel("Importance level: ");
		actorLabel3.setFont(new Font(actorLabel.getName(), Font.BOLD, 16));
		
		JLabel actorLabel4 = new JLabel(actor.getImportance().toString().replace('_', ' ')+ ", ");
		actorLabel4.setFont(new Font(actorLabel.getName(), Font.PLAIN, 16));
		
		JLabel actorLabel5 = new JLabel("Confidence level: ");
		actorLabel5.setFont(new Font(actorLabel.getName(), Font.BOLD, 16));
		
		JLabel actorLabel6 = new JLabel(actor.getConfidence().toString().replace('_', ' ') + " )");
		actorLabel6.setFont(new Font(actorLabel.getName(), Font.PLAIN, 16));

	
		b1.add(actorLabel);
		b1.add(actorLabel2);
		b1.add(actorLabel3);
		b1.add(actorLabel4);
		b1.add(actorLabel5);
		b1.add(actorLabel6);
		
		JButton showHideButton = new JButton("Show / Hide");
		showHideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideTable.setVisible(!hideTable.isVisible());
			}
		});
		
		b1.add(Box.createHorizontalStrut(10));
		b1.add(showHideButton);
		b1.add( Box.createHorizontalGlue() );
		jpanel.add( b1 );
		
		hideTable.add(table.getTableHeader());
		hideTable.add(table);
		jpanel.add(hideTable);

		//jpanel.add(new JScrollPane(table), "growx,wrap,hmax 300");
		jpanel.add(Box.createVerticalStrut(20));
		
		actors.add(actor);
		tables.add(table);
	}
	
	if(imageLabel != null && !imageOnTop.getState())
	{
		jpanel.add(imageLabel);
	}

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
	
	bottomInfoLabel = new JLabel("Actors: " + actors.size() + ", Intentional Elements: " + amountOfIE );
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
