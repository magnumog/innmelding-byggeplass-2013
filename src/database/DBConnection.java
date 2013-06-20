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
	private String url;
	
	public DBConnection(String url) {
		this.url = url;
	}
	
	public boolean connect() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:dsn", "","");
			statement = connection.createStatement();
			if(connection != null) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void colseConnection() {
		try{
			if(connection != null) {
				connection.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
