package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
    private static String DATABASE = "melefi_db";
    private static String USER = "root";
    private static String PASSWORD = "root";
    
	public static Connection open() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection	=	DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/" + DATABASE + "?user=" + USER + "&password=" + PASSWORD
							);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
