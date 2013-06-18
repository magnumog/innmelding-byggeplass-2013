package modell;
/*
 * Author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 */

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Sertifikat {
	private boolean forerkort;
	private String forerkortKlasser;
	private boolean grunnopplaeringArbeidsmiljo;
	private boolean maskinForerBevis;
	private String maskinForerKlasser;
	private boolean arbeidsVarsling;
	private String arbeidsVarslingKurs;
	private boolean varmeArbeider;
	private String varmeArbeiderdato;
	private boolean truckKranForer;
	private String truckKranForerBevis;
	
	public final static String FORERKORT_PROPERTY = "forerkort";
	public final static String FORERKORTKLASSER_PROPERTY = "forerkortKlasser";
	public final static String GRUNNOPPLARING_PROPERTY = "grunnopplaeringArbeidsmiljo";
	public final static String MASKINFORER_PROPERTY = "maskinForerBevis";
	public final static String MASKINKLASSER_PROPERTY = "maskinForerKlasser";
	public final static String ARBEIDSVARSLING_PROPERTY = "arbeidsVarsling";
	public final static String ARBEIDSVARSLINGSKURS_PROPERTY = "arbeidsVarslingKurs";
	public final static String VARMEARBEIDER_PROPERTY = "varmeArbeider";
	public final static String VARMEARBEIDERDATO_PROPERTY = "varmeArbeiderdato";
	public final static String TRUCKKRANFORER_PROPERTY = "truckKranForer";
	public final static String TRUCKKRANFORERBEVIS_PROPERTY = "truckKranForerBevis";
	
	private PropertyChangeSupport pcs;
	
	public Sertifikat() {
		pcs = new PropertyChangeSupport(this);
	}
	
	
	public boolean isForerkort() {
		return forerkort;
	}
	public void setForerkort(boolean forerkort) {
		boolean oldForerkort = this.isForerkort();
		this.forerkort = forerkort;
		pcs.firePropertyChange(FORERKORT_PROPERTY, oldForerkort, forerkort);
	}
	public String getForerkortKlasser() {
		return forerkortKlasser;
	}
	public void setForerkortKlasser(String forerkortKlasser) {
		String oldForerkortKlasser = this.getForerkortKlasser();
		this.forerkortKlasser = forerkortKlasser;
		pcs.firePropertyChange(FORERKORTKLASSER_PROPERTY, oldForerkortKlasser, forerkortKlasser);		
	}
	public boolean isGrunnopplaeringArbeidsmiljo() {
		return grunnopplaeringArbeidsmiljo;
	}
	public void setGrunnopplaeringArbeidsmiljo(boolean grunnopplaeringArbeidsmiljo) {
		boolean oldGrunnopplaring = this.isGrunnopplaeringArbeidsmiljo();
		this.grunnopplaeringArbeidsmiljo = grunnopplaeringArbeidsmiljo;
		pcs.firePropertyChange(GRUNNOPPLARING_PROPERTY, oldGrunnopplaring, grunnopplaeringArbeidsmiljo);
	}
	public boolean isMaskinForerBevis() {
		return maskinForerBevis;
	}
	public void setMaskinForerBevis(boolean maskinForerBevis) {
		boolean oldMaskinForer = this.isMaskinForerBevis();
		this.maskinForerBevis = maskinForerBevis;
		pcs.firePropertyChange(MASKINFORER_PROPERTY, oldMaskinForer, maskinForerBevis);
	}
	public String getMaskinForerKlasser() {
		return maskinForerKlasser;
	}
	public void setMaskinForerKlasser(String maskinForerKlasser) {
		String oldMaskinKlasser = this.getMaskinForerKlasser();
		this.maskinForerKlasser = maskinForerKlasser;
		pcs.firePropertyChange(MASKINKLASSER_PROPERTY, oldMaskinKlasser, maskinForerKlasser);
	}
	public boolean isArbeidsVarsling() {
		return arbeidsVarsling;
	}
	public void setArbeidsVarsling(boolean arbeidsVarsling) {
		boolean oldArbeidVarsling = this.isArbeidsVarsling();
		this.arbeidsVarsling = arbeidsVarsling;
		pcs.firePropertyChange(ARBEIDSVARSLING_PROPERTY, oldArbeidVarsling, arbeidsVarsling);
	}
	public String getArbeidsVarslingKurs() {
		return arbeidsVarslingKurs;
	}
	public void setArbeidsVarslingKurs(String arbeidsVarslingKurs) {
		String oldArbeidsVarslingKurs = this.getArbeidsVarslingKurs();
		this.arbeidsVarslingKurs = arbeidsVarslingKurs;
		pcs.firePropertyChange(ARBEIDSVARSLINGSKURS_PROPERTY, oldArbeidsVarslingKurs, arbeidsVarslingKurs);
	}
	public boolean isVarmeArbeider() {
		return varmeArbeider;
	}
	public void setVarmeArbeider(boolean varmeArbeider) {
		boolean oldVarmeArbeider = this.isVarmeArbeider();
		this.varmeArbeider = varmeArbeider;
		pcs.firePropertyChange(VARMEARBEIDER_PROPERTY, oldVarmeArbeider, varmeArbeider);
	}
	public String getVarmeArbeiderdato() {
		return varmeArbeiderdato;
	}
	public void setVarmeArbeiderdato(String varmeArbeiderdato) {
		String oldVarmeArbeiderDato = this.getVarmeArbeiderdato();
		this.varmeArbeiderdato = varmeArbeiderdato;
		pcs.firePropertyChange(VARMEARBEIDERDATO_PROPERTY, oldVarmeArbeiderDato, varmeArbeiderdato);
	}
	public boolean isTruckKranForer() {
		return truckKranForer;
	}
	public void setTruckKranForer(boolean truckKranForer) {
		boolean oldTruckKranForer = this.isTruckKranForer();
		this.truckKranForer = truckKranForer;
		pcs.firePropertyChange(TRUCKKRANFORER_PROPERTY, oldTruckKranForer, truckKranForer);
	}
	public String getTruckKranForerBevis() {
		return truckKranForerBevis;
	}
	public void setTruckKranForerBevis(String truckKranForerBevis) {
		String oldTruckKranForerBevis = this.getTruckKranForerBevis();
		this.truckKranForerBevis = truckKranForerBevis;
		pcs.firePropertyChange(TRUCKKRANFORERBEVIS_PROPERTY, oldTruckKranForerBevis, truckKranForerBevis);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

}
