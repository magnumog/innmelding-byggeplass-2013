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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import personaliaModel.PersonaliaModel;

public class PersonaliaPanel extends JPanel implements ActionListener, PropertyChangeListener {
	
	private static final long serialVersionUID = 1L;
	protected JLabel nameLabel,dateOfBirthLabel,idCardLabel,idCardExpiresDateLabel,adressLabel,postalNrLabel,postalPlaceLabel,telefoneNrLabel,employeerLabel;
	protected JLabel employerPhoneLabel,nextToKindNameLabel,nextToKindPhoneLabel,selectLanguageLabel;
	protected JTextField namePropertyComponent,dateOfBirthpropertyComponent,idCardPropertyComponent,idExpiresPropertyComponent,adressPropertyComponent,postNrPropertyComponent,postPlacePropertyComponent,phonePropertyComponent,employeePropertyComponent;
	protected JTextField employeePhonePropertyComponent,nextToKindPropertyComponent,nextToKindPhonePropertyComponent;
	protected JComboBox<Language> languageChoise;
	JButton Neste;
	
	PersonaliaModel model = null;
	
	public PersonaliaPanel() {		
		createComponents();
		
		addactionListeners();
		
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

	public void setModel(PersonaliaModel model){
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

	public PersonaliaModel getModel() {
		return model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(model == null) {
			return;
		}
		
		if(e.getSource() == Neste) {
			System.out.println("Du trykket på knappen");
		} else if(e.getSource() == languageChoise) {
			System.out.println("Du endret språk til: " + (Language)languageChoise.getSelectedItem() + " index: " + languageChoise.getSelectedIndex());
			//languageNr = languageChoise.getSelectedIndex();
		} else if(e.getSource() == namePropertyComponent) {
			model.setName(namePropertyComponent.getText());
		}else if(e.getSource() == namePropertyComponent) {
			model.setName(namePropertyComponent.getText());
		} else if(e.getSource() == dateOfBirthpropertyComponent) {
			model.setDateOfBirth(dateOfBirthpropertyComponent.getText());
		} else if(e.getSource() == idCardPropertyComponent) {
			model.setIdCardNr(idCardPropertyComponent.getText());
		} else if(e.getSource() == idExpiresPropertyComponent) {
			model.setIdexpireDate(idExpiresPropertyComponent.getText()); 
		} else if(e.getSource() == adressPropertyComponent) {
			model.setAdresse(adressPropertyComponent.getText());
		} else if(e.getSource() == postNrPropertyComponent) {
			model.setPostalNr(postNrPropertyComponent.getText());
		} else if(e.getSource() == postalPlaceLabel) {
			model.setPostalPlace(postPlacePropertyComponent.getText());
		} else if(e.getSource()==phonePropertyComponent) {
			model.setPhoneNr(phonePropertyComponent.getText());
		} else if(e.getSource()==employeePropertyComponent) {
			model.setEmployeer(employeePropertyComponent.getText());
		} else if(e.getSource()==employeePhonePropertyComponent) {
			model.setEmployeerPhone(employeePhonePropertyComponent.getText());
		} else if(e.getSource()==nextToKindPropertyComponent) {
			model.setNextToKind(nextToKindPropertyComponent.getText());
		} else if(e.getSource()==nextToKindPhonePropertyComponent) {
			model.setNextToKindPhone(nextToKindPhonePropertyComponent.getText());
		} else {
			System.out.println("WTF happend in actionPerformed");
		}
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("hendelse");
		if(evt.getPropertyName() == PersonaliaModel.NAME_PROPERTY) {
			namePropertyComponent.setText(model.getName());
			System.out.println("Navn endret");
		} else if (evt.getPropertyName() == PersonaliaModel.DATE_PROPERTY) {
			System.out.println("Endret dateOfBirth");
		} else if (evt.getPropertyName() == PersonaliaModel.DATE_PROPERTY) {
			System.out.println("Endret dateOfBirth");
		} else if (evt.getPropertyName() == PersonaliaModel.ID_CARDNUMBER) {
			System.out.println("Endret id_cardNumber"); 
		} else if (evt.getPropertyName() == PersonaliaModel.ID_EXPIRATION) {
			System.out.println("Endret id_expirationdate"); 
		} else if (evt.getPropertyName() == PersonaliaModel.ADRESS_PROPERTY) {
			System.out.println("Endret adresse"); 
		} else if (evt.getPropertyName() == PersonaliaModel.POSTALNR_PROPERTY) {
			System.out.println("Endret postnr"); 
		} else if (evt.getPropertyName() == PersonaliaModel.POSTALPLACE_PROPERTY) {
			System.out.println("Endret poststed"); 
		} else if (evt.getPropertyName() == PersonaliaModel.PHONE_PROPERTY) {
			System.out.println("Endret TelefonNr"); 
		} else if (evt.getPropertyName() == PersonaliaModel.EMPLOYER_PROPERTY) {
			System.out.println("Endret employee"); 
		} else if (evt.getPropertyName() == PersonaliaModel.EMPLOYERPHONE_PROPERTY) {
			System.out.println("Endret employeePhone"); 
		} else if (evt.getPropertyName() == PersonaliaModel.NEXTTO_PROPERTY) {
			System.out.println("Endret nextToKind"); 
		} else if (evt.getPropertyName() == PersonaliaModel.NEXTTOPHONE_PROPERTY) {
			System.out.println("Endret nextToPhone"); 
		} else {
			System.out.println("WTF happend in propertyChange");
		}
	}
}
