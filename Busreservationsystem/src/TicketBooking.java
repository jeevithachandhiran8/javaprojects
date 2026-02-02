import java.util.*;
import java.sql.*;
public class TicketBooking
{
	Scanner sc=new Scanner(System.in);
	
	void booking()throws SQLException
	{ 
		BusDao bd=new BusDao();
		Connection con=ConnectionObject.getConnection();
		con.setAutoCommit(false);
		int bn=0;
		int seat =0;

		
			System.out.println("Enter bus no:");
		     bn = sc.nextInt();
		    if(bd.checkBusno(bn))
		    {
		    	System.out.println("Seats required:");
		    	seat = sc.nextInt();
		    	
		    }
		    else
		    {
		    	System.out.println("BusNumber is invalid ,kindly check BusNumber");
		    	return;
		    	
		    }
		    		

   
	    sc.nextLine(); 
	    

		System.out.println("Enter your name:");
	    String name = sc.nextLine();
	    
   
	    
	    int available=bd.getAvailable(bn);
	    
	    if(seat <= available)
	    {
	    	System.out.println("Confirm your booking YES/NO:");
            String c = sc.nextLine();
            
            if(c.equalsIgnoreCase("yes"))
            {
            	try
            	{
            		PreparedStatement ps=con.prepareStatement("INSERT INTO passenger (name, busno, bookedseats) VALUES (?,?,?)");
                    
                	ps.setString(1,name);
                	ps.setInt(2,bn);
                	ps.setInt(3,seat);
                	ps.executeUpdate();
                	
                	PreparedStatement ps2=con.prepareStatement("update bus set availableseats=availableseats-? where busno=?");
                	ps2.setInt(1, seat);
                	ps2.setInt(2, bn);
                	ps2.executeUpdate();
                	
                	con.commit();
                	System.out.println("Ticket booked successfully!");


                	 ps.close();
                	 ps2.close();
            		
            	}
            	catch(Exception e)
            	{
            		con.rollback();
                    System.out.println("Booking failed. Transaction rolled back.");
            	}
            	
            	
            }
            else
            {
            	con.rollback();
            	System.out.println("Booking cancelled");
            	
            }
	    }
	    else
	    {
	    	System.out.println("\n Available seats :"+available+"\n seat is not available please try another bus");
         	return;
	    	
	    }
	    
	    
	   
	    con.setAutoCommit(true);

		con.close();
	    
	    
	    
		
	}
	
	
	
	
	
	

   

}
