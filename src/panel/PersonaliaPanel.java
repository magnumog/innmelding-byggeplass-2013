package panel;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

import database.DBInnsertion;
import modell.Personalia;



public class PersonaliaPanel extends JPanel implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private static int sprak = 0;
	private static String[][] labelTekst = {{"Fornavn: ", "Fødselsdato: ", "ID-Kortnummer: ", "Utløpsdato ID-Kort: ", "Adresse: ", "Postnr: ", "Poststed: ", "Telefon/mobil: ", "Arbeidsgiver: ", "Arbeidsgivers telefonnr: ", "Nærmeste pårørende: ", "Nærmeste pårørende telefon: ", "Snakker skandinavisk: ", "Forstår skandinavisk: ", "Ja", "Nei", "Ved nei, tiltak: ", "Etternavn: ", "Nasjonalitet: "},
		{"Firstname: ", "Date of birth: ", "ID card number: ", "Expiry date ID card", "Adress: ", "Postcode: ", "Postal town: ", "Telephone/mobile: ", "Employer: ", "Employer phonenr: ", "Next of kin: ", "Next of kin phonenr: ", "Speaks scandinavian: ", "Understands scandinavian: ", "Yes", "No", "If no, action: ", "Lastname: ", "Nationality: "},
		{"Imię: ", "Data urodzenia: ", "Nr dowodu tozsamosci: ", "Data waznosci dowodu tozsamosci: ", "Adres: ", "Kod poczto-wy: ", "Miejscowosc: ", "Nr tel. stacjonarnego/ komórkowego: ", "Pracodawca: ", "Nr tel: ", "Najbliższy krewny: ", "Nr tel. stacjonarnego/komórkowego: ", "Mówi językiem skandynawskim: ", "Rozumie język skandynawski: ", "Tak", "Nie", "Jeśli nie, zaleca się: ", "Nazwisko: ", "Narodowość: "}};
	//GUI til personalia
	private static JLabel fornavnLabel,etternavnlabel,dateOfBirthLabel,idCardLabel,idCardExpiresDateLabel,adressLabel,postalNrLabel,postalPlaceLabel,telefoneNrLabel,employeerLabel;
	private static JLabel employerPhoneLabel,nextToKindNameLabel,nextToKindPhoneLabel,nasjonalityLabel;
	protected JTextField fornavnPropertyComponent, etternavnPropertyComponent,dateOfBirthpropertyComponent,idCardPropertyComponent,idExpiresPropertyComponent,adressPropertyComponent,postNrPropertyComponent,postPlacePropertyComponent,phonePropertyComponent,employeePropertyComponent;
	protected JTextField employeePhonePropertyComponent,nextToKindPropertyComponent,nextToKindPhonePropertyComponent, nasjonalitypropertyComponent;

	//GUI språk
	private static JLabel speakSkandinaviskLabel, understandSkandinaviskLabel;
	private static JRadioButton speakSkadinvaiskJaRadio,speakSkadinvaiskNeiRadio,understadnSkandinaviskJaRadio,understadnSkandinaviskNeiRadio;
	protected ButtonGroup speakSkandinavisk,understandSkandinavisk;
	private static JTextField speakTiltakPropertyComponent,understandTiltakPropertyComponent;
	private static JLabel speakTiltakLabel,understandTiltakLabel;

	boolean speakingSkandinavisk, understandingSkandinavisk;


	//GUI knapper
	public static JButton Neste,nullstill;

	Personalia model = null;

	//	DBConnection conn = new DBConnection();

	public PersonaliaPanel() {
		createComponents();
		addactionListeners();
		layGUI();
		setNameOnComponenents();
		speakTiltakPropertyComponent.setEditable(false);
		understandTiltakPropertyComponent.setEditable(false);

	}

	private void setNameOnComponenents() {
		// Setter navn på componentene slik at de kan brukes i tester
		fornavnPropertyComponent.setName("NamePropertyComponent");
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

		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 1;
		add(fornavnLabel,c);
		c.gridx=2;
		add(etternavnlabel,c);
		c.gridx = 0;
		c.gridy = 2;
		add(dateOfBirthLabel,c);
		c.gridx = 2;
		add(nasjonalityLabel,c);
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
		c.gridx = 1;
		c.insets = new Insets(2, 0, 2, 2);
		add(postalPlaceLabel,c);
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(2,2,2,2);
		add(telefoneNrLabel,c);
		c.gridx = 0;
		c.gridy = 9;
		add(employeerLabel,c);
		c.insets = new Insets(2,2,2,2);
		c.gridx = 2;
		c.gridy = 9;
		add(employerPhoneLabel,c);
		c.gridx = 0;
		c.gridy = 11;
		add(nextToKindNameLabel,c);
		//		c.anchor = GridBagConstraints.WEST;
		c.gridx = 2;
		c.gridy = 11;
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
		add(fornavnPropertyComponent,c);
		c.gridx = 3;
		add(etternavnPropertyComponent,c);
		c.gridx = 1;
		c.gridy = 2;
		add(dateOfBirthpropertyComponent,c);
		c.gridx = 3;
		add(nasjonalitypropertyComponent,c);
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
		c.gridx = 2;
		c.gridy = 6;
		add(postPlacePropertyComponent,c);
		c.gridx = 1;
		c.gridy = 8;
		add(phonePropertyComponent,c);
		c.gridx = 1;
		c.gridy = 9;
		add(employeePropertyComponent,c);
		c.insets = new Insets(2,2,2,2);
		c.gridx = 3;
		c.gridy = 9;
		add(employeePhonePropertyComponent,c);
		c.insets = new Insets(2,2,2,2);
		c.gridx = 1;
		c.gridy = 11;
		add(nextToKindPropertyComponent,c);
		c.gridx = 3;
		c.gridy = 11;
		add(nextToKindPhonePropertyComponent,c);
		c.gridx=1;
		c.gridy=13;
		add(speakSkadinvaiskJaRadio,c);
		c.insets = new Insets(1, 60, 1, 1);
		//		c.anchor=GridBagConstraints.EAST;
		c.gridx=1;
		c.gridy=13;
		add(speakSkadinvaiskNeiRadio,c);
		c.anchor=GridBagConstraints.WEST;
		c.insets = new Insets(2, 2, 2, 2);
		c.gridx=1;
		c.gridy=14;
		add(understadnSkandinaviskJaRadio,c);
		c.insets = new Insets(1, 60, 1, 1);
		//		c.anchor=GridBagConstraints.EAST;
		c.gridx=1;
		c.gridy=14;
		add(understadnSkandinaviskNeiRadio,c);
		c.anchor = GridBagConstraints.WEST;
		c.insets = new Insets(2, 2, 2, 2);
		c.gridwidth=2;
		c.gridx=2;
		c.gridy=13;
		add(speakTiltakLabel,c);
		c.gridx=2;
		c.gridy=14;
		add(understandTiltakLabel,c);
		c.anchor = GridBagConstraints.EAST;
		c.gridx=2;
		c.gridy=13;
		c.insets = new Insets(1, 85, 1, 1);
		add(speakTiltakPropertyComponent, c);
		c.gridx=2;
		c.gridy=14;
		add(understandTiltakPropertyComponent,c);

		c.anchor = GridBagConstraints.WEST;
		c.gridx=1;
		c.gridy=16;
		add(nullstill,c);
		nullstill.setVisible(false);
		c.anchor = GridBagConstraints.EAST;
		c.gridx=1;
		c.gridy=16;
		add(Neste,c);
		Neste.setVisible(false);



	}
	private void createComponents() {
		//Fikser alle komponenter som skal brukes
		fornavnLabel = new JLabel(labelTekst[sprak][0]);
		fornavnPropertyComponent = new JTextField(15);
		etternavnlabel = new JLabel(labelTekst[sprak][17]);
		etternavnPropertyComponent = new JTextField(10);
		dateOfBirthLabel = new JLabel(labelTekst[sprak][1]);
		dateOfBirthpropertyComponent = new JTextField(10);
		idCardLabel = new JLabel(labelTekst[sprak][2]);
		idCardPropertyComponent = new JTextField(10);
		idCardExpiresDateLabel = new JLabel(labelTekst[sprak][3]);
		idExpiresPropertyComponent = new JTextField(10);
		adressLabel = new JLabel(labelTekst[sprak][4]);
		adressPropertyComponent = new JTextField(15);
		postalNrLabel = new JLabel(labelTekst[sprak][5]);
		postNrPropertyComponent = new JTextField(5);
		postalPlaceLabel = new JLabel(labelTekst[sprak][6]);
		postPlacePropertyComponent = new JTextField(15);
		telefoneNrLabel = new JLabel(labelTekst[sprak][7]);
		phonePropertyComponent = new JTextField(10);
		employeerLabel = new JLabel(labelTekst[sprak][8]);
		employeePropertyComponent = new JTextField(15);
		employerPhoneLabel = new JLabel(labelTekst[sprak][9]);
		employeePhonePropertyComponent = new JTextField(10);
		nextToKindNameLabel = new JLabel(labelTekst[sprak][10]);
		nextToKindPropertyComponent = new JTextField(15);
		nextToKindPhoneLabel = new JLabel(labelTekst[sprak][11]);
		nextToKindPhonePropertyComponent = new JTextField(10);
		nasjonalityLabel = new JLabel(labelTekst[sprak][18]);
		nasjonalitypropertyComponent = new JTextField(10);

		speakSkandinaviskLabel = new JLabel(labelTekst[sprak][12]);
		understandSkandinaviskLabel = new JLabel(labelTekst[sprak][13]);
		speakSkadinvaiskJaRadio = new JRadioButton(labelTekst[sprak][14]);
		speakSkadinvaiskNeiRadio = new JRadioButton(labelTekst[sprak][15]);
		understadnSkandinaviskJaRadio = new JRadioButton(labelTekst[sprak][14]);
		understadnSkandinaviskNeiRadio = new JRadioButton(labelTekst[sprak][15]);
		speakSkandinavisk = new ButtonGroup();
		understandSkandinavisk = new ButtonGroup();
		speakSkandinavisk.add(speakSkadinvaiskJaRadio);
		speakSkandinavisk.add(speakSkadinvaiskNeiRadio);
		understandSkandinavisk.add(understadnSkandinaviskJaRadio);
		understandSkandinavisk.add(understadnSkandinaviskNeiRadio);
		understandTiltakPropertyComponent = new JTextField(19);
		speakTiltakPropertyComponent = new JTextField(19);
		understandTiltakLabel = new JLabel(labelTekst[sprak][16]);
		speakTiltakLabel = new JLabel(labelTekst[sprak][16]);


		Neste = new JButton("Neste");
		nullstill = new JButton("Nullstill");

	}
	private void addactionListeners() {
		//Legger til ActionListener på LaguageChoise dette slik at det skal gå å bytte språk, og på knappen.
		Neste.addActionListener(this);
		nullstill.addActionListener(this);
		fornavnPropertyComponent.addActionListener(this);
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
		speakSkadinvaiskJaRadio.addActionListener(this);
		speakSkadinvaiskNeiRadio.addActionListener(this);
		understadnSkandinaviskJaRadio.addActionListener(this);
		understadnSkandinaviskNeiRadio.addActionListener(this);
		speakTiltakPropertyComponent.addActionListener(this);
		understandTiltakPropertyComponent.addActionListener(this);
		etternavnPropertyComponent.addActionListener(this);
		nasjonalitypropertyComponent.addActionListener(this);
	}

	public void setModel(Personalia model){
		this.model = model;
		model.addPropertyChangeListener(this);
		fornavnPropertyComponent.setText(model.getName());
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
		understadnSkandinaviskJaRadio.setSelected(model.isUnderstandScandinavian());
		//		understadnSkandinaviskNeiRadio.setSelected(!model.isUnderstandScandinavian());
		understandTiltakPropertyComponent.setText(model.getTiltakUnderstand());
		speakSkadinvaiskJaRadio.setSelected(model.isSpeakScandinavian());
		//		speakSkadinvaiskNeiRadio.setSelected(!model.isSpeakScandinavian());
		speakTiltakPropertyComponent.setText(model.getTiltakSpeak());
		etternavnPropertyComponent.setText(model.getEtternavn());
		nasjonalitypropertyComponent.setText(model.getNasjonalitet());
	}
	public Personalia getModel() {
		return model;
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		if(model == null) {
			return;
		}
		if(action.getSource() == Neste) {
			//			System.out.println("Du trykket på knappen");
			model.setName(fornavnPropertyComponent.getText());
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
			model.setUnderstandScandinavian(understadnSkandinaviskJaRadio.isSelected());
			model.setSpeakScandinavian(speakSkadinvaiskJaRadio.isSelected());
			model.setTiltakSpeak(speakTiltakPropertyComponent.getText());
			model.setTiltakUnderstand(understandTiltakPropertyComponent.getText());
			model.setEtternavn(etternavnPropertyComponent.getText());
			model.setNasjonalitet(nasjonalitypropertyComponent.getText());
			try {
				DBInnsertion.getCount();
				DBInnsertion.createPersonalia(model.getName(), model.getEtternavn(), model.getDateOfBirth(), model.getIdCardNr(), model.getIdexpireDate(), model.getAdresse(), model.getPostalNr(), model.getPostalPlace(), model.getPhoneNr(), model.getEmployeer(), model.getEmployeerPhone(), model.getNextToKind(), model.getNextToKindPhone(), model.getNasjonalitet());
				DBInnsertion.createSprak(model.isSpeakScandinavian(), model.isUnderstandScandinavian(), model.getTiltakSpeak(), model.getTiltakUnderstand());
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Du må skrive inn et tall i ID-kortnummer feltet");
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Det skjedde noe feil når dataene skulle overføres til databasen");
			}

			//			System.out.println("You just updated a bunch of shit");
			//			System.out.println("NAVN:" + model.getName() + " FODT: " + model.getDateOfBirth() + " ID:" + model.getIdCardNr() + " IDUT:" + model.getIdexpireDate() + " ADRESSE:" + model.getAdresse());
			//			System.out.println("POSTNR:" + model.getPostalNr() + " POSTSTED:" + model.getPostalPlace() + " TELE:" + model.getPhoneNr() + " ARBEIDS:" +model.getEmployeer() + " ARBEIDTELE:" + model.getEmployeerPhone());
			//			System.out.println("NERMESTE:" +model.getNextToKind() + " NERMESTETELE:" +model.getNextToKindPhone() + " SNAKKER:" + model.isSpeakScandinavian() + " FORSTAR:" +model.isUnderstandScandinavian() + " SNAKKETILTAK:" +model.getTiltakSpeak() + " FORSTATILTAK:" + model.getTiltakUnderstand());
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
			model.setSpeakScandinavian(speakSkadinvaiskJaRadio.isSelected());
			model.setUnderstandScandinavian(understadnSkandinaviskJaRadio.isSelected());
			model.setTiltakSpeak(null);
			model.setTiltakUnderstand(null);
			//			System.out.println("You just nulled a bunch of shit");
		} else if (action.getSource() == fornavnPropertyComponent) {
			model.setName(fornavnPropertyComponent.getText());
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
		} else if(action.getSource() == nasjonalitypropertyComponent) {
			model.setNasjonalitet(nasjonalitypropertyComponent.getText());
		} else if(action.getSource() == etternavnPropertyComponent) {
			model.setEtternavn(etternavnPropertyComponent.getText());
		} else if(action.getSource() == understadnSkandinaviskJaRadio || action.getSource()==understadnSkandinaviskNeiRadio) {
			if(action.getSource()==understadnSkandinaviskJaRadio) {
				model.setUnderstandScandinavian(true);
				understandTiltakPropertyComponent.setEditable(false);
				//				System.out.println("Endret understand -- true");
			} else if(action.getSource() == understadnSkandinaviskNeiRadio) {
				model.setUnderstandScandinavian(false);
				understandTiltakPropertyComponent.setEditable(true);
				understandTiltakLabel.setVisible(true);
				//				System.out.println("Endret understand -- false");
			}
			System.out.println("Endret understand"); 
		} else if(action.getSource() == speakSkadinvaiskJaRadio || action.getSource() == speakSkadinvaiskNeiRadio) {
			if(action.getSource() == speakSkadinvaiskJaRadio) {
				model.setSpeakScandinavian(true);
				speakTiltakPropertyComponent.setEditable(false);
				understadnSkandinaviskJaRadio.setSelected(true);
				understandTiltakPropertyComponent.setEditable(false);
				//				System.out.println("Endret Speak -- true");
			} else {
				model.setSpeakScandinavian(false);
				speakTiltakPropertyComponent.setEditable(true);
				//				System.out.println("Endret speak -- false");
			}
			//			System.out.println("Endret speak");
		} else if(action.getSource() == speakTiltakPropertyComponent) {
			model.setTiltakSpeak(speakTiltakPropertyComponent.getText());
			//			System.out.println("Endret tiltak speak");
		} else if(action.getSource() == understandTiltakPropertyComponent) {
			model.setTiltakUnderstand(understandTiltakPropertyComponent.getText());
			//			System.out.println("Endret tiltak understand");
		}

	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//		System.out.println("hendelse");
		if(evt.getPropertyName() == Personalia.NAME_PROPERTY) {
			fornavnPropertyComponent.setText(model.getName());
			//			System.out.println("Navn endret");
		} else if (evt.getPropertyName() == Personalia.DATE_PROPERTY) {
			dateOfBirthpropertyComponent.setText(model.getDateOfBirth());
			//			System.out.println("Endret dateOfBirth");
		} else if (evt.getPropertyName() == Personalia.ID_CARDNUMBER) {
			idCardPropertyComponent.setText(model.getIdCardNr());
			//			System.out.println("Endret id_cardNumber"); 
		} else if (evt.getPropertyName() == Personalia.ID_EXPIRATION) {
			idExpiresPropertyComponent.setText(model.getIdexpireDate());
			//			System.out.println("Endret id_expirationdate"); 
		} else if (evt.getPropertyName() == Personalia.ADRESS_PROPERTY) {
			adressPropertyComponent.setText(model.getAdresse());
			//			System.out.println("Endret adresse"); 
		} else if (evt.getPropertyName() == Personalia.POSTALNR_PROPERTY) {
			postNrPropertyComponent.setText(model.getPostalNr());
			//			System.out.println("Endret postnr"); 
		} else if (evt.getPropertyName() == Personalia.POSTALPLACE_PROPERTY) {
			postPlacePropertyComponent.setText(model.getPostalPlace());
			//			System.out.println("Endret poststed"); 
		} else if (evt.getPropertyName() == Personalia.PHONE_PROPERTY) {
			phonePropertyComponent.setText(model.getPhoneNr());
			//			System.out.println("Endret TelefonNr"); 
		} else if (evt.getPropertyName() == Personalia.EMPLOYER_PROPERTY) {
			employeePropertyComponent.setText(model.getEmployeer());
			//			System.out.println("Endret employee"); 
		} else if (evt.getPropertyName() == Personalia.EMPLOYERPHONE_PROPERTY) {
			employeePhonePropertyComponent.setText(model.getEmployeerPhone());
			//			System.out.println("Endret employeePhone"); 
		} else if (evt.getPropertyName() == Personalia.NEXTTO_PROPERTY) {
			nextToKindPropertyComponent.setText(model.getNextToKind());
			//			System.out.println("Endret nextToKind"); 
		} else if (evt.getPropertyName() == Personalia.NEXTTOPHONE_PROPERTY) {
			nextToKindPhonePropertyComponent.setText(model.getNextToKindPhone());
			//			System.out.println("Endret nextToPhone"); 
		} else if(evt.getPropertyName() == Personalia.SPEAKSVANDINAVIAN_PROPERTY) {
			speakSkadinvaiskJaRadio.setSelected(model.isSpeakScandinavian());
			//			speakSkadinvaiskNeiRadio.setSelected(!model.isSpeakScandinavian());
		} else if(evt.getPropertyName() == Personalia.UNDERSTANDSKANDINAVIAN_PROPERTY) {
			understadnSkandinaviskJaRadio.setSelected(model.isUnderstandScandinavian());
			//			understadnSkandinaviskNeiRadio.setSelected(!model.isUnderstandScandinavian());
		} else if(evt.getPropertyName() == Personalia.TILTAKSPEAK_PROPERTY) {
			speakTiltakPropertyComponent.setText(model.getTiltakSpeak());
			//			System.out.println("Endret speak tiltak");
		} else if(evt.getPropertyName() == Personalia.TILTAKUNDERSTAND_PROPERTY) {
			understandTiltakPropertyComponent.setText(model.getTiltakUnderstand());
			//			System.out.println("Endret understand tiltak");
		} else if(evt.getPropertyName() == Personalia.LASTNAME_PROPERTY) {
			etternavnPropertyComponent.setText(model.getEtternavn());
		} else if(evt.getPropertyName() == Personalia.NASJONALITY_PROPERTY) {
			nasjonalitypropertyComponent.setText(model.getNasjonalitet());
		}
	}

	public static void changeLanguage(int i) {
		sprak = i;
		fornavnLabel.setText(labelTekst[i][0]);
		dateOfBirthLabel.setText(labelTekst[i][1]);
		idCardLabel.setText(labelTekst[i][2]);
		idCardExpiresDateLabel.setText(labelTekst[i][3]);
		adressLabel.setText(labelTekst[i][4]);
		postalNrLabel.setText(labelTekst[i][5]);
		postalPlaceLabel.setText(labelTekst[i][6]);
		telefoneNrLabel.setText(labelTekst[i][7]);
		employeerLabel.setText(labelTekst[i][8]);
		employerPhoneLabel.setText(labelTekst[i][9]);
		nextToKindNameLabel.setText(labelTekst[i][10]);
		nextToKindPhoneLabel.setText(labelTekst[i][11]);
		speakSkandinaviskLabel.setText(labelTekst[i][12]);
		understandSkandinaviskLabel.setText(labelTekst[i][13]);
		speakSkadinvaiskJaRadio.setText(labelTekst[i][14]);
		speakSkadinvaiskNeiRadio.setText(labelTekst[i][15]);
		understadnSkandinaviskJaRadio.setText(labelTekst[i][14]);
		understadnSkandinaviskNeiRadio.setText(labelTekst[i][15]);
		speakTiltakLabel.setText(labelTekst[i][16]);
		understandTiltakLabel.setText(labelTekst[i][16]);
		etternavnlabel.setText(labelTekst[i][17]);
		nasjonalityLabel.setText(labelTekst[i][18]);
	}
}