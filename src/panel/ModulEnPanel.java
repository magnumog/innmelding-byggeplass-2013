package panel;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/


import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import database.DBInnsertion;

import modell.ModulEn;

public class ModulEnPanel extends JPanel implements ActionListener,PropertyChangeListener, MouseListener {
	private static final long serialVersionUID = 1L;
	private static int sprak = 0;
	public static String[][] labeltekst = {{"Ja, dato for gjennomføring: ", "Nei", "<html>Gjennomført obligatorisk sikkerthetopplæring Modul 1: </html>" ,"http://veidekke.edvantage.net/ETS/index.jsp?context=UserRegistration&view=_UserRegistrationForm&selfRegID=157", "<html><u>Ta modulEn nå</u></html>"},
		{"Yes, date: ", "No", "                           Completed mandatory safety training Module 1: ", "http://veidekke.edvantage.net/ETS/index.jsp?context=UserRegistration&view=_UserRegistrationForm&locale=en_GB_315&changeUserLanguage=true&selfRegID=157"},
		{"Tak, Data: ", "Nie", "<html>Ukończone obowiązkowe szkolenie z zakresu bezpieczeństwa, <br>moduł nr 1: </html>", "http://veidekke.edvantage.net/ETS/index.jsp?context=UserRegistration&view=_UserRegistrationForm&locale=pl_PL_315&changeUserLanguage=true&selfRegID=157"}};
	private static JRadioButton modulEnJaRadio, modulEnNeiRadio;
	protected JTextField modulEnJaDato,modulEnNeiFrist;
	private static JLabel modulEnInfo;
	private JLabel neiTaModulEn;

	protected static JButton Neste,nullstill;

	ModulEn model = null;

	//	DBConnection conn = new DBConnection();

	public ModulEnPanel(){
		modulEnJaRadio = new JRadioButton(labeltekst[sprak][0]);
		modulEnNeiRadio = new JRadioButton(labeltekst[sprak][1]);
		modulEnJaDato = new JTextField(7);
		modulEnNeiFrist = new JTextField(5);
		modulEnInfo = new JLabel(labeltekst[sprak][2]);
		neiTaModulEn = new JLabel(labeltekst[sprak][4]);
		neiTaModulEn.setForeground(Color.BLUE);
		neiTaModulEn.setVisible(false);
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
//		c.ipadx = 80;
		add(modulEnNeiRadio,c);
		c.gridx=4;
		add(modulEnNeiFrist,c);
		modulEnNeiFrist.setVisible(false);
		add(neiTaModulEn,c);
		neiTaModulEn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c.gridy=1;
		c.gridx=1;
		add(Neste);
		c.gridx=2;
		c.gridwidth=300;
		c.gridheight=2;
		add(nullstill);
		Neste.setVisible(false);
		nullstill.setVisible(false);

		modulEnJaDato.addActionListener(this);
		modulEnJaRadio.addActionListener(this);
		modulEnNeiRadio.addActionListener(this);
		modulEnNeiFrist.addActionListener(this);
		neiTaModulEn.addMouseListener(this);
		Neste.addActionListener(this);
		nullstill.addActionListener(this);
		modulEnJaDato.setEditable(false);
		modulEnNeiFrist.setEditable(false);
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
		//		System.out.println("Hendelse");
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
					DBInnsertion.createModulEN(model.isModulEnJaSvar(), model.getModulEnJADato());					
				} else {
					DBInnsertion.createModulEN(model.isModulEnJaSvar(), model.getModulEnNeiFrist());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//			System.out.println("JA:" + model.isModulEnJaSvar() + " NEI:" + model.isModulEnNeiSvar() + " JADATO:" + model.getModulEnJADato() +  " NEIFRIST:" + model.getModulEnNeiFrist());
		} else if(e.getSource()==nullstill) {
			model.setModulEnJaSvar(false);
			model.setModulEnNeiSvar(false);
			model.setModulEnJADato(null);
			model.setModulEnNeiFrist(null);
		} else if(e.getSource() == modulEnJaRadio) {
			model.setModulEnJaSvar(modulEnJaRadio.isSelected());
			modulEnJaDato.setEditable(true);
			modulEnNeiFrist.setEditable(false);
		} else if(e.getSource() == modulEnNeiRadio) {
//			String URL = labeltekst[sprak][3];
//			try {
//				java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			neiTaModulEn.setVisible(true);
			model.setModulEnNeiSvar(modulEnNeiRadio.isSelected());
			modulEnNeiFrist.setEditable(true);
			modulEnJaDato.setEditable(false);
		} else if(e.getSource() == modulEnJaDato) {
			model.setModulEnJADato(modulEnJaDato.getText());
		} else if(e.getSource() == modulEnNeiFrist) {
			model.setModulEnNeiFrist(modulEnNeiFrist.getText());
		}

	}

	public static void changeLanguage(int i) {
		sprak = i;
		modulEnJaRadio.setText(labeltekst[i][0]);
		modulEnNeiRadio.setText(labeltekst[i][1]);
		modulEnInfo.setText(labeltekst[i][2]);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String URL = labeltekst[sprak][3];
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		neiTaModulEn.setForeground(new Color(128,0,128));
	}

}
