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
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DBInnsertion;

import modell.Kurs;

public class KursPanel extends JPanel implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private static int sprak = 0;
	private static String[][] labelTekst = {{"Verksted og lager, type:", "Spesialkraner, type:", "Vinsjer oig taljer","Anhuking - stropping - signalgivning", "Klatre- og hengestillaser(36t kurs)","Personløftere klasse: ", "Personløftere under jord", "Borvogner og tunnelrigger",
		"Selvgående valser", "Traktorutstyr", "Vinkelsliper/-kutter", "Boltepistol", "Annet: (Beskriv):", "Spikerpistol", "Kombihammer/borhammer", "Kjedesag", "Kapp-/Klyve-/Gjerdesag", "Bindemaskin armering", "Vibrostav", "Håndholdt armeringskapper", "Skjærebrenner",
		"Sponbrytende", "Slipemaskiner", "Trebearbeidingsmaskiner", "Asfaltarbeider", "Betongsager, kjerneboringsutstyr", "Veggsager","Vaiersager", "Gulvsager og asfaltsag", "Høytrykkspylerutstyr", "Ryddesager og trimmere",
		"Spunte- og pæleutstyr", "Mobilt betongpumpeutstyr", "Sikker bruk/kontroll av stillas", "Sikker bruk av forskaling", "Fallsikringsutstyr", "Førstehjelpskurs, Dato:"},
		{""},
		{}};
	private static JCheckBox verkstedOgLagerCheck, SpesialKranerCheck, VinsjerOgTaljerCheck, anhukingStroppingOgSignalgivningCheck, klatreOgHengeStilaserCheck, personLoftereCheck, personLoftereUnderJordCheck;
	private static JCheckBox borVognerOgTunnelriggerCheck, selvgåendeValserCheck, TraktorutstyrCheck, vinkelSliperKutterCheck, boltePistolCheck, spikerPistolCheck, KombiHammerBorHammerCheck, kjedeSagCheck;
	private static JCheckBox KappKlyveGjerdeSagCheck, bindeMaskinArmeringCheck, VibrostavCheck, haandholdtArmeringsKapperCheck, skjarebrennerCheck, sponBrytendeCheck, slipemaskinerCheck, trebearbeidingsMaskinerCheck;
	private static JCheckBox asfaltArbeiderCheck, betongSagerKjerneBorCheck, veggsagerCheck, vaierSagerCheck, gulvsagerOgAsfaltsagCheck, hoytrykkspylerUtstyrCheck, ryddeSagerOgTrimmereCheck, spunteOgPaleutstyrCheck;
	private static JCheckBox mobiltBetongPumpeUtstyr, sikkerBrukKontrollAvStillasCheck, sikkerBrukAvForskalingCheck, fallsikringutstyrCheck, forstehjelpUtstyrCheck;
	private static JCheckBox annetCheck;

	protected JTextField verkstedOgLagerPropertyComponent, spesialKranerPropertyComponent, personlofterePropertyComponent, forstehjelpPropertyComponent, annetPropertyComponent;

	protected static JButton Neste, nullstill;

	Kurs model = null;
	//	DBConnection conn = new DBConnection();

	public KursPanel() {
		//Legger ut componentene i GUI

		createKursComponents();
		layComponents();
		addActionListeners();
	}

	private void addActionListeners() {
		verkstedOgLagerCheck.addActionListener(this);
		SpesialKranerCheck.addActionListener(this);
		VinsjerOgTaljerCheck.addActionListener(this);
		anhukingStroppingOgSignalgivningCheck.addActionListener(this);
		klatreOgHengeStilaserCheck.addActionListener(this);
		personLoftereCheck.addActionListener(this);
		personLoftereUnderJordCheck.addActionListener(this);
		borVognerOgTunnelriggerCheck.addActionListener(this);
		selvgåendeValserCheck.addActionListener(this);
		TraktorutstyrCheck.addActionListener(this);
		vinkelSliperKutterCheck.addActionListener(this);
		boltePistolCheck.addActionListener(this);
		spikerPistolCheck.addActionListener(this);
		KombiHammerBorHammerCheck.addActionListener(this);
		kjedeSagCheck.addActionListener(this);
		KappKlyveGjerdeSagCheck.addActionListener(this);
		bindeMaskinArmeringCheck.addActionListener(this);
		VibrostavCheck.addActionListener(this);
		haandholdtArmeringsKapperCheck.addActionListener(this);
		skjarebrennerCheck.addActionListener(this);
		sponBrytendeCheck.addActionListener(this);
		slipemaskinerCheck.addActionListener(this);
		trebearbeidingsMaskinerCheck.addActionListener(this);
		asfaltArbeiderCheck.addActionListener(this);
		betongSagerKjerneBorCheck.addActionListener(this);
		veggsagerCheck.addActionListener(this);
		vaierSagerCheck.addActionListener(this);
		gulvsagerOgAsfaltsagCheck.addActionListener(this);
		hoytrykkspylerUtstyrCheck.addActionListener(this);
		ryddeSagerOgTrimmereCheck.addActionListener(this);
		spunteOgPaleutstyrCheck.addActionListener(this);
		mobiltBetongPumpeUtstyr.addActionListener(this);
		sikkerBrukKontrollAvStillasCheck.addActionListener(this);
		sikkerBrukAvForskalingCheck.addActionListener(this);
		fallsikringutstyrCheck.addActionListener(this);
		forstehjelpUtstyrCheck.addActionListener(this);
		annetCheck.addActionListener(this);
		verkstedOgLagerPropertyComponent.addActionListener(this);
		spesialKranerPropertyComponent.addActionListener(this);
		personlofterePropertyComponent.addActionListener(this);
		forstehjelpPropertyComponent.addActionListener(this);
		annetPropertyComponent.addActionListener(this);
		Neste.addActionListener(this);
		nullstill.addActionListener(this);

	}

	private void layComponents() {
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(1,1,4,15);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		add(verkstedOgLagerCheck,c);
		c.gridy = 1;
		add(SpesialKranerCheck,c);
		c.gridy = 2;
		add(VinsjerOgTaljerCheck,c);
		c.gridy = 3;
		add(anhukingStroppingOgSignalgivningCheck,c);
		c.gridy = 4;
		add(klatreOgHengeStilaserCheck,c);
		c.gridy = 5;
		add(personLoftereCheck,c);
		c.gridy = 6;
		add(personLoftereUnderJordCheck,c);
		c.gridx=0;
		c.gridy = 7;
		add(borVognerOgTunnelriggerCheck,c);
		c.gridy = 8;
		add(selvgåendeValserCheck,c);
		c.gridy =9;
		add(TraktorutstyrCheck,c);
		c.gridy = 10;
		add(vinkelSliperKutterCheck,c);
		c.gridy = 11;
		add(boltePistolCheck, c);
		c.gridy = 12;
		add(annetCheck,c);
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 0;
		add(verkstedOgLagerPropertyComponent,c);
		c.gridy=1;
		add(spesialKranerPropertyComponent,c);
		c.gridy=5;
		add(personlofterePropertyComponent,c);
		c.anchor = GridBagConstraints.WEST;

		c.gridx = 1;
		c.gridy = 0;
		add(spikerPistolCheck,c);
		c.gridy=1;
		add(KombiHammerBorHammerCheck,c);
		c.gridy=2;
		add(kjedeSagCheck,c);
		c.gridy=3;
		add(KappKlyveGjerdeSagCheck,c);
		c.gridy=4;
		add(bindeMaskinArmeringCheck,c);
		c.gridy=5;
		add(VibrostavCheck,c);
		c.gridy=6;
		add(haandholdtArmeringsKapperCheck,c);
		c.gridy=7;
		add(skjarebrennerCheck,c);
		c.gridy=8;
		add(sponBrytendeCheck,c);
		c.gridy=9;
		add(slipemaskinerCheck,c);
		c.gridy=10;
		add(trebearbeidingsMaskinerCheck,c);
		c.gridy=11;
		add(asfaltArbeiderCheck,c);

		c.gridx = 2;
		c.gridy = 0;
		add(betongSagerKjerneBorCheck,c);
		c.gridy = 1;
		add(veggsagerCheck,c);
		c.gridy=2;
		add(vaierSagerCheck,c);
		c.gridy=3;
		add(gulvsagerOgAsfaltsagCheck,c);
		c.gridy=4;
		add(hoytrykkspylerUtstyrCheck,c);
		c.gridy=5;
		add(ryddeSagerOgTrimmereCheck,c);
		c.gridy=6;
		add(spunteOgPaleutstyrCheck,c);
		c.gridy=7;
		add(mobiltBetongPumpeUtstyr,c);
		c.gridy=8;
		add(sikkerBrukKontrollAvStillasCheck,c);
		c.gridy=9;
		add(sikkerBrukAvForskalingCheck,c);
		c.gridy=10;
		add(fallsikringutstyrCheck,c);
		c.gridy=11;
		add(forstehjelpUtstyrCheck,c);
		c.anchor = GridBagConstraints.EAST;
		add(forstehjelpPropertyComponent,c);

		c.anchor = GridBagConstraints.EAST;
		c.gridx=0;
		c.gridy=12;
		c.gridwidth=3;
		add(annetPropertyComponent,c);
		c.gridy=13;
		add(Neste,c);
		c.gridy=14;
		add(nullstill,c);
		Neste.setVisible(false);
		nullstill.setVisible(false);

	}

	private void createKursComponents() {
		verkstedOgLagerCheck = new JCheckBox(labelTekst[sprak][0]);
		verkstedOgLagerPropertyComponent = new JTextField(5);
		SpesialKranerCheck = new JCheckBox(labelTekst[sprak][1]);
		spesialKranerPropertyComponent = new JTextField(5);
		VinsjerOgTaljerCheck = new JCheckBox(labelTekst[sprak][2]);
		anhukingStroppingOgSignalgivningCheck = new JCheckBox(labelTekst[sprak][3]);
		klatreOgHengeStilaserCheck = new JCheckBox(labelTekst[sprak][4]);
		personLoftereCheck = new JCheckBox(labelTekst[sprak][5]);
		personlofterePropertyComponent = new JTextField(6);
		personLoftereUnderJordCheck = new JCheckBox(labelTekst[sprak][6]);
		borVognerOgTunnelriggerCheck = new JCheckBox(labelTekst[sprak][7]);
		selvgåendeValserCheck = new JCheckBox(labelTekst[sprak][8]);
		TraktorutstyrCheck = new JCheckBox(labelTekst[sprak][9]);
		vinkelSliperKutterCheck = new JCheckBox(labelTekst[sprak][10]);
		boltePistolCheck = new JCheckBox(labelTekst[sprak][11]);
		annetCheck = new JCheckBox(labelTekst[sprak][12]);

		spikerPistolCheck = new JCheckBox(labelTekst[sprak][13]);
		KombiHammerBorHammerCheck = new JCheckBox(labelTekst[sprak][14]);
		kjedeSagCheck = new JCheckBox(labelTekst[sprak][15]);
		KappKlyveGjerdeSagCheck = new JCheckBox(labelTekst[sprak][16]);
		bindeMaskinArmeringCheck = new JCheckBox(labelTekst[sprak][17]);
		VibrostavCheck = new JCheckBox(labelTekst[sprak][18]);
		haandholdtArmeringsKapperCheck = new JCheckBox(labelTekst[sprak][19]);
		skjarebrennerCheck = new JCheckBox(labelTekst[sprak][20]);
		sponBrytendeCheck = new JCheckBox(labelTekst[sprak][21]);
		slipemaskinerCheck = new JCheckBox(labelTekst[sprak][22]);
		trebearbeidingsMaskinerCheck = new JCheckBox(labelTekst[sprak][23]);
		asfaltArbeiderCheck = new JCheckBox(labelTekst[sprak][24]);

		betongSagerKjerneBorCheck = new JCheckBox(labelTekst[sprak][25]);
		veggsagerCheck = new JCheckBox(labelTekst[sprak][26]);
		vaierSagerCheck = new JCheckBox(labelTekst[sprak][27]);
		gulvsagerOgAsfaltsagCheck = new JCheckBox(labelTekst[sprak][28]);
		hoytrykkspylerUtstyrCheck = new JCheckBox(labelTekst[sprak][29]);
		ryddeSagerOgTrimmereCheck = new JCheckBox(labelTekst[sprak][30]);
		spunteOgPaleutstyrCheck = new JCheckBox(labelTekst[sprak][31]);
		mobiltBetongPumpeUtstyr = new JCheckBox(labelTekst[sprak][32]);
		sikkerBrukKontrollAvStillasCheck = new JCheckBox(labelTekst[sprak][33]);
		sikkerBrukAvForskalingCheck = new JCheckBox(labelTekst[sprak][34]);
		fallsikringutstyrCheck = new JCheckBox(labelTekst[sprak][35]);
		forstehjelpUtstyrCheck = new JCheckBox(labelTekst[sprak][36]);
		forstehjelpPropertyComponent = new JTextField(5);
		annetPropertyComponent = new JTextField(48);
		Neste = new JButton("Neste");
		nullstill = new JButton("Nullstill");
		verkstedOgLagerPropertyComponent.setEditable(false);
		spesialKranerPropertyComponent.setEditable(false);
		personlofterePropertyComponent.setEditable(false);
		forstehjelpPropertyComponent.setEditable(false);
		annetPropertyComponent.setEditable(false);

	}

	public void setModel(Kurs model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		verkstedOgLagerCheck.setSelected(model.isVerkstedOgLager());
		SpesialKranerCheck.setSelected(model.isSpesialKraner());
		VinsjerOgTaljerCheck.setSelected(model.isVinsjerOgTaljer());
		anhukingStroppingOgSignalgivningCheck.setSelected(model.isAnhukStroppingSignalGiving());
		klatreOgHengeStilaserCheck.setSelected(model.isKlatreOgHengestilaser());
		personLoftereCheck.setSelected(model.isPersonLoftere());
		personLoftereUnderJordCheck.setSelected(model.isPersonLoftereUnderJord());
		borVognerOgTunnelriggerCheck.setSelected(model.isBorvognerTunnelrigger());
		selvgåendeValserCheck.setSelected(model.isSelvgaendeUtstyr());
		TraktorutstyrCheck.setSelected(model.isTraktorUtstyr());
		vinkelSliperKutterCheck.setSelected(model.isVinkelsliperKutter());
		boltePistolCheck.setSelected(model.isBoltePistol());
		spikerPistolCheck.setSelected(model.isSpikerPistol());
		KombiHammerBorHammerCheck.setSelected(model.isKombihammerBorhammer());
		kjedeSagCheck.setSelected(model.isKjedeSag());
		KappKlyveGjerdeSagCheck.setSelected(model.isKappklyveGjerdeSag());
		bindeMaskinArmeringCheck.setSelected(model.isBindeMaskinArmering());
		VibrostavCheck.setSelected(model.isVibroStav());
		haandholdtArmeringsKapperCheck.setSelected(model.isVibroStav());
		skjarebrennerCheck.setSelected(model.isSkjarebrenner());
		sponBrytendeCheck.setSelected(model.isSponBrytende());
		slipemaskinerCheck.setSelected(model.isSlipeMaskiner());
		trebearbeidingsMaskinerCheck.setSelected(model.isTreBearbeidingsMaskin());
		asfaltArbeiderCheck.setSelected(model.isAsfaltarbeider());
		betongSagerKjerneBorCheck.setSelected(model.isBetongSagerKjerneBoring());
		veggsagerCheck.setSelected(model.isVeggSager());
		vaierSagerCheck.setSelected(model.isVaierSager());
		gulvsagerOgAsfaltsagCheck.setSelected(model.isGulvOgAsfaltSag());
		hoytrykkspylerUtstyrCheck.setSelected(model.isHoytrykkSpyler());
		ryddeSagerOgTrimmereCheck.setSelected(model.isRyddeSagerOgTrimmere());
		spunteOgPaleutstyrCheck.setSelected(model.isSpunteOgPaleUtstyr());
		mobiltBetongPumpeUtstyr.setSelected(model.isMobiltBetongPumpeUtstyr());
		sikkerBrukKontrollAvStillasCheck.setSelected(model.isSikkerKontorllAvStillas());
		sikkerBrukAvForskalingCheck.setSelected(model.isSikkerBrukAvForskaling());
		fallsikringutstyrCheck.setSelected(model.isFallSikkring());
		forstehjelpUtstyrCheck.setSelected(model.isForsteHjelp());
		annetCheck.setSelected(model.isAnnet());
		verkstedOgLagerPropertyComponent.setText(model.getVerksetedLagerTekst());
		spesialKranerPropertyComponent.setText(model.getSpesialKranerTekst());
		personlofterePropertyComponent.setText(model.getPersonLoftereTekst());
		forstehjelpPropertyComponent.setText(model.getForstehjelpDatoTekst());
		annetPropertyComponent.setText(model.getAnnetTekst());
	}

	public Kurs getModel() {
		return model;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//		System.out.println("Hendelse");
		if(evt.getPropertyName() == Kurs.VERKSTEDOGLAGER_PROPERTY) {
			verkstedOgLagerCheck.setSelected(model.isVerkstedOgLager());
		} else if(evt.getPropertyName() == Kurs.SPESIALKRANER_PROPERTY) {
			SpesialKranerCheck.setSelected(model.isSpesialKraner());
		} else if(evt.getPropertyName() == Kurs.VINSJEROGTALJER_PROPERTY) {
			VinsjerOgTaljerCheck.setSelected(model.isVinsjerOgTaljer());
		} else if(evt.getPropertyName() == Kurs.ANHUKSTROPPINGSIGNAL_PROPERTY) {
			anhukingStroppingOgSignalgivningCheck.setSelected(model.isAnhukStroppingSignalGiving());
		} else if(evt.getPropertyName() == Kurs.KLATREHENGESTILASER_PROPERTY) {
			klatreOgHengeStilaserCheck.setSelected(model.isKlatreOgHengestilaser());
		} else if(evt.getPropertyName() == Kurs.PERSONLOFTERE_PROPERTY) {
			personLoftereCheck.setSelected(model.isPersonLoftere());
		} else if(evt.getPropertyName() == Kurs.PERSONLOFTEREUNDERJORD_PROPERTY) {
			personLoftereUnderJordCheck.setSelected(model.isPersonLoftereUnderJord());
		} else if(evt.getPropertyName() == Kurs.BORVOGNERTUNNELRIGGER_PROPERTY) {
			borVognerOgTunnelriggerCheck.setSelected(model.isBorvognerTunnelrigger());
		} else if(evt.getPropertyName() == Kurs.SELVGAENDEUTSTYR_PROPERTY) {
			selvgåendeValserCheck.setSelected(model.isSelvgaendeUtstyr());
		} else if(evt.getPropertyName() == Kurs.TRAKTORUTSTYR_PROPERTY){
			TraktorutstyrCheck.setSelected(model.isTraktorUtstyr());
		} else if(evt.getPropertyName() == Kurs.VINKELSLIPERKUTTER_PROPERTY) {
			vinkelSliperKutterCheck.setSelected(model.isVinkelsliperKutter());
		} else if(evt.getPropertyName() == Kurs.BOLTEPISTOL) {
			boltePistolCheck.setSelected(model.isBoltePistol());
		} else if(evt.getPropertyName() == Kurs.SPIKERPISTOL_PROPERTY) {
			spikerPistolCheck.setSelected(model.isSpikerPistol());
		} else if(evt.getPropertyName() == Kurs.KOMBIHAMMERBORHAMMER_PROPERTY) {
			KombiHammerBorHammerCheck.setSelected(model.isKombihammerBorhammer());
		} else if(evt.getPropertyName() == Kurs.KJEDESAG_PROPERTY) {
			kjedeSagCheck.setSelected(model.isKjedeSag());
		} else if(evt.getPropertyName() == Kurs.KAPPKLYVEGJERDESAG_PROPERTY) {
			KappKlyveGjerdeSagCheck.setSelected(model.isKappklyveGjerdeSag());
		} else if(evt.getPropertyName() == Kurs.BINDEMASKINARMERING_PROPERTY) {
			bindeMaskinArmeringCheck.setSelected(model.isBindeMaskinArmering());
		} else if(evt.getPropertyName() == Kurs.VIBROSTAV_PROPERTY) {
			VibrostavCheck.setSelected(model.isVibroStav());
		} else if(evt.getPropertyName() == Kurs.HANDHALDTARMERINGSKAPPER_PROPERTY) {
			haandholdtArmeringsKapperCheck.setSelected(model.isHandhaldtArmeringsKapper());
		} else if(evt.getPropertyName() == Kurs.SKJAREBRENNER_PROPERTY) {
			skjarebrennerCheck.setSelected(model.isSkjarebrenner());
		} else if(evt.getPropertyName() == Kurs.SPONBRYTENDE_PROPERTY) {
			sponBrytendeCheck.setSelected(model.isSponBrytende());
		} else if(evt.getPropertyName() == Kurs.SLIPEMASKINER_PROPERTY) {
			slipemaskinerCheck.setSelected(model.isSlipeMaskiner());
		} else if(evt.getPropertyName() == Kurs.TREBEARBEIDINGSMASKIN_PROPERTY) {
			trebearbeidingsMaskinerCheck.setSelected(model.isTreBearbeidingsMaskin());
		} else if(evt.getPropertyName() == Kurs.ASFALTARBEIDER_PROPERTY) {
			asfaltArbeiderCheck.setSelected(model.isAsfaltarbeider());
		} else if(evt.getPropertyName() == Kurs.BETONGSAGERKJERNEBORING_PROPERTY) {
			betongSagerKjerneBorCheck.setSelected(model.isBetongSagerKjerneBoring());
		} else if(evt.getPropertyName() == Kurs.VEGGSAGER_PROPERTY) {
			veggsagerCheck.setSelected(model.isVeggSager());
		} else if(evt.getPropertyName() == Kurs.VAIERSAGER_PROPERTY) {
			vaierSagerCheck.setSelected(model.isVaierSager());
		} else if(evt.getPropertyName() == Kurs.GULVOGASFALTSAG_PROPERTY) {
			gulvsagerOgAsfaltsagCheck.setSelected(model.isGulvOgAsfaltSag());
		} else if(evt.getPropertyName() == Kurs.HOYTRYKKSPYLER_PROPERTY) {
			hoytrykkspylerUtstyrCheck.setSelected(model.isHoytrykkSpyler());
		} else if(evt.getPropertyName() == Kurs.RYDDESAGEROGTRIMMERE_PROPERTY) {
			ryddeSagerOgTrimmereCheck.setSelected(model.isRyddeSagerOgTrimmere());
		} else if(evt.getPropertyName() == Kurs.SPUNTOGPALEUTSTYR_PROPERTY) {
			spunteOgPaleutstyrCheck.setSelected(model.isSpunteOgPaleUtstyr());
		} else if(evt.getPropertyName() == Kurs.MOBILTBETONGPUMPEUTSTYR) {
			mobiltBetongPumpeUtstyr.setSelected(model.isMobiltBetongPumpeUtstyr());
		} else if(evt.getPropertyName() == Kurs.SIKKERKONTROLLAVSTILLAS_PROPERTY) {
			sikkerBrukKontrollAvStillasCheck.setSelected(model.isSikkerKontorllAvStillas());
		} else if(evt.getPropertyName() == Kurs.SIKKERBRUKAVFORSKALING_PROPERTY) {
			sikkerBrukAvForskalingCheck.setSelected(model.isSikkerBrukAvForskaling());
		} else if(evt.getPropertyName() == Kurs.FALLSIKKRING_PROPERTY) {
			fallsikringutstyrCheck.setSelected(model.isFallSikkring());
		} else if(evt.getPropertyName() == Kurs.FORSTEHJELP_PROPERTY) {
			forstehjelpUtstyrCheck.setSelected(model.isForsteHjelp());
		} else if(evt.getPropertyName() == Kurs.VERKSTEDOGLAGERTEKST_PROPERTY) {
			verkstedOgLagerPropertyComponent.setText(model.getVerksetedLagerTekst());
		} else if(evt.getPropertyName() == Kurs.SPESIALKRANERTEKST_PROPERTY) {
			spesialKranerPropertyComponent.setText(model.getSpesialKranerTekst());
		} else if(evt.getPropertyName() == Kurs.PEROSNLOFTERETEKST_PROPERTY) {
			personlofterePropertyComponent.setText(model.getPersonLoftereTekst());
		} else if(evt.getPropertyName() == Kurs.FORSTEHJELPDATOTEKST_PROPERTY) {
			forstehjelpPropertyComponent.setText(model.getForstehjelpDatoTekst());
		} else if(evt.getPropertyName() == Kurs.ANNET_PROPERTY) {
			annetCheck.setSelected(model.isAnnet());
		} else if(evt.getPropertyName() == Kurs.ANNETTEKST_PROPERTY) {
			annetPropertyComponent.setText(model.getAnnetTekst());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(model == null) {
			return;
		}

		if(e.getSource()==Neste) {
			model.setVerkstedOgLager(verkstedOgLagerCheck.isSelected());
			model.setSpesialKraner(SpesialKranerCheck.isSelected());
			model.setVinsjerOgTaljer(VinsjerOgTaljerCheck.isSelected());
			model.setAnhukStroppingSignalGiving(anhukingStroppingOgSignalgivningCheck.isSelected());
			model.setKlatreOgHengestilaser(klatreOgHengeStilaserCheck.isSelected());
			model.setPersonLoftere(personLoftereCheck.isSelected());
			model.setPersonLoftereUnderJord(personLoftereUnderJordCheck.isSelected());
			model.setBorvognerTunnelrigger(borVognerOgTunnelriggerCheck.isSelected());
			model.setSelvgaendeUtstyr(selvgåendeValserCheck.isSelected());
			model.setTraktorUtstyr(TraktorutstyrCheck.isSelected());
			model.setVinkelsliperKutter(vinkelSliperKutterCheck.isSelected());
			model.setBoltePistol(boltePistolCheck.isSelected());
			model.setSpikerPistol(spikerPistolCheck.isSelected());
			model.setKombihammerBorhammer(KombiHammerBorHammerCheck.isSelected());
			model.setKjedeSag(kjedeSagCheck.isSelected());
			model.setKappklyveGjerdeSag(KappKlyveGjerdeSagCheck.isSelected());
			model.setBindeMaskinArmering(bindeMaskinArmeringCheck.isSelected());
			model.setVibroStav(VibrostavCheck.isSelected());
			model.setHandhaldtArmeringsKapper(haandholdtArmeringsKapperCheck.isSelected());
			model.setSkjarebrenner(skjarebrennerCheck.isSelected());
			model.setSponBrytende(sponBrytendeCheck.isSelected());
			model.setSlipeMaskiner(slipemaskinerCheck.isSelected());
			model.setTreBearbeidingsMaskin(trebearbeidingsMaskinerCheck.isSelected());
			model.setAsfaltarbeider(asfaltArbeiderCheck.isSelected());
			model.setBetongSagerKjerneBoring(betongSagerKjerneBorCheck.isSelected());
			model.setVeggSager(veggsagerCheck.isSelected());
			model.setVaierSager(vaierSagerCheck.isSelected());
			model.setGulvOgAsfaltSag(gulvsagerOgAsfaltsagCheck.isSelected());
			model.setHoytrykkSpyler(hoytrykkspylerUtstyrCheck.isSelected());
			model.setRyddeSagerOgTrimmere(ryddeSagerOgTrimmereCheck.isSelected());
			model.setSpunteOgPaleUtstyr(spunteOgPaleutstyrCheck.isSelected());
			model.setMobiltBetongPumpeUtstyr(mobiltBetongPumpeUtstyr.isSelected());
			model.setSikkerKontorllAvStillas(sikkerBrukKontrollAvStillasCheck.isSelected());
			model.setSikkerBrukAvForskaling(sikkerBrukAvForskalingCheck.isSelected());
			model.setFallSikkring(fallsikringutstyrCheck.isSelected());
			model.setForsteHjelp(forstehjelpUtstyrCheck.isSelected());
			model.setAnnet(annetCheck.isSelected());
			model.setVerksetedLagerTekst(verkstedOgLagerPropertyComponent.getText());
			model.setSpesialKranerTekst(spesialKranerPropertyComponent.getText());
			model.setPersonLoftereTekst(personlofterePropertyComponent.getText());
			model.setForstehjelpDatoTekst(forstehjelpPropertyComponent.getText());
			model.setAnnetTekst(annetPropertyComponent.getText());
			try {
				DBInnsertion.createKurs(model.isVerkstedOgLager(), model.getVerksetedLagerTekst(), model.isSpesialKraner(), model.getSpesialKranerTekst(), model.isVinsjerOgTaljer(), model.isAnhukStroppingSignalGiving(), model.isKlatreOgHengestilaser(), model.isPersonLoftere(), model.getPersonLoftereTekst(), model.isPersonLoftereUnderJord(), model.isBorvognerTunnelrigger(), model.isSelvgaendeUtstyr(), model.isTraktorUtstyr(), model.isVinkelsliperKutter(), model.isBoltePistol(), model.isSpikerPistol(), model.isKombihammerBorhammer(), model.isKjedeSag(), model.isKappklyveGjerdeSag(), model.isBindeMaskinArmering(), model.isVibroStav(), model.isHandhaldtArmeringsKapper(), model.isSkjarebrenner(), model.isSponBrytende(), model.isSlipeMaskiner(), model.isTreBearbeidingsMaskin(), model.isAsfaltarbeider(), model.isBetongSagerKjerneBoring(), model.isVeggSager(), model.isVaierSager(), model.isGulvOgAsfaltSag(), model.isHoytrykkSpyler(), model.isRyddeSagerOgTrimmere(), model.isSpunteOgPaleUtstyr(), model.isMobiltBetongPumpeUtstyr(), model.isSikkerKontorllAvStillas(), model.isSikkerBrukAvForskaling(), model.isFallSikkring(), model.isForsteHjelp(), model.getForstehjelpDatoTekst(), model.isAnnet(), model.getAnnetTekst());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//			System.out.println("VERKSTED:" + model.isVerkstedOgLager()+ " VERKSTEDTEKST:" + model.getVerksetedLagerTekst() + " SPESIALKRAN:" + model.isSpesialKraner() + " SPESIALKRANTEKST:" + model.getSpesialKranerTekst());
			//			System.out.println("VINSJER:" + model.isVinsjerOgTaljer() + " ANHUK:" + model.isAnhukStroppingSignalGiving() + " KLATREHENGESTILAS:" + model.isKlatreOgHengestilaser() + " PERSONLOFTER:" + model.isPersonLoftere() + " PERSONLOFTERTEKST:" + model.getPersonLoftereTekst());
			//			System.out.println("PERSONLOFTERUNDERJORD:" + model.isPersonLoftereUnderJord() + " BORVOGNER:" + model.isBorvognerTunnelrigger() + " SELVGÅENDE:" + model.isSelvgaendeUtstyr() + " TRAKTORUTSTYR:" + model.isTraktorUtstyr());
			//			System.out.println("VINKELSLIPER:" + model.isVinkelsliperKutter() + " BOLTEPISTOL:" + model.isBoltePistol() + " SPIKERPISTOL:" + model.isSpikerPistol() + " KOMBIHAMMER:" + model.isKombihammerBorhammer() + " KJEDESAG:" + model.isKjedeSag());
			//			System.out.println("KAPPKLYVEGJERDESAG:" + model.isKappklyveGjerdeSag() + " BINDEMASKIN:" + model.isBindeMaskinArmering() + " VIBROSTAV:" + model.isVibroStav() + " HÅNDHOLDTARMERINGSKAPPER:" + model.isHandhaldtArmeringsKapper());
			//			System.out.println("SKJÆREBRENNER:" + model.isSkjarebrenner() + " SPONBRYTENDE:" + model.isSponBrytende() + " SLIPEMASKINER:" + model.isSlipeMaskiner() + " TREBEARBEIDINGSMASKINER:" + model.isTreBearbeidingsMaskin() + " ASFALTARBEIDER:" + model.isAsfaltarbeider());
			//			System.out.println("BETONGSAGER:" + model.isBetongSagerKjerneBoring() + " VEGGSAGER:" + model.isVeggSager() + " VAIERSAGER:" + model.isVaierSager() + " GULVSAGOGASFALTSAG:" + model.isGulvOgAsfaltSag() + " HØYTRYKKSPYLER:" + model.isHoytrykkSpyler());
			//			System.out.println("RYDDESAGER:" + model.isRyddeSagerOgTrimmere() + " SPUNTEOGPÆLEUTSTYR:" + model.isSpunteOgPaleUtstyr() + " MOBILTBETONGPUMPEUTSTYR:" + model.isMobiltBetongPumpeUtstyr() + " SIKKERSTILAS:" + model.isSikkerKontorllAvStillas());
			//			System.out.println("SIKKERFORSKALING:" + model.isSikkerBrukAvForskaling() + " FALLSIKRINGSUTSTYR:" + model.isFallSikkring() + " FORSTEHJELP:" + model.isForsteHjelp() + " FORSTEHJELPTEKST:" + model.getForstehjelpDatoTekst());
			//			System.out.println("ANNET:" + model.isAnnet() + " ANNETTEKST:" + model.getAnnetTekst());
		} else if(e.getSource()== nullstill) {
			model.setVerkstedOgLager(false);
			model.setSpesialKraner(false);
			model.setVinsjerOgTaljer(false);
			model.setAnhukStroppingSignalGiving(false);
			model.setKlatreOgHengestilaser(false);
			model.setPersonLoftere(false);
			model.setPersonLoftereUnderJord(false);
			model.setBorvognerTunnelrigger(false);
			model.setSelvgaendeUtstyr(false);
			model.setTraktorUtstyr(false);
			model.setVinkelsliperKutter(false);
			model.setBoltePistol(false);
			model.setSpikerPistol(false);
			model.setKombihammerBorhammer(false);
			model.setKjedeSag(false);
			model.setKappklyveGjerdeSag(false);
			model.setBindeMaskinArmering(false);
			model.setVibroStav(false);
			model.setHandhaldtArmeringsKapper(false);
			model.setSkjarebrenner(false);
			model.setSponBrytende(false);
			model.setSlipeMaskiner(false);
			model.setTreBearbeidingsMaskin(false);
			model.setAsfaltarbeider(false);
			model.setBetongSagerKjerneBoring(false);
			model.setVeggSager(false);
			model.setVaierSager(false);
			model.setGulvOgAsfaltSag(false);
			model.setHoytrykkSpyler(false);
			model.setRyddeSagerOgTrimmere(false);
			model.setSpunteOgPaleUtstyr(false);
			model.setMobiltBetongPumpeUtstyr(false);
			model.setSikkerKontorllAvStillas(false);
			model.setSikkerBrukAvForskaling(false);
			model.setFallSikkring(false);
			model.setForsteHjelp(false);
			model.setAnnet(false);
			model.setVerksetedLagerTekst(null);
			model.setSpesialKranerTekst(null);
			model.setPersonLoftereTekst(null);
			model.setForstehjelpDatoTekst(null);
			model.setAnnetTekst(null);
			//			System.out.println("VERKSTED:" + model.isVerkstedOgLager()+ " VERKSTEDTEKST:" + model.getVerksetedLagerTekst() + " SPESIALKRAN:" + model.isSpesialKraner() + " SPESIALKRANTEKST:" + model.getSpesialKranerTekst());
			//			System.out.println("VINSJER:" + model.isVinsjerOgTaljer() + " ANHUK:" + model.isAnhukStroppingSignalGiving() + " KLATREHENGESTILAS:" + model.isKlatreOgHengestilaser() + " PERSONLOFTER:" + model.isPersonLoftere() + " PERSONLOFTERTEKST:" + model.getPersonLoftereTekst());
			//			System.out.println("PERSONLOFTERUNDERJORD:" + model.isPersonLoftereUnderJord() + " BORVOGNER:" + model.isBorvognerTunnelrigger() + " SELVGÅENDE:" + model.isSelvgaendeUtstyr() + " TRAKTORUTSTYR:" + model.isTraktorUtstyr());
			//			System.out.println("VINKELSLIPER:" + model.isVinkelsliperKutter() + " BOLTEPISTOL:" + model.isBoltePistol() + " SPIKERPISTOL:" + model.isSpikerPistol() + " KOMBIHAMMER:" + model.isKombihammerBorhammer() + " KJEDESAG:" + model.isKjedeSag());
			//			System.out.println("KAPPKLYVEGJERDESAG:" + model.isKappklyveGjerdeSag() + " BINDEMASKIN:" + model.isBindeMaskinArmering() + " VIBROSTAV:" + model.isVibroStav() + " HÅNDHOLDTARMERINGSKAPPER:" + model.isHandhaldtArmeringsKapper());
			//			System.out.println("SKJÆREBRENNER:" + model.isSkjarebrenner() + " SPONBRYTENDE:" + model.isSponBrytende() + " SLIPEMASKINER:" + model.isSlipeMaskiner() + " TREBEARBEIDINGSMASKINER:" + model.isTreBearbeidingsMaskin() + " ASFALTARBEIDER:" + model.isAsfaltarbeider());
			//			System.out.println("BETONGSAGER:" + model.isBetongSagerKjerneBoring() + " VEGGSAGER:" + model.isVeggSager() + " VAIERSAGER:" + model.isVaierSager() + " GULVSAGOGASFALTSAG:" + model.isGulvOgAsfaltSag() + " HØYTRYKKSPYLER:" + model.isHoytrykkSpyler());
			//			System.out.println("RYDDESAGER:" + model.isRyddeSagerOgTrimmere() + " SPUNTEOGPÆLEUTSTYR:" + model.isSpunteOgPaleUtstyr() + " MOBILTBETONGPUMPEUTSTYR:" + model.isMobiltBetongPumpeUtstyr() + " SIKKERSTILAS:" + model.isSikkerKontorllAvStillas());
			//			System.out.println("SIKKERFORSKALING:" + model.isSikkerBrukAvForskaling() + " FALLSIKRINGSUTSTYR:" + model.isFallSikkring() + " FORSTEHJELP:" + model.isForsteHjelp() + " FORSTEHJELPTEKST:" + model.getForstehjelpDatoTekst());
			//			System.out.println("ANNET:" + model.isAnnet() + " ANNETTEKST:" + model.getAnnetTekst());

		} else if(e.getSource()==verkstedOgLagerCheck) {
			model.setVerkstedOgLager(verkstedOgLagerCheck.isSelected());
			if(verkstedOgLagerCheck.isSelected()) {
				verkstedOgLagerPropertyComponent.setEditable(true);
			} else
				verkstedOgLagerPropertyComponent.setEditable(false);
			//			System.out.println("Endret verksted og lager check");
		} else if(e.getSource()==SpesialKranerCheck) {
			model.setSpesialKraner(SpesialKranerCheck.isSelected());
			if(SpesialKranerCheck.isSelected()) {
				spesialKranerPropertyComponent.setEditable(true);
			} else 
				spesialKranerPropertyComponent.setEditable(false);
			//			System.out.println("Endret spesialkraner check");
		} else if(e.getSource()==VinsjerOgTaljerCheck) {
			model.setVinsjerOgTaljer(VinsjerOgTaljerCheck.isSelected());
			//			System.out.println("Endret Vinsjer og taljer check");
		} else if(e.getSource()==anhukingStroppingOgSignalgivningCheck) {
			model.setAnhukStroppingSignalGiving(anhukingStroppingOgSignalgivningCheck.isSelected());
			//			System.out.println("Endret anhuk osv check");
		} else if(e.getSource()==klatreOgHengeStilaserCheck) {
			model.setKlatreOgHengestilaser(klatreOgHengeStilaserCheck.isSelected());
			//			System.out.println("Endret Klatre og hengestialser check");
		} else if(e.getSource()==personLoftereCheck) {
			model.setPersonLoftere(personLoftereCheck.isSelected());
			if(personLoftereCheck.isSelected()) {
				personlofterePropertyComponent.setEditable(true);
			} else 
				personlofterePropertyComponent.setEditable(false);
			//			System.out.println("Endret Personløftere check");
		} else if(e.getSource()==personLoftereUnderJordCheck) {
			model.setPersonLoftereUnderJord(personLoftereUnderJordCheck.isSelected());
			//			System.out.println("Endret personløftereunderjord Check");
		} else if(e.getSource()==borVognerOgTunnelriggerCheck) {
			model.setBorvognerTunnelrigger(borVognerOgTunnelriggerCheck.isSelected());
			//			System.out.println("Endret borvogner og tunnelrigger check");
		} else if(e.getSource()==selvgåendeValserCheck) {
			model.setSelvgaendeUtstyr(selvgåendeValserCheck.isSelected());
			//			System.out.println("Endret selvgåendevalse check");
		} else if(e.getSource()==TraktorutstyrCheck) {
			model.setTraktorUtstyr(TraktorutstyrCheck.isSelected());
			//			System.out.println("Endret Traktorutstyr check");
		} else if(e.getSource()==vinkelSliperKutterCheck) {
			model.setVinkelsliperKutter(vinkelSliperKutterCheck.isSelected());
			//			System.out.println("Endret vinkelsliperKutter check");
		} else if(e.getSource()==boltePistolCheck) {
			model.setBoltePistol(boltePistolCheck.isSelected());
			//			System.out.println("Endret boltepistol check");
		} else if(e.getSource()==spikerPistolCheck) {
			model.setSpikerPistol(spikerPistolCheck.isSelected());
			//			System.out.println("Endret Spikerpistol check");
		} else if(e.getSource()==KombiHammerBorHammerCheck) {
			model.setKombihammerBorhammer(KombiHammerBorHammerCheck.isSelected());
			//			System.out.println("Endret kombihammer check");
		} else if(e.getSource()==kjedeSagCheck) {
			model.setKjedeSag(kjedeSagCheck.isSelected());
			//			System.out.println("Endret kjedesag check");
		} else if(e.getSource()==KappKlyveGjerdeSagCheck) {
			model.setKappklyveGjerdeSag(KappKlyveGjerdeSagCheck.isSelected());
			//			System.out.println("Endret kappklyveGjerdesag Check");
		} else if(e.getSource()==bindeMaskinArmeringCheck) {
			model.setBindeMaskinArmering(bindeMaskinArmeringCheck.isSelected());
			//			System.out.println("Endret bindemaskinArmering check");
		} else if(e.getSource()==VibrostavCheck) {
			model.setVibroStav(VibrostavCheck.isSelected());
			//			System.out.println("Endret vibrostav check");
		} else if(e.getSource()==haandholdtArmeringsKapperCheck) {
			model.setHandhaldtArmeringsKapper(haandholdtArmeringsKapperCheck.isSelected());
			//			System.out.println("Endret håndholdtArmeringsKapper check");
		} else if(e.getSource()==skjarebrennerCheck) {
			model.setSkjarebrenner(skjarebrennerCheck.isSelected());
			//			System.out.println("Endret skjærebrenner check");
		} else if(e.getSource()==sponBrytendeCheck) {
			model.setSponBrytende(sponBrytendeCheck.isSelected());
			//			System.out.println("Endret sponbrytende check");
		} else if(e.getSource()==slipemaskinerCheck) {
			model.setSlipeMaskiner(slipemaskinerCheck.isSelected());
			//			System.out.println("Endret slipemaskiner check");
		} else if(e.getSource()==trebearbeidingsMaskinerCheck) {
			model.setTreBearbeidingsMaskin(trebearbeidingsMaskinerCheck.isSelected());
			//			System.out.println("Endret trebearbeidingsmaskiner check");
		} else if(e.getSource()==asfaltArbeiderCheck) {
			model.setAsfaltarbeider(asfaltArbeiderCheck.isSelected());
			//			System.out.println("Endret asfaltarbeider check");
		} else if(e.getSource()==betongSagerKjerneBorCheck) {
			model.setBetongSagerKjerneBoring(betongSagerKjerneBorCheck.isSelected());
			//			System.out.println("Endret betongsager kjerneborutstyr Check");
		} else if(e.getSource()==veggsagerCheck) {
			model.setVeggSager(veggsagerCheck.isSelected());
			//			System.out.println("Endret veggsager check");
		} else if(e.getSource()==vaierSagerCheck) {
			model.setVaierSager(vaierSagerCheck.isSelected());
			//			System.out.println("Endret vaiersager check");
		} else if(e.getSource()==gulvsagerOgAsfaltsagCheck) {
			model.setGulvOgAsfaltSag(gulvsagerOgAsfaltsagCheck.isSelected());
			//			System.out.println("Endret gulvsager og asfaltsag check");
		} else if(e.getSource()==hoytrykkspylerUtstyrCheck) {
			model.setHoytrykkSpyler(hoytrykkspylerUtstyrCheck.isSelected());
			//			System.out.println("Endret hoytrykkspyler check");
		} else if (e.getSource()==ryddeSagerOgTrimmereCheck) {
			model.setRyddeSagerOgTrimmere(ryddeSagerOgTrimmereCheck.isSelected());
			//			System.out.println("Endret ryddesager og trimmere check");
		} else if(e.getSource()==spunteOgPaleutstyrCheck){
			model.setSpunteOgPaleUtstyr(spunteOgPaleutstyrCheck.isSelected());
			//			System.out.println("Endret Spunte og pæleutstyr check");
		} else if(e.getSource()==mobiltBetongPumpeUtstyr) {
			model.setMobiltBetongPumpeUtstyr(mobiltBetongPumpeUtstyr.isSelected());
			//			System.out.println("Endret mobiltbetongpumpeutstyr check");
		} else if(e.getSource()==sikkerBrukKontrollAvStillasCheck) {
			model.setSikkerKontorllAvStillas(sikkerBrukKontrollAvStillasCheck.isSelected());
			//			System.out.println("Endret sikkerbruk av stilas check");		
		} else if(e.getSource()==sikkerBrukAvForskalingCheck) {
			model.setSikkerBrukAvForskaling(sikkerBrukAvForskalingCheck.isSelected());
			//			System.out.println("Endret sikker bruk av forskaling check");
		} else if(e.getSource()==fallsikringutstyrCheck) {
			model.setFallSikkring(fallsikringutstyrCheck.isSelected());
			//			System.out.println("Endret fallsikringsutstyr check");
		} else if(e.getSource()==forstehjelpUtstyrCheck) {
			model.setForsteHjelp(forstehjelpUtstyrCheck.isSelected());
			if(forstehjelpUtstyrCheck.isSelected()) {
				forstehjelpPropertyComponent.setEditable(true);
			} else
				forstehjelpPropertyComponent.setEditable(false);
			//			System.out.println("Endret forstehjelp utstyr check");
		} else if(e.getSource()==annetCheck) {
			model.setAnnet(annetCheck.isSelected());
			if(annetCheck.isSelected()) {
				annetPropertyComponent.setEditable(true);
			} else
				annetPropertyComponent.setEditable(false);
			//			System.out.println("Endret Annet check");
		} else if(e.getSource()==verkstedOgLagerPropertyComponent) {
			model.setVerksetedLagerTekst(verkstedOgLagerPropertyComponent.getText());
			//			System.out.println("Endret teksten til verksted og lager");
		} else if(e.getSource()==spesialKranerPropertyComponent) {
			model.setSpesialKranerTekst(spesialKranerPropertyComponent.getText());
			//			System.out.println("Endret teksten til spesialkran");
		} else if(e.getSource()==personlofterePropertyComponent) {
			model.setPersonLoftereTekst(personlofterePropertyComponent.getText());
			//			System.out.println("Endret personlofter tekst");
		} else if(e.getSource()==forstehjelpPropertyComponent) {
			model.setForstehjelpDatoTekst(forstehjelpPropertyComponent.getText());
			//			System.out.println("Endret teksten til forstehjelp");
		} else if(e.getSource()==annetPropertyComponent) {
			model.setAnnetTekst(annetPropertyComponent.getText());
			//			System.out.println("Endret teksten til annet");
		}
	}

	public static void changeLanguage(int i) {
		verkstedOgLagerCheck.setText(labelTekst[i][0]);
		SpesialKranerCheck.setText(labelTekst[i][1]);
		VinsjerOgTaljerCheck.setText(labelTekst[i][2]);
		anhukingStroppingOgSignalgivningCheck.setText(labelTekst[i][3]);
		klatreOgHengeStilaserCheck.setText(labelTekst[i][4]);
		personLoftereCheck.setText(labelTekst[i][5]);
		personLoftereUnderJordCheck.setText(labelTekst[i][6]);
		borVognerOgTunnelriggerCheck.setText(labelTekst[i][7]);
		selvgåendeValserCheck.setText(labelTekst[i][8]);
		TraktorutstyrCheck.setText(labelTekst[i][9]);
		vinkelSliperKutterCheck.setText(labelTekst[i][10]);
		boltePistolCheck.setText(labelTekst[i][11]);
		annetCheck.setText(labelTekst[i][12]);			
		spikerPistolCheck.setText(labelTekst[i][13]);
		KombiHammerBorHammerCheck.setText(labelTekst[i][14]);
		kjedeSagCheck.setText(labelTekst[i][15]);
		KappKlyveGjerdeSagCheck.setText(labelTekst[i][16]);
		bindeMaskinArmeringCheck.setText(labelTekst[i][17]);
		VibrostavCheck.setText(labelTekst[i][18]);
		haandholdtArmeringsKapperCheck.setText(labelTekst[i][19]);
		skjarebrennerCheck.setText(labelTekst[i][20]);
		sponBrytendeCheck.setText(labelTekst[i][21]);
		slipemaskinerCheck.setText(labelTekst[i][22]);
		trebearbeidingsMaskinerCheck.setText(labelTekst[i][23]);
		asfaltArbeiderCheck.setText(labelTekst[i][24]);			
		betongSagerKjerneBorCheck.setText(labelTekst[i][25]);
		veggsagerCheck.setText(labelTekst[i][26]);
		vaierSagerCheck.setText(labelTekst[i][27]);
		gulvsagerOgAsfaltsagCheck.setText(labelTekst[i][28]);
		hoytrykkspylerUtstyrCheck.setText(labelTekst[i][29]);
		ryddeSagerOgTrimmereCheck.setText(labelTekst[i][30]);
		spunteOgPaleutstyrCheck.setText(labelTekst[i][31]);
		mobiltBetongPumpeUtstyr.setText(labelTekst[i][32]);
		sikkerBrukKontrollAvStillasCheck.setText(labelTekst[i][33]);
		sikkerBrukAvForskalingCheck.setText(labelTekst[i][34]);
		fallsikringutstyrCheck.setText(labelTekst[i][35]);
		forstehjelpUtstyrCheck.setText(labelTekst[i][36]); 
	}
}
