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
	public static int sprak=0;
	private static String[][] tekst = {{"Start registrering","Neste", "Tilbake"}, {"Start registration","Next", "Back"},{"Start rejestracja", "Nastepny", "Z powrotem"}};
	private JFrame main;
	private JPanel Welcomme;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private static JButton velkommeNext,panelOneNext, panelOneBack,panelTwoNext,panelTwoBack,panelTreBack;

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
		main = new JFrame("Registrering av personell på prosjekt");
		main.setSize(730, 800);
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

		buttons();
		panelOneNext.setAlignmentY(JButton.SOUTH);

		Welcomme.add(velkommeNext, BorderLayout.SOUTH);
		panel1.add(panelOneBack, BorderLayout.SOUTH);
		panel1.add(panelOneNext, BorderLayout.SOUTH);
		panel2.add(panelTwoBack, BorderLayout.SOUTH);
		panel2.add(panelTwoNext, BorderLayout.SOUTH);
		panel3.add(panelTreBack, BorderLayout.SOUTH);
		panel3.add(doClickPanel, BorderLayout.SOUTH);
		main.setContentPane(Welcomme);
		main.setVisible(true);

		@SuppressWarnings("unused")
		DBSetup dbconn = new DBSetup();

	}

	private void buttons() {
		velkommeNext = new JButton(tekst[sprak][0]);
		velkommeNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.setContentPane(panel1);
				main.validate();
				main.repaint();
			}
		});

		panelOneNext = new JButton(tekst[sprak][1]);
		panelOneNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setContentPane(panel2);
				main.validate();
				main.repaint();
			}
		});
		panelTwoNext = new JButton(tekst[sprak][1]);
		panelTwoNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.setContentPane(panel3);
				main.validate();
				main.repaint();
			}
		});

		panelOneBack = new JButton(tekst[sprak][2]); //må nulling av feltene også implementeres
		panelOneBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoClickPanel.nullstill.doClick();
				main.setContentPane(Welcomme);
				main.validate();
				main.repaint();
			}
		});

		panelTwoBack = new JButton(tekst[sprak][2]);
		panelTwoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setContentPane(panel1);
				main.validate();
				main.repaint();
			}
		});

		panelTreBack = new JButton(tekst[sprak][2]);
		panelTreBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setContentPane(panel2);
				main.validate();
				main.repaint();
			}
		});

	}
	public static void changeLanguage(int i) {
		sprak = i;
		velkommeNext.setText(tekst[i][0]);
		panelOneNext.setText(tekst[i][1]);
		panelTwoNext.setText(tekst[i][1]);
		panelOneBack.setText(tekst[i][2]);
		panelTwoBack.setText(tekst[i][2]);
		panelTreBack.setText(tekst[i][2]);
	}	

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		RegistreringPanelProgram prog = new RegistreringPanelProgram();
	}

}
