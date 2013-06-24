package database;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/


import java.sql.*;

import modell.Personalia;

public class DBConnection {
	private java.sql.Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;	
	private ResultSet resultSet = null;
	public DBConnection() {
		try{


			//Denne funker
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
			Connection connection = DriverManager.getConnection(database,"","");
			Statement statement = connection.createStatement();

			System.out.println("Connected");
			
			createTable();


			//		insert into tabellen
			/*for(int i=0;i<25;i++) {
				String addRow = "INSERT INTO " + tableName + " (Name) " + "VALUES('" + Integer.toString(i) + "')";
				statement.execute(addRow);
			}

			System.out.println("Rader lagt inn i tabellene");*/

			statement.close();
			connection.close();

			//
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createTable() {
		//Create a table
		//Dette funker ikke helt ennå
		String tableName="Personalia";
		String createTabel = "CREATE TABLE " + tableName + " (id COUNTER NOT NULL, Name Text(32), PRIMARY KEY (id))";
		try {
			statement.execute(createTabel);				
			System.out.println("tabel createt");
		} catch(Exception e) {
			System.out.println("Tabellen eksisterer allerede");
		}
	}

	public void createPersonalia(String name) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
		String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
		Connection connection = DriverManager.getConnection(database,"","");
		Statement statement = connection.createStatement();
		
		String addRow = "INSERT INTO Personalia (Name) " + "VALUES('" + name + "')";
		statement.execute(addRow);
		
		statement.close();
		connection.close();
		
	}

}
