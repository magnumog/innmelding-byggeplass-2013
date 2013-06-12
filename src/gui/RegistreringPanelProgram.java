package gui;

/*
 * Author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RegistreringPanelProgram extends JPanel {
	private static final long serialVersionUID = 1L;

	public RegistreringPanelProgram() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		PersonaliaPanel registreringPanel = new PersonaliaPanel();
		add(registreringPanel);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Registrering av personell på prosjekt");
		frame.getContentPane().setPreferredSize(new Dimension(450, 500));
		frame.add(new RegistreringPanelProgram()).setBackground(Color.red);
		frame.setMinimumSize(new Dimension(450, 500));
		frame.pack();
		frame.setLocation(50, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.setBounds(450, 500, 450, 500);
	}
}
