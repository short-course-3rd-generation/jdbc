package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.dto.Expert;

public class Database {
	
	private static final String DB_URL="jdbc:postgresql://127.0.0.1:5000/EXPERT"; 
	
	private Database() {}
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("org.postgresql.Driver");
			Properties p=new Properties();
			p.put("user", "postgres");
			p.put("password", "123");
			conn =DriverManager.getConnection(DB_URL,p);
			
			System.out.println("connection success!!!");
		}catch(SQLException e) {
			System.out.println("connection fialure");
			e.printStackTrace();
		}catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}catch(Exception ee) {
			System.out.println("connection fialure");
			ee.printStackTrace();
		}
		return conn;
	}

}
