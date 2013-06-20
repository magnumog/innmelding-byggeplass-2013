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

import modell.Sertifikat;

public class SertifikatPanel extends JPanel implements ActionListener,PropertyChangeListener {
	private static final long serialVersionUID = 1L;	
	protected JCheckBox driversLicenseCheck, grunnArbeidsmiljoCheck, maskinforerCheck, arbeidsVarslingCheck, varmeArbeiderCheck, truckKranBevisCheck;
	protected JLabel driverlicenseLabel, maskinforerLabel, arbeidsvarslingLabel, varmeArbeiderLabel, truckKranLabel;
	protected JTextField driverLicensePropertyComponent, maskinForerPropertyComponent, varmeArbeiderPropertyComponent, truckKranPropertyComponent, arbeidsVarslingPropertyComponent;

	protected JButton neste, nullstill;
	
	Sertifikat model = null;
	
	public SertifikatPanel() {		
		createSertifikatKursComponents();
		laySertifikatGrid();
		addActionListeners();		
		
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
		c.gridy=8;
		add(neste,c);
		c.gridy=9;
		add(nullstill,c);
		
	}

	private void addActionListeners() {
		driversLicenseCheck.addActionListener(this);
		grunnArbeidsmiljoCheck.addActionListener(this);
		maskinforerCheck.addActionListener(this);
		arbeidsVarslingCheck.addActionListener(this);
		varmeArbeiderCheck.addActionListener(this);
		truckKranBevisCheck.addActionListener(this);
		driverLicensePropertyComponent.addActionListener(this);
		maskinForerPropertyComponent.addActionListener(this);
		varmeArbeiderPropertyComponent.addActionListener(this);
		truckKranPropertyComponent.addActionListener(this);
		arbeidsVarslingPropertyComponent.addActionListener(this);
		neste.addActionListener(this);
		nullstill.addActionListener(this);
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
		neste = new JButton("Neste");
		nullstill = new JButton("Nullstill");
	}
	
	public void setModel(Sertifikat model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		driversLicenseCheck.setSelected(model.isForerkort());
		driverLicensePropertyComponent.setText(model.getForerkortKlasser());
		grunnArbeidsmiljoCheck.setSelected(model.isGrunnopplaeringArbeidsmiljo());
		maskinforerCheck.setSelected(model.isMaskinForerBevis());
		maskinForerPropertyComponent.setText(model.getMaskinForerKlasser());
		arbeidsVarslingCheck.setSelected(model.isArbeidsVarsling());
		arbeidsVarslingPropertyComponent.setText(model.getArbeidsVarslingKurs());
		varmeArbeiderCheck.setSelected(model.isVarmeArbeider());
		varmeArbeiderPropertyComponent.setText(model.getVarmeArbeiderdato());
		truckKranBevisCheck.setSelected(model.isTruckKranForer());
		truckKranPropertyComponent.setText(model.getTruckKranForerBevis());
	}
	
	public Sertifikat getModel() {
		return model;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Hendelse");
		if(evt.getPropertyName() == Sertifikat.FORERKORT_PROPERTY) {
			driversLicenseCheck.setSelected(model.isForerkort());
		} else if(evt.getPropertyName() == Sertifikat.FORERKORTKLASSER_PROPERTY) {
			driverLicensePropertyComponent.setText(model.getForerkortKlasser());
		} else if(evt.getPropertyName() == Sertifikat.GRUNNOPPLARING_PROPERTY) {
			grunnArbeidsmiljoCheck.setSelected(model.isGrunnopplaeringArbeidsmiljo());
		} else if(evt.getPropertyName() == Sertifikat.MASKINFORER_PROPERTY) {
			maskinforerCheck.setSelected(model.isMaskinForerBevis());
		} else if(evt.getPropertyName() == Sertifikat.MASKINKLASSER_PROPERTY) {
			maskinForerPropertyComponent.setText(model.getMaskinForerKlasser());
		} else if(evt.getPropertyName() == Sertifikat.ARBEIDSVARSLING_PROPERTY) {
			arbeidsVarslingCheck.setSelected(model.isArbeidsVarsling());
		} else if(evt.getPropertyName() == Sertifikat.ARBEIDSVARSLINGSKURS_PROPERTY) {
			arbeidsVarslingPropertyComponent.setText(model.getArbeidsVarslingKurs());
		} else if(evt.getPropertyName() == Sertifikat.VARMEARBEIDER_PROPERTY) {
			varmeArbeiderCheck.setSelected(model.isVarmeArbeider());
		} else if(evt.getPropertyName() == Sertifikat.VARMEARBEIDERDATO_PROPERTY) {
			varmeArbeiderPropertyComponent.setText(model.getVarmeArbeiderdato());
		} else if(evt.getPropertyName() == Sertifikat.TRUCKKRANFORER_PROPERTY) {
			truckKranBevisCheck.setSelected(model.isTruckKranForer());
		} else if(evt.getPropertyName() == Sertifikat.TRUCKKRANFORERBEVIS_PROPERTY) {
			truckKranPropertyComponent.setText(model.getTruckKranForerBevis());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(model==null) {
			return;
		}
		
		try {
			if(a.getSource() == neste) {
				model.setForerkort(driversLicenseCheck.isSelected());
				model.setForerkortKlasser(driverLicensePropertyComponent.getText());
				model.setGrunnopplaeringArbeidsmiljo(grunnArbeidsmiljoCheck.isSelected());
				model.setMaskinForerBevis(maskinforerCheck.isSelected());
				model.setMaskinForerKlasser(maskinForerPropertyComponent.getText());
				model.setArbeidsVarsling(arbeidsVarslingCheck.isSelected());
				model.setArbeidsVarslingKurs(arbeidsVarslingPropertyComponent.getText());
				model.setVarmeArbeider(varmeArbeiderCheck.isSelected());
				model.setVarmeArbeiderdato(varmeArbeiderPropertyComponent.getText());
				model.setTruckKranForer(truckKranBevisCheck.isSelected());
				model.setTruckKranForerBevis(truckKranPropertyComponent.getText());
				System.out.println("FORERKORT:" + model.isForerkort() + " FORERKORTKLASSER:" + model.getForerkortKlasser() + " GRUNNOPPLÆRINGARBEIDSMILJØ:" + model.isGrunnopplaeringArbeidsmiljo());
				System.out.println("MASKINFORER:" + model.isMaskinForerBevis() +  " MASKINFORERKLASSER:" + model.getMaskinForerKlasser() + " ABEIDSVARSLER:" + model.isArbeidsVarsling());
				System.out.println("ARBEIDSVARSLERKURS:" + model.getArbeidsVarslingKurs() + " VARMEARBEIDER:" + model.isVarmeArbeider() + " VARMEDATO:" + model.getVarmeArbeiderdato());
				System.out.println("TRUCK/KRANFORER:" + model.isTruckKranForer() + " TRUCK/KRANFORERBEVIS:" + model.getTruckKranForerBevis());
			} else if(a.getSource()==nullstill) {
				model.setForerkort(false);
				model.setForerkortKlasser(null);
				model.setGrunnopplaeringArbeidsmiljo(false);
				model.setMaskinForerBevis(false);
				model.setMaskinForerKlasser(null);
				model.setArbeidsVarsling(false);
				model.setArbeidsVarslingKurs(null);
				model.setVarmeArbeider(false);
				model.setVarmeArbeiderdato(null);
				model.setTruckKranForer(false);
				model.setTruckKranForerBevis(null);
				System.out.println("FORERKORT:" + model.isForerkort() + " FORERKORTKLASSER:" + model.getForerkortKlasser() + " GRUNNOPPLÆRINGARBEIDSMILJØ:" + model.isGrunnopplaeringArbeidsmiljo());
				System.out.println("MASKINFORER:" + model.isMaskinForerBevis() +  " MASKINFORERKLASSER:" + model.getMaskinForerKlasser() + " ABEIDSVARSLER:" + model.isArbeidsVarsling());
				System.out.println("ARBEIDSVARSLERKURS:" + model.getArbeidsVarslingKurs() + " VARMEARBEIDER:" + model.isVarmeArbeider() + " VARMEDATO:" + model.getVarmeArbeiderdato());
				System.out.println("TRUCK/KRANFORER:" + model.isTruckKranForer() + " TRUCK/KRANFORERBEVIS:" + model.getTruckKranForerBevis());	
			} else if(a.getSource()==driversLicenseCheck) {
				model.setForerkort(driversLicenseCheck.isSelected());
				System.out.println("Endret Forerkort");
			} else if(a.getSource() == driverLicensePropertyComponent) {
				model.setForerkortKlasser(driverLicensePropertyComponent.getText());
				System.out.println("Endret tekst til Forerkort");
			} else if(a.getSource() == grunnArbeidsmiljoCheck) {
				model.setGrunnopplaeringArbeidsmiljo(grunnArbeidsmiljoCheck.isSelected());
				System.out.println("Endret Grunnopplaring");
			} else if(a.getSource() == maskinforerCheck) {
				model.setMaskinForerBevis(maskinforerCheck.isSelected());
				System.out.println("Endret maskinforer");
			} else if(a.getSource() == maskinForerPropertyComponent) {
				model.setMaskinForerKlasser(maskinForerPropertyComponent.getText());
				System.out.println("Endret maskinforer tekst");
			} else if(a.getSource() == arbeidsVarslingCheck) {
				model.setArbeidsVarsling(arbeidsVarslingCheck.isSelected());
				System.out.println("Endret arbeidsvarsling");
			} else if(a.getSource() == arbeidsVarslingPropertyComponent) {
				model.setArbeidsVarslingKurs(arbeidsVarslingPropertyComponent.getText());
				System.out.println("Endret arbeidsvarsling tekst");
			} else if(a.getSource() == varmeArbeiderCheck) {
				model.setVarmeArbeider(varmeArbeiderCheck.isSelected());
				System.out.println("Endrt varmearbeider");
			} else if(a.getSource() == varmeArbeiderPropertyComponent) {
				model.setVarmeArbeiderdato(varmeArbeiderPropertyComponent.getText());
				System.out.println("Endret Varmearbeider tekst");
			} else if(a.getSource() == truckKranBevisCheck) {
				model.setTruckKranForer(truckKranBevisCheck.isSelected());
				System.out.println("Endret truckKran bevis");
			} else if(a.getSource() == truckKranPropertyComponent) {
				model.setTruckKranForerBevis(truckKranPropertyComponent.getText());
				System.out.println("Endret truckKran tekst");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some shit happend in Sertifikat");
		}
		
	}

}
