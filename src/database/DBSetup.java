package database;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/

import java.sql.DriverManager;
import java.sql.Statement;

public class DBSetup {
	private java.sql.Connection connection = null;
	private Statement statement = null;
	
	public DBSetup() {
		try{
			//Denne funker
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
			connection = DriverManager.getConnection(database,"","");
			statement = connection.createStatement();

			System.out.println("Connected");

			//Create a table
			String tableName="Personalia";
			String createTabel = "CREATE TABLE " + tableName + " (id Integer, Navn Text(32), FødselsDato Text(10), IDkortnummer Text(10), Utløpsdato_ID_kort Text(10), Adresse Text(30), PostNr Text(8), PostSted Text(25), TelefornNr Text(15), Arbeidsgiver Text(20), ArbeidsgiverTelefon Text(20), NærmestePårørende Text(35), NærmestePårørendeTelefon Text(20), PRIMARY KEY (id))";
			try {
				statement.execute(createTabel);				
				System.out.println("Personalia createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("Personalia eksisterer allerede eller feil skjedde");
			}

			tableName = "Sprak";
			createTabel = "CREATE TABLE " + tableName + " (id Integer, Snakker BIT, Forstar BIT, SnakkeTiltak Text(50), ForstaTiltak Text(50), Primary key (id))";
			try {
				statement.execute(createTabel);				
				System.out.println("sprak createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("sprak eksisterer allerede eller feil skjedde");
			}

			tableName = "ModulEn";
			createTabel = "CREATE TABLE " + tableName + " (id Integer, Gjennomført BIT, Dato Text(10), Primary key(id))";
			try {
				statement.execute(createTabel);				
				System.out.println("ModulEn createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("ModulEn eksisterer allerede eller feil skjedde");
			}
			
			tableName = "Sertifikat";
			createTabel = "CREATE TABLE " + tableName + " (id Integer, Førerkort BIT, GrunnopplæringIArbeidsmiljø BIT, Maskinførerbevis BIT, Arbeidsvarslingskurs BIT, VarmeArbeider BIT, TruckKranførerBevis BIT, FørerkortKlasser TEXT(30), MaskinførerKlasser TEXT(30), ArbeidsVarslingsKursNr TEXT(30), VarmeArbeiderUtløpDato TEXT(20), TruckKranBevis TEXT(30), PRIMARY KEY(id))";
			try {
				statement.execute(createTabel);				
				System.out.println("Sertifikat createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("Sertifikat eksisterer allerede eller feil skjedde");
			}
			
			tableName = "Kurs";
			createTabel = "CREATE TABLE " + tableName + " (id Integer, VerksetdOgLager BIT, VerkstedOgLagerType Text(30), SpesialKraner BIT, SpesialKranerType TEXT(30), VinsjerOgTaljer BIT, AnhukingStroppingSignalgiving BIT, KlatreOgHengeStilaser BIT, PersonLøftere BIT, PersonløftereKlasse TEXT(30), " +
					"PersonløfterUnderJord BIT, BorVognerOgTunnelrigger BIT, SelvgåendeValser BIT, TraktorUtstyr BIT, vinkelsliper BIT, BoltePistol BIT, Spikerpistol BIT, KombihammerBorHammer BIT, Kjedesag BIT, KappKlyveGjerdeSag BIT, BindeMaskinArmering BIT, Vibrostav BIT, HåndholdtArmeringsKapper BIT, Skjærebrenner BIT, Sponbrytende BIT, " +
					"SlipeMaskiner BIT, Trebearbeidingsmaskiner BIT, Asfaltarbeider BIT, BetongsagerKjerneboringsutstyr BIT, Veggsager BIT, Vaiersager BIT, GulvsagOgAsfaltSag BIT, HøytrykkSpylerutstyr BIT, RyddesagerOgTrimmere BIT, SpunteOgPæleutstyr BIT, MobiltBetongpumpeutstyr BIT, SikkerBrukKontollAvStillas BIT, " +
					"SikkerBrukAvForskaling BIT, Fallsikringutstyr BIT, Førstehjelpskurs BIT, FørstehjelskursDato Text(12), Annet BIT, AnnetBeskrivels Text(120), PRIMARY KEY(id))";
			try {
				statement.execute(createTabel);
				System.out.println("Kurs createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("Kurs eksisterer allerede eller feil skjedde");
			}
			
			tableName = "VerneUtstyr";
			createTabel = "CREATE TABLE " + tableName +  " (id Integer, Påbudtverneutstyr BIT, Tilgjengeligverneutstyr BIT, Dato Text(10), ArbeidsGiverUnderskrift Text(45), PRIMARY KEY(id))";
			try {
				statement.execute(createTabel);
				System.out.println("verneutstyr createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("verneutstyr eksisterer allerede eller feil skjedde");
			}
			
			tableName = "ModulTo";
			createTabel = "CREATE TABLE " + tableName + " (id Integer, infoOmFravær BIT, SkrevetunderSikkerhetsinstruks BIT, GjennomførtModulTo BIT, KlistremerkeModulEn BIT, ForstårVeidekkesReaksjon BIT, UtdeltblokkOgRisikovurdering BIT, KjentMedSHA_Plan BIT, PRIMARY KEY(id))";
			try {
				statement.execute(createTabel);
				System.out.println("ModulTo createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("ModulTo eksisterer allerede eller feil skjedde");
			}		

			//Gjør klar til versjon2 av programet
//			tableName = "PostNr";
//			createTabel = "CREATE TABLE " + tableName + " (PostNr Text(8), PostSted Text(25), Primary Key(PostNr))";
//			try {
//				statement.execute(createTabel);				
//				System.out.println("PostNr createt");
//			} catch(Exception e) {
//				e.printStackTrace();
//				System.out.println("Tabellen eksisterer allerede eller feil skjedde");
//			}

			statement.close();
			connection.close();
			System.out.println("Connection closed");

			//
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
