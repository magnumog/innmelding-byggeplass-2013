package modell;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BekreftMedbrakt {
	private boolean pabudtVerneutstyr,tilgjengeligVerneutstyr;
	private String dato, navnPaaArbeidgiver;
	
	public final static String PAABUDTVERNEUTSTYR_PROPERTY = "pabudtVerneutstyr";
	public final static String TILGJENGELIGVERNEUTSTYR_PROPERTY = "tilgjengeligVerneutstyr";
	public final static String DATO_PROPERTY = "dato";
	public final static String NAVNPAAARBEIDSGIVER_PROPERTY = "navnPaaArbeidgiver";
	
	private PropertyChangeSupport pcs;
	
	public BekreftMedbrakt() {
		pcs = new PropertyChangeSupport(this);
	}

	public boolean isPabudtVerneutstyr() {
		return pabudtVerneutstyr;
	}

	public void setPabudtVerneutstyr(boolean pabudtVerneutstyr) {
		boolean oldpabudt = this.isPabudtVerneutstyr();
		this.pabudtVerneutstyr = pabudtVerneutstyr;
		pcs.firePropertyChange(PAABUDTVERNEUTSTYR_PROPERTY, oldpabudt, pabudtVerneutstyr);
	}

	public boolean isTilgjengeligVerneutstyr() {
		return tilgjengeligVerneutstyr;
	}

	public void setTilgjengeligVerneutstyr(boolean tilgjengeligVerneutstyr) {
		boolean oldtilgjengelig = this.isTilgjengeligVerneutstyr();
		this.tilgjengeligVerneutstyr = tilgjengeligVerneutstyr;
		pcs.firePropertyChange(TILGJENGELIGVERNEUTSTYR_PROPERTY, oldtilgjengelig, tilgjengeligVerneutstyr);
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		String oldDato = this.getDato();
		this.dato = dato;
		pcs.firePropertyChange(DATO_PROPERTY, oldDato, dato);
	}

	public String getNavnPaaArbeidgiver() {
		return navnPaaArbeidgiver;
	}

	public void setNavnPaaArbeidgiver(String navnPaaArbeidgiver) {
		String oldNavnPaaArbeidsgiver = this.getNavnPaaArbeidgiver();
		this.navnPaaArbeidgiver = navnPaaArbeidgiver;
		pcs.firePropertyChange(NAVNPAAARBEIDSGIVER_PROPERTY, oldNavnPaaArbeidsgiver, navnPaaArbeidgiver);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
	

}
