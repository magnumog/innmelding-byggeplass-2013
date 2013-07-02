package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddRemovePanel implements ActionListener {
	protected JButton updateJpanel;
	public AddRemovePanel() {
		updateJpanel = new JButton("Neste");
		updateJpanel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == updateJpanel) {
			//Do some shit!
		}
		
		
	}

}
