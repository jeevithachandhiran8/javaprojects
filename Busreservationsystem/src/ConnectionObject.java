import java.sql.*;
public class ConnectionObject {
	

	public static final String url="jdbc:mysql://localhost:3306/busreservationsystem";
	public static final String name="root";
	public static final String password="lunasol";
	
	public static Connection getConnection()throws SQLException
	{
		return DriverManager.getConnection(url,name,password);
	}

}
