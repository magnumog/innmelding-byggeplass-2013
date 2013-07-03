package program;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	JFrame main;
	JPanel Welcomme;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JButton velkommeNext;

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
		Velkommen velkommen = new Velkommen();
		
		//Dette for at det skal gå å bytte vindu
		main = new JFrame("Regustrering av personell på prosjekt");
		main.setSize(760, 800);
		main.setLocation(400, 100);
		main.setResizable(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Welcomme = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		Welcomme.add(velkommen);
		panel1.add(registreringPanel, BorderLayout.NORTH);
		panel1.add(modulEnPanel, BorderLayout.NORTH);
		panel2.add(sertifikatPanel, BorderLayout.NORTH);
		panel2.add(kursPanel, BorderLayout.NORTH);
		panel3.add(medbraktPanel, BorderLayout.NORTH);
		panel3.add(modulToPanel, BorderLayout.NORTH);
		
		velkommeNext = new JButton("Start registrering");
		velkommeNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.setContentPane(panel1);
				main.validate();
				main.repaint();
			}
		});
		
		JButton panelOneNext = new JButton("Neste");
		panelOneNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setContentPane(panel2);
				main.validate();
				main.repaint();
			}
		});
		JButton panelTwoNext = new JButton("Neste");
		panelTwoNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.setContentPane(panel3);
				main.validate();
				main.repaint();
			}
		});
		JButton panelTwoBack = new JButton("Tilbake");
		panelTwoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setContentPane(panel1);
				main.validate();
				main.repaint();
			}
		});
		
		JButton panelTreBack = new JButton("Tilbake");
		panelTreBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setContentPane(panel2);
				main.validate();
				main.repaint();
			}
		});
		panelOneNext.setAlignmentY(JButton.SOUTH);
		
		Welcomme.add(velkommeNext, BorderLayout.SOUTH);
		panel1.add(panelOneNext, BorderLayout.SOUTH);
		panel2.add(panelTwoBack, BorderLayout.SOUTH);
		panel2.add(panelTwoNext, BorderLayout.SOUTH);
		panel3.add(panelTreBack, BorderLayout.SOUTH);
		panel3.add(doClickPanel, BorderLayout.SOUTH);
		main.setContentPane(Welcomme);
		main.setVisible(true);
		
		
//		add(registreringPanel);
//		add(modulEnPanel);
//		add(sertifikatPanel);
//		add(kursPanel);
//		add(medbraktPanel);
//		add(modulToPanel);
//		add(doClickPanel);
		
		@SuppressWarnings("unused")
		DBSetup dbconn = new DBSetup();
		
	}
	
	public static void main(String[] args) {
//		JFrame frame = new JFrame("Registrering av personell på prosjekt");
//		JPanel p = new JPanel();
//		JScrollPane scrollframe = new JScrollPane(new RegistreringPanelProgram());
//		frame.add(p);
//		p.setVisible(true);
//		frame.getContentPane().add(new RegistreringPanelProgram());
//		frame.add(scrollframe);
//		frame.setMinimumSize(new Dimension(900, 1000));
//		frame.pack();
//		frame.setSize(900, 1000);//Denne som må brukes for å bestemme hvor stort vinduet skal være!
//		frame.setLocation(400, 100);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		@SuppressWarnings("unused")
		RegistreringPanelProgram prog = new RegistreringPanelProgram();
	}
	
	public static void changeLanguage(int i) {
		if(i==0) {
		}
	}
}
