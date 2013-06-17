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

public class KursPanel extends JPanel implements ActionListener,PropertyChangeListener, ChangeListener {
	private static final long serialVersionUID = 1L;
	protected JCheckBox verkstedOgLagerCheck, SpesialKranerCheck, VinsjerOgTaljerCheck, anhukingStroppingOgSignalgivningCheck, klatreOgHengeStilaserCheck, personLøftereCheck, personLøftereUnderJordCheck;
	protected JCheckBox borVognerOgTunnelriggerCheck, selvgåendeValserCheck, TraktorutstyrCheck, vinkelSliperKutterCheck, boltePistolCheck, spikerPistolCheck, KombiHammerBorHammerCheck, kjedeSagCheck;
	protected JCheckBox KappKlyveGjerdeSagCheck, bindeMaskinArmeringCheck, VibrostavCheck, haandholdtArmeringsKapperCheck, skjarebrennerCheck, sponBrytendeCheck, slipemaskinerCheck, trebearbeidingsMaskinerCheck;
	protected JCheckBox asfaltArbeiderCheck, betongSagerKjerneBorCheck, veggsagerCheck, vaierSagerCheck, gulvsagerOgAsfaltsagCheck, hoytrykkspylerUtstyrCheck, ryddeSagerOgTrimmereCheck, spunteOgPaleutstyrCheck;
	protected JCheckBox mobiltBetongPumpeUtstyr, sikkerBrukKontrollAvStillasCheck, sikkerBrukAvForskalingCheck, fallsikringutstyrCheck, forstehjelpUtstyr;
	protected JCheckBox annetLabel;
	
	protected JTextField verkstedOgLagerPropertyComponent, spesialKranerPropertyComponent, personlofterePropertyComponent, forstehjelpPropertyComponent, annetPropertyComponent;
	
	public KursPanel() {
		//Legger ut componentene i GUI
		
		createKursComponents();
		layComponents();
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
		add(personLøftereCheck,c);
		c.gridy = 6;
		add(personLøftereUnderJordCheck,c);
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
		add(annetLabel,c);
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
		add(forstehjelpUtstyr,c);
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
		anhukingStroppingOgSignalgivningCheck = new JCheckBox("ANhuking - stropping - signalgivning");
		klatreOgHengeStilaserCheck = new JCheckBox("Klatre- og hengestillaser(36t kurs)");
		personLøftereCheck = new JCheckBox("Personløftere klasse: ");
		personlofterePropertyComponent = new JTextField(6);
		personLøftereUnderJordCheck = new JCheckBox("Personløftere under jord");
		borVognerOgTunnelriggerCheck = new JCheckBox("Borvogner og tunnelrigger");
		selvgåendeValserCheck = new JCheckBox("Selvgående valser");
		TraktorutstyrCheck = new JCheckBox("Traktorutstyr");
		vinkelSliperKutterCheck = new JCheckBox("Vinkelsliper/-kutter");
		boltePistolCheck = new JCheckBox("Boltepistol");
		annetLabel = new JCheckBox("Annet: (Beskriv):");
		
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
		forstehjelpUtstyr = new JCheckBox("Førstehjelpskurs, Dato:");
		forstehjelpPropertyComponent = new JTextField(5);
		annetPropertyComponent = new JTextField(48);		
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
		// TODO Auto-generated method stub
		
	}
}
