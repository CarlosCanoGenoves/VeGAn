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

	public static String XMIFile = "";
	
	public LoadFile()
	{
		setTitle("VeGAn");
        setSize(500, 200);

        JButton buttonSelectFile = new JButton("Select Goal Model (XMI file)");
        JLabel labelSelectedFile = new JLabel("File selected: None");
        JButton buttonPrioritization = new JButton("Prioritization of Goal Model");
        JButton buttonExit = new JButton("Exit");
        
        buttonSelectFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser();
		        jfc.setDialogTitle("Select a Goal Model");
		        jfc.setAcceptAllFileFilterUsed(false);
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("XMI file", "xmi");
		        jfc.addChoosableFileFilter(filter);
				
		        int returnValue = jfc.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		        	XMIFile = jfc.getSelectedFile().getAbsolutePath();
		        	//JOptionPane.showMessageDialog(null, "File selected: " + XMIFile);
		        	labelSelectedFile.setText("File selected: " + XMIFile);
		        }
		        
			}
		});
        
        buttonPrioritization.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(XMIFile.equals(""))
				{
					 JOptionPane.showMessageDialog(null, "You must select a file");
				}
				else
				{
					//JOptionPane.showMessageDialog(null, "Trying to open: "+XMIFile);
					new Prioritization("file://" + XMIFile);
					dispose();
				}
				
			}
		});

        buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result= JOptionPane.showConfirmDialog(null, "Are you sure you want to close the application?");
				
				if(result==0)
				{
					dispose();
				}
				
			}
		});
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel topPanel = new JPanel();
        
        // Add button to JPanel
        topPanel.add(buttonSelectFile);
        topPanel.add(buttonPrioritization);
        topPanel.add(buttonExit);
        
        panel.add(topPanel);
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(labelSelectedFile);
        
        panel.add(bottomPanel);


        add(panel);
        

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] argv) throws Exception {
		
		LoadFile lf = new LoadFile();
	}
	
}
