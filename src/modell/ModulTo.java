package modell;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModulTo {
	private boolean fravaroppfolging, underskrevetsikkerhetsinstruks, gjennomfortModulTo, klistremerkeModulEn, inneforstattMedReaksjonsmonster, utdeltBlokkLopendeRisiko, SHAPlan;
	
	public final static String FRAVAROPPFOLGING_PROPERTY = "fravaroppfolging";
	public final static String UNDERSKREVETSIKKERHETSINSTRUKS_PROPERTY = "underskrevetsikkerhetsinstruks";
	public final static String GJENNOMFORTMODULTO_PROPERTY = "gjennomfortModulTo";
	public final static String KLISTREMERKEMODULEN_PROPERTY = "klistremerkeModulEn";
	public final static String INNEFORSTATTMEDREAKSJONSMONSER_PROPERTY = "inneforstattMedReaksjonsmonster";
	public final static String UTDELTBLOKKLOPENDERISIKO_PROPERTY = "utdeltBlokkLopendeRisiko";
	public final static String SHAPLAN_PROPERTY = "SHAPlan";
	
	private PropertyChangeSupport pcs;
	
	public ModulTo() {
		pcs = new PropertyChangeSupport(this);
	}
	
	public boolean isFravaroppfolging() {
		return fravaroppfolging;
	}

	public void setFravaroppfolging(boolean fravaroppfolging) {
		boolean oldfravar = this.isFravaroppfolging();
		this.fravaroppfolging = fravaroppfolging;
		pcs.firePropertyChange(FRAVAROPPFOLGING_PROPERTY, oldfravar, fravaroppfolging);
	}

	public boolean isUnderskrevetsikkerhetsinstruks() {
		return underskrevetsikkerhetsinstruks;
	}

	public void setUnderskrevetsikkerhetsinstruks(boolean underskrevetsikkerhetsinstruks) {
		boolean oldunderskrevetSikkerhetsInstruks = this.isUnderskrevetsikkerhetsinstruks();
		this.underskrevetsikkerhetsinstruks = underskrevetsikkerhetsinstruks;
		pcs.firePropertyChange(UNDERSKREVETSIKKERHETSINSTRUKS_PROPERTY, oldunderskrevetSikkerhetsInstruks, underskrevetsikkerhetsinstruks);
	}

	public boolean isGjennomfortModulTo() {
		return gjennomfortModulTo;
	}

	public void setGjennomfortModulTo(boolean gjennomfortModulTo) {
		boolean oldGjennomfortModulTo = this.isGjennomfortModulTo();
		this.gjennomfortModulTo = gjennomfortModulTo;
		pcs.firePropertyChange(GJENNOMFORTMODULTO_PROPERTY, oldGjennomfortModulTo, gjennomfortModulTo);
	}

	public boolean isKlistremerkeModulEn() {
		return klistremerkeModulEn;
	}

	public void setKlistremerkeModulEn(boolean klistremerkeModulEn) {
		boolean oldKlistremerke = this.isKlistremerkeModulEn();
		this.klistremerkeModulEn = klistremerkeModulEn;
		pcs.firePropertyChange(KLISTREMERKEMODULEN_PROPERTY, oldKlistremerke, klistremerkeModulEn);
	}

	public boolean isInneforstattMedReaksjonsmonster() {
		return inneforstattMedReaksjonsmonster;
	}

	public void setInneforstattMedReaksjonsmonster(boolean inneforstattMedReaksjonsmonster) {
		boolean oldInneforstattMedReaksjonsmonster = this.isInneforstattMedReaksjonsmonster();
		this.inneforstattMedReaksjonsmonster = inneforstattMedReaksjonsmonster;
		pcs.firePropertyChange(INNEFORSTATTMEDREAKSJONSMONSER_PROPERTY, oldInneforstattMedReaksjonsmonster, inneforstattMedReaksjonsmonster);
	}

	public boolean isUtdeltBlokkLopendeRisiko() {
		return utdeltBlokkLopendeRisiko;
	}

	public void setUtdeltBlokkLopendeRisiko(boolean utdeltBlokkLopendeRisiko) {
		boolean oldUtdeltBlokk = this.isUtdeltBlokkLopendeRisiko();
		this.utdeltBlokkLopendeRisiko = utdeltBlokkLopendeRisiko;
		pcs.firePropertyChange(UTDELTBLOKKLOPENDERISIKO_PROPERTY, oldUtdeltBlokk, utdeltBlokkLopendeRisiko);
	}

	public boolean isSHAPlan() {
		return SHAPlan;
	}

	public void setSHAPlan(boolean sHAPlan) {
		boolean oldSHAPlan = this.isSHAPlan();
		SHAPlan = sHAPlan;
		pcs.firePropertyChange(SHAPLAN_PROPERTY, oldSHAPlan, sHAPlan);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
}
