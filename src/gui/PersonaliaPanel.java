package gui;
/*
 * Author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import personaliaModel.Personalia;


public class PersonaliaPanel extends JPanel implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	protected JLabel nameLabel,dateOfBirthLabel,idCardLabel,idCardExpiresDateLabel,adressLabel,postalNrLabel,postalPlaceLabel,telefoneNrLabel,employeerLabel;
	protected JLabel employerPhoneLabel,nextToKindNameLabel,nextToKindPhoneLabel,selectLanguageLabel;
	protected JTextField namePropertyComponent,dateOfBirthpropertyComponent,idCardPropertyComponent,idExpiresPropertyComponent,adressPropertyComponent,postNrPropertyComponent,postPlacePropertyComponent,phonePropertyComponent,employeePropertyComponent;
	protected JTextField employeePhonePropertyComponent,nextToKindPropertyComponent,nextToKindPhonePropertyComponent;
	protected JComboBox<Language> languageChoise;
	JButton Neste;

	Personalia model = null;

	public PersonaliaPanel() {		

		createComponents();

		addactionListeners();

		layGUI();
		namePropertyComponent.setName("NamePropertyComponent");
		dateOfBirthpropertyComponent.setName("DateOfBirthpropertyComponent");
		idCardPropertyComponent.setName("IdCardPropertyComponent");
		idExpiresPropertyComponent.setName("IdExpiresPropertyComponent");
		adressPropertyComponent.setName("AdressPropertyComponent");
		postNrPropertyComponent.setName("PostNrPropertyComponent");
		postPlacePropertyComponent.setName("PostPlacePropertyComponent");
		phonePropertyComponent.setName("PhonePropertyComponent");
		employeePropertyComponent.setName("EmployeePropertyComponent");
		employeePhonePropertyComponent.setName("EmployeePhonePropertyComponent");
		nextToKindPropertyComponent.setName("NextToKindPropertyComponent");
		nextToKindPhonePropertyComponent.setName("NextToKindPhonePropertyComponent");

	}

	private void layGUI() {
		//Legger ut GUI komponentene.
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();

		//c.gridheight = 10;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.gridx = 1;
		c.gridy = 0;
		add(selectLanguageLabel,c);
		selectLanguageLabel.setVisible(false); //Setter usynlige fordi denne funksjonen er ikke implementert ennå.
		c.gridx = 2;
		c.gridy = 0;
		add(languageChoise,c);
		languageChoise.setVisible(false); //Sette usynlig for denne funksjonen er ikke implementert ennå.



		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 1;
		add(nameLabel,c);
		c.gridx = 0;
		c.gridy = 2;
		add(dateOfBirthLabel,c);
		c.gridx = 0;
		c.gridy = 3;
		add(idCardLabel,c);
		c.gridx = 0;
		c.gridy = 4;
		add(idCardExpiresDateLabel,c);
		c.gridx = 0;
		c.gridy = 5;
		add(adressLabel,c);
		c.gridx = 0;
		c.gridy = 6;
		add(postalNrLabel,c);
		c.gridx = 2;
		c.gridy = 6;
		add(postalPlaceLabel,c);
		c.gridx = 0;
		c.gridy = 8;
		add(telefoneNrLabel,c);
		c.gridx = 0;
		c.gridy = 9;
		add(employeerLabel,c);
		c.gridx = 0;
		c.gridy = 10;
		add(employerPhoneLabel,c);
		c.gridx = 0;
		c.gridy = 11;
		add(nextToKindNameLabel,c);
		c.gridx = 0;
		c.gridy = 12;
		add(nextToKindPhoneLabel,c);

		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 1;
		add(namePropertyComponent,c);
		c.gridx = 1;
		c.gridy = 2;
		add(dateOfBirthpropertyComponent,c);
		c.gridx = 1;
		c.gridy = 3;
		add(idCardPropertyComponent,c);
		c.gridx = 1;
		c.gridy = 4;
		add(idExpiresPropertyComponent,c);
		c.gridx = 1;
		c.gridy = 5;
		add(adressPropertyComponent,c);
		c.gridx = 1;
		c.gridy = 6;
		add(postNrPropertyComponent,c);
		c.gridx = 3;
		c.gridy = 6;
		add(postPlacePropertyComponent,c);
		c.gridx = 1;
		c.gridy = 8;
		add(phonePropertyComponent,c);
		c.gridx = 1;
		c.gridy = 9;
		add(employeePropertyComponent,c);
		c.gridx = 1;
		c.gridy = 10;
		add(employeePhonePropertyComponent,c);
		c.gridx = 1;
		c.gridy = 11;
		add(nextToKindPropertyComponent,c);
		c.gridx = 1;
		c.gridy = 12;
		add(nextToKindPhonePropertyComponent,c);

		c.gridx=1;
		c.gridy=13;
		add(Neste,c);

	}

	private void createComponents() {
		//Fikser alle komponenter som skal brukes
		nameLabel = new JLabel("Navn: ");
		namePropertyComponent = new JTextField(15);
		dateOfBirthLabel = new JLabel("Fødselsdato: ");
		dateOfBirthpropertyComponent = new JTextField(10);
		idCardLabel = new JLabel("Id-kortnummer: ");
		idCardPropertyComponent = new JTextField(10);
		idCardExpiresDateLabel = new JLabel("Utløpsdato ID-kort: ");
		idExpiresPropertyComponent = new JTextField(10);
		adressLabel = new JLabel("Adresse: ");
		adressPropertyComponent = new JTextField(15);
		postalNrLabel = new JLabel("Postnr: ");
		postNrPropertyComponent = new JTextField(8);
		postalPlaceLabel = new JLabel("Poststed: ");
		postPlacePropertyComponent = new JTextField(15);
		telefoneNrLabel = new JLabel("Telefon/Mobil: ");
		phonePropertyComponent = new JTextField(10);
		employeerLabel = new JLabel("Arbeidsgiver: ");
		employeePropertyComponent = new JTextField(15);
		employerPhoneLabel = new JLabel("Arbeidsgivers telefon: ");
		employeePhonePropertyComponent = new JTextField(15);
		nextToKindNameLabel = new JLabel("Nærmeste pårørende: ");
		nextToKindPropertyComponent = new JTextField(15);
		nextToKindPhoneLabel = new JLabel("Telefon/Mobil til nærmeste pårørende: ");
		nextToKindPhonePropertyComponent = new JTextField(	10);
		selectLanguageLabel = new JLabel("Velg Språk/Select Language: ");
		languageChoise = new JComboBox<Language>(Language.values());
		Neste = new JButton("Neste");

	}
	private void addactionListeners() {
		//Legger til ActionListener på LaguageChoise dette slik at det skal gå å bytte språk, og på knappen.
		languageChoise.addActionListener(this);
		Neste.addActionListener(this);
		namePropertyComponent.addActionListener(this);
		dateOfBirthpropertyComponent.addActionListener(this);
		idCardPropertyComponent.addActionListener(this);
		idExpiresPropertyComponent.addActionListener(this);
		adressPropertyComponent.addActionListener(this);
		postNrPropertyComponent.addActionListener(this);
		postPlacePropertyComponent.addActionListener(this);
		phonePropertyComponent.addActionListener(this);
		employeePropertyComponent.addActionListener(this);
		employeePhonePropertyComponent.addActionListener(this);
		nextToKindPropertyComponent.addActionListener(this);
		nextToKindPhonePropertyComponent.addActionListener(this);
	}
	public void setModel(Personalia model){
		this.model = model;
		this.model.addPropertyChangeListener(this);
		namePropertyComponent.setText(model.getName());
		dateOfBirthpropertyComponent.setText(model.getDateOfBirth());
		idCardPropertyComponent.setText(model.getIdCardNr());
		idExpiresPropertyComponent.setText(model.getIdexpireDate());
		adressPropertyComponent.setText(model.getAdresse());
		postNrPropertyComponent.setText(model.getPostalNr());
		postPlacePropertyComponent.setText(model.getPostalPlace());
		phonePropertyComponent.setText(model.getPhoneNr());
		employeePropertyComponent.setText(model.getEmployeer());
		employeePhonePropertyComponent.setText(model.getEmployeerPhone());
		nextToKindPropertyComponent.setText(model.getNextToKind());
		nextToKindPhonePropertyComponent.setText(model.getNextToKindPhone());		
	}
	public Personalia getModel() {
		return model;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(model != null) {
			return;
		}

		try {
			if(evt.getSource() == Neste) {
				System.out.println("Du trykket på knappen");
//				System.out.println("" + model.getName() + " " + model.getDateOfBirth() + " " + model.getIdCardNr());
			} 
			if(evt.getSource() == languageChoise) {
				System.out.println("Du endret språk til: " + (Language)languageChoise.getSelectedItem() + " index: " + languageChoise.getSelectedIndex());
				//languageNr = languageChoise.getSelectedIndex();
			} 
			if(evt.getSource() == namePropertyComponent) {
				model.setName(namePropertyComponent.getText());
			} 
			if(evt.getSource() == dateOfBirthpropertyComponent) {
				model.setDateOfBirth(dateOfBirthpropertyComponent.getText());
			} 
			if(evt.getSource() == idCardPropertyComponent) {
				model.setIdCardNr(idCardPropertyComponent.getText());
			} else if(evt.getSource() == idExpiresPropertyComponent) {
				model.setIdexpireDate(idExpiresPropertyComponent.getText()); 
			} else if(evt.getSource() == adressPropertyComponent) {
				model.setAdresse(adressPropertyComponent.getText());
			} else if(evt.getSource() == postNrPropertyComponent) {
				model.setPostalNr(postNrPropertyComponent.getText());
			} else if(evt.getSource() == postalPlaceLabel) {
				model.setPostalPlace(postPlacePropertyComponent.getText());
			} else if(evt.getSource()==phonePropertyComponent) {
				model.setPhoneNr(phonePropertyComponent.getText());
			} else if(evt.getSource()==employeePropertyComponent) {
				model.setEmployeer(employeePropertyComponent.getText());
			} else if(evt.getSource()==employeePhonePropertyComponent) {
				model.setEmployeerPhone(employeePhonePropertyComponent.getText());
			} else if(evt.getSource()==nextToKindPropertyComponent) {
				model.setNextToKind(nextToKindPropertyComponent.getText());
			} else if(evt.getSource()==nextToKindPhonePropertyComponent) {
				model.setNextToKindPhone(nextToKindPhonePropertyComponent.getText());
			} else {
				System.out.println("WTF happend in actionPerformed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some shit happend");
		}
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("hendelse");
		if(evt.getPropertyName() == Personalia.NAME_PROPERTY) {
			namePropertyComponent.setText(model.getName());
			System.out.println("Navn endret");
		} else if (evt.getPropertyName() == Personalia.DATE_PROPERTY) {
			dateOfBirthpropertyComponent.setText(model.getDateOfBirth());
			System.out.println("Endret dateOfBirth");
		} else if (evt.getPropertyName() == Personalia.ID_CARDNUMBER) {
			idCardPropertyComponent.setText(model.getIdCardNr());
			System.out.println("Endret id_cardNumber"); 
		} else if (evt.getPropertyName() == Personalia.ID_EXPIRATION) {
			idExpiresPropertyComponent.setText(model.getIdexpireDate());
			System.out.println("Endret id_expirationdate"); 
		} else if (evt.getPropertyName() == Personalia.ADRESS_PROPERTY) {
			adressPropertyComponent.setText(model.getAdresse());
			System.out.println("Endret adresse"); 
		} else if (evt.getPropertyName() == Personalia.POSTALNR_PROPERTY) {
			postNrPropertyComponent.setText(model.getPostalNr());
			System.out.println("Endret postnr"); 
		} else if (evt.getPropertyName() == Personalia.POSTALPLACE_PROPERTY) {
			postPlacePropertyComponent.setText(model.getPostalPlace());
			System.out.println("Endret poststed"); 
		} else if (evt.getPropertyName() == Personalia.PHONE_PROPERTY) {
			phonePropertyComponent.setText(model.getPhoneNr());
			System.out.println("Endret TelefonNr"); 
		} else if (evt.getPropertyName() == Personalia.EMPLOYER_PROPERTY) {
			employeePropertyComponent.setText(model.getEmployeer());
			System.out.println("Endret employee"); 
		} else if (evt.getPropertyName() == Personalia.EMPLOYERPHONE_PROPERTY) {
			employeePhonePropertyComponent.setText(model.getEmployeerPhone());
			System.out.println("Endret employeePhone"); 
		} else if (evt.getPropertyName() == Personalia.NEXTTO_PROPERTY) {
			nextToKindPropertyComponent.setText(model.getNextToKind());
			System.out.println("Endret nextToKind"); 
		} else if (evt.getPropertyName() == Personalia.NEXTTOPHONE_PROPERTY) {
			nextToKindPhonePropertyComponent.setText(model.getNextToKindPhone());
			System.out.println("Endret nextToPhone"); 
		} else {
			System.out.println("WTF happend in propertyChange");
		}
	}
}
