package panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ModulEnPanel extends JPanel implements ActionListener,PropertyChangeListener,ChangeListener {
	private static final long serialVersionUID = 1L;
	protected JRadioButton modulEnJa, modulEnNei;
	protected JTextField modulEnJaDato,modulEnNeiFrist;
	protected JLabel modulEnInfo;
	
	public ModulEnPanel(){
		modulEnJa = new JRadioButton("Ja, dato for gjennomføring: ");
		modulEnNei = new JRadioButton("Nei, Dato frist: ");
		modulEnJaDato = new JTextField(5);
		modulEnNeiFrist = new JTextField(5);
		modulEnInfo = new JLabel("Gjennomført obligatorisk sikkerthetopplæring Modul 1:");
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(modulEnJa);
		btnGroup.add(modulEnNei);
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
		add(modulEnJa,c);
		c.gridx=2;
		add(modulEnJaDato,c);
		c.gridx=3;
		add(modulEnNei,c);
		c.gridx=4;
		add(modulEnNeiFrist,c);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
