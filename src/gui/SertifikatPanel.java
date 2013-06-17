package gui;
/*
 * Author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 */

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

public class SertifikatPanel extends JPanel implements ActionListener,PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	protected JCheckBox driversLicense, grunnArbeidsmiljo, maskinforer, arbeidsVarsling, varmeArbeider,truckKranBevis;
	protected JLabel driverlicenseLabel, maskinforerLabel, arbeidsvarslingLabel, varmeArbeiderLabel, truckKranLabel;
	protected JTextField driverLicensePropertyComponent, maskinForerPropertyComponent, varmeArbeiderPropertyComponent, truckKranPropertyComponent, arbeidsVarslingPropertyComponent;
	
	
	protected JButton neste, nullstill;
	
	public SertifikatPanel() {
		driversLicense = new JCheckBox("Førerkort");
		grunnArbeidsmiljo = new JCheckBox("Grunnopplæring i Arbeidsmiljø");
		maskinforer = new JCheckBox("Maskinførerbevis");
		arbeidsVarsling = new JCheckBox("Arbeidsvarsling kurs nr");
		varmeArbeider = new JCheckBox("VarmeArbeider");
		truckKranBevis = new JCheckBox("Truck/kranførerbevis");
		driverlicenseLabel = new JLabel("Hvis ja, hvilke førerklasser: ");
		driverLicensePropertyComponent = new JTextField(5);
		maskinforerLabel = new JLabel("Hvis ja, hvilke: ");
		maskinForerPropertyComponent = new JTextField(5);
		arbeidsvarslingLabel = new JLabel("Hvis ja, kurs nr: ");
		arbeidsVarslingPropertyComponent = new JTextField(5);
		varmeArbeiderLabel = new JLabel("Hvis ja, utløpsdato: ");
		varmeArbeiderPropertyComponent = new JTextField(5);
		truckKranLabel = new JLabel("Hvis ja, hvilke: ");
		truckKranPropertyComponent = new JTextField(5);
		
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(1,1,1,1);
		
		//Legger ut checkbokser
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		add(driversLicense,c);
		c.anchor = GridBagConstraints.WEST;
		c.gridy = 1;
		add(grunnArbeidsmiljo,c);
		c.anchor = GridBagConstraints.WEST;
		c.gridy = 2;
		add(maskinforer,c);
		c.anchor = GridBagConstraints.WEST;
		c.gridy = 3;
		add(arbeidsVarsling,c);
		c.anchor = GridBagConstraints.WEST;
		c.gridy = 4;
		add(varmeArbeider,c);
		c.anchor = GridBagConstraints.WEST;
		c.gridy = 5;
		add(truckKranBevis,c);
		
		
		
		
		
		//Legger ut label og tekstbokser
		c.gridx = 1;
		c.gridy = 0;
		add(driverlicenseLabel,c);
		c.gridy = 2;
		add(maskinforerLabel,c);
		c.gridy = 3;
		add(arbeidsvarslingLabel,c);
		c.gridy = 4;
		add(varmeArbeiderLabel,c);
		c.gridy = 5;
		add(truckKranLabel,c);
		c.gridx = 2;
		c.gridy = 0;
		add(driverLicensePropertyComponent,c);
		c.gridy = 2;
		add(maskinForerPropertyComponent,c);
		c.gridy = 3;
		add(arbeidsVarslingPropertyComponent,c);
		c.gridy = 4;
		add(varmeArbeiderPropertyComponent,c);
		c.gridy = 5;
		add(truckKranPropertyComponent,c);
		
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
