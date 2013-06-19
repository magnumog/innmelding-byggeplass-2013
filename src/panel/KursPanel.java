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
	protected JCheckBox borVognerOgTunnelriggerCheck, selvgåendeValserCheck, TraktorutstyrCheck, vinkelSliperKutterCheck, boltePistolCheck, spikerPistolCheck, KombiHammerBorHammerCheck, kjedeSagCheck;
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
		
	}

	private void createKursComponents() {
		verkstedOgLagerCheck = new JCheckBox("Verksted og lager, type:");
		verkstedOgLagerPropertyComponent = new JTextField(5);
		SpesialKranerCheck = new JCheckBox("Spesialkraner, type:");
		spesialKranerPropertyComponent = new JTextField(5);
		VinsjerOgTaljerCheck = new JCheckBox("Vinsjer oig taljer");
		anhukingStroppingOgSignalgivningCheck = new JCheckBox("Anhuking - stropping - signalgivning");
		klatreOgHengeStilaserCheck = new JCheckBox("Klatre- og hengestillaser(36t kurs)");
		personLoftereCheck = new JCheckBox("Personløftere klasse: ");
		personlofterePropertyComponent = new JTextField(6);
		personLoftereUnderJordCheck = new JCheckBox("Personløftere under jord");
		borVognerOgTunnelriggerCheck = new JCheckBox("Borvogner og tunnelrigger");
		selvgåendeValserCheck = new JCheckBox("Selvgående valser");
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
		haandholdtArmeringsKapperCheck = new JCheckBox("Håndholdt armeringskapper");
		skjarebrennerCheck = new JCheckBox("Skjærebrenner");
		sponBrytendeCheck = new JCheckBox("Sponbrytende");
		slipemaskinerCheck = new JCheckBox("Slipemaskiner");
		trebearbeidingsMaskinerCheck = new JCheckBox("Trebearbeidingsmaskiner");
		asfaltArbeiderCheck = new JCheckBox("Asfaltarbeider");
		
		betongSagerKjerneBorCheck = new JCheckBox("Betongsager, kjerneboringsutstyr");
		veggsagerCheck = new JCheckBox("Veggsager");
		vaierSagerCheck = new JCheckBox("Vaiersager");
		gulvsagerOgAsfaltsagCheck = new JCheckBox("Gulvsager og asfaltsag");
		hoytrykkspylerUtstyrCheck = new JCheckBox("Høytrykkspylerutstyr");
		ryddeSagerOgTrimmereCheck = new JCheckBox("Ryddesager og trimmere");
		spunteOgPaleutstyrCheck = new JCheckBox("Spunte- og pæleutstyr");
		mobiltBetongPumpeUtstyr = new JCheckBox("Mobilt betongpumpeutstyr");
		sikkerBrukKontrollAvStillasCheck = new JCheckBox("Sikker bruk/kontroll av stillas");
		sikkerBrukAvForskalingCheck = new JCheckBox("Sikker bruk av forskaling");
		fallsikringutstyrCheck = new JCheckBox("Fallsikringsutstyr");
		forstehjelpUtstyrCheck = new JCheckBox("Førstehjelpskurs, Dato:");
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
		
		if(e.getSource()==verkstedOgLagerCheck) {
			model.setVerkstedOgLager(verkstedOgLagerCheck.isSelected());
			System.out.println("Endret verksted og lager check");
		} else if(e.getSource()==SpesialKranerCheck) {
			model.setSpesialKraner(SpesialKranerCheck.isSelected());
			System.out.println("Endret spesialkraner check");
		} else if(e.getSource()==VinsjerOgTaljerCheck) {
			model.setVinsjerOgTaljer(VinsjerOgTaljerCheck.isSelected());
			System.out.println("Endret Vinsjer og taljer check");
		} else if(e.getSource()==anhukingStroppingOgSignalgivningCheck) {
			model.setAnhukStroppingSignalGiving(anhukingStroppingOgSignalgivningCheck.isSelected());
			System.out.println("Endret anhuk osv check");
		} else if(e.getSource()==klatreOgHengeStilaserCheck) {
			model.setKlatreOgHengestilaser(klatreOgHengeStilaserCheck.isSelected());
			System.out.println("Endret Klatre og hengestialser check");
		} else if(e.getSource()==personLoftereCheck) {
			model.setPersonLoftere(personLoftereCheck.isSelected());
			System.out.println("Endret Personløftere check");
		} else if(e.getSource()==personLoftereUnderJordCheck) {
			model.setPersonLoftereUnderJord(personLoftereUnderJordCheck.isSelected());
			System.out.println("Endret personløftereunderjord Check");
		} else if(e.getSource()==borVognerOgTunnelriggerCheck) {
			model.setBorvognerTunnelrigger(borVognerOgTunnelriggerCheck.isSelected());
			System.out.println("Endret borvogner og tunnelrigger check");
		} else if(e.getSource()==selvgåendeValserCheck) {
			model.setSelvgaendeUtstyr(selvgåendeValserCheck.isSelected());
			System.out.println("Endret selvgåendevalse check");
		} else if(e.getSource()==TraktorutstyrCheck) {
			model.setTraktorUtstyr(TraktorutstyrCheck.isSelected());
			System.out.println("Endret Traktorutstyr check");
		} else if(e.getSource()==vinkelSliperKutterCheck) {
			model.setVinkelsliperKutter(vinkelSliperKutterCheck.isSelected());
			System.out.println("Endret vinkelsliperKutter check");
		} else if(e.getSource()==boltePistolCheck) {
			model.setBoltePistol(boltePistolCheck.isSelected());
			System.out.println("Endret boltepistol check");
		} else if(e.getSource()==spikerPistolCheck) {
			model.setSpikerPistol(spikerPistolCheck.isSelected());
			System.out.println("Endret Spikerpistol check");
		} else if(e.getSource()==KombiHammerBorHammerCheck) {
			model.setKombihammerBorhammer(KombiHammerBorHammerCheck.isSelected());
			System.out.println("Endret kombihamme check");
		} else if(e.getSource()==kjedeSagCheck) {
			model.setKjedeSag(kjedeSagCheck.isSelected());
			System.out.println("Endret kjedesag check");
		} else if(e.getSource()==KappKlyveGjerdeSagCheck) {
			model.setKappklyveGjerdeSag(KappKlyveGjerdeSagCheck.isSelected());
			System.out.println("Endret kappklyveGjerdesag Check");
		} else if(e.getSource()==bindeMaskinArmeringCheck) {
			model.setBindeMaskinArmering(bindeMaskinArmeringCheck.isSelected());
			System.out.println("Endret bindemaskinArmering check");
		} else if(e.getSource()==VibrostavCheck) {
			model.setVibroStav(VibrostavCheck.isSelected());
			System.out.println("Endret vibrostav check");
		} else if(e.getSource()==haandholdtArmeringsKapperCheck) {
			model.setHandhaldtArmeringsKapper(haandholdtArmeringsKapperCheck.isSelected());
			System.out.println("Endret håndholdtArmeringsKapper check");
		} else if(e.getSource()==skjarebrennerCheck) {
			model.setSkjarebrenner(skjarebrennerCheck.isSelected());
			System.out.println("Endret skjærebrenner check");
		} else if(e.getSource()==sponBrytendeCheck) {
			model.setSponBrytende(sponBrytendeCheck.isSelected());
			System.out.println("Endret sponbrytende check");
		} else if(e.getSource()==slipemaskinerCheck) {
			model.setSlipeMaskiner(slipemaskinerCheck.isSelected());
			System.out.println("Endret slipemaskiner check");
		} else if(e.getSource()==trebearbeidingsMaskinerCheck) {
			model.setTreBearbeidingsMaskin(trebearbeidingsMaskinerCheck.isSelected());
			System.out.println("Endret trebearbeidingsmaskiner check");
		} else if(e.getSource()==asfaltArbeiderCheck) {
			model.setAsfaltarbeider(asfaltArbeiderCheck.isSelected());
			System.out.println("Endret asfaltarbeider check");
		} else if(e.getSource()==betongSagerKjerneBorCheck) {
			model.setBetongSagerKjerneBoring(betongSagerKjerneBorCheck.isSelected());
			System.out.println("Endret betongsager kjerneborutstyr Check");
		} else if(e.getSource()==veggsagerCheck) {
			model.setVeggSager(veggsagerCheck.isSelected());
			System.out.println("Endret veggsager check");
		} else if(e.getSource()==vaierSagerCheck) {
			model.setVaierSager(vaierSagerCheck.isSelected());
			System.out.println("Endret vaiersager check");
		} else if(e.getSource()==gulvsagerOgAsfaltsagCheck) {
			model.setGulvOgAsfaltSag(gulvsagerOgAsfaltsagCheck.isSelected());
			System.out.println("Endret gulvsager og asfaltsag check");
		} else if(e.getSource()==hoytrykkspylerUtstyrCheck) {
			model.setHoytrykkSpyler(hoytrykkspylerUtstyrCheck.isSelected());
			System.out.println("Endret hoytrykkspyler check");
		} else if (e.getSource()==ryddeSagerOgTrimmereCheck) {
			model.setRyddeSagerOgTrimmere(ryddeSagerOgTrimmereCheck.isSelected());
			System.out.println("Endret ryddesager og trimmere check");
		} else if(e.getSource()==spunteOgPaleutstyrCheck){
			model.setSpunteOgPaleUtstyr(spunteOgPaleutstyrCheck.isSelected());
			System.out.println("Endret Spunte og pæleutstyr check");
		} else if(e.getSource()==mobiltBetongPumpeUtstyr) {
			model.setMobiltBetongPumpeUtstyr(mobiltBetongPumpeUtstyr.isSelected());
			System.out.println("Endret mobiltbetongpumpeutstyr check");
		} else if(e.getSource()==sikkerBrukKontrollAvStillasCheck) {
			model.setSikkerKontorllAvStillas(sikkerBrukKontrollAvStillasCheck.isSelected());
			System.out.println("Endret sikkerbruk av stilas check");		
		} else if(e.getSource()==sikkerBrukAvForskalingCheck) {
			model.setSikkerBrukAvForskaling(sikkerBrukAvForskalingCheck.isSelected());
			System.out.println("Endret sikker bruk av forskaling check");
		} else if(e.getSource()==fallsikringutstyrCheck) {
			model.setFallSikkring(fallsikringutstyrCheck.isSelected());
			System.out.println("Endret fallsikringsutstyr check");
		} else if(e.getSource()==forstehjelpUtstyrCheck) {
			model.setForsteHjelp(forstehjelpUtstyrCheck.isSelected());
			System.out.println("Endret forstehjelp utstyr check");
		} else if(e.getSource()==annetCheck) {
			model.setAnnet(annetCheck.isSelected());
			System.out.println("Endret Annet check");
		} else if(e.getSource()==verkstedOgLagerPropertyComponent) {
			model.setVerksetedLagerTekst(verkstedOgLagerPropertyComponent.getText());
			System.out.println("Endret teksten til verksted og lager");
		} else if(e.getSource()==spesialKranerPropertyComponent) {
			model.setSpesialKranerTekst(spesialKranerPropertyComponent.getText());
			System.out.println("Endret teksten til spesialkran");
		} else if(e.getSource()==personlofterePropertyComponent) {
			model.setPersonLoftereTekst(personlofterePropertyComponent.getText());
			System.out.println("Endret personlofter tekst");
		} else if(e.getSource()==forstehjelpPropertyComponent) {
			model.setForstehjelpDatoTekst(forstehjelpPropertyComponent.getText());
			System.out.println("Endret teksten til forstehjelp");
		} else if(e.getSource()==annetPropertyComponent) {
			model.setAnnetTekst(annetPropertyComponent.getText());
			System.out.println("Endret teksten til annet");
		}
	}
}
