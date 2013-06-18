package modell;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/*
 * Author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 */

public class ModulEn {
	private boolean modulEnJaSvar;
	private boolean modulEnNeiSvar;
	private String modulEnJADato;
	private String modulEnNeiFrist;
	
	public final static String MODULENJA_PROPERTY = "modulEnJaSvar";
	public final static String MODULENNEI_PROPERTY = "modulEnNeiSvar";
	public final static String MODULENJADATO_PROPERTY = "modulEnJaDato";
	public final static String MODULENNEIFRIST_PROPERTY = "modulEnNeiDato";

	private PropertyChangeSupport pcs;
	
	public boolean isModulEnJaSvar() {
		return modulEnJaSvar;
	}
	
	public ModulEn() {
		pcs = new PropertyChangeSupport(this);
	}
	
	public void setModulEnJaSvar(boolean modulEnSvar) {
		boolean oldModulEnSvar = this.isModulEnJaSvar();
		this.modulEnJaSvar = modulEnSvar;
		pcs.firePropertyChange(MODULENJA_PROPERTY, oldModulEnSvar, modulEnSvar);
	}
	public String getModulEnJADato() {
		return modulEnJADato;
	}
	public boolean isModulEnNeiSvar() {
		return modulEnNeiSvar;
	}

	public void setModulEnNeiSvar(boolean modulEnNeiSvar) {
		boolean oldModulNeiSvar = this.isModulEnNeiSvar();
		this.modulEnNeiSvar = modulEnNeiSvar;
		pcs.firePropertyChange(MODULENNEI_PROPERTY, oldModulNeiSvar, modulEnNeiSvar);
	}

	public void setModulEnJADato(String modulEnJADato) {
		String oldModulEnJaDato = this.getModulEnJADato();
		this.modulEnJADato = modulEnJADato;
		pcs.firePropertyChange(MODULENJADATO_PROPERTY, oldModulEnJaDato, oldModulEnJaDato);
	}
	public String getModulEnNeiFrist() {
		return modulEnNeiFrist;
	}
	public void setModulEnNeiFrist(String modulEnNeiFrist) {
		String oldModulEnNeiFrist = this.getModulEnNeiFrist();
		this.modulEnNeiFrist = modulEnNeiFrist;
		pcs.firePropertyChange(MODULENNEIFRIST_PROPERTY, oldModulEnNeiFrist, modulEnNeiFrist);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	
}
