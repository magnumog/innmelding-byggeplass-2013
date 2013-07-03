package program;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Velkommen extends JPanel {
	
	protected ImageIcon veidekke = new ImageIcon("C:/workspace/innmelding-byggeplass-2013/src/panel/Veidekke-logo.jpg");
	protected JLabel logo = new JLabel(veidekke);
	
	public Velkommen() {
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.gridheight=12;
		c.gridwidth=1;
		add(logo,c);
	}

}
