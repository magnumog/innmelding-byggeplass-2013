package database;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/


import java.sql.*;

public class DBConnection {
	private static java.sql.Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	public static int id = 0;
	
	public static void setID(int nyId) {
		id = nyId;
	}

	public DBConnection() {
	}

	public static void createPersonalia(String id, String name, String fdato, String idKort, String idutlop, String Adresse, String postnr, String poststed, String telefon, String arbeidsgiver, String arbeidsgivertelefon, String nermestepaarorende, String narmesteparorendetelefon) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();

		preparedStatement = connection.prepareStatement("INSERT INTO Personalia(id, Navn, FødselsDato, IDkortnummer, Utløpsdato_ID_kort, Adresse, PostNr, PostSted, TelefornNr, Arbeidsgiver, ArbeidsgiverTelefon, NærmestePårørende, NærmestePårørendeTelefon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		preparedStatement.setInt(1,Integer.parseInt(id));
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, fdato);
		preparedStatement.setString(4, idKort);
		preparedStatement.setString(5, idutlop);
		preparedStatement.setString(6, Adresse);
		preparedStatement.setString(7, postnr);
		preparedStatement.setString(8, poststed);
		preparedStatement.setString(9, telefon);
		preparedStatement.setString(10, arbeidsgiver);
		preparedStatement.setString(11, arbeidsgivertelefon);
		preparedStatement.setString(12, nermestepaarorende);
		preparedStatement.setString(13, narmesteparorendetelefon);
		preparedStatement.execute();
		System.out.println(id);

		/*String addRow = "INSERT INTO Personalia (Name, FødselsDato, ID-kortnummer) " + "VALUES('" + name + "','" + fdato + "','" + idKort + "')";
		statement.execute(addRow);*/

		statement.close();
		connection.close();
	}

	public static void createSprak(String id, boolean snakker, boolean forstar, String snakkeTiltak, String forstaTiltak) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO Sprak(id, Snakker, Forstar, SnakkeTiltak, ForstaTiltak) VALUES (?,?,?,?,?)");
		preparedStatement.setInt(1, Integer.parseInt(id));
		preparedStatement.setBoolean(2, snakker);
		preparedStatement.setBoolean(3, forstar);
		preparedStatement.setString(4, snakkeTiltak);
		preparedStatement.setString(5, forstaTiltak);
		preparedStatement.execute();

		statement.close();
		connection.close();
		
		System.out.println("Idnr: " + id);
	}

	public static void createModulEN(boolean gjennomfort, String dato) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO ModulEn(id, Gjennomført, Dato) VALUES(?,?,?)");
		System.out.println("" + id + gjennomfort + dato);
		preparedStatement.setInt(1, id);
		preparedStatement.setBoolean(2, gjennomfort);
		preparedStatement.setString(3, dato);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}

	public static void createSertifikat(boolean forerkort, boolean grunnopplaring, boolean maskin, boolean arbeidsvarsling, boolean varme, boolean trukKran, String forerKlasser, String  maskinKlasser, String arbeidsVarslingKurs, String varmeArbeiderDato, String truckKranBevis) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO Sertifikat(id, Førerkort, GrunnopplæringIArbeidsmiljø, Maskinførerbevis, Arbeidsvarslingskurs, VarmeArbeider, TruckKranførerBevis, FørerkortKlasser, MaskinførerKlasser, ArbeidsVarslingsKursNr, VarmeArbeiderUtløpDato, TruckKranBevis) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setBoolean(2, forerkort);
		preparedStatement.setBoolean(3, grunnopplaring);
		preparedStatement.setBoolean(4, maskin);
		preparedStatement.setBoolean(5, arbeidsvarsling);
		preparedStatement.setBoolean(6, varme);
		preparedStatement.setBoolean(7, trukKran);
		preparedStatement.setString(8, forerKlasser);
		preparedStatement.setString(9, maskinKlasser);
		preparedStatement.setString(10, arbeidsVarslingKurs);
		preparedStatement.setString(11, varmeArbeiderDato);
		preparedStatement.setString(12, truckKranBevis);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}
	
	public static void createKurs(boolean verksted, String verksteTekst, boolean speskran, String speskranTekst, boolean vinsjer, boolean anhuk, boolean klatreHenge, boolean perslofter, String personlofterTekst, boolean personUnderJord, boolean borvognerTunnel, boolean selvgandeValse, boolean traktorUts, boolean vinkelsliper, boolean boltepistol, boolean spikerpistol, boolean kobihammer, boolean kjedesag, boolean kappKlyveGjerde, boolean bindeMaskin, boolean vibrostav, boolean handholdtArmerinKap, boolean skjarebrenner, boolean sponbrytende, boolean slipemaskin, boolean trebearbeidng, boolean asfaltarbeider, boolean betonsgerKjernebor, boolean veggsager, boolean vaiersag, boolean gulvSagAsfaltSag, boolean hoytrykk, boolean ryddesag, boolean spuntePæleutstyr, boolean mobilBetong, boolean sikkerStilas, boolean sikkerForskaling, boolean fallsikring, boolean forestehjelp, String forstehjelpDato, boolean annet, String annetTekst) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO Kurs(id, VerksetdOgLager, VerkstedOgLagerType, SpesialKraner, SpesialKranerType, VinsjerOgTaljer, AnhukingStroppingSignalgiving, KlatreOgHengeStilaser, PersonLøftere, PersonløftereKlasse, PersonløfterUnderJord, BorVognerOgTunnelrigger, "+
				"SelvgåendeValser, TraktorUtstyr, vinkelsliper, BoltePistol, Spikerpistol, KombihammerBorHammer, Kjedesag, KappKlyveGjerdeSag, BindeMaskinArmering, Vibrostav, HåndholdtArmeringsKapper, Skjærebrenner, Sponbrytende, SlipeMaskiner, Trebearbeidingsmaskiner, Asfaltarbeider, BetongsagerKjerneboringsutstyr, " +
				"Veggsager, Vaiersager, GulvsagOgAsfaltSag, HøytrykkSpylerutstyr, RyddesagerOgTrimmere, SpunteOgPæleutstyr, MobiltBetongpumpeutstyr, SikkerBrukKontollAvStillas, SikkerBrukAvForskaling, Fallsikringutstyr, Førstehjelpskurs, FørstehjelskursDato, Annet, AnnetBeskrivels) " +
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1,id);
		preparedStatement.setBoolean(2, verksted);
		preparedStatement.setString(3, verksteTekst);
		preparedStatement.setBoolean(4, speskran);
		preparedStatement.setString(5, speskranTekst);
		preparedStatement.setBoolean(6, vinsjer);
		preparedStatement.setBoolean(7, anhuk);
		preparedStatement.setBoolean(8, klatreHenge);
		preparedStatement.setBoolean(9, perslofter);
		preparedStatement.setString(10, personlofterTekst);
		preparedStatement.setBoolean(11, personUnderJord);
		preparedStatement.setBoolean(12, borvognerTunnel);
		preparedStatement.setBoolean(13, selvgandeValse);
		preparedStatement.setBoolean(14, traktorUts);
		preparedStatement.setBoolean(15, vinkelsliper);
		preparedStatement.setBoolean(16, boltepistol);
		preparedStatement.setBoolean(17, spikerpistol);
		preparedStatement.setBoolean(18, kobihammer);
		preparedStatement.setBoolean(19, kjedesag);
		preparedStatement.setBoolean(20, kappKlyveGjerde);
		preparedStatement.setBoolean(21, bindeMaskin);
		preparedStatement.setBoolean(22, vibrostav);
		preparedStatement.setBoolean(23, handholdtArmerinKap);
		preparedStatement.setBoolean(24, skjarebrenner);
		preparedStatement.setBoolean(25, sponbrytende);
		preparedStatement.setBoolean(26, slipemaskin);
		preparedStatement.setBoolean(27, trebearbeidng);
		preparedStatement.setBoolean(28, asfaltarbeider);
		preparedStatement.setBoolean(29, betonsgerKjernebor);
		preparedStatement.setBoolean(30, veggsager);
		preparedStatement.setBoolean(31, vaiersag);
		preparedStatement.setBoolean(32, gulvSagAsfaltSag);
		preparedStatement.setBoolean(33, hoytrykk);
		preparedStatement.setBoolean(34, ryddesag);
		preparedStatement.setBoolean(35, spuntePæleutstyr);
		preparedStatement.setBoolean(36, mobilBetong);
		preparedStatement.setBoolean(37, sikkerStilas);
		preparedStatement.setBoolean(38, sikkerForskaling);
		preparedStatement.setBoolean(39, fallsikring);
		preparedStatement.setBoolean(40, forestehjelp);
		preparedStatement.setString(41, forstehjelpDato);
		preparedStatement.setBoolean(42, annet);
		preparedStatement.setString(43, annetTekst);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}
	
	public static void createVerneutstyr(boolean pabudt, boolean tilgjengelig, String dato, String arbeidsgivernavn) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO VerneUtstyr(id, Påbudtverneutstyr, Tilgjengeligverneutstyr, Dato, ArbeidsGiverUnderskrift) VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setBoolean(2, pabudt);
		preparedStatement.setBoolean(3, tilgjengelig);
		preparedStatement.setString(4, dato);
		preparedStatement.setString(5, arbeidsgivernavn);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}
	
	public static void createModulTo(boolean fravar, boolean sikkerhet, boolean gjennomfortModulTo, boolean klistremerkeModulEn, boolean reaksjonsmonster, boolean avviksblokk, boolean shaplan) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		connection = DriverManager.getConnection(database,"","");
		statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO ModulTo(id, infoOmFravær, SkrevetunderSikkerhetsinstruks, GjennomførtModulTo, KlistremerkeModulEn, ForstårVeidekkesReaksjon, UtdeltblokkOgRisikovurdering, KjentMedSHA_Plan) VALUES(?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setBoolean(2, fravar);
		preparedStatement.setBoolean(3, sikkerhet);
		preparedStatement.setBoolean(4, gjennomfortModulTo);
		preparedStatement.setBoolean(5, klistremerkeModulEn);
		preparedStatement.setBoolean(6, reaksjonsmonster);
		preparedStatement.setBoolean(7, avviksblokk);
		preparedStatement.setBoolean(8, shaplan);
		preparedStatement.execute();
		
		statement.close();
		connection.close();
	}
}
