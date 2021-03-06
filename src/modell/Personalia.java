package modell;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/


import java.beans.*;

public class Personalia {
	private String fornavn;
	private String dateOfBirth;
	private String IdCardNr;
	private String IdexpireDate;
	private String adresse;
	private String postalNr;
	private String postalPlace;
	private String phoneNr;
	private String employeer;
	private String employeerPhone;
	private String nextToKind;
	private String NextToKindPhone;
	private String etternavn;
	private String nasjonalitet;
	private boolean SpeakScandinavian;
	private boolean understandScandinavian;
	private String tiltakSpeak;
	private String tiltakUnderstand;
	

	public final static String NAME_PROPERTY = "fornavn";
	public final static String LASTNAME_PROPERTY = "etternavn";
	public final static String DATE_PROPERTY = "dateOfBirth";
	public final static String ID_CARDNUMBER = "IdCardNr";
	public final static String ID_EXPIRATION = "IdexpireDate";
	public final static String ADRESS_PROPERTY = "adresse";
	public final static String POSTALNR_PROPERTY = "postalNr";
	public final static String POSTALPLACE_PROPERTY = "postalPlace";
	public final static String PHONE_PROPERTY = "phoneNr";
	public final static String EMPLOYER_PROPERTY = "employeer";
	public final static String EMPLOYERPHONE_PROPERTY = "employeerPhone";
	public final static String NEXTTO_PROPERTY = "nextToKind";
	public final static String NEXTTOPHONE_PROPERTY = "NextToKindPhone";
	public final static String NASJONALITY_PROPERTY = "nasjonalitet";
	public final static String SPEAKSVANDINAVIAN_PROPERTY = "SpeakScandinavian";
	public final static String UNDERSTANDSKANDINAVIAN_PROPERTY = "understandScandinavian";
	public final static String TILTAKSPEAK_PROPERTY = "tiltakSpeak";
	public final static String TILTAKUNDERSTAND_PROPERTY = "tiltakUnderstand";
	
	
	
	
	private PropertyChangeSupport pcs;
	
	public Personalia() {
		pcs = new PropertyChangeSupport(this);
	}

	public String getEtternavn() {
		return etternavn;
	}
	
	public void setEtternavn(String etternavn) {
		String oldEtternavn = this.getEtternavn();
		this.etternavn = etternavn;
		pcs.firePropertyChange(LASTNAME_PROPERTY, oldEtternavn, etternavn);
	}
	
	public String getNasjonalitet() {
		return nasjonalitet;
	}
	
	public void setNasjonalitet(String nasjonalitet) {
		String OldNasjonlaitet = this.getNasjonalitet();
		this.nasjonalitet = nasjonalitet;
		pcs.firePropertyChange(NASJONALITY_PROPERTY, OldNasjonlaitet, nasjonalitet);
	}
	public String getTiltakSpeak() {
		return tiltakSpeak;
	}
	
	public void setTiltakSpeak(String tiltakSpeak) {
		String oldTiltak = this.getTiltakSpeak();
		this.tiltakSpeak = tiltakSpeak;
		pcs.firePropertyChange(TILTAKSPEAK_PROPERTY, oldTiltak, tiltakSpeak);
	}
	
	public String getTiltakUnderstand() {
		return tiltakUnderstand;
	}
	
	public void setTiltakUnderstand(String tiltakUnderstand) {
		String oldTiltak = this.getTiltakUnderstand();
		this.tiltakUnderstand = tiltakUnderstand;
		pcs.firePropertyChange(TILTAKUNDERSTAND_PROPERTY, oldTiltak, tiltakUnderstand);
	}
	public String getName() {
		return fornavn;
	}
	public void setName(String name) {
		String oldName = this.getName();
		this.fornavn = name;
		pcs.firePropertyChange(NAME_PROPERTY, oldName, this.fornavn);
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		String oldDate = this.getDateOfBirth();
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange(DATE_PROPERTY, oldDate, this.dateOfBirth);
	}
	public String getIdCardNr() {
		return IdCardNr;
	}
	public void setIdCardNr(String idCardNr) {
		String oldCardNr = this.getIdCardNr();
		IdCardNr = idCardNr;
		pcs.firePropertyChange(ID_CARDNUMBER, oldCardNr, idCardNr);
	}
	public String getIdexpireDate() {
		return IdexpireDate;
	}
	public void setIdexpireDate(String idexpireDate) {
		String OldExpireDate = this.getIdexpireDate();
		IdexpireDate = idexpireDate;
		pcs.firePropertyChange(ID_EXPIRATION, OldExpireDate, OldExpireDate);
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		String oldAdress = this.getAdresse();
		this.adresse = adresse;
		pcs.firePropertyChange(ADRESS_PROPERTY, oldAdress, adresse);
	}
	public String getPostalNr() {
		return postalNr;
	}
	public void setPostalNr(String postalNr) {
		String oldPostal = this.getPostalNr();
		this.postalNr = postalNr;
		pcs.firePropertyChange(POSTALNR_PROPERTY, oldPostal, postalNr);
	}
	public String getPostalPlace() {
		return postalPlace;
	}
	public void setPostalPlace(String postalPlace) {
		String OldPostalPlace = this.getPostalPlace();
		this.postalPlace = postalPlace;
		pcs.firePropertyChange(POSTALPLACE_PROPERTY, OldPostalPlace, postalPlace);
	}
	public String getPhoneNr() {
		return phoneNr;
	}
	public void setPhoneNr(String phoneNr) {
		String oldPhoneNr = this.getPhoneNr();
		this.phoneNr = phoneNr;
		pcs.firePropertyChange(PHONE_PROPERTY, oldPhoneNr, phoneNr);
	}
	public String getEmployeer() {
		return employeer;
	}
	public void setEmployeer(String employeer) {
		String oldemployeer = this.getEmployeer();
		this.employeer = employeer;
		pcs.firePropertyChange(EMPLOYER_PROPERTY, oldemployeer, employeer);
	}
	public String getEmployeerPhone() {
		return employeerPhone;
	}
	public void setEmployeerPhone(String employeerPhone) {
		String oldemployeerPhone = this.getEmployeerPhone();
		this.employeerPhone = employeerPhone;
		pcs.firePropertyChange(EMPLOYERPHONE_PROPERTY, oldemployeerPhone , employeerPhone);
	}
	public String getNextToKind() {
		return nextToKind;
	}
	public void setNextToKind(String nextToKind) {
		String OldNextTokind = this.getNextToKind();
		this.nextToKind = nextToKind;
		pcs.firePropertyChange(NEXTTO_PROPERTY, OldNextTokind, nextToKind);
	}
	public String getNextToKindPhone() {
		return NextToKindPhone;
	}
	public void setNextToKindPhone(String nextToKindPhone) {
		String oldNextToPhone = this.getNextToKindPhone();
		this.NextToKindPhone = nextToKindPhone;
		pcs.firePropertyChange(NEXTTOPHONE_PROPERTY, oldNextToPhone, nextToKindPhone);
	}
	public boolean isSpeakScandinavian() {
		return SpeakScandinavian;
	}
	public void setSpeakScandinavian(boolean speakScandinavian) {
		boolean oldSpeakScandinavian = this.isSpeakScandinavian();
		this.SpeakScandinavian = speakScandinavian;
		pcs.firePropertyChange(UNDERSTANDSKANDINAVIAN_PROPERTY, oldSpeakScandinavian, speakScandinavian);
		
	}
	
	public boolean isUnderstandScandinavian() {
		return understandScandinavian;
	}
	
	public void setUnderstandScandinavian(boolean understandScandinavian) {
		boolean oldUnderstadnScandinavian = this.isUnderstandScandinavian();
		this.understandScandinavian = understandScandinavian;
		pcs.firePropertyChange(UNDERSTANDSKANDINAVIAN_PROPERTY, oldUnderstadnScandinavian, understandScandinavian);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
}
	
