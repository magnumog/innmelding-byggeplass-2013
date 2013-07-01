package panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DoClickPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton neste;
	
	public DoClickPanel() {
		neste = new JButton("Neste");
		neste.addActionListener(this);
		
		GridBagConstraints c;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.insets = new Insets(1,1,1,1);
		c.anchor = GridBagConstraints.WEST;
		c.gridx=0;
		c.gridy=0;
		add(neste,c);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == neste) {
			System.out.println("du trykket");
		}
		PersonaliaPanel.Neste.doClick();
		ModulEnPanel.Neste.doClick();
		SertifikatPanel.neste.doClick();
		KursPanel.Neste.doClick();
		BekreftMedbraktPanel.neste.doClick();
		ModulToPanel.neste.doClick();
	}
}
