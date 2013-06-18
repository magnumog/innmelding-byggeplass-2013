package modell;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Kurs {
	private boolean verkstedOgLager, spesialKraner, vinsjerOgTaljer, AnhukStroppingSignalGiving, klatreOgHengestilaser, personLøftere,personLøftereUnderJord, borvognerTunnelrigger, selvgaendeUtstyr;
	private boolean traktorUtstyr, vinkelsliperKutter, boltePistol, spikerPistol, kombihammerBorhammer, kjedeSag, kappklyveGjerdeSag, bindeMaskinArmering, vibroStav, handhaldtArmeringsKapper;
	private boolean skjarebrenner, sponBrytende, slipeMaskiner, treBearbeidingsMaskin, asfaltarbeider, betongSagerKjerneBoring, veggSager, vaierSager, gulvOgAsfaltSag, hoytrykkSpyler;
	private boolean ryddeSagerOgTrimmere, spunteOgPaleUtstyr, mobiltBetongPumpeUtstyr, sikkerKontorllAvStillas, sikkerBrukAvForskaling, fallSikkring, forsteHjelp, Annet;
	
	private String VerksetedLagerTekst, SpesialKranerTekst, PersonLoftereTekst, ForstehjelpDatoTekst, AnnetTekst;
	
	private PropertyChangeSupport pcs;
	
	public Kurs() {
		pcs = new PropertyChangeSupport(this);
	}

	public boolean isVerkstedOgLager() {
		return verkstedOgLager;
	}

	public void setVerkstedOgLager(boolean verkstedOgLager) {
		this.verkstedOgLager = verkstedOgLager;
	}
	
	public boolean isSpesialKraner() {
		return spesialKraner;
	}

	public void setSpesialKraner(boolean spesialKraner) {
		this.spesialKraner = spesialKraner;
	}

	public boolean isVinsjerOgTaljer() {
		return vinsjerOgTaljer;
	}

	public void setVinsjerOgTaljer(boolean vinsjerOgTaljer) {
		this.vinsjerOgTaljer = vinsjerOgTaljer;
	}

	public boolean isAnhukStroppingSignalGiving() {
		return AnhukStroppingSignalGiving;
	}

	public void setAnhukStroppingSignalGiving(boolean anhukStroppingSignalGiving) {
		AnhukStroppingSignalGiving = anhukStroppingSignalGiving;
	}
	
	public boolean isKlatreOgHengestilaser() {
		return klatreOgHengestilaser;
	}

	public void setKlatreOgHengestilaser(boolean klatreOgHengestilaser) {
		this.klatreOgHengestilaser = klatreOgHengestilaser;
	}

	public boolean isPersonLøftere() {
		return personLøftere;
	}

	public void setPersonLøftere(boolean personLøftere) {
		this.personLøftere = personLøftere;
	}

	public boolean isPersonLøftereUnderJord() {
		return personLøftereUnderJord;
	}

	public void setPersonLøftereUnderJord(boolean personLøftereUnderJord) {
		this.personLøftereUnderJord = personLøftereUnderJord;
	}

	public boolean isBorvognerTunnelrigger() {
		return borvognerTunnelrigger;
	}

	public void setBorvognerTunnelrigger(boolean borvognerTunnelrigger) {
		this.borvognerTunnelrigger = borvognerTunnelrigger;
	}

	public boolean isSelvgaendeUtstyr() {
		return selvgaendeUtstyr;
	}

	public void setSelvgaendeUtstyr(boolean selvgaendeUtstyr) {
		this.selvgaendeUtstyr = selvgaendeUtstyr;
	}

	public boolean isTraktorUtstyr() {
		return traktorUtstyr;
	}

	public void setTraktorUtstyr(boolean traktorUtstyr) {
		this.traktorUtstyr = traktorUtstyr;
	}
	
	public boolean isVinkelsliperKutter() {
		return vinkelsliperKutter;
	}

	public void setVinkelsliperKutter(boolean vinkelsliperKutter) {
		this.vinkelsliperKutter = vinkelsliperKutter;
	}

	public boolean isBoltePistol() {
		return boltePistol;
	}

	public void setBoltePistol(boolean boltePistol) {
		this.boltePistol = boltePistol;
	}

	public boolean isSpikerPistol() {
		return spikerPistol;
	}

	public void setSpikerPistol(boolean spikerPistol) {
		this.spikerPistol = spikerPistol;
	}

	public boolean isKombihammerBorhammer() {
		return kombihammerBorhammer;
	}

	public void setKombihammerBorhammer(boolean kombihammerBorhammer) {
		this.kombihammerBorhammer = kombihammerBorhammer;
	}

	public boolean isKjedeSag() {
		return kjedeSag;
	}

	public void setKjedeSag(boolean kjedeSag) {
		this.kjedeSag = kjedeSag;
	}

	public boolean isKappklyveGjerdeSag() {
		return kappklyveGjerdeSag;
	}

	public void setKappklyveGjerdeSag(boolean kappklyveGjerdeSag) {
		this.kappklyveGjerdeSag = kappklyveGjerdeSag;
	}
	
	public boolean isBindeMaskinArmering() {
		return bindeMaskinArmering;
	}
	
	public void setBindeMaskinArmering(boolean bindeMaskinArmering) {
		this.bindeMaskinArmering = bindeMaskinArmering;
	}

	public boolean isVibroStav() {
		return vibroStav;
	}

	public void setVibroStav(boolean vibroStav) {
		this.vibroStav = vibroStav;
	}
	public boolean isHandhaldtArmeringsKapper() {
		return handhaldtArmeringsKapper;
	}
	public void setHandhaldtArmeringsKapper(boolean handhaldtArmeringsKapper) {
		this.handhaldtArmeringsKapper = handhaldtArmeringsKapper;
	}
	public boolean isSkjarebrenner() {
		return skjarebrenner;
	}
	public void setSkjarebrenner(boolean skjarebrenner) {
		this.skjarebrenner = skjarebrenner;
	}
	
	public boolean isSponBrytende() {
		return sponBrytende;
	}
	
	public void setSponBrytende(boolean sponBrytende) {
		this.sponBrytende = sponBrytende;
	}
	
	public boolean isSlipeMaskiner() {
		return slipeMaskiner;
	}

	public void setSlipeMaskiner(boolean slipeMaskiner) {
		this.slipeMaskiner = slipeMaskiner;
	}

	public boolean isTreBearbeidingsMaskin() {
		return treBearbeidingsMaskin;
	}
	public void setTreBearbeidingsMaskin(boolean treBearbeidingsMaskin) {
		this.treBearbeidingsMaskin = treBearbeidingsMaskin;
	}
	
	public boolean isAsfaltarbeider() {
		return asfaltarbeider;
	}
	
	public void setAsfaltarbeider(boolean asfaltarbeider) {
		this.asfaltarbeider = asfaltarbeider;
	}

	public boolean isBetongSagerKjerneBoring() {
		return betongSagerKjerneBoring;
	}

	public void setBetongSagerKjerneBoring(boolean betongSagerKjerneBoring) {
		this.betongSagerKjerneBoring = betongSagerKjerneBoring;
	}

	public boolean isVeggSager() {
		return veggSager;
	}

	public void setVeggSager(boolean veggSager) {
		this.veggSager = veggSager;
	}


	public boolean isVaierSager() {
		return vaierSager;
	}

	public void setVaierSager(boolean vaierSager) {
		this.vaierSager = vaierSager;
	}

	public boolean isGulvOgAsfaltSag() {
		return gulvOgAsfaltSag;
	}

	public void setGulvOgAsfaltSag(boolean gulvOgAsfaltSag) {
		this.gulvOgAsfaltSag = gulvOgAsfaltSag;
	}

	public boolean isHoytrykkSpyler() {
		return hoytrykkSpyler;
	}

	public void setHoytrykkSpyler(boolean hoytrykkSpyler) {
		this.hoytrykkSpyler = hoytrykkSpyler;
	}

	public boolean isRyddeSagerOgTrimmere() {
		return ryddeSagerOgTrimmere;
	}

	public void setRyddeSagerOgTrimmere(boolean ryddeSagerOgTrimmere) {
		this.ryddeSagerOgTrimmere = ryddeSagerOgTrimmere;
	}

	public boolean isSpunteOgPaleUtstyr() {
		return spunteOgPaleUtstyr;
	}

	public void setSpunteOgPaleUtstyr(boolean spunteOgPaleUtstyr) {
		this.spunteOgPaleUtstyr = spunteOgPaleUtstyr;
	}
	
	public boolean isMobiltBetongPumpeUtstyr() {
		return mobiltBetongPumpeUtstyr;
	}
	
	public void setMobiltBetongPumpeUtstyr(boolean mobiltBetongPumpeUtstyr) {
		this.mobiltBetongPumpeUtstyr = mobiltBetongPumpeUtstyr;
	}

	public boolean isSikkerKontorllAvStillas() {
		return sikkerKontorllAvStillas;
	}

	public void setSikkerKontorllAvStillas(boolean sikkerKontorllAvStillas) {
		this.sikkerKontorllAvStillas = sikkerKontorllAvStillas;
	}

	public boolean isSikkerBrukAvForskaling() {
		return sikkerBrukAvForskaling;
	}
	
	public void setSikkerBrukAvForskaling(boolean sikkerBrukAvForskaling) {
		this.sikkerBrukAvForskaling = sikkerBrukAvForskaling;
	}
	
	public boolean isFallSikkring() {
		return fallSikkring;
	}
	
	public void setFallSikkring(boolean fallSikkring) {
		this.fallSikkring = fallSikkring;
	}
	
	public boolean isForsteHjelp() {
		return forsteHjelp;
	}
	
	public void setForsteHjelp(boolean forsteHjelp) {
		this.forsteHjelp = forsteHjelp;
	}
	
	public boolean isAnnet() {
		return Annet;
	}
	
	public void setAnnet(boolean annet) {
		Annet = annet;
	}
	
	public String getVerksetedLagerTekst() {
		return VerksetedLagerTekst;
	}

	public void setVerksetedLagerTekst(String verksetedLagerTekst) {
		VerksetedLagerTekst = verksetedLagerTekst;
	}
	
	public String getSpesialKranerTekst() {
		return SpesialKranerTekst;
	}

	public void setSpesialKranerTekst(String spesialKranerTekst) {
		SpesialKranerTekst = spesialKranerTekst;
	}
	
	public String getPersonLoftereTekst() {
		return PersonLoftereTekst;
	}

	public void setPersonLoftereTekst(String personLoftereTekst) {
		PersonLoftereTekst = personLoftereTekst;
	}

	public String getForstehjelpDatoTekst() {
		return ForstehjelpDatoTekst;
	}

	public void setForstehjelpDatoTekst(String forstehjelpDatoTekst) {
		ForstehjelpDatoTekst = forstehjelpDatoTekst;
	}

	public String getAnnetTekst() {
		return AnnetTekst;
	}

	public void setAnnetTekst(String annetTekst) {
		AnnetTekst = annetTekst;
	}
	
	public PropertyChangeSupport getPcs() {
		return pcs;
	}
	
	public void setPcs(PropertyChangeSupport pcs) {
		this.pcs = pcs;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

}
