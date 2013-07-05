package program;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import panel.BekreftMedbraktPanel;
import panel.KursPanel;
import panel.ModulEnPanel;
import panel.ModulToPanel;
import panel.PersonaliaPanel;
import panel.SertifikatPanel;

public class Velkommen extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String[][] labels = {{"Velkommen til Veidekkes elektroniske registrering av personell"},{"Welcomme to Veidekkes electronical registration of personell"},{"Witamy Veidekkes elektroniczny rejestracja personelu"}};
	protected ImageIcon veidekke = new ImageIcon("src/bilder/Veidekke-logo__JPG__8006a.jpg");
	private Image image = veidekke.getImage().getScaledInstance(615, 615, Image.SCALE_SMOOTH);
	private JLabel logo;
	protected ImageIcon noImg = new ImageIcon("src\\bilder\\no.gif");
	protected ImageIcon gbImg = new ImageIcon("src\\bilder\\gb.gif");
	protected ImageIcon polskImg = new ImageIcon("src\\bilder\\pl.gif");
	private JToggleButton no, gb, polsk;
	private ButtonGroup sprak;
	private int spraknr = 0;
	private JLabel velkommen = new JLabel(labels[spraknr][0]);

	public Velkommen() {
		sprak = new ButtonGroup();
		veidekke.setImage(image);
		logo = new JLabel(veidekke);
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.ipadx=26;
		c.gridx=0;
		c.gridy=0;
		c.gridheight=12;
		c.gridwidth=1;
		add(logo,c);
		c.ipadx=0;
		c.ipady=25;
		c.insets = new Insets(600, 1, 1, 1);
		c.gridx=0;
		c.gridy=5;
		velkommen.setFont(new Font("Andalus", Font.BOLD, 24));
		add(velkommen,c);
		no = new JToggleButton();
		no.setIcon(noImg);
		no.setContentAreaFilled(false);
		no.setBorderPainted(false);
		gb = new JToggleButton();
		gb.setIcon(gbImg);
		gb.setContentAreaFilled(false);
		gb.setBorderPainted(false);
		polsk = new JToggleButton();
		polsk.setIcon(polskImg);
		polsk.setContentAreaFilled(false);
		polsk.setBorderPainted(false);
		c.gridy=7;
		c.insets = new Insets(650,1,1,100);
		add(no,c);
		c.insets = new Insets(650, 0, 1, 1);
		add(gb,c);
		c.insets = new Insets(650, 100, 1, 1);
		add(polsk,c);

		no.addActionListener(this);
		gb.addActionListener(this);
		polsk.addActionListener(this);
		sprak.add(no);
		sprak.add(gb);
		sprak.add(polsk);
		no.setSelected(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == no) {
			System.out.println("Du trykket på det norske flagget");
			spraknr=0;
			velkommen.setText(labels[spraknr][0]);
		} else if(e.getSource() == gb) {
			System.out.println("Du trykket på det engelseke falgget");
			spraknr=1;
			velkommen.setText(labels[spraknr][0]);
		} else if(e.getSource() == polsk) {
			System.out.println("Polsk sprak");
			spraknr=2;
			velkommen.setText(labels[spraknr][0]);
		}
		RegistreringPanelProgram.changeLanguage(spraknr);
		PersonaliaPanel.changeLanguage(spraknr);
		ModulEnPanel.changeLanguage(spraknr);
		SertifikatPanel.changeLanguage(spraknr);
		KursPanel.changeLanguage(spraknr);
		BekreftMedbraktPanel.changeLanguage(spraknr);
		ModulToPanel.changeLanguage(spraknr);

	}

}
