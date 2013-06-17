package panel;
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
	protected JCheckBox driversLicenseCheck, grunnArbeidsmiljoCheck, maskinforerCheck, arbeidsVarslingCheck, varmeArbeiderCheck, truckKranBevisCheck;
	protected JLabel driverlicenseLabel, maskinforerLabel, arbeidsvarslingLabel, varmeArbeiderLabel, truckKranLabel;
	protected JTextField driverLicensePropertyComponent, maskinForerPropertyComponent, varmeArbeiderPropertyComponent, truckKranPropertyComponent, arbeidsVarslingPropertyComponent;

	protected JButton neste, nullstill;
	
	public SertifikatPanel() {		
		createSertifikatKursComponents();
		laySertifikatGrid();
		
	}

	private void laySertifikatGrid() {
		//Legger ut componentene i GUI
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(1,1,1,1);
		
		//Legger ut checkbokser
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 2;
		add(driversLicenseCheck,c);
		c.gridy = 3;
		add(grunnArbeidsmiljoCheck,c);
		c.gridy =4;
		add(maskinforerCheck,c);
		c.gridy = 5;
		add(arbeidsVarslingCheck,c);
		c.gridy = 6;
		add(varmeArbeiderCheck,c);
		c.gridy = 7;
		add(truckKranBevisCheck,c);
		
		//Legger ut label og tekstbokser
		c.gridx = 1;
		c.gridy = 2;
		add(driverlicenseLabel,c);
		c.gridy = 4;
		add(maskinforerLabel,c);
		c.gridy = 5;
		add(arbeidsvarslingLabel,c);
		c.gridy = 6;
		add(varmeArbeiderLabel,c);
		c.gridy = 7;
		add(truckKranLabel,c);
		c.gridx = 2;
		c.gridy = 2;
		add(driverLicensePropertyComponent,c);
		c.gridy = 4;
		add(maskinForerPropertyComponent,c);
		c.gridy = 5;
		add(arbeidsVarslingPropertyComponent,c);
		c.gridy = 6;
		add(varmeArbeiderPropertyComponent,c);
		c.gridy = 7;
		add(truckKranPropertyComponent,c);
		

		
	}

	private void createSertifikatKursComponents() {
		driversLicenseCheck = new JCheckBox("Førerkort");
		grunnArbeidsmiljoCheck = new JCheckBox("Grunnopplæring i Arbeidsmiljø");
		maskinforerCheck = new JCheckBox("Maskinførerbevis");
		arbeidsVarslingCheck = new JCheckBox("Arbeidsvarsling kurs nr");
		varmeArbeiderCheck = new JCheckBox("VarmeArbeider");
		truckKranBevisCheck = new JCheckBox("Truck/kranførerbevis");
		driverlicenseLabel = new JLabel("Hvis ja, hvilke førerklasser: ");
		driverLicensePropertyComponent = new JTextField(5);
		maskinforerLabel = new JLabel("Hvis ja, hvilke klasse: ");
		maskinForerPropertyComponent = new JTextField(5);
		arbeidsvarslingLabel = new JLabel("Hvis ja, kurs nr: ");
		arbeidsVarslingPropertyComponent = new JTextField(5);
		varmeArbeiderLabel = new JLabel("Hvis ja, utløpsdato: ");
		varmeArbeiderPropertyComponent = new JTextField(5);
		truckKranLabel = new JLabel("Hvis ja, hvilke klasse: ");
		truckKranPropertyComponent = new JTextField(5);
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
