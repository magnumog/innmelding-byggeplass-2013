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
import javax.swing.*;

import personaliaModel.Personalia;


public class PersonaliaPanel extends JPanel implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	//GUI til personalia
	protected JLabel nameLabel,dateOfBirthLabel,idCardLabel,idCardExpiresDateLabel,adressLabel,postalNrLabel,postalPlaceLabel,telefoneNrLabel,employeerLabel;
	protected JLabel employerPhoneLabel,nextToKindNameLabel,nextToKindPhoneLabel,selectLanguageLabel, emptyLabel;
	protected JTextField namePropertyComponent,dateOfBirthpropertyComponent,idCardPropertyComponent,idExpiresPropertyComponent,adressPropertyComponent,postNrPropertyComponent,postPlacePropertyComponent,phonePropertyComponent,employeePropertyComponent;
	protected JTextField employeePhonePropertyComponent,nextToKindPropertyComponent,nextToKindPhonePropertyComponent;
	protected JComboBox<Language> languageChoise;
	
	//GUI språk
	protected JLabel speakSkandinaviskLabel, understandSkandinaviskLabel;
	protected JToggleButton speakSkadinvaiskJaToggel,speakSkadinvaiskNeiToggel,understadnSkandinaviskJaToggel,understadnSkandinaviskNeiToggel;
	protected ButtonGroup speakSkandinavisk,understandSkandinavisk;
	protected JTextField speakTiltakPropertyComponent,understandTiltakPropertyComponent;
	protected JLabel speakTiltakLabel,understandTiltakLabel;
	
	boolean speakingSkandinavisk, understandingSkandinavisk;
	
	
	//GUI knapper
	protected JButton Neste,nullstill;

	Personalia model = null;

	public PersonaliaPanel() {
		createComponents();
		addactionListeners();
		layGUI();
		setNameOnComponenents();
		
	}

	private void setNameOnComponenents() {
		// Setter navn på componentene slik at de kan brukes i tester
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
		
		c.ipadx=1;
		c.ipady=1;
		c.insets = new Insets(2,2,2,2);

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
		c.gridx=0;
		c.gridy=13;
		add(speakSkandinaviskLabel,c);
		c.gridx=0;
		c.gridy=14;
		add(understandSkandinaviskLabel,c);

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
		add(speakSkadinvaiskJaToggel,c);
		c.anchor=GridBagConstraints.EAST;
		c.gridx=1;
		c.gridy=13;
		add(speakSkadinvaiskNeiToggel,c);
		c.anchor=GridBagConstraints.WEST;
		c.gridx=1;
		c.gridy=14;
		add(understadnSkandinaviskJaToggel,c);
		c.anchor=GridBagConstraints.EAST;
		c.gridx=1;
		c.gridy=14;
		add(understadnSkandinaviskNeiToggel,c);
		c.gridx=2;
		c.gridy=13;
		add(speakTiltakLabel,c);
		c.gridx=2;
		c.gridy=14;
		add(understandTiltakLabel,c);
		c.anchor = GridBagConstraints.WEST;
		c.gridx=3;
		c.gridy=13;
		add(speakTiltakPropertyComponent, c);
		c.gridx=3;
		c.gridy=14;
		add(understandTiltakPropertyComponent,c);
		
		c.anchor = GridBagConstraints.WEST;
		c.gridx=1;
		c.gridy=15;
		add(emptyLabel,c);
		emptyLabel.setVisible(true);
		c.gridx=1;
		c.gridy=16;
		add(nullstill,c);
		c.anchor = GridBagConstraints.EAST;
		c.gridx=1;
		c.gridy=16;
		add(Neste,c);
		
		
		

	}
	private void createComponents() {
		//Fikser alle komponenter som skal brukes
		emptyLabel = new JLabel(" ");
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
		
		
		speakSkandinaviskLabel = new JLabel("Snakker skandinavisk: ");
		understandSkandinaviskLabel = new JLabel("Forstår skandinavisk: ");
		speakSkadinvaiskJaToggel = new JToggleButton("Ja");
		speakSkadinvaiskNeiToggel = new JToggleButton("Nei");
		understadnSkandinaviskJaToggel = new JToggleButton("Ja");
		understadnSkandinaviskNeiToggel = new JToggleButton("Nei");
		speakSkandinavisk = new ButtonGroup();
		understandSkandinavisk = new ButtonGroup();
		speakSkandinavisk.add(speakSkadinvaiskJaToggel);
		speakSkandinavisk.add(speakSkadinvaiskNeiToggel);
		understandSkandinavisk.add(understadnSkandinaviskJaToggel);
		understandSkandinavisk.add(understadnSkandinaviskNeiToggel);
		understandTiltakPropertyComponent = new JTextField(5);
		speakTiltakPropertyComponent = new JTextField(5);
		understandTiltakLabel = new JLabel("Ved nei, tiltak; ");//Få med Disse i MVC!!!!!!!!!!!!!!
		speakTiltakLabel = new JLabel("Ved nei, tiltak: ");//Denne også
		
		
		Neste = new JButton("Neste");
		nullstill = new JButton("Nullstill");

	}
	private void addactionListeners() {
		//Legger til ActionListener på LaguageChoise dette slik at det skal gå å bytte språk, og på knappen.
		languageChoise.addActionListener(this);
		Neste.addActionListener(this);
		nullstill.addActionListener(this);
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
		speakSkadinvaiskJaToggel.addActionListener(this);
		speakSkadinvaiskNeiToggel.addActionListener(this);
		understadnSkandinaviskJaToggel.addActionListener(this);
		understadnSkandinaviskNeiToggel.addActionListener(this);
		speakTiltakPropertyComponent.addActionListener(this);
		understandTiltakPropertyComponent.addActionListener(this);
	}
	
	public void speak() {
		if(speakSkadinvaiskJaToggel.isSelected()) {
			speakingSkandinavisk=true;
		} else {
			speakingSkandinavisk = false;
		}
	}
	
	public void understand() {
		if (understadnSkandinaviskJaToggel.isSelected()) {
			understandingSkandinavisk=true;
		} else {
			understandingSkandinavisk=false;
		}
	}
	
	public void setModel(Personalia model){
		this.model = model;
		model.addPropertyChangeListener(this);
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
	public void actionPerformed(ActionEvent action) {
		if(model == null) {
			return;
		}

		try {
			if(action.getSource() == Neste) {
				System.out.println("Du trykket på knappen");
				model.setName(namePropertyComponent.getText());
				model.setDateOfBirth(dateOfBirthpropertyComponent.getText());
				model.setIdCardNr(idCardPropertyComponent.getText());
				model.setIdexpireDate(idExpiresPropertyComponent.getText());
				model.setAdresse(adressPropertyComponent.getText());
				model.setPostalNr(postNrPropertyComponent.getText());
				model.setPostalPlace(postPlacePropertyComponent.getText());
				model.setPhoneNr(phonePropertyComponent.getText());
				model.setEmployeer(employeePropertyComponent.getText());
				model.setEmployeerPhone(employeePhonePropertyComponent.getText());
				model.setNextToKind(nextToKindPropertyComponent.getText());
				model.setNextToKindPhone(nextToKindPhonePropertyComponent.getText());
				model.setUnderstandScandinavian(understandingSkandinavisk);
				model.setSpeakScandinavian(speakingSkandinavisk);
				model.setTiltakSpeak(speakTiltakPropertyComponent.getText());
				model.setTiltakUnderstand(understandTiltakPropertyComponent.getText());
				System.out.println("You just updated a bunch of shit");
			} else if (action.getSource() == nullstill) {
				model.setName(null);
				model.setDateOfBirth(null);
				model.setIdCardNr(null);
				model.setIdexpireDate(null);
				model.setAdresse(null);
				model.setPostalNr(null);
				model.setPostalPlace(null);
				model.setPhoneNr(null);
				model.setEmployeer(null);
				model.setEmployeerPhone(null);
				model.setNextToKind(null);
				model.setNextToKindPhone(null);
				model.setSpeakScandinavian(speakSkadinvaiskJaToggel.isSelected());
				model.setUnderstandScandinavian(understadnSkandinaviskJaToggel.isSelected());
				model.setTiltakSpeak(null);
				model.setTiltakUnderstand(null);
				System.out.println("You just nulled a bunch of shit");
			}else if(action.getSource() == languageChoise) {
				System.out.println("Du endret språk til: " + (Language)languageChoise.getSelectedItem() + " index: " + languageChoise.getSelectedIndex());
			} else if (action.getSource() == namePropertyComponent) {
				model.setName(namePropertyComponent.getText());
			} else if(action.getSource() == dateOfBirthpropertyComponent) {
				model.setDateOfBirth(dateOfBirthpropertyComponent.getText());
			} else if(action.getSource() == idCardPropertyComponent) {
				model.setIdCardNr(idCardPropertyComponent.getText());
			} else if(action.getSource() == idExpiresPropertyComponent) {
				model.setIdexpireDate(idExpiresPropertyComponent.getText()); 
			} else if(action.getSource() == adressPropertyComponent) {
				model.setAdresse(adressPropertyComponent.getText());
			} else if(action.getSource() == postNrPropertyComponent) {
				model.setPostalNr(postNrPropertyComponent.getText());
			} else if(action.getSource() == postalPlaceLabel) {
				model.setPostalPlace(postPlacePropertyComponent.getText());
			} else if(action.getSource()==phonePropertyComponent) {
				model.setPhoneNr(phonePropertyComponent.getText());
			} else if(action.getSource()==employeePropertyComponent) {
				model.setEmployeer(employeePropertyComponent.getText());
			} else if(action.getSource()==employeePhonePropertyComponent) {
				model.setEmployeerPhone(employeePhonePropertyComponent.getText());
			} else if(action.getSource()==nextToKindPropertyComponent) {
				model.setNextToKind(nextToKindPropertyComponent.getText());
			} else if(action.getSource()==nextToKindPhonePropertyComponent) {
				model.setNextToKindPhone(nextToKindPhonePropertyComponent.getText());
			} else if(action.getSource() == understadnSkandinaviskJaToggel) {
				model.setUnderstandScandinavian(understandingSkandinavisk);
				System.out.println("Endret understand --> JA"); 
			} else if(action.getSource() == understadnSkandinaviskNeiToggel) {
				model.setUnderstandScandinavian(understandingSkandinavisk);
				System.out.println("Endret understand-->NEI");
			} else if(action.getSource() == speakSkadinvaiskJaToggel) {
				model.setSpeakScandinavian(speakingSkandinavisk);
				System.out.println("Endret speak-->JA");
			} else if(action.getSource() == speakSkadinvaiskNeiToggel) {
				model.setSpeakScandinavian(speakingSkandinavisk);
				System.out.println("speak-->NEI");
			} else if(action.getSource() == speakTiltakPropertyComponent) {
				model.setTiltakSpeak(speakTiltakPropertyComponent.getText());
				System.out.println("Endret tiltak speak");
			} else if(action.getSource() == understandTiltakPropertyComponent) {
				model.setTiltakUnderstand(understandTiltakPropertyComponent.getText());
				System.out.println("Endret tiltak understand");
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
		} //else if(evt.getPropertyName() == Personalia.SPEAKSVANDINAVIAN_PROPERTY) {
			//speakSkadinvaiskJaToggel.isSelected();
		//} else if(evt.getPropertyName() == Personalia.UNDERSTANDSKANDINAVIAN_PROPERTY) {
			//understadnSkandinaviskJaToggel.isSelected(); } 
		  else if(evt.getPropertyName() == Personalia.TILTAKSPEAK_PROPERTY) {
			speakTiltakPropertyComponent.setText(model.getTiltakSpeak());
			System.out.println("Endret speak tiltak");
		} else if(evt.getPropertyName() == Personalia.TILTAKUNDERSTAND_PROPERTY) {
			understandTiltakPropertyComponent.setText(model.getTiltakUnderstand());
			System.out.println("Endret understand tiltak");
		}
	}
}
