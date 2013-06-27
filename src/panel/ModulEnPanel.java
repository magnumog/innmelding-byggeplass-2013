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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import database.DBConnection;

import modell.ModulEn;

public class ModulEnPanel extends JPanel implements ActionListener,PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	protected JRadioButton modulEnJaRadio, modulEnNeiRadio;
	protected JTextField modulEnJaDato,modulEnNeiFrist;
	protected JLabel modulEnInfo;
	
	protected JButton Neste,nullstill;
	
	ModulEn model = null;
	
//	DBConnection conn = new DBConnection();
	
	public ModulEnPanel(){
		modulEnJaRadio = new JRadioButton("Ja, dato for gjennomføring: ");
		modulEnNeiRadio = new JRadioButton("Nei, Dato frist: ");
		modulEnJaDato = new JTextField(5);
		modulEnNeiFrist = new JTextField(5);
		modulEnInfo = new JLabel("Gjennomført obligatorisk sikkerthetopplæring Modul 1:");
		Neste = new JButton("Neste");
		nullstill = new JButton("nullstill");
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(modulEnJaRadio);
		btnGroup.add(modulEnNeiRadio);
		//Legger ut componentene i GUI
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(1,1,1,1);
		c.anchor = GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		add(modulEnInfo,c);
		c.gridx=1;
		add(modulEnJaRadio,c);
		c.gridx=2;
		add(modulEnJaDato,c);
		c.gridx=3;
		add(modulEnNeiRadio,c);
		c.gridx=4;
		add(modulEnNeiFrist,c);
		c.gridy=1;
		c.gridx=1;
		add(Neste);
		c.gridx=2;
		add(nullstill);
		Neste.setVisible(true);
		nullstill.setVisible(false);
		
		modulEnJaDato.addActionListener(this);
		modulEnJaRadio.addActionListener(this);
		modulEnNeiRadio.addActionListener(this);
		modulEnNeiFrist.addActionListener(this);
		Neste.addActionListener(this);
		nullstill.addActionListener(this);
	}
	
	public void setModel(ModulEn model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		modulEnJaRadio.setSelected(model.isModulEnJaSvar());
		modulEnNeiRadio.setSelected((model.isModulEnNeiSvar()));
		modulEnJaDato.setText(model.getModulEnJADato());
		modulEnNeiFrist.setText(model.getModulEnNeiFrist());
	}
	
	public ModulEn getModel() {
		return model;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Hendelse");
		if(evt.getPropertyName() == ModulEn.MODULENJA_PROPERTY) {
			modulEnJaRadio.setSelected(model.isModulEnJaSvar());
		} else if(evt.getPropertyName() == ModulEn.MODULENNEI_PROPERTY) {
			modulEnNeiRadio.setSelected(model.isModulEnNeiSvar());
		} else if(evt.getPropertyName() == ModulEn.MODULENJADATO_PROPERTY) {
			modulEnJaDato.setText(model.getModulEnJADato());
		} else if(evt.getPropertyName() == ModulEn.MODULENNEIFRIST_PROPERTY) {
			modulEnNeiFrist.setText(model.getModulEnNeiFrist());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(model == null) {
			return;
		}
		
		if(e.getSource() == Neste) {
			model.setModulEnJaSvar(modulEnJaRadio.isSelected());
			model.setModulEnNeiSvar(modulEnNeiRadio.isSelected());
			model.setModulEnJADato(modulEnJaDato.getText());
			model.setModulEnNeiFrist(modulEnNeiFrist.getText());
			try {
				if(model.isModulEnJaSvar()) {
					DBConnection.createModulEN(model.isModulEnJaSvar(), model.getModulEnJADato());					
				} else {
					DBConnection.createModulEN(model.isModulEnJaSvar(), model.getModulEnNeiFrist());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("JA:" + model.isModulEnJaSvar() + " NEI:" + model.isModulEnNeiSvar() + " JADATO:" + model.getModulEnJADato() +  " NEIFRIST:" + model.getModulEnNeiFrist());
		} else if(e.getSource()==nullstill) {
			model.setModulEnJaSvar(true);
			model.setModulEnNeiSvar(false);
			model.setModulEnJADato(null);
			model.setModulEnNeiFrist(null);
		} else if(e.getSource() == modulEnJaRadio) {
			model.setModulEnJaSvar(modulEnJaRadio.isSelected());			
		} else if(e.getSource() == modulEnNeiRadio) {
			model.setModulEnNeiSvar(modulEnNeiRadio.isSelected());
		} else if(e.getSource() == modulEnJaDato) {
			model.setModulEnJADato(modulEnJaDato.getText());
		} else if(e.getSource() == modulEnNeiFrist) {
			model.setModulEnNeiFrist(modulEnNeiFrist.getText());
		}
		
	}

}
