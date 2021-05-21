package VISUAL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadFile extends JFrame{

	public static String imageFile = "None";
	public static String XMIFile = "None";
	
	
	public LoadFile()
	{
		this("None");
	}
	
	public LoadFile(String location)
	{
		XMIFile = location;
		setTitle("VeGAn");
        setSize(700, 200);

        JButton buttonSelectGoalModel = new JButton("Load Goal Model (XMI file)...");
        JButton buttonSelectImage = new JButton("Load Goal Model Image...");
        JLabel labelSelectedFile = new JLabel("Goal Model selected: " + XMIFile.replace("file://", ""));
        JLabel labelSelectedImage = new JLabel("Image selected: " + imageFile);
        JButton buttonPrioritization = new JButton("Prioritization of Goal Model");
        JButton buttonExit = new JButton("Exit");
        
        buttonSelectGoalModel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser();
		        jfc.setDialogTitle("Select a Goal Model");
		        jfc.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("XMI file", "xmi");
		        jfc.addChoosableFileFilter(filter);
				
		        int returnValue = jfc.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		        	XMIFile = "file://" + jfc.getSelectedFile().getAbsolutePath();
		        	//JOptionPane.showMessageDialog(null, "File selected: " + XMIFile);
		        	labelSelectedFile.setText("Goal Model selected: " + XMIFile.replace("file://", ""));
		        }
		        
			}
		});
        
        buttonSelectImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser();
		        jfc.setDialogTitle("Select a Image");
		        jfc.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image file", "jpg");
		        jfc.addChoosableFileFilter(filter);
				
		        int returnValue = jfc.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		        	imageFile = jfc.getSelectedFile().getAbsolutePath();
		        	labelSelectedImage.setText("Image selected: " + imageFile);
		        }
		        
			}
		});
        
        buttonPrioritization.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(XMIFile.equals("None"))
				{
					 JOptionPane.showMessageDialog(null, "You must select a file");
				}
				else
				{
					//JOptionPane.showMessageDialog(null, "Trying to open: "+XMIFile);
					new Prioritization(XMIFile, imageFile);
					dispose();
				}
				
			}
		});

        buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application?", null, JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION)
				{
					dispose();
				}
				
			}
		});
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel topPanel = new JPanel();
        
        // Add button to JPanel
        topPanel.add(buttonSelectGoalModel);
        topPanel.add(buttonSelectImage);
        topPanel.add(buttonPrioritization);
        topPanel.add(buttonExit);
        
        panel.add(topPanel);
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(labelSelectedFile);
        
        panel.add(bottomPanel);
        
        JPanel bottomPane2 = new JPanel();
        bottomPane2.add(labelSelectedImage);
        
        panel.add(bottomPane2);


        add(panel);
        

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] argv) throws Exception {
		
		LoadFile lf = new LoadFile("None");
	}
	
}
