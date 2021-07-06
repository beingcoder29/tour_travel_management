package utilities;

import java.sql.*;

public class ConnectionFactory {
	Connection cn=null;
	
	public Connection getConn()
	{
		try
		{
		
	
		 Class.forName("com.mysql.jdbc.Driver");
          cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/tms","root","admin");
        
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return cn;
	}
}
