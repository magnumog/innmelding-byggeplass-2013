package gui;
/*
 * Author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 */


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PersonaliaPanel extends JPanel implements ActionListener, PropertyChangeListener {
	
	private static final long serialVersionUID = 1L;
	protected JLabel nameLabel,dateOfBirthLabel,idCardLabel,idCardExpiresDateLabel,adressLabel,postalNrLabel,postalPlaceLabel,telefoneNrLabel,employeerLabel;
	protected JLabel employerPhoneLabel,nextToKindNameLabel,nextToKindPhoneLabel,selectLanguageLabel, emptyLabel;
	protected JTextField nameField,dateOfBirthField,idCardField,idCardExpireDateField,adressField,postalNrField,postalPlaceField,telefonNrField,employerField;
	protected JTextField employerPhoneField,nextToKindNameField,nextToKindPhoneField;
	protected JComboBox<Language> languageChoise;
	JButton Neste;
	int topp=10, side=10;
	
	//String [][] ord = new String[][]{{"Navn:","Fødlselsdato","ID-kortnummer"},{},{"Name", "Personalnumber","Registration number"},{}};
	//int languageNr = 0;
	
	
	
	public PersonaliaPanel() {
		//Lager en emptylabel for å fikse GUI slik jeg vil ha det
		emptyLabel = new JLabel("Denne skal ikke synes");
		emptyLabel.setVisible(false);
		
		
		//Fikser alle komponenter som skal brukes
		nameLabel = new JLabel("Navn: ");
		nameField = new JTextField(15);
		dateOfBirthLabel = new JLabel("Fødselsdato: ");
		dateOfBirthField = new JTextField(10);
		idCardLabel = new JLabel("Id-kortnummer: ");
		idCardField = new JTextField(10);
		idCardExpiresDateLabel = new JLabel("Utløpsdato ID-kort: ");
		idCardExpireDateField = new JTextField(10);
		adressLabel = new JLabel("Adresse: ");
		adressField = new JTextField(15);
		postalNrLabel = new JLabel("Postnr: ");
		postalNrField = new JTextField(8);
		postalPlaceLabel = new JLabel("Poststed: ");
		postalPlaceField = new JTextField(15);
		telefoneNrLabel = new JLabel("Telefon/Mobil: ");
		telefonNrField = new JTextField(10);
		employeerLabel = new JLabel("Arbeidsgiver: ");
		employerField = new JTextField(15);
		employerPhoneLabel = new JLabel("Arbeidsgivers telefon: ");
		employerPhoneField = new JTextField(15);
		nextToKindNameLabel = new JLabel("Nærmeste pårørende: ");
		nextToKindNameField = new JTextField(15);
		nextToKindPhoneLabel = new JLabel("Telefon/Mobil til nærmeste pårørende: ");
		nextToKindPhoneField = new JTextField(10);
		selectLanguageLabel = new JLabel("Velg Språk/Select Language: ");
		languageChoise = new JComboBox<Language>(Language.values());
		Neste = new JButton("Neste");
		
		//Legger til ActionListener på LaguageChoise dette slik at det skal gå å bytte språk, og på knappen.
		languageChoise.addActionListener(this);
		Neste.addActionListener(this);
		
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		//c.gridheight = 10;
		c.anchor = GridBagConstraints.NORTHEAST;
		c.gridx = 1;
		c.gridy = 0;
		add(selectLanguageLabel,c);
		c.gridx = 2;
		c.gridy = 0;
		add(languageChoise,c);
		
		
		
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
		add(nameField,c);
		c.gridx = 1;
		c.gridy = 2;
		add(dateOfBirthField,c);
		c.gridx = 1;
		c.gridy = 3;
		add(idCardField,c);
		c.gridx = 1;
		c.gridy = 4;
		add(idCardExpireDateField,c);
		c.gridx = 1;
		c.gridy = 5;
		add(adressField,c);
		c.gridx = 1;
		c.gridy = 6;
		add(postalNrField,c);
		c.gridx = 3;
		c.gridy = 6;
		add(postalPlaceField,c);
		c.gridx = 1;
		c.gridy = 8;
		add(telefonNrField,c);
		c.gridx = 1;
		c.gridy = 9;
		add(employerField,c);
		c.gridx = 1;
		c.gridy = 10;
		add(employerPhoneField,c);
		c.gridx = 1;
		c.gridy = 11;
		add(nextToKindNameField,c);
		c.gridx = 1;
		c.gridy = 12;
		add(nextToKindPhoneField,c);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Neste) {
			System.out.println("Du trykket på knappen");
		} else if(e.getSource() == languageChoise) {
			System.out.println("Du endret språk til: " + (Language)languageChoise.getSelectedItem() + " index: " + languageChoise.getSelectedIndex());
			//languageNr = languageChoise.getSelectedIndex();
		} 
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
