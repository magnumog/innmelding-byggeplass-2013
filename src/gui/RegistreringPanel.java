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
	
	protected JLabel nameLabel;
	protected JTextField nameField;
	protected JLabel dateOfBirthLabel;
	protected JTextField dateOfBirthField;
	protected JLabel idCardLabel;
	protected JTextField idCardField;
	protected JLabel idCardExpiresLabel;
	protected JTextField idCardExpireDateField;
	protected JLabel adressLabel;
	protected JTextField adressField;
	protected JLabel postalNrLabel;
	protected JTextField postalNrField;
	protected JLabel postalPlaceLabel;
	protected JTextField postalPlaceField;
	protected JLabel telefoneNrLabel;
	protected JTextField telefonNrField;
	protected JLabel EmployeerLabel;
	protected JTextField EmployerField;
	protected JLabel EmployerPhoneLabel;
	protected JTextField EmployerPhoneField;
	protected JLabel nextToKindNameLabel;
	protected JTextField nextToKindNameField;
	protected JLabel nextToKindPhoneLabel;
	protected JTextField nextToKindPhoneField;
	int topp=10, side=10;
	
	public RegistreringPanel() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(topp, side, topp, side));
		
		nameLabel = new JLabel("Navn:");
		nameField = new JTextField(50);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		add(nameLabel,c);
		c.gridx=1;
		c.gridy=0;
		add(nameField,c);
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
