package database;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forst�elig
 * Owner Veidekke ASA
 **/


import java.sql.*;

public class DBConnection {
	private java.sql.Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;

	public DBConnection() {
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
//				System.out.println("Tabellen eksisterer allerede eller feil skjedde");
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
			createTabel = "CREATE Table " + tableName + " (id counter not null, F�rerkort BIT, Grunnoppl�ringIArbeidsmilj� BIT, Maskinf�rerbevis BIT, Arbeidsvarslingskurs BIT, VarmeArbeider BIT, TruckKranf�rerBevis BIT, F�rerkortKlasser TEXT(30), Maskinf�rerKlasser TEXT(30), ArbeidsVarslingsKursNr TEXT(30), VarmeArbeiderUtl�pDato TEXT(20), TruckKranBevis TEXT(30), PRIMARY KEY(id))";
			try {
				statement.execute(createTabel);				
				System.out.println("Sertifikat createt");
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

	public void createPersonalia(String name, String fdato, String idKort, String idutlop, String Adresse, String postnr, String poststed, String telefon, String arbeidsgiver, String arbeidsgivertelefon, String nermestepaarorende, String narmesteparorendetelefon) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		Connection connection = DriverManager.getConnection(database,"","");
		Statement statement = connection.createStatement();

		preparedStatement = connection.prepareStatement("INSERT INTO Personalia(Navn, F�dselsDato, IDkortnummer, Utl�psdato_ID_kort, Adresse, PostNr, PostSted, TelefornNr, Arbeidsgiver, ArbeidsgiverTelefon, N�rmesteP�r�rende, N�rmesteP�r�rendeTelefon) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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

		/*String addRow = "INSERT INTO Personalia (Name, F�dselsDato, ID-kortnummer) " + "VALUES('" + name + "','" + fdato + "','" + idKort + "')";
		statement.execute(addRow);*/

		statement.close();
		connection.close();
	}

	public void createSprak(boolean snakker, boolean forstar, String snakkeTiltak, String forstaTiltak) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		Connection connection = DriverManager.getConnection(database,"","");
		Statement statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO Sprak(Snakker, Forstar, SnakkeTiltak, ForstaTiltak) VALUES (?,?,?,?)");
		preparedStatement.setBoolean(1, snakker);
		preparedStatement.setBoolean(2, forstar);
		preparedStatement.setString(3, snakkeTiltak);
		preparedStatement.setString(4, forstaTiltak);
		preparedStatement.execute();

		statement.close();
		connection.close();
	}

	public void createModulEN(boolean gjennomfort, String dato) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		Connection connection = DriverManager.getConnection(database,"","");
		Statement statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO ModulEn(Gjennomf�rt, Dato) VALUES(?,?)");
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
		Connection connection = DriverManager.getConnection(database,"","");
		Statement statement = connection.createStatement();
		preparedStatement = connection.prepareStatement("INSERT INTO Sertifikat(F�rerkort, Grunnoppl�ringIArbeidsmilj�, Maskinf�rerbevis, Arbeidsvarslingskurs, VarmeArbeider, TruckKranf�rerBevis, F�rerkortKlasser, Maskinf�rerKlasser, ArbeidsVarslingsKursNr, VarmeArbeiderUtl�pDato, TruckKranBevis) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
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
}
