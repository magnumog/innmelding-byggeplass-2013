package database;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/


import java.sql.*;

public class DBConnection {
	private java.sql.Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private int id = 0;
	
	public void setID(int nyId) {
		this.id = nyId;
	}

	public DBConnection() {
	}

	public void createPersonalia(String name, String fdato, String idKort, String idutlop, String Adresse, String postnr, String poststed, String telefon, String arbeidsgiver, String arbeidsgivertelefon, String nermestepaarorende, String narmesteparorendetelefon) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();

		preparedStatement = connection.prepareStatement("INSERT INTO Personalia(Navn, FødselsDato, IDkortnummer, Utløpsdato_ID_kort, Adresse, PostNr, PostSted, TelefornNr, Arbeidsgiver, ArbeidsgiverTelefon, NærmestePårørende, NærmestePårørendeTelefon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, fdato);
		preparedStatement.setString(3, idKort);
		preparedStatement.setString(4, idutlop);
		preparedStatement.setString(5, Adresse);
		preparedStatement.setString(6, postnr);
		preparedStatement.setString(7, poststed);
		preparedStatement.setString(8, telefon);
		preparedStatement.setString(9, arbeidsgiver);
		preparedStatement.setString(10, arbeidsgivertelefon);
		preparedStatement.setString(11, nermestepaarorende);
		preparedStatement.setString(12, narmesteparorendetelefon);
		preparedStatement.execute();

		/*String addRow = "INSERT INTO Personalia (Name, FødselsDato, ID-kortnummer) " + "VALUES('" + name + "','" + fdato + "','" + idKort + "')";
		statement.execute(addRow);*/

		statement.close();
		connection.close();
	}

	public void createSprak(boolean snakker, boolean forstar, String snakkeTiltak, String forstaTiltak) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO Sprak(Snakker, Forstar, SnakkeTiltak, ForstaTiltak) VALUES (?,?,?,?)");
		preparedStatement.setBoolean(1, snakker);
		preparedStatement.setBoolean(2, forstar);
		preparedStatement.setString(3, snakkeTiltak);
		preparedStatement.setString(4, forstaTiltak);
		preparedStatement.execute();

		statement.close();
		connection.close();
		
		System.out.println("Idnr: " + id);
	}

	public void createModulEN(boolean gjennomfort, String dato) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO ModulEn(Gjennomført, Dato) VALUES(?,?)");
		preparedStatement.setBoolean(1, gjennomfort);
		preparedStatement.setString(2, dato);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}

	public void createSertifikat(boolean forerkort, boolean grunnopplaring, boolean maskin, boolean arbeidsvarsling, boolean varme, boolean trukKran, String forerKlasser, String  maskinKlasser, String arbeidsVarslingKurs, String varmeArbeiderDato, String truckKranBevis) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO Sertifikat(Førerkort, GrunnopplæringIArbeidsmiljø, Maskinførerbevis, Arbeidsvarslingskurs, VarmeArbeider, TruckKranførerBevis, FørerkortKlasser, MaskinførerKlasser, ArbeidsVarslingsKursNr, VarmeArbeiderUtløpDato, TruckKranBevis) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setBoolean(1, forerkort);
		preparedStatement.setBoolean(2, grunnopplaring);
		preparedStatement.setBoolean(3, maskin);
		preparedStatement.setBoolean(4, arbeidsvarsling);
		preparedStatement.setBoolean(5, varme);
		preparedStatement.setBoolean(6, trukKran);
		preparedStatement.setString(7, forerKlasser);
		preparedStatement.setString(8, maskinKlasser);
		preparedStatement.setString(9, arbeidsVarslingKurs);
		preparedStatement.setString(10, varmeArbeiderDato);
		preparedStatement.setString(11, truckKranBevis);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}
	
	public void createKurs(boolean verksted, String verksteTekst, boolean speskran, String speskranTekst, boolean vinsjer, boolean anhuk, boolean klatreHenge, boolean perslofter, String personlofterTekst, boolean personUnderJord, boolean borvognerTunnel, boolean selvgandeValse, boolean traktorUts, boolean vinkelsliper, boolean boltepistol, boolean spikerpistol, boolean kobihammer, boolean kjedesag, boolean kappKlyveGjerde, boolean bindeMaskin, boolean vibrostav, boolean handholdtArmerinKap, boolean skjarebrenner, boolean sponbrytende, boolean slipemaskin, boolean trebearbeidng, boolean asfaltarbeider, boolean betonsgerKjernebor, boolean veggsager, boolean vaiersag, boolean gulvSagAsfaltSag, boolean hoytrykk, boolean ryddesag, boolean spuntePæleutstyr, boolean mobilBetong, boolean sikkerStilas, boolean sikkerForskaling, boolean fallsikring, boolean forestehjelp, String forstehjelpDato, boolean annet, String annetTekst) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO Kurs(VerksetdOgLager, VerkstedOgLagerType, SpesialKraner, SpesialKranerType, VinsjerOgTaljer, AnhukingStroppingSignalgiving, KlatreOgHengeStilaser, PersonLøftere, PersonløftereKlasse, PersonløfterUnderJord, BorVognerOgTunnelrigger, "+
				"SelvgåendeValser, TraktorUtstyr, vinkelsliper, BoltePistol, Spikerpistol, KombihammerBorHammer, Kjedesag, KappKlyveGjerdeSag, BindeMaskinArmering, Vibrostav, HåndholdtArmeringsKapper, Skjærebrenner, Sponbrytende, SlipeMaskiner, Trebearbeidingsmaskiner, Asfaltarbeider, BetongsagerKjerneboringsutstyr, " +
				"Veggsager, Vaiersager, GulvsagOgAsfaltSag, HøytrykkSpylerutstyr, RyddesagerOgTrimmere, SpunteOgPæleutstyr, MobiltBetongpumpeutstyr, SikkerBrukKontollAvStillas, SikkerBrukAvForskaling, Fallsikringutstyr, Førstehjelpskurs, FørstehjelskursDato, Annet, AnnetBeskrivels) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setBoolean(1, verksted);
		preparedStatement.setString(2, verksteTekst);
		preparedStatement.setBoolean(3, speskran);
		preparedStatement.setString(4, speskranTekst);
		preparedStatement.setBoolean(5, vinsjer);
		preparedStatement.setBoolean(6, anhuk);
		preparedStatement.setBoolean(7, klatreHenge);
		preparedStatement.setBoolean(8, perslofter);
		preparedStatement.setString(9, personlofterTekst);
		preparedStatement.setBoolean(10, personUnderJord);
		preparedStatement.setBoolean(11, borvognerTunnel);
		preparedStatement.setBoolean(12, selvgandeValse);
		preparedStatement.setBoolean(13, traktorUts);
		preparedStatement.setBoolean(14, vinkelsliper);
		preparedStatement.setBoolean(15, boltepistol);
		preparedStatement.setBoolean(16, spikerpistol);
		preparedStatement.setBoolean(17, kobihammer);
		preparedStatement.setBoolean(18, kjedesag);
		preparedStatement.setBoolean(19, kappKlyveGjerde);
		preparedStatement.setBoolean(20, bindeMaskin);
		preparedStatement.setBoolean(21, vibrostav);
		preparedStatement.setBoolean(22, handholdtArmerinKap);
		preparedStatement.setBoolean(23, skjarebrenner);
		preparedStatement.setBoolean(24, sponbrytende);
		preparedStatement.setBoolean(25, slipemaskin);
		preparedStatement.setBoolean(26, trebearbeidng);
		preparedStatement.setBoolean(27, asfaltarbeider);
		preparedStatement.setBoolean(28, betonsgerKjernebor);
		preparedStatement.setBoolean(29, veggsager);
		preparedStatement.setBoolean(30, vaiersag);
		preparedStatement.setBoolean(31, gulvSagAsfaltSag);
		preparedStatement.setBoolean(32, hoytrykk);
		preparedStatement.setBoolean(33, ryddesag);
		preparedStatement.setBoolean(34, spuntePæleutstyr);
		preparedStatement.setBoolean(35, mobilBetong);
		preparedStatement.setBoolean(36, sikkerStilas);
		preparedStatement.setBoolean(37, sikkerForskaling);
		preparedStatement.setBoolean(38, fallsikring);
		preparedStatement.setBoolean(39, forestehjelp);
		preparedStatement.setString(40, forstehjelpDato);
		preparedStatement.setBoolean(41, annet);
		preparedStatement.setString(42, annetTekst);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}
	
	public void createVerneutstyr(boolean pabudt, boolean tilgjengelig, String dato, String arbeidsgivernavn) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO VerneUtstyr(Påbudtverneutstyr, Tilgjengeligverneutstyr, Dato, ArbeidsGiverUnderskrift) VALUES(?,?,?,?)");
		preparedStatement.setBoolean(1, pabudt);
		preparedStatement.setBoolean(2, tilgjengelig);
		preparedStatement.setString(3, dato);
		preparedStatement.setString(4, arbeidsgivernavn);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}
	
	public void createModulTo(boolean fravar, boolean sikkerhet, boolean gjennomfortModulTo, boolean klistremerkeModulEn, boolean reaksjonsmonster, boolean avviksblokk, boolean shaplan) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO ModulTo(infoOmFravær, SkrevetunderSikkerhetsinstruks, GjennomførtModulTo, KlistremerkeModulEn, ForstårVeidekkesReaksjon, UtdeltblokkOgRisikovurdering, KjentMedSHA_Plan) VALUES(?,?,?,?,?,?,?)");
		preparedStatement.setBoolean(1, fravar);
		preparedStatement.setBoolean(2, sikkerhet);
		preparedStatement.setBoolean(3, gjennomfortModulTo);
		preparedStatement.setBoolean(4, klistremerkeModulEn);
		preparedStatement.setBoolean(5, reaksjonsmonster);
		preparedStatement.setBoolean(6, avviksblokk);
		preparedStatement.setBoolean(7, shaplan);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}
}
