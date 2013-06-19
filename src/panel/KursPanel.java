package panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modell.Kurs;

public class KursPanel extends JPanel implements ActionListener, PropertyChangeListener, ChangeListener {
	private static final long serialVersionUID = 1L;
	protected JCheckBox verkstedOgLagerCheck, SpesialKranerCheck, VinsjerOgTaljerCheck, anhukingStroppingOgSignalgivningCheck, klatreOgHengeStilaserCheck, personLoftereCheck, personLoftereUnderJordCheck;
	protected JCheckBox borVognerOgTunnelriggerCheck, selvg�endeValserCheck, TraktorutstyrCheck, vinkelSliperKutterCheck, boltePistolCheck, spikerPistolCheck, KombiHammerBorHammerCheck, kjedeSagCheck;
	protected JCheckBox KappKlyveGjerdeSagCheck, bindeMaskinArmeringCheck, VibrostavCheck, haandholdtArmeringsKapperCheck, skjarebrennerCheck, sponBrytendeCheck, slipemaskinerCheck, trebearbeidingsMaskinerCheck;
	protected JCheckBox asfaltArbeiderCheck, betongSagerKjerneBorCheck, veggsagerCheck, vaierSagerCheck, gulvsagerOgAsfaltsagCheck, hoytrykkspylerUtstyrCheck, ryddeSagerOgTrimmereCheck, spunteOgPaleutstyrCheck;
	protected JCheckBox mobiltBetongPumpeUtstyr, sikkerBrukKontrollAvStillasCheck, sikkerBrukAvForskalingCheck, fallsikringutstyrCheck, forstehjelpUtstyrCheck;
	protected JCheckBox annetCheck;
	
	protected JTextField verkstedOgLagerPropertyComponent, spesialKranerPropertyComponent, personlofterePropertyComponent, forstehjelpPropertyComponent, annetPropertyComponent;
	
	Kurs model = null;
	
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
		selvg�endeValserCheck.addActionListener(this);
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
		add(selvg�endeValserCheck,c);
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
		
	}

	private void createKursComponents() {
		verkstedOgLagerCheck = new JCheckBox("Verksted og lager, type:");
		verkstedOgLagerPropertyComponent = new JTextField(5);
		SpesialKranerCheck = new JCheckBox("Spesialkraner, type:");
		spesialKranerPropertyComponent = new JTextField(5);
		VinsjerOgTaljerCheck = new JCheckBox("Vinsjer oig taljer");
		anhukingStroppingOgSignalgivningCheck = new JCheckBox("Anhuking - stropping - signalgivning");
		klatreOgHengeStilaserCheck = new JCheckBox("Klatre- og hengestillaser(36t kurs)");
		personLoftereCheck = new JCheckBox("Personl�ftere klasse: ");
		personlofterePropertyComponent = new JTextField(6);
		personLoftereUnderJordCheck = new JCheckBox("Personl�ftere under jord");
		borVognerOgTunnelriggerCheck = new JCheckBox("Borvogner og tunnelrigger");
		selvg�endeValserCheck = new JCheckBox("Selvg�ende valser");
		TraktorutstyrCheck = new JCheckBox("Traktorutstyr");
		vinkelSliperKutterCheck = new JCheckBox("Vinkelsliper/-kutter");
		boltePistolCheck = new JCheckBox("Boltepistol");
		annetCheck = new JCheckBox("Annet: (Beskriv):");
		
		spikerPistolCheck = new JCheckBox("Spikerpistol");
		KombiHammerBorHammerCheck = new JCheckBox("Kombihammer/borhammer");
		kjedeSagCheck = new JCheckBox("Kjedesag");
		KappKlyveGjerdeSagCheck = new JCheckBox("Kapp-/Klyve-/Gjerdesag");
		bindeMaskinArmeringCheck = new JCheckBox("Bindemaskin armering");
		VibrostavCheck = new JCheckBox("Vibrostav");
		haandholdtArmeringsKapperCheck = new JCheckBox("H�ndholdt armeringskapper");
		skjarebrennerCheck = new JCheckBox("Skj�rebrenner");
		sponBrytendeCheck = new JCheckBox("Sponbrytende");
		slipemaskinerCheck = new JCheckBox("Slipemaskiner");
		trebearbeidingsMaskinerCheck = new JCheckBox("Trebearbeidingsmaskiner");
		asfaltArbeiderCheck = new JCheckBox("Asfaltarbeider");
		
		betongSagerKjerneBorCheck = new JCheckBox("Betongsager, kjerneboringsutstyr");
		veggsagerCheck = new JCheckBox("Veggsager");
		vaierSagerCheck = new JCheckBox("Vaiersager");
		gulvsagerOgAsfaltsagCheck = new JCheckBox("Gulvsager og asfaltsag");
		hoytrykkspylerUtstyrCheck = new JCheckBox("H�ytrykkspylerutstyr");
		ryddeSagerOgTrimmereCheck = new JCheckBox("Ryddesager og trimmere");
		spunteOgPaleutstyrCheck = new JCheckBox("Spunte- og p�leutstyr");
		mobiltBetongPumpeUtstyr = new JCheckBox("Mobilt betongpumpeutstyr");
		sikkerBrukKontrollAvStillasCheck = new JCheckBox("Sikker bruk/kontroll av stillas");
		sikkerBrukAvForskalingCheck = new JCheckBox("Sikker bruk av forskaling");
		fallsikringutstyrCheck = new JCheckBox("Fallsikringsutstyr");
		forstehjelpUtstyrCheck = new JCheckBox("F�rstehjelpskurs, Dato:");
		forstehjelpPropertyComponent = new JTextField(5);
		annetPropertyComponent = new JTextField(48);		
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
		selvg�endeValserCheck.setSelected(model.isSelvgaendeUtstyr());
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
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(model == null) {
			return;
		}
		
	}
}
