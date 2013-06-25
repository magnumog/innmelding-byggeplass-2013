package database;

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
			String createTabel = "CREATE TABLE " + tableName + " (id COUNTER NOT NULL, Navn Text(32), F�dselsDato Text(10), IDkortnummer Text(10), Utl�psdato_ID_kort Text(10), Adresse Text(30), PostNr Text(8), PostSted Text(25), TelefornNr Text(15), Arbeidsgiver Text(20), ArbeidsgiverTelefon Text(20), N�rmesteP�r�rende Text(35), N�rmesteP�r�rendeTelefon Text(20), PRIMARY KEY (id))";
			try {
				statement.execute(createTabel);				
				System.out.println("Personalia createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("Tabellen eksisterer allerede eller feil skjedde");
			}

			tableName = "Sprak";
			createTabel = "CREATE TABLE " + tableName + " (id COUNTER NOT NULL, Snakker BIT, Forstar BIT, SnakkeTiltak Text(50), ForstaTiltak Text(50), Primary key (id))";
			try {
				statement.execute(createTabel);				
				System.out.println("sprak createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("Tabellen eksisterer allerede eller feil skjedde");
			}

			tableName = "ModulEn";
			createTabel = "CREATE TABLE " + tableName + " (id counter not null, Gjennomf�rt BIT, Dato Text(10), Primary key(id))";
			try {
				statement.execute(createTabel);				
				System.out.println("ModulEn createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("Tabellen eksisterer allerede eller feil skjedde");
			}
			
			tableName = "Sertifikat";
			createTabel = "CREATE TABLE " + tableName + " (id counter not null, F�rerkort BIT, Grunnoppl�ringIArbeidsmilj� BIT, Maskinf�rerbevis BIT, Arbeidsvarslingskurs BIT, VarmeArbeider BIT, TruckKranf�rerBevis BIT, F�rerkortKlasser TEXT(30), Maskinf�rerKlasser TEXT(30), ArbeidsVarslingsKursNr TEXT(30), VarmeArbeiderUtl�pDato TEXT(20), TruckKranBevis TEXT(30), PRIMARY KEY(id))";
			try {
				statement.execute(createTabel);				
				System.out.println("Sertifikat createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("Tabellen eksisterer allerede eller feil skjedde");
			}
			
			tableName = "Kurs";
			createTabel = "CREATE TABLE " + tableName + " (id counter not null, VerksetdOgLager BIT, VerkstedOgLagerType Text(30), SpesialKraner BIT, SpesialKranerType TEXT(30), VinsjerOgTaljer BIT, AnhukingStroppingSignalgiving BIT, KlatreOgHengeStilaser BIT, PersonL�ftere BIT, Personl�ftereKlasse TEXT(30), " +
					"Personl�fterUnderJord BIT, BorVognerOgTunnelrigger BIT, Selvg�endeValser BIT, TraktorUtstyr BIT, BoltePistol BIT, Spikerpistol BIT, KombihammerBorHammer BIT, Kjedesag BIT, KappKlyveGjerdeSag BIT, BindeMaskinArmering BIT, Vibrostav BIT, H�ndholdtArmeringsKapper BIT, Sk�rebrenner BIT, Sponbrytende BIT, " +
					"SlipeMaskiner BIT, Trebearbeidingsmaskiner BIT, Asfaltarbeider BIT, BetongsagerKjerneboringsutstyr BIT, Veggsager BIT, Vaiersager BIT, GulvsagOgAsfaltSag BIT, H�ytrykkSpylerutstyr BIT, RyddesagerOgTrimmere BIT, SpunteOgP�leutstyr BIT, MobiltBetongpumpeutstyr BIT, SikkerBrukKontollAvStillas BIT, " +
					"SikkerBrukAvForskaling BIT, Fallsikringutstyr BIT, F�rstehjelpskurs BIT, F�rstehjelskursDato Text(12), Annet BIT, AnnetBeskrivels Text(120), PRIMARY KEY(id))";
			try {
				statement.execute(createTabel);
				System.out.println("Kurs createt");
			} catch(Exception e) {
//				e.printStackTrace();
				System.out.println("Tabellen eksisterer allerede eller feil skjedde");
			}
					

			//Gj�r klar til versjon2 av programet
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