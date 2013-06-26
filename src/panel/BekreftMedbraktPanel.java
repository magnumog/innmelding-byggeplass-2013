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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modell.BekreftMedbrakt;

public class BekreftMedbraktPanel extends JPanel implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	protected JCheckBox harMedVerneUtstyr, tillgjengeligVerneUtstyr;
	protected JTextField datoBekreftet, navnPaaArbeidstaker;
	protected JLabel datoLabel, arbeidsgiverLabel;
	
	protected JButton neste;
	
	BekreftMedbrakt model = null;
	
	public BekreftMedbraktPanel() {
		harMedVerneUtstyr = new JCheckBox("Påbudt verneutstyr: Hjelm(Standard: EN397) og vernesko(Standard: EN345(EN ISO20345)) med spikertrampsåle.");
		tillgjengeligVerneUtstyr = new JCheckBox("Alltid tilgengelig: Hørselvern, øyevern, arbeidshansker og ved behov Åndedrettsvern, kjemikalie-/kuttreduserende-/spesialhansker og synbarhetstøy");
		datoBekreftet = new JTextField(8);
		navnPaaArbeidstaker = new JTextField(15);
		datoLabel = new JLabel("Dato:");
		arbeidsgiverLabel = new JLabel("Navn på arbeidgiver:");
		neste = new JButton("NESTE");
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
		c.gridx=1;
		add(datoBekreftet,c);
		c.gridx=2;
		add(arbeidsgiverLabel,c);
		c.gridx=3;
		add(navnPaaArbeidstaker,c);
		c.gridy=3;
		add(neste,c);
		
		harMedVerneUtstyr.addActionListener(this);
		tillgjengeligVerneUtstyr.addActionListener(this);
		datoBekreftet.addActionListener(this);
		navnPaaArbeidstaker.addActionListener(this);
		neste.addActionListener(this);
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
