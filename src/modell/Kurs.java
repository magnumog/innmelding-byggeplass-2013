package modell;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Kurs {
	private boolean verkstedOgLager, spesialKraner, vinsjerOgTaljer, AnhukStroppingSignalGiving, klatreOgHengestilaser, personLoftere, personLoftereUnderJord, borvognerTunnelrigger, selvgaendeUtstyr;
	private boolean traktorUtstyr, vinkelsliperKutter, boltePistol, spikerPistol, kombihammerBorhammer, kjedeSag, kappklyveGjerdeSag, bindeMaskinArmering, vibroStav, handhaldtArmeringsKapper;
	private boolean skjarebrenner, sponBrytende, slipeMaskiner, treBearbeidingsMaskin, asfaltarbeider, betongSagerKjerneBoring, veggSager, vaierSager, gulvOgAsfaltSag, hoytrykkSpyler;
	private boolean ryddeSagerOgTrimmere, spunteOgPaleUtstyr, mobiltBetongPumpeUtstyr, sikkerKontrollAvStillas, sikkerBrukAvForskaling, fallSikkring, forsteHjelp, Annet;
	
	private String VerksetedLagerTekst, SpesialKranerTekst, PersonLoftereTekst, ForstehjelpDatoTekst, AnnetTekst;
	
	public final static String VERKSTEDOGLAGER_PROPERTY = "verkstedOgLager";
	public final static String SPESIALKRANER_PROPERTY = "spesialKraner";
	public final static String VINSJEROGTALJER_PROPERTY = "vinsjerOgTaljer";
	public final static String ANHUKSTROPPINGSIGNAL_PROPERTY = "AnhukStroppingSignalGiving";
	public final static String KLATREHENGESTILASER_PROPERTY = "klatreOgHengestilaser";
	public final static String PERSONLOFTERE_PROPERTY = "personLoftere";
	public final static String PERSONLOFTEREUNDERJORD_PROPERTY = "personLoftereUnderJord";
	public final static String BORVOGNERTUNNELRIGGER_PROPERTY = "borvognerTunnelrigger";
	public final static String SELVGAENDEUTSTYR_PROPERTY = "selvgaendeUtstyr";
	public final static String TRAKTORUTSTYR_PROPERTY = "traktorUtstyr";
	public final static String VINKELSLIPERKUTTER_PROPERTY = "vinkelsliperKutter";
	public final static String BOLTEPISTOL = "boltePistol";
	public final static String SPIKERPISTOL_PROPERTY = "spikerPistol";
	public final static String KOMBIHAMMERBORHAMMER_PROPERTY = "kombihammerBorhammer";
	public final static String KJEDESAG_PROPERTY = "kjedeSag";
	public final static String KAPPKLYVEGJERDESAG_PROPERTY = "kappklyveGjerdeSag";
	public final static String BINDEMASKINARMERING_PROPERTY = "bindeMaskinArmering";
	public final static String VIBROSTAV_PROPERTY = "vibroStav";
	public final static String HANDHALDTARMERINGSKAPPER_PROPERTY = "handhaldtArmeringsKapper";
	public final static String SKJAREBRENNER_PROPERTY = "skjarebrenner";
	public final static String SPONBRYTENDE_PROPERTY = "sponBrytende";
	public final static String SLIPEMASKINER_PROPERTY = "slipeMaskiner";
	public final static String TREBEARBEIDINGSMASKIN_PROPERTY = "treBearbeidingsMaskin";
	public final static String ASFALTARBEIDER_PROPERTY = "asfaltarbeider";
	public final static String BETONGSAGERKJERNEBORING_PROPERTY = "betongSagerKjerneBoring";
	public final static String VEGGSAGER_PROPERTY = "veggSager";
	public final static String VAIERSAGER_PROPERTY = "vaierSager";
	public final static String GULVOGASFALTSAG_PROPERTY = "gulvOgAsfaltSag";
	public final static String HOYTRYKKSPYLER_PROPERTY = "hoytrykkSpyler";
	public final static String RYDDESAGEROGTRIMMERE_PROPERTY = "ryddeSagerOgTrimmere";
	public final static String SPUNTOGPALEUTSTYR_PROPERTY = "spunteOgPaleUtstyr";
	public final static String MOBILTBETONGPUMPEUTSTYR = "mobiltBetongPumpeUtstyr";
	public final static String SIKKERKONTROLLAVSTILLAS_PROPERTY = "sikkerKontorllAvStillas";
	public final static String SIKKERBRUKAVFORSKALING_PROPERTY = "sikkerBrukAvForskaling";
	public final static String FALLSIKKRING_PROPERTY = "fallSikkring";
	public final static String FORSTEHJELP_PROPERTY = "forstehjelp";
	public final static String ANNET_PROPERTY = "annet";
	
	public final static String VERKSTEDOGLAGERTEKST_PROPERTY = "VerksetedLagerTekst";
	public final static String SPESIALKRANERTEKST_PROPERTY = "SpesialKranerTekst";
	public final static String PEROSNLOFTERETEKST_PROPERTY = "PersonLoftereTekst";
	public final static String FORSTEHJELPDATOTEKST_PROPERTY = "ForstehjelpDatoTekst";
	public final static String ANNETTEKST_PROPERTY = "AnnetTekst";
	
	private PropertyChangeSupport pcs;
	
	public Kurs() {
		pcs = new PropertyChangeSupport(this);
	}

	public boolean isVerkstedOgLager() {
		return verkstedOgLager;
	}

	public void setVerkstedOgLager(boolean verkstedOgLager) {
		boolean oldVerksetedOgLager = this.isVerkstedOgLager();
		this.verkstedOgLager = verkstedOgLager;
		pcs.firePropertyChange(VERKSTEDOGLAGER_PROPERTY, oldVerksetedOgLager, verkstedOgLager);
	}
	
	public boolean isSpesialKraner() {
		return spesialKraner;
	}

	public void setSpesialKraner(boolean spesialKraner) {
		boolean oldSpesialKraner = this.isSpesialKraner();
		this.spesialKraner = spesialKraner;
		pcs.firePropertyChange(SPESIALKRANER_PROPERTY, oldSpesialKraner, spesialKraner);
	}

	public boolean isVinsjerOgTaljer() {
		return vinsjerOgTaljer;
	}

	public void setVinsjerOgTaljer(boolean vinsjerOgTaljer) {
		boolean oldVinsjerOgTaljer = this.isVinsjerOgTaljer();
		this.vinsjerOgTaljer = vinsjerOgTaljer;
		pcs.firePropertyChange(VINSJEROGTALJER_PROPERTY, oldVinsjerOgTaljer, vinsjerOgTaljer);
	}

	public boolean isAnhukStroppingSignalGiving() {
		return AnhukStroppingSignalGiving;
	}

	public void setAnhukStroppingSignalGiving(boolean anhukStroppingSignalGiving) {
		boolean oldAnhukStroppingSignal = this.isAnhukStroppingSignalGiving();
		this.AnhukStroppingSignalGiving = anhukStroppingSignalGiving;
		pcs.firePropertyChange(ANHUKSTROPPINGSIGNAL_PROPERTY, oldAnhukStroppingSignal, oldAnhukStroppingSignal);
	}
	
	public boolean isKlatreOgHengestilaser() {
		return klatreOgHengestilaser;
	}

	public void setKlatreOgHengestilaser(boolean klatreOgHengestilaser) {
		boolean oldklatreOgHentestilaser = this.isKlatreOgHengestilaser();
		this.klatreOgHengestilaser = klatreOgHengestilaser;
		pcs.firePropertyChange(KLATREHENGESTILASER_PROPERTY, oldklatreOgHentestilaser, klatreOgHengestilaser);
	}

	public boolean isPersonLoftere() {
		return personLoftere;
	}

	public void setPersonLoftere(boolean personLoftere) {
		boolean oldPersonLoftere = this.isPersonLoftere();
		this.personLoftere = personLoftere;
		pcs.firePropertyChange(PERSONLOFTERE_PROPERTY, oldPersonLoftere, personLoftere);
	}

	public boolean isPersonLoftereUnderJord() {
		return personLoftereUnderJord;
	}

	public void setPersonLoftereUnderJord(boolean personLoftereUnderJord) {
		boolean oldPersonLoftereUnderJord = this.isPersonLoftereUnderJord();
		this.personLoftereUnderJord = personLoftereUnderJord;
		pcs.firePropertyChange(PERSONLOFTEREUNDERJORD_PROPERTY, oldPersonLoftereUnderJord, personLoftereUnderJord);
	}

	public boolean isBorvognerTunnelrigger() {
		return borvognerTunnelrigger;
	}

	public void setBorvognerTunnelrigger(boolean borvognerTunnelrigger) {
		boolean oldBorVognerTunnelRigger = this.isBorvognerTunnelrigger();
		this.borvognerTunnelrigger = borvognerTunnelrigger;
		pcs.firePropertyChange(BORVOGNERTUNNELRIGGER_PROPERTY, oldBorVognerTunnelRigger, borvognerTunnelrigger);
	}

	public boolean isSelvgaendeUtstyr() {
		return selvgaendeUtstyr;
	}

	public void setSelvgaendeUtstyr(boolean selvgaendeUtstyr) {
		boolean oldSelvGaendeUtstyr = this.isSelvgaendeUtstyr();
		this.selvgaendeUtstyr = selvgaendeUtstyr;
		pcs.firePropertyChange(SELVGAENDEUTSTYR_PROPERTY, oldSelvGaendeUtstyr, selvgaendeUtstyr);
	}

	public boolean isTraktorUtstyr() {
		return traktorUtstyr;
	}

	public void setTraktorUtstyr(boolean traktorUtstyr) {
		boolean oldTraktorUtstyr = this.isTraktorUtstyr();
		this.traktorUtstyr = traktorUtstyr;
		pcs.firePropertyChange(TRAKTORUTSTYR_PROPERTY, oldTraktorUtstyr, traktorUtstyr);
	}
	
	public boolean isVinkelsliperKutter() {
		return vinkelsliperKutter;
	}

	public void setVinkelsliperKutter(boolean vinkelsliperKutter) {
		boolean oldVinkelsliperkutter = this.isVinkelsliperKutter();
		this.vinkelsliperKutter = vinkelsliperKutter;
		pcs.firePropertyChange(VINKELSLIPERKUTTER_PROPERTY, oldVinkelsliperkutter, vinkelsliperKutter);
	}

	public boolean isBoltePistol() {
		return boltePistol;
	}

	public void setBoltePistol(boolean boltePistol) {
		boolean oldBoltePistol = this.isBoltePistol();
		this.boltePistol = boltePistol;
		pcs.firePropertyChange(BOLTEPISTOL, oldBoltePistol, boltePistol);
	}

	public boolean isSpikerPistol() {
		return spikerPistol;
	}

	public void setSpikerPistol(boolean spikerPistol) {
		boolean oldSpikerPistol = this.isSpikerPistol();
		this.spikerPistol = spikerPistol;
		pcs.firePropertyChange(SPIKERPISTOL_PROPERTY, oldSpikerPistol, spikerPistol);
	}

	public boolean isKombihammerBorhammer() {
		return kombihammerBorhammer;
	}

	public void setKombihammerBorhammer(boolean kombihammerBorhammer) {
		boolean oldKombiHammerBorhammer = this.isKombihammerBorhammer();
		this.kombihammerBorhammer = kombihammerBorhammer;
		pcs.firePropertyChange(KOMBIHAMMERBORHAMMER_PROPERTY, oldKombiHammerBorhammer, kombihammerBorhammer);
	}

	public boolean isKjedeSag() {
		return kjedeSag;
	}

	public void setKjedeSag(boolean kjedeSag) {
		boolean oldKjedeSag = this.isKjedeSag();
		this.kjedeSag = kjedeSag;
		pcs.firePropertyChange(KJEDESAG_PROPERTY, oldKjedeSag, kjedeSag);
	}

	public boolean isKappklyveGjerdeSag() {
		return kappklyveGjerdeSag;
	}

	public void setKappklyveGjerdeSag(boolean kappklyveGjerdeSag) {
		boolean oldeKKappKlyveGjerdeSag = this.isKappklyveGjerdeSag();
		this.kappklyveGjerdeSag = kappklyveGjerdeSag;
		pcs.firePropertyChange(KAPPKLYVEGJERDESAG_PROPERTY, oldeKKappKlyveGjerdeSag, kappklyveGjerdeSag);
	}
	
	public boolean isBindeMaskinArmering() {
		return bindeMaskinArmering;
	}
	
	public void setBindeMaskinArmering(boolean bindeMaskinArmering) {
		boolean oldBindeMaskinArmering = this.isBindeMaskinArmering();
		this.bindeMaskinArmering = bindeMaskinArmering;
		pcs.firePropertyChange(BINDEMASKINARMERING_PROPERTY, oldBindeMaskinArmering, bindeMaskinArmering);
	}

	public boolean isVibroStav() {
		return vibroStav;
	}

	public void setVibroStav(boolean vibroStav) {
		boolean oldVibroStav = this.isVibroStav();
		this.vibroStav = vibroStav;
		pcs.firePropertyChange(VIBROSTAV_PROPERTY, oldVibroStav, vibroStav);
	}
	public boolean isHandhaldtArmeringsKapper() {
		return handhaldtArmeringsKapper;
	}
	public void setHandhaldtArmeringsKapper(boolean handhaldtArmeringsKapper) {
		boolean oldHandhaldtArmeringsKapper = this.isHandhaldtArmeringsKapper();
		this.handhaldtArmeringsKapper = handhaldtArmeringsKapper;
		pcs.firePropertyChange(HANDHALDTARMERINGSKAPPER_PROPERTY, oldHandhaldtArmeringsKapper, handhaldtArmeringsKapper);
	}
	public boolean isSkjarebrenner() {
		return skjarebrenner;
	}
	public void setSkjarebrenner(boolean skjarebrenner) {
		boolean oldSkjareBrenner = this.isSkjarebrenner();
		this.skjarebrenner = skjarebrenner;
		pcs.firePropertyChange(SKJAREBRENNER_PROPERTY, oldSkjareBrenner, skjarebrenner);
	}
	
	public boolean isSponBrytende() {
		return sponBrytende;
	}
	
	public void setSponBrytende(boolean sponBrytende) {
		boolean oldSponBrytende = this.isSponBrytende();
		this.sponBrytende = sponBrytende;
		pcs.firePropertyChange(SPONBRYTENDE_PROPERTY, oldSponBrytende, sponBrytende);
	}
	
	public boolean isSlipeMaskiner() {
		return slipeMaskiner;
	}

	public void setSlipeMaskiner(boolean slipeMaskiner) {
		boolean oldSlipeMaskiner = this.isSlipeMaskiner();
		this.slipeMaskiner = slipeMaskiner;
		pcs.firePropertyChange(SLIPEMASKINER_PROPERTY, oldSlipeMaskiner, slipeMaskiner);
	}

	public boolean isTreBearbeidingsMaskin() {
		return treBearbeidingsMaskin;
	}
	public void setTreBearbeidingsMaskin(boolean treBearbeidingsMaskin) {
		boolean oldTreBearbeidingsMaskin = this.isTreBearbeidingsMaskin();
		this.treBearbeidingsMaskin = treBearbeidingsMaskin;
		pcs.firePropertyChange(TREBEARBEIDINGSMASKIN_PROPERTY, oldTreBearbeidingsMaskin, treBearbeidingsMaskin);
	}
	
	public boolean isAsfaltarbeider() {
		return asfaltarbeider;
	}
	
	public void setAsfaltarbeider(boolean asfaltarbeider) {
		boolean oldAsfaltArbeider = this.isAsfaltarbeider();
		this.asfaltarbeider = asfaltarbeider;
		pcs.firePropertyChange(ASFALTARBEIDER_PROPERTY, oldAsfaltArbeider, asfaltarbeider);
	}

	public boolean isBetongSagerKjerneBoring() {
		return betongSagerKjerneBoring;
	}

	public void setBetongSagerKjerneBoring(boolean betongSagerKjerneBoring) {
		boolean oldBetongSagerKjerneBoring = this.isBetongSagerKjerneBoring();
		this.betongSagerKjerneBoring = betongSagerKjerneBoring;
		pcs.firePropertyChange(BETONGSAGERKJERNEBORING_PROPERTY, oldBetongSagerKjerneBoring, betongSagerKjerneBoring);
	}

	public boolean isVeggSager() {
		return veggSager;
	}

	public void setVeggSager(boolean veggSager) {
		boolean oldVeggSager = this.isVeggSager();
		this.veggSager = veggSager;
		pcs.firePropertyChange(VEGGSAGER_PROPERTY, oldVeggSager, veggSager);
	}

	public boolean isVaierSager() {
		return vaierSager;
	}

	public void setVaierSager(boolean vaierSager) {
		boolean oldVaierSager = this.isVaierSager();
		this.vaierSager = vaierSager;
		pcs.firePropertyChange(VAIERSAGER_PROPERTY, oldVaierSager, vaierSager);
	}

	public boolean isGulvOgAsfaltSag() {
		return gulvOgAsfaltSag;
	}

	public void setGulvOgAsfaltSag(boolean gulvOgAsfaltSag) {
		boolean oldGulvOgAsfaltSag = this.isGulvOgAsfaltSag();
		this.gulvOgAsfaltSag = gulvOgAsfaltSag;
		pcs.firePropertyChange(GULVOGASFALTSAG_PROPERTY, oldGulvOgAsfaltSag, gulvOgAsfaltSag);
	}

	public boolean isHoytrykkSpyler() {
		return hoytrykkSpyler;
	}

	public void setHoytrykkSpyler(boolean hoytrykkSpyler) {
		boolean oldHoytrykkSpyler = this.isHoytrykkSpyler();
		this.hoytrykkSpyler = hoytrykkSpyler;
		pcs.firePropertyChange(HOYTRYKKSPYLER_PROPERTY, oldHoytrykkSpyler, hoytrykkSpyler);
	}

	public boolean isRyddeSagerOgTrimmere() {
		return ryddeSagerOgTrimmere;
	}

	public void setRyddeSagerOgTrimmere(boolean ryddeSagerOgTrimmere) {
		boolean oldRyddeSagerOgTrimmere = this.isRyddeSagerOgTrimmere();
		this.ryddeSagerOgTrimmere = ryddeSagerOgTrimmere;
		pcs.firePropertyChange(RYDDESAGEROGTRIMMERE_PROPERTY, oldRyddeSagerOgTrimmere, ryddeSagerOgTrimmere);
	}

	public boolean isSpunteOgPaleUtstyr() {
		return spunteOgPaleUtstyr;
	}

	public void setSpunteOgPaleUtstyr(boolean spunteOgPaleUtstyr) {
		boolean oldSpunteOgPaleUtstyr = this.isSpunteOgPaleUtstyr();
		this.spunteOgPaleUtstyr = spunteOgPaleUtstyr;
		pcs.firePropertyChange(SPUNTOGPALEUTSTYR_PROPERTY, oldSpunteOgPaleUtstyr, spunteOgPaleUtstyr);
	}
	
	public boolean isMobiltBetongPumpeUtstyr() {
		return mobiltBetongPumpeUtstyr;
	}
	
	public void setMobiltBetongPumpeUtstyr(boolean mobiltBetongPumpeUtstyr) {
		boolean oldMobiltBetongPumpeUtstyr = this.isMobiltBetongPumpeUtstyr();
		this.mobiltBetongPumpeUtstyr = mobiltBetongPumpeUtstyr;
		pcs.firePropertyChange(MOBILTBETONGPUMPEUTSTYR, oldMobiltBetongPumpeUtstyr, mobiltBetongPumpeUtstyr);
	}

	public boolean isSikkerKontorllAvStillas() {
		return sikkerKontrollAvStillas;
	}

	public void setSikkerKontorllAvStillas(boolean sikkerKontorllAvStillas) {
		boolean oldSikkerKontrollAvStillas = this.isSikkerKontorllAvStillas();
		this.sikkerKontrollAvStillas = sikkerKontorllAvStillas;
		pcs.firePropertyChange(SIKKERKONTROLLAVSTILLAS_PROPERTY, oldSikkerKontrollAvStillas, sikkerKontorllAvStillas);
	}

	public boolean isSikkerBrukAvForskaling() {
		return sikkerBrukAvForskaling;
	}
	
	public void setSikkerBrukAvForskaling(boolean sikkerBrukAvForskaling) {
		boolean oldSikkerBrukAvForskaling = this.isSikkerBrukAvForskaling();
		this.sikkerBrukAvForskaling = sikkerBrukAvForskaling;
		pcs.firePropertyChange(SIKKERBRUKAVFORSKALING_PROPERTY, oldSikkerBrukAvForskaling, sikkerBrukAvForskaling);
	}
	
	public boolean isFallSikkring() {
		return fallSikkring;
	}
	
	public void setFallSikkring(boolean fallSikkring) {
		boolean oldFallSikkring = this.isFallSikkring();
		this.fallSikkring = fallSikkring;
		pcs.firePropertyChange(FALLSIKKRING_PROPERTY, oldFallSikkring, fallSikkring);
	}
	
	public boolean isForsteHjelp() {
		return forsteHjelp;
	}
	
	public void setForsteHjelp(boolean forsteHjelp) {
		boolean oldForsteHjelp = this.isForsteHjelp();
		this.forsteHjelp = forsteHjelp;
		pcs.firePropertyChange(FORSTEHJELP_PROPERTY, oldForsteHjelp, forsteHjelp);
	}
	
	public boolean isAnnet() {
		return Annet;
	}
	
	public void setAnnet(boolean annet) {
		boolean oldAnnet = this.isAnnet();
		Annet = annet;
		pcs.firePropertyChange(ANNET_PROPERTY, oldAnnet, annet);
	}
	
	public String getVerksetedLagerTekst() {
		return VerksetedLagerTekst;
	}

	public void setVerksetedLagerTekst(String verksetedLagerTekst) {
		String OldVerkstedOgLagerTekst = this.getVerksetedLagerTekst();
		VerksetedLagerTekst = verksetedLagerTekst;
		pcs.firePropertyChange(VERKSTEDOGLAGERTEKST_PROPERTY, OldVerkstedOgLagerTekst, verksetedLagerTekst);
	}
	
	public String getSpesialKranerTekst() {
		return SpesialKranerTekst;
	}

	public void setSpesialKranerTekst(String spesialKranerTekst) {
		String oldSpesialKranerTekst = this.getSpesialKranerTekst();
		SpesialKranerTekst = spesialKranerTekst;
		pcs.firePropertyChange(SPESIALKRANERTEKST_PROPERTY, oldSpesialKranerTekst, spesialKranerTekst);
	}
	
	public String getPersonLoftereTekst() {
		return PersonLoftereTekst;
	}

	public void setPersonLoftereTekst(String personLoftereTekst) {
		String oldPersonLoftereTekst = this.getPersonLoftereTekst();
		PersonLoftereTekst = personLoftereTekst;
		pcs.firePropertyChange(PEROSNLOFTERETEKST_PROPERTY, oldPersonLoftereTekst, personLoftereTekst);
	}

	public String getForstehjelpDatoTekst() {
		return ForstehjelpDatoTekst;
	}

	public void setForstehjelpDatoTekst(String forstehjelpDatoTekst) {
		String oldForsteHjelpDatoTekst = this.getForstehjelpDatoTekst();
		ForstehjelpDatoTekst = forstehjelpDatoTekst;
		pcs.firePropertyChange(FORSTEHJELPDATOTEKST_PROPERTY, oldForsteHjelpDatoTekst, forstehjelpDatoTekst);
	}

	public String getAnnetTekst() {
		return AnnetTekst;
	}

	public void setAnnetTekst(String annetTekst) {
		String oldAnnetTekst = this.getAnnetTekst();
		AnnetTekst = annetTekst;
		pcs.firePropertyChange(ANNETTEKST_PROPERTY, oldAnnetTekst, annetTekst);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

}
