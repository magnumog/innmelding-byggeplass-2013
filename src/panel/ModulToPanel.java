package panel;

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

import database.DBInnsertion;

import modell.ModulTo;

public class ModulToPanel extends JPanel implements ActionListener,PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	protected JCheckBox fravar, bedriftsikkerhetsinstruks, gjennomfortModulTo, klistremerkeModulEn, veidekkesReaksjonsMonster, avviskblokkOgRisikovurdering, SHAplan;
	
	protected static JButton neste;
	
	ModulTo model = null;
//	DBConnection conn = new DBConnection();
	
	public ModulToPanel() {
		fravar = new JCheckBox("Informert om fraværsoppfølging, alternativt arbeid ved skade/sykdom, AKAN, varslingsrutiner ved sykdom og skade.");
		bedriftsikkerhetsinstruks = new JCheckBox("Underskrevet bedriftens sikkerhetsInstruks.");
		gjennomfortModulTo = new JCheckBox("Gjennomført obligatorisk sikkerhetsopplæring på prosjektet (Modul 2). (utdelt klistremerke for hjelm der dette benyttes).");
		klistremerkeModulEn = new JCheckBox("Mottatt klistremerke for godkjent Modul 1 og festet denne på hjelm.");
		veidekkesReaksjonsMonster = new JCheckBox("Arbeidstakeren er inneforstått med Veidekkes reaksjonsmønster ved brudd på sikkerhetsbestemmelser.");
		avviskblokkOgRisikovurdering = new JCheckBox("Fått utdelt avviksblokk og Risikovurdering - \"Blokk - løpende risikovurdering\"");
		SHAplan = new JCheckBox("Gjort kjent med Byggherrens SHA-plan - oppslagstavle");
		neste = new JButton("Neste");
		
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(1, 1, 1, 1);
		c.anchor = GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		add(fravar,c);
		c.gridy=1;
		add(bedriftsikkerhetsinstruks,c);
		c.gridy=2;
		add(gjennomfortModulTo,c);
		c.gridy=3;
		add(klistremerkeModulEn,c);
		c.gridy=4;
		add(veidekkesReaksjonsMonster,c);
		c.gridy=5;
		add(avviskblokkOgRisikovurdering,c);
		c.gridy=6;
		add(SHAplan,c);
		c.gridy=7;
		add(neste,c);
		
		fravar.addActionListener(this);
		bedriftsikkerhetsinstruks.addActionListener(this);
		gjennomfortModulTo.addActionListener(this);
		klistremerkeModulEn.addActionListener(this);
		veidekkesReaksjonsMonster.addActionListener(this);
		avviskblokkOgRisikovurdering.addActionListener(this);
		SHAplan.addActionListener(this);
		neste.addActionListener(this);
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
		System.out.println("Hendelse");
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
			System.out.println("Fravær:" + model.isFravaroppfolging() + " Sikkerhetsinstruks:" + model.isUnderskrevetsikkerhetsinstruks() + "gjennomførtModulTo:" + model.isGjennomfortModulTo() + "Klistremerke:" +model.isKlistremerkeModulEn());
			System.out.println("Reaksjonsmønster:" + model.isInneforstattMedReaksjonsmonster() + " Avviksblokk:" + model.isUtdeltBlokkLopendeRisiko() + " SHA-plan:" + model.isSHAPlan());
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

}
