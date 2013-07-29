package panel;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.DBInnsertion;
import modell.ModulTo;

public class ModulToPanel extends JPanel implements ActionListener,PropertyChangeListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private static int sprak = 0;
	private static String[][] labelTekst = {{"Informert om fraværsoppfølging, alternativt arbeid ved skade/sykdom, AKAN, varslingsrutiner ved sykdom og skade.", "Underskrevet bedriftens sikkerhetsInstruks.", "Gjennomført obligatorisk sikkerhetsopplæring på prosjektet (Modul 2). (utdelt klistremerke for hjelm der dette benyttes).",
	"Mottatt klistremerke for godkjent Modul 1 og festet denne på hjelm.", "Arbeidstakeren er inneforstått med Veidekkes reaksjonsmønster ved brudd på sikkerhetsbestemmelser.","Fått utdelt avviksblokk og Risikovurdering - \"Blokk - løpende risikovurdering\"", "Gjort kjent med Byggherrens SHA-plan - oppslagstavle"
	,"<html><u>- sikkerhetsInstruks.</u></html>", "<html><u>- Veidekkes reaksjonsmønster ved brudd på sikkerhetsbestemmelser.</u></html>"},
	{"<html>Informed about follow-up of absence, alternative work in the event of injury/illness,<br> AKAN(the work avisory center for issues relating to alcohol, drugs and addictiv gambling),<br> notification routines for illness and injury</html>",
	"Signed the company safety instructions.", "Comleted mandatory safety training on the project(Module 2). (issued helmet badges where these are used)", "Recived badge for approved Module 1 and fixed this to helmet", 
	"The employee is aware of Veidekke's pattern of reaction to breach of safety regulations.", "Issued with non-conformance block and Risk Assessment - \"Block -  ongoing risk assessment\"","Made aware of client's helth and safety plan - information board",
	"<html><u>- safety instructions.</u></html>", "<html><u>- Veidekke's pattern of reaction to breach of safety regulations.</u></html>"},
	{"<html>Pracownik został poinformowany o konsekwencjach nieobecności,<br> pracach zamiennych w przypadku urazu lub choroby, AKAN (zakładowym biurze doradztwa w zakresie problemów<br> związanych z nadużywaniem alkoholu, stosowaniem narkotyków oraz uzależnieniem od gier hazardowych)<br> oraz procedurach dotyczących zgłaszania chorób i urazów.</html>",
	"Pracownik podpisał zakładowe instrukcje bezpieczeństwa.","<html>Pracownik ukończył obowiązkowe szkolenie z zakresu bezpieczeństwa przy realizacji projektu (moduł nr 2).<br> (Otrzymał oznaczenie na kask, jeśli są stosowane).</html>", "Pracownik otrzymał i umieścił na kasku oznaczenie zatwierdzonego modułu nr 1.",
	"<html>Pracownik zna stosowane przez firmę Veidekke standardowe procedury reagowania na<br> naruszenie przepisów bezpieczeństwa.</html>", "<html>Pracownik otrzymał świadectwo ukończenia szkolenia z zakresu niezgodności oraz oceny ryzyka – <br>„Blok – stała ocena ryzyka”</html>", "Pracownik zna plan bezpieczeństwa i higieny pracy (tablica informacyjna).",
	"<html><u>- instrukcje bezpieczeństwa.</u></html>","<html><u>- Veidekke standardowe procedury reagowania na<br> naruszenie przepisów bezpieczeństwa.</u></html>" }};
	private static JCheckBox fravar, bedriftsikkerhetsinstruks, gjennomfortModulTo, klistremerkeModulEn, veidekkesReaksjonsMonster, avviskblokkOgRisikovurdering, SHAplan;
	private static JLabel sikkerhet, reaksjonsmonster;

	
	protected static JButton neste, nullstill;
	
	ModulTo model = null;
//	DBConnection conn = new DBConnection();
	
	public ModulToPanel() {
		fravar = new JCheckBox(labelTekst[sprak][0]);
		bedriftsikkerhetsinstruks = new JCheckBox(labelTekst[sprak][1]);
		gjennomfortModulTo = new JCheckBox(labelTekst[sprak][2]);
		klistremerkeModulEn = new JCheckBox(labelTekst[sprak][3]);
		veidekkesReaksjonsMonster = new JCheckBox(labelTekst[sprak][4]);
		avviskblokkOgRisikovurdering = new JCheckBox(labelTekst[sprak][5]);
		SHAplan = new JCheckBox(labelTekst[sprak][6]);
		sikkerhet = new JLabel(labelTekst[sprak][7]);
		sikkerhet.setForeground(Color.BLUE);
		sikkerhet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sikkerhet.addMouseListener(this);
		reaksjonsmonster = new JLabel(labelTekst[sprak][8]);
		reaksjonsmonster.setForeground(Color.blue);
		reaksjonsmonster.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		reaksjonsmonster.addMouseListener(this);
		neste = new JButton("Neste");
		nullstill = new JButton();
		
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(1, 1, 1, 1);
		c.anchor = GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		c.insets = new Insets(0, 0, 0, 220);
		add(sikkerhet,c);
		c.gridy=1;
		add(reaksjonsmonster,c);
		c.gridy=3;
		c.insets = new Insets(0, 0, 0, 0);
		add(fravar,c);
		c.gridy=4;
		add(bedriftsikkerhetsinstruks,c);
		c.gridy=5;
		add(gjennomfortModulTo,c);
		c.gridy=6;
		add(klistremerkeModulEn,c);
		c.gridy=7;
		add(veidekkesReaksjonsMonster,c);
		c.gridy=8;
		add(avviskblokkOgRisikovurdering,c);
		c.gridy=9;
		add(SHAplan,c);
		c.gridy=10;
		add(neste,c);
		neste.setVisible(false);
//		c.gridy=1;
//		add(sikkerhet, c);
//		c.gridy=4;
//		c.insets = new Insets(0, 0, 0, 0);
//		add(reaksjonsmonster,c);
		
		fravar.addActionListener(this);
		bedriftsikkerhetsinstruks.addActionListener(this);
		gjennomfortModulTo.addActionListener(this);
		klistremerkeModulEn.addActionListener(this);
		veidekkesReaksjonsMonster.addActionListener(this);
		avviskblokkOgRisikovurdering.addActionListener(this);
		SHAplan.addActionListener(this);
		neste.addActionListener(this);
		nullstill.addActionListener(this);
	}
	
	public void setModel(ModulTo model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		fravar.setSelected(model.isFravaroppfolging());
		bedriftsikkerhetsinstruks.setSelected(model.isUnderskrevetsikkerhetsinstruks());
		gjennomfortModulTo.setSelected(model.isGjennomfortModulTo());
		klistremerkeModulEn.setSelected(model.isKlistremerkeModulEn());
		veidekkesReaksjonsMonster.setSelected(model.isInneforstattMedReaksjonsmonster());
		avviskblokkOgRisikovurdering.setSelected(model.isUtdeltBlokkLopendeRisiko());
		SHAplan.setSelected(model.isSHAPlan());
	}
	
	public ModulTo getModel() {
		return model;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
//		System.out.println("Hendelse");
		if(evt.getPropertyName() == ModulTo.FRAVAROPPFOLGING_PROPERTY) {
			fravar.setSelected(model.isFravaroppfolging());
		} else if(evt.getPropertyName() == ModulTo.UNDERSKREVETSIKKERHETSINSTRUKS_PROPERTY) {
			bedriftsikkerhetsinstruks.setSelected(model.isUnderskrevetsikkerhetsinstruks());
		} else if(evt.getPropertyName() == ModulTo.GJENNOMFORTMODULTO_PROPERTY) {
			gjennomfortModulTo.setSelected(model.isGjennomfortModulTo());
		} else if(evt.getPropertyName() == ModulTo.KLISTREMERKEMODULEN_PROPERTY) {
			klistremerkeModulEn.setSelected(model.isKlistremerkeModulEn());
		} else if(evt.getPropertyName() == ModulTo.INNEFORSTATTMEDREAKSJONSMONSER_PROPERTY) {
			veidekkesReaksjonsMonster.setSelected(model.isInneforstattMedReaksjonsmonster());
		} else if(evt.getPropertyName() == ModulTo.UTDELTBLOKKLOPENDERISIKO_PROPERTY) {
			avviskblokkOgRisikovurdering.setSelected(model.isUtdeltBlokkLopendeRisiko());
		} else if(evt.getPropertyName()== ModulTo.SHAPLAN_PROPERTY) {
			SHAplan.setSelected(model.isSHAPlan());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(model==null) {
			return;
		}
		
		if(e.getSource() == neste) {
			model.setFravaroppfolging(fravar.isSelected());
			model.setGjennomfortModulTo(gjennomfortModulTo.isSelected());
			model.setInneforstattMedReaksjonsmonster(veidekkesReaksjonsMonster.isSelected());
			model.setKlistremerkeModulEn(klistremerkeModulEn.isSelected());
			model.setSHAPlan(SHAplan.isSelected());
			model.setUnderskrevetsikkerhetsinstruks(bedriftsikkerhetsinstruks.isSelected());
			model.setUtdeltBlokkLopendeRisiko(avviskblokkOgRisikovurdering.isSelected());
			try {
				DBInnsertion.createModulTo(model.isFravaroppfolging(), model.isUnderskrevetsikkerhetsinstruks(), model.isGjennomfortModulTo(), model.isKlistremerkeModulEn(), model.isInneforstattMedReaksjonsmonster(), model.isUtdeltBlokkLopendeRisiko(), model.isSHAPlan());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			System.out.println("Fravær:" + model.isFravaroppfolging() + " Sikkerhetsinstruks:" + model.isUnderskrevetsikkerhetsinstruks() + "gjennomførtModulTo:" + model.isGjennomfortModulTo() + "Klistremerke:" +model.isKlistremerkeModulEn());
//			System.out.println("Reaksjonsmønster:" + model.isInneforstattMedReaksjonsmonster() + " Avviksblokk:" + model.isUtdeltBlokkLopendeRisiko() + " SHA-plan:" + model.isSHAPlan());
		} else if(e.getSource()== nullstill) {
			model.setFravaroppfolging(false);
			model.setGjennomfortModulTo(false);
			model.setInneforstattMedReaksjonsmonster(false);
			model.setKlistremerkeModulEn(false);
			model.setSHAPlan(false);
			model.setUnderskrevetsikkerhetsinstruks(false);
			model.setUtdeltBlokkLopendeRisiko(false);
		} else if(e.getSource()==fravar) {
			model.setFravaroppfolging(fravar.isSelected());
		} else if(e.getSource()==bedriftsikkerhetsinstruks) {
			model.setUnderskrevetsikkerhetsinstruks(bedriftsikkerhetsinstruks.isSelected());
		} else if(e.getSource()==gjennomfortModulTo) {
			model.setGjennomfortModulTo(gjennomfortModulTo.isSelected());
		} else if(e.getSource()==klistremerkeModulEn) {
			model.setKlistremerkeModulEn(klistremerkeModulEn.isSelected());
		} else if(e.getSource()==veidekkesReaksjonsMonster) {
			model.setInneforstattMedReaksjonsmonster(veidekkesReaksjonsMonster.isSelected());
		} else if(e.getSource()==avviskblokkOgRisikovurdering) {
			model.setUtdeltBlokkLopendeRisiko(avviskblokkOgRisikovurdering.isSelected());
		} else if(e.getSource() == SHAplan) {
			model.setSHAPlan(SHAplan.isSelected());
		}
	}
	
	public static void changeLanguage(int i) {
		sprak = i;
		fravar.setText(labelTekst[i][0]);
		bedriftsikkerhetsinstruks.setText(labelTekst[i][1]);
		gjennomfortModulTo.setText(labelTekst[i][2]);
		klistremerkeModulEn.setText(labelTekst[i][3]);
		veidekkesReaksjonsMonster.setText(labelTekst[i][4]);
		avviskblokkOgRisikovurdering.setText(labelTekst[i][5]);
		SHAplan.setText(labelTekst[i][6]);
		sikkerhet.setText(labelTekst[i][7]);
		reaksjonsmonster.setText(labelTekst[i][8]);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==sikkerhet) {
			try {
		        File myFile = new File("src/filer/sikkerhet.pdf");
		        Desktop.getDesktop().open(myFile);
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    }
			sikkerhet.setForeground(new Color(128,0,128));
		} else if(e.getSource() == reaksjonsmonster) {
			try {
		        File myFile = new File("src/filer/Burdd på sikkerhetsbestemelser.pdf");
		        Desktop.getDesktop().open(myFile);
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    }
			reaksjonsmonster.setForeground(new Color(128,0,128));
		} else {
			System.out.println("ingenting");
		}
		
	}

}
