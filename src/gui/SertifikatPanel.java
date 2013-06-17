package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class SertifikatPanel extends JPanel implements ActionListener,PropertyChangeListener {
	protected JCheckBox driversLicense, grunnArbeidsmiljo, maskinforer, arbeidsVarsling, varmeArbeider,truckKranBevis;
	
	public SertifikatPanel() {
		driversLicense = new JCheckBox("Førerkort");
		grunnArbeidsmiljo = new JCheckBox("Grunnopplæring i Arbeidsmiljø");
		maskinforer = new JCheckBox("Maskinførerbevis");
		arbeidsVarsling = new JCheckBox("Arbeidsvarsling kurs nr");
		varmeArbeider = new JCheckBox("VarmeArbeider");
		truckKranBevis = new JCheckBox("Truck/kranførerbevis");
		
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		add(driversLicense,c);
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 0;
		add(grunnArbeidsmiljo,c);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 2;
		c.gridy = 0;
		add(maskinforer,c);
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 1;
		add(arbeidsVarsling,c);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		add(varmeArbeider);
		c.anchor = GridBagConstraints.EAST;
		c.gridx=2;
		c.gridy=1;
		add(truckKranBevis);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
