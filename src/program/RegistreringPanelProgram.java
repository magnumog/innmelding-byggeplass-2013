package program;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forst�elig
 * Owner Veidekke ASA
 **/



import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.DBSetup;
import panel.BekreftMedbraktPanel;
import panel.DoClickPanel;
import panel.KursPanel;
import panel.ModulEnPanel;
import panel.ModulToPanel;
import panel.PersonaliaPanel;
import panel.SertifikatPanel;
import modell.BekreftMedbrakt;
import modell.Kurs;
import modell.ModulEn;
import modell.ModulTo;
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
		
		ModulToPanel modulToPanel = new ModulToPanel();
		ModulTo modulTo = new ModulTo();
		modulToPanel.setModel(modulTo);
		
		DoClickPanel doClickPanel = new DoClickPanel();
		
		
		add(registreringPanel);
		add(modulEnPanel);
		add(sertifikatPanel);
		add(kursPanel);
		add(medbraktPanel);
		add(modulToPanel);
		add(doClickPanel);
		
		@SuppressWarnings("unused")
		DBSetup dbconn = new DBSetup();
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Registrering av personell p� prosjekt");
//		JPanel p = new JPanel();
//		JScrollPane scrollframe = new JScrollPane(new RegistreringPanelProgram());
//		frame.add(p);
//		p.setVisible(true);
		frame.getContentPane().add(new RegistreringPanelProgram());
//		frame.add(scrollframe);
		frame.setMinimumSize(new Dimension(900, 1000));
		frame.pack();
		frame.setSize(900, 1000);//Denne som m� brukes for � bestemme hvor stort vinduet skal v�re!
		frame.setLocation(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
