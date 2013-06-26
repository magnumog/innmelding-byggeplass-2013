package program;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/



import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import database.DBSetup;
import panel.BekreftMedbraktPanel;
import panel.DoClickPanel;
import panel.KursPanel;
import panel.ModulEnPanel;
import panel.PersonaliaPanel;
import panel.SertifikatPanel;
import modell.BekreftMedbrakt;
import modell.Kurs;
import modell.ModulEn;
import modell.Personalia;
import modell.Sertifikat;


public class RegistreringPanelProgram extends JPanel {
	private static final long serialVersionUID = 1L;

	public RegistreringPanelProgram() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
//		kobler modellen opp mot viewet slik at modellen skal oppdateres ved endringer
		PersonaliaPanel registreringPanel = new PersonaliaPanel();
		Personalia personaliaModel = new Personalia();
		registreringPanel.setModel(personaliaModel);
				
		ModulEnPanel modulEnPanel = new ModulEnPanel();
		ModulEn modulEnModel = new ModulEn();
		modulEnPanel.setModel(modulEnModel);

		SertifikatPanel sertifikatPanel = new SertifikatPanel();
		Sertifikat sertifikatModel = new Sertifikat();
		sertifikatPanel.setModel(sertifikatModel);
		
		KursPanel kursPanel = new KursPanel();
		Kurs kursModel = new Kurs();
		kursPanel.setModel(kursModel);
		
		BekreftMedbraktPanel medbraktPanel = new BekreftMedbraktPanel();
		BekreftMedbrakt medbraktModel = new BekreftMedbrakt();
		medbraktPanel.setModel(medbraktModel);
		
		DoClickPanel doClickPanel = new DoClickPanel();
		
		
//		add(registreringPanel);
//		add(modulEnPanel);
//		add(sertifikatPanel);
//		add(kursPanel);
		add(medbraktPanel);
//		add(doClickPanel);
		
		@SuppressWarnings("unused")
		DBSetup dbconn = new DBSetup();
		
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
