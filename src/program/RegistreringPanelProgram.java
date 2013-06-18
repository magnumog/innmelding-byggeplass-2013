package program;

/*
 * Author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 */


import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import panel.KursPanel;
import panel.ModulEnPanel;
import panel.PersonaliaPanel;
import panel.SertifikatPanel;

import modell.Personalia;
import modell.Sertifikat;


public class RegistreringPanelProgram extends JPanel {
	private static final long serialVersionUID = 1L;

	public RegistreringPanelProgram() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
//		PersonaliaPanel registreringPanel = new PersonaliaPanel();
		ModulEnPanel modulEn = new ModulEnPanel();
		SertifikatPanel sertifikatPanel = new SertifikatPanel();
		KursPanel kursPanel = new KursPanel();
		
		
//		kobler modellen opp mot viewet slik at modellen skal oppdateres ved endringer
//		Personalia personaliaModel = new Personalia();
//		registreringPanel.setModel(personaliaModel);
		Sertifikat sertifikatModel = new Sertifikat();
		sertifikatPanel.setModel(sertifikatModel);
		
//		add(registreringPanel);
		add(modulEn);
		add(sertifikatPanel);
		add(kursPanel);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Registrering av personell på prosjekt");
		frame.getContentPane().add(new RegistreringPanelProgram());
		frame.setMinimumSize(new Dimension(800, 1000));
//		frame.setMaximumSize(new Dimension(470, 600));
		frame.pack();
		frame.setLocation(0, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.setBounds(450, 500, 450, 500)
		
		/*JFrame frame = new JFrame("Oving 3");
		frame.getContentPane().add(new RegistreringPanelProgram());
		frame.pack();
		frame.setLocation(0, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);*/
	}
}
