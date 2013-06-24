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
			String createTabel = "CREATE TABLE " + tableName + " (id COUNTER NOT NULL, Navn Text(32), FodselsDato Text(10), IDkortnummer Text(10), PRIMARY KEY (id))";
			try {
				statement.execute(createTabel);				
				System.out.println("tabel createt");
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Tabellen eksisterer allerede eller feil skjedde");
			}

			statement.close();
			connection.close();

			//
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void createPersonalia(String name, String fdato, String idKort) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		Connection connection = DriverManager.getConnection(database,"","");
		Statement statement = connection.createStatement();
		
		preparedStatement = connection.prepareStatement("INSERT INTO Personalia(Navn, FodselsDato, IDkortnummer) VALUES (?, ?, ?)");
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, fdato);
		preparedStatement.setString(3, idKort);
		preparedStatement.execute();
		
		/*String addRow = "INSERT INTO Personalia (Name, FødselsDato, ID-kortnummer) " + "VALUES('" + name + "','" + fdato + "','" + idKort + "')";
		statement.execute(addRow);*/
		
		statement.close();
		connection.close();
		
	}

}
