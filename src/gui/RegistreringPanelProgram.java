package gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RegistreringPanelProgram extends JPanel {
	public RegistreringPanelProgram() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		RegistreringPanel registreringPanel = new RegistreringPanel();
		
	}
	
public static void main(String[] args) {
	JFrame frame = new JFrame("Registrering av personell på prosjekt");
	frame.getContentPane().add(new RegistreringPanelProgram()).setPreferredSize(new Dimension(900, 1000));
	frame.pack();
	frame.setLocation(100, 100);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	//frame.setSize(900, 1000);
}
}
