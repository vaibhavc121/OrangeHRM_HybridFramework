package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtility
{

	private DatabaseUtility()
	{

	}

//		Add the below dependency in the project-
//		https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/9.0.0

//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "vaibhav");

//		if (connection.isClosed())
//		{
//			System.out.println("we have not connected to the db");
//		}
//		else
//		{
//			System.out.println("we have successfully connected to the db");
//		}

	// Database connection details
	private static final String URL = "jdbc:mysql://localhost:3306/enfinity"; // Replace with your DB URL
	private static final String USER = "root"; // Replace with your DB username
	private static final String PASSWORD = "vaibhav"; // Replace with your DB password

	public static Connection getConnection() throws Exception
	{
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}

	public static ResultSet getTestData(String query) throws Exception
	{
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(query);
	}

	public static void closeConnection(Connection conn) throws Exception
	{
		if (conn != null)
		{
			conn.close();
		}
	}

}
