package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RegistreringPanel extends JPanel implements ActionListener, ChangeListener, PropertyChangeListener {
	
	protected JLabel nameLabel,dateOfBirthLabel,idCardLabel,idCardExpiresLabel,adressLabel,postalNrLabel,postalPlaceLabel,telefoneNrLabel,EmployeerLabel;
	protected JLabel EmployerPhoneLabel,nextToKindNameLabel,nextToKindPhoneLabel;
	protected JTextField nameField,dateOfBirthField,idCardField,idCardExpireDateField,adressField,postalNrField,postalPlaceField,telefonNrField,EmployerField;
	protected JTextField EmployerPhoneField,nextToKindNameField,nextToKindPhoneField;
	JButton Lagre;
	int topp=10, side=10;
	
	public RegistreringPanel() {
		
		nameLabel = new JLabel("Navn: ");
		nameField = new JTextField(40);
		dateOfBirthLabel = new JLabel("Fødselsdato: ");
		dateOfBirthField = new JTextField(10);
		idCardLabel = new JLabel("ID-Kortnummer:");
		idCardField = new JTextField(10);
		idCardExpiresLabel = new JLabel("Utløpsdato ID-kort:");
		idCardExpireDateField = new JTextField(10);
		adressLabel = new JLabel("Adresse:");
		adressField = new JTextField(20);
		postalNrLabel = new JLabel("Postnr");
		postalNrField = new JTextField(8);
		postalPlaceLabel = new JLabel("Poststed:");
		postalPlaceField = new JTextField(20);
		telefoneNrLabel = new JLabel("Telefon/Mobil:");
		telefonNrField = new JTextField(18);
		EmployeerLabel = new JLabel("Arbeidsgiver");
		EmployerField = new JTextField(40);
		EmployerPhoneLabel = new JLabel("Arbeidsgivers telefon");
		EmployerPhoneField = new JTextField(18);
		nextToKindNameLabel = new JLabel("Nærmeste pårørende:");
		nextToKindNameField = new JTextField(40);
		nextToKindPhoneLabel = new JLabel("Telefon/Mobil til nærmeste pårørende");
		nextToKindPhoneField = new JTextField(18);
		Lagre = new JButton("Lagre");
		
		
		GridBagConstraints c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		c.anchor = GridBagConstraints.NORTHWEST;
		c.gridx=0;
		c.gridy=0;
		add(nameLabel,c);
		c.gridx=1;
		c.gridy=0;
		add(nameField,c);
		c.gridx=0;
		c.gridy=1;
		add(dateOfBirthLabel,c);
		c.gridx=1;
		c.gridy=1;
		add(dateOfBirthField,c);
		
		
		
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
