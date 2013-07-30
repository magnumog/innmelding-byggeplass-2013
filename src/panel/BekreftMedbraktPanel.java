package panel;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DBInnsertion;

import modell.BekreftMedbrakt;

public class BekreftMedbraktPanel extends JPanel implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private static int sprak = 0;
	private static String[][] labelTekst = {{"<html>Påbudt verneutstyr: Hjelm(Standard: EN397)<br> og vernesko(Standard: EN345(EN ISO20345)) med spikertrampsåle.</html>", "<html>Alltid tilgengelig: Hørselvern, øyevern, arbeidshansker<br> og ved behov Åndedrettsvern, kjemikalie-/kuttreduserende-/spesialhansker og synbarhetstøy</html>",
		"Dato:","Navn på arbeidgiver:"},
		{"<html>Mandatory protective equipment: Helmet(Standard: EN3907)<br> and protective footwear(Standard: EN345(EN ISO20345)) with penetration-resistant soles</html>", "<html>Always available: Hearing protection, eye protection, work gloves<br> and if needed: Breathing protection, chemical/cutreducing/special gloves and high-visibility clothing</html>", "Date:", "Name of Emplyer:"},
		{"<html>Obowiązkowe wyposażenie ochronne: kask (norma: EN 397)<br> i obuwie ochronne (norma: EN 345 (EN ISO 20345)) z podeszwami odpornymi na penetrację. </html>", "<html>Zawsze dostępne: środki ochrony uszu, środki ochrony oczu, rękawice robocze;<br> w razie konieczności: środki ochrony układu oddechowego,<br> rękawice chroniące przed działaniem środków chemicznych/przecięciem/specjalistyczne, odzież odblaskowa.</html>",
			"Data:","nazwa na Pracodawca:"}};
	private static JCheckBox harMedVerneUtstyr, tillgjengeligVerneUtstyr;
	private static JTextField datoBekreftet, navnPaaArbeidstaker;
	private static JLabel datoLabel, arbeidsgiverLabel;
	
	protected static JButton neste, nullstill;
	
	BekreftMedbrakt model = null;
	
//	DBConnection conn = new DBConnection();
	
	public BekreftMedbraktPanel() {
		harMedVerneUtstyr = new JCheckBox(labelTekst[sprak][0]);
		tillgjengeligVerneUtstyr = new JCheckBox(labelTekst[sprak][1]);
		datoBekreftet = new JTextField(8);
		navnPaaArbeidstaker = new JTextField(15);
		datoLabel = new JLabel(labelTekst[sprak][2]);
		arbeidsgiverLabel = new JLabel(labelTekst[sprak][3]);
		neste = new JButton("NESTE");
		nullstill = new JButton();
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(1,1,1,1);
		c.anchor = GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		add(harMedVerneUtstyr,c);
		c.gridy=1;
		add(tillgjengeligVerneUtstyr,c);
		c.gridy=2;
		add(datoLabel,c);
		c.gridx=0;
		c.insets = new Insets(5,35,1,1);
		add(datoBekreftet,c);
		c.gridx=0;
		c.insets = new Insets(0,148,1,1);
		add(arbeidsgiverLabel,c);
		c.gridx=0;
		c.insets = new Insets(4,268,1,50);
		add(navnPaaArbeidstaker,c);
		c.gridy=3;
		add(neste,c);
		neste.setVisible(false);
		
		harMedVerneUtstyr.addActionListener(this);
		tillgjengeligVerneUtstyr.addActionListener(this);
		datoBekreftet.addActionListener(this);
		navnPaaArbeidstaker.addActionListener(this);
		neste.addActionListener(this);
		nullstill.addActionListener(this);
	}
	
	public void setModel(BekreftMedbrakt model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		harMedVerneUtstyr.setSelected(model.isPabudtVerneutstyr());
		tillgjengeligVerneUtstyr.setSelected(model.isTilgjengeligVerneutstyr());
		datoBekreftet.setText(model.getDato());
		navnPaaArbeidstaker.setText(model.getNavnPaaArbeidgiver());
	}
	
	public BekreftMedbrakt getModel() {
		return model;
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
//		System.out.println("Hendelse");
		if(evt.getPropertyName() == BekreftMedbrakt.PAABUDTVERNEUTSTYR_PROPERTY) {
			harMedVerneUtstyr.setSelected(model.isPabudtVerneutstyr());
		} else if(evt.getPropertyName() == BekreftMedbrakt.TILGJENGELIGVERNEUTSTYR_PROPERTY) {
			tillgjengeligVerneUtstyr.setSelected(model.isTilgjengeligVerneutstyr());
		} else if(evt.getPropertyName() == BekreftMedbrakt.DATO_PROPERTY) {
			datoBekreftet.setText(model.getDato());
		} else if(evt.getPropertyName() == BekreftMedbrakt.NAVNPAAARBEIDSGIVER_PROPERTY) {
			navnPaaArbeidstaker.setText(model.getNavnPaaArbeidgiver());
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(model == null) {
			return;
		}
		
		if(e.getSource() == neste) {
			model.setDato(datoBekreftet.getText());
			model.setNavnPaaArbeidgiver(navnPaaArbeidstaker.getText());
			model.setPabudtVerneutstyr(harMedVerneUtstyr.isSelected());
			model.setTilgjengeligVerneutstyr(tillgjengeligVerneUtstyr.isSelected());
			try {
				DBInnsertion.createVerneutstyr(model.isPabudtVerneutstyr(), model.isTilgjengeligVerneutstyr(), model.getDato(), model.getNavnPaaArbeidgiver());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Det skjedde noe feil når dataene skulle overføres til databasen programmet avsluttes, vennligst kontakt hjelp");
				System.exit(0);
			}
//			System.out.println("PabudtVern:" + model.isPabudtVerneutstyr() + " TilgjengeligVern:" + model.isTilgjengeligVerneutstyr() + " Dato:" + model.getDato() + " Navnpåarbeidsgiver:" + model.getNavnPaaArbeidgiver());
		} else if(e.getSource()== nullstill) {
			model.setDato(null);
			model.setNavnPaaArbeidgiver(null);
			model.setPabudtVerneutstyr(false);
			model.setTilgjengeligVerneutstyr(false);
		} else if(e.getSource() == datoBekreftet) {
			model.setDato(datoBekreftet.getText());
		} else if(e.getSource() == navnPaaArbeidstaker) {
			model.setNavnPaaArbeidgiver(navnPaaArbeidstaker.getText());
		} else if(e.getSource() == harMedVerneUtstyr) {
			model.setPabudtVerneutstyr(harMedVerneUtstyr.isSelected());
		} else if(e.getSource() == tillgjengeligVerneUtstyr) {
			model.setTilgjengeligVerneutstyr(tillgjengeligVerneUtstyr.isSelected());
		}
		
	}

	public static void changeLanguage(int i) {
		sprak = i;
		harMedVerneUtstyr.setText(labelTekst[i][0]);
		tillgjengeligVerneUtstyr.setText(labelTekst[i][1]);
		datoLabel.setText(labelTekst[i][2]);
		arbeidsgiverLabel.setText(labelTekst[sprak][3]);
		if(i==2){
//			navnPaaArbeidstaker.setColumns(6);
		}
	}
}
