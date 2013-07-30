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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.DBInnsertion;

public class DoClickPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton neste;
	public static JButton nullstill;
	DateFormat dateFormat = new SimpleDateFormat("dd. MMMM yyyy");
	java.util.Date date = new java.util.Date();

	public DoClickPanel() {
		neste = new JButton("Lagre og Avslutt");
		neste.addActionListener(this);
		nullstill = new JButton();
		nullstill.addActionListener(this);

		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(1,1,1,1);
		c.anchor = GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		add(neste,c);
		System.out.println("Current Date : " + dateFormat.format(date));


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == neste) {
			try {
				PersonaliaPanel.Neste.doClick();
				ModulEnPanel.Neste.doClick();
				SertifikatPanel.neste.doClick();
				KursPanel.Neste.doClick();
				BekreftMedbraktPanel.neste.doClick();
				ModulToPanel.neste.doClick();
				DBInnsertion.creatRegDato(dateFormat.format(date));				
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Noe feil skjedde når dataene skulle overføres til databasen, programmet avsluttes, vennligst kontakt hjelp");
				System.exit(0);
			}
			JOptionPane.showMessageDialog(null, "Dataene dine ble vellykket lagt inn i databasen, ha en god dag videre");
			System.out.println("Dataene er oppdatert i databasen");
			System.exit(0);
		} else if (e.getSource()==nullstill) {
//			PersonaliaPanel.nullstill.doClick();
//			ModulEnPanel.nullstill.doClick();
//			SertifikatPanel.nullstill.doClick();
//			KursPanel.nullstill.doClick();
//			BekreftMedbraktPanel.nullstill.doClick();
//			ModulToPanel.nullstill.doClick();
		}
	}
}
