package VISUAL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.emf.common.util.URI;

public class LoadFile extends JFrame{

	public static String XMIFile = "";
	
	public LoadFile()
	{
		setTitle("VeGAn");
        setSize(400, 400);

        JButton buttonSelectFile = new JButton("Select File");
        //JLabel labelSelectedFile = new JLabel("Select File");
        JButton buttonPrioritization = new JButton("Prioritization");
        
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
		        	JOptionPane.showMessageDialog(null, "File selected: " + XMIFile);
		        	//labelSelectedFile.setText(XMIFile);
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

        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Add button to JPanel
        panel.add(buttonSelectFile);
        //panel.add(labelSelectedFile);
        panel.add(buttonPrioritization);

        add(panel);
        

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] argv) throws Exception {
		
		LoadFile lf = new LoadFile();
	}
	
}
