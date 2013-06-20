package database;
/**
 * @author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 **/

import java.sql.*;

public class DBAccess {
	public static void main(String[] args) {
		try{
			//Denne funker
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String filename = "C:/workspace/innmelding-byggeplass-2013/src/database/elektroniskInnmelding.mdb";
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + filename;
			Connection connection = DriverManager.getConnection(database,"","");
			Statement statement = connection.createStatement();
			
			System.out.println("Connected");
			
			//Create a table
			//Dette funker ikke helt ennå
			String tableName="Personalia";
			String createTabel = "CREATE TABLE " + tableName + " (id INTEGER Not null AUTO_INCREMENT, Name Text(32), PRIMARY KEY (id))";
			try {
				statement.execute(createTabel);				
				System.out.println("tabel createt");
			} catch(Exception e) {
				System.out.println("Tabellen eksisterer allerede");
			}
			
			
			//insert into tabellen
//			for(int i=0;i<25;i++) {
//				String addRow = "INSERT INTO " + tableName + " VALUES ( " + String.valueOf((int) (Math.random() * 32767)) + ", 'Text Value " + String.valueOf(Math.random()) + "')";
//				statement.execute(addRow);
//			}
			
			System.out.println("Rader lagt inn i tabellene");
			
			statement.close();
			connection.close();
			
			//
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}
