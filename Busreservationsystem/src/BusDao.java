import java.sql.*;
public class BusDao {
	
	
	public void displayBusInfo()throws SQLException
	{
		String query="select * from bus";
		Connection con=ConnectionObject.getConnection();
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("BUS DETAILS");
		System.out.println("----------------------------------");
		while(rs.next())
		{
			System.out.println("BUS NO : "+rs.getInt(1));
			System.out.println("totalCapacity: "+rs.getInt(2));
			System.out.println("availableSeats: "+rs.getInt(3));
			System.out.println("----------------------------------");
			System.out.println();
			
		}
		
	}
	
	public int getAvailable(int busNo)throws SQLException
	{
		
		
		String query="select availableseats from bus where busno= ?";
		Connection con=ConnectionObject.getConnection();
		
		PreparedStatement ps=con.prepareStatement(query);
		
		 ps.setInt(1, busNo);

		    ResultSet rs = ps.executeQuery();

		    int available = 0;

		    if (rs.next()) {
		        available = rs.getInt("availableseats"); // ✅ FIX
		    }

		    rs.close();
		    ps.close();
		    con.close();

		    return available;
		
		
		
	}
	
	public boolean checkBusno(int busNo)throws SQLException
	{
		String queryBus="select busno from bus where busno= ?";
		Connection con=ConnectionObject.getConnection();
		
		
		
		PreparedStatement ps=con.prepareStatement(queryBus);
		ps.setInt(1, busNo);
		
		ResultSet rs=ps.executeQuery();
		
		boolean exists=rs.next();
		
		ps.close();
		rs.close();
		con.close();
		
		return exists;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
