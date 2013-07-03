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

public class Velkommen extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	protected ImageIcon veidekke = new ImageIcon("src/bilder/Veidekke-logo__JPG__8006a.jpg");
	private Image image = veidekke.getImage().getScaledInstance(615, 615, Image.SCALE_SMOOTH);
	private JLabel logo;
	private JLabel velkommen = new JLabel("Velkommen til Veidekkes elektroniske registrering av personell");
	protected ImageIcon noImg = new ImageIcon("src\\bilder\\no.gif");
	protected ImageIcon gbImg = new ImageIcon("src\\bilder\\gb.gif");
	private JToggleButton no, gb;
	private ButtonGroup sprak;
	private int spraknr = 0;
	
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
		c.gridy=7;
		c.insets = new Insets(650,1,1,30);
		add(no,c);
		c.gridx=0;
		c.insets = new Insets(650, 30, 1, 1);
//		c.anchor = GridBagConstraints.WEST;
		add(gb,c);
		no.addActionListener(this);
		gb.addActionListener(this);
		sprak.add(no);
		sprak.add(gb);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == no) {
			System.out.println("Du trykket på det norske flagget");
			velkommen.setText("Velkommen til Veidekkes elektroniske registrering av personell");
			spraknr=0;
		} else if(e.getSource() == gb) {
			System.out.println("Du trykket på det engelseke falgget");
			velkommen.setText("Welcomme to Veidekkes electronical registration of personell");
			spraknr=1;
		}
		
	}

}
