package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RegistreringPanel extends JPanel implements ActionListener, PropertyChangeListener {
	
	private static final long serialVersionUID = 1L;
	protected JLabel nameLabel,dateOfBirthLabel,idCardLabel,idCardExpiresDateLabel,adressLabel,postalNrLabel,postalPlaceLabel,telefoneNrLabel,EmployeerLabel;
	protected JLabel EmployerPhoneLabel,nextToKindNameLabel,nextToKindPhoneLabel;
	protected JTextField nameField,dateOfBirthField,idCardField,idCardExpireDateField,adressField,postalNrField,postalPlaceField,telefonNrField,EmployerField;
	protected JTextField EmployerPhoneField,nextToKindNameField,nextToKindPhoneField;
	JButton Neste;
	int topp=10, side=10;
	
	private FlowLayout layout;
	//private Container container;
	
	public RegistreringPanel() {
		//Fikser alle komponenter
		nameLabel = new JLabel("Navn: ");
		nameField = new JTextField(15);
		dateOfBirthLabel = new JLabel("Fødselsdato: ");
		dateOfBirthField = new JTextField(10);
		idCardLabel = new JLabel("ID-Kortnummer:");
		idCardField = new JTextField(10);
		idCardExpiresDateLabel = new JLabel("Utløpsdato ID-kort:");
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
		Neste = new JButton("Neste");
		
		Neste.addActionListener(this);
		
		/*GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.NORTH;
		
		c.gridx = 0;
		c.gridy = 0;
		add(nameLabel,c);
		
		c.gridx = 1;
		c.gridy = 0;
		add(nameField,c);*/
		
		layout = new FlowLayout();
		setLayout(layout);
		//layout.setAlignment(FlowLayout.LEFT);
		add(nameLabel);
		add(nameField);
		add(dateOfBirthLabel);
		add(dateOfBirthField);
		layout = new FlowLayout();
		setLayout(layout);
		add(idCardLabel);
		add(idCardField);
		add(idCardExpiresDateLabel);
		add(idCardExpireDateField);
		layout = new FlowLayout();
		setLayout(layout);
		add(adressLabel);
		add(adressField);
		add(postalNrLabel);
		add(postalNrField);
		add(postalPlaceLabel);
		add(postalPlaceField);
		add(EmployeerLabel);
		add(EmployerField);
		add(EmployerPhoneLabel);
		add(EmployerPhoneField);
		add(nextToKindNameLabel);
		add(nextToKindNameField);
		add(nextToKindPhoneLabel);
		add(nextToKindPhoneField);
		add(Neste);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Neste) {
			System.out.println("Du trykket på knappen");
		}
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
