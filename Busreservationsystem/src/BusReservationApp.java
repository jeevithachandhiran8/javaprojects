import java.util.*;


public class BusReservationApp
{
	
	static Scanner sc=new Scanner(System.in);
	
	
	

	public static void main(String[] args) 
	{
		BusDao d=new BusDao();
		TicketBooking tb=new TicketBooking();
		
		//BusReservationApp app=new BusReservationApp();
		//BusService bs=new BusService();
		
	
		int opt;
		
	    
		
		do
		{
			System.out.println("select your choice ");
			System.out.println("-------------------------------");
			System.out.println("1 : VIEW BUS DETAILS");
			System.out.println("2 : BOOKING TICKET ");
			System.out.println("3 : EXIT");
			System.out.println("-------------------------------");
			opt=sc.nextInt();
			
			switch(opt)
			{ 
			case 1:
				try
				{
					d.displayBusInfo();
					
				}
				catch(Exception e)
				{
					System.out.println(e);
					
				}
		
				break;
			case 2:
				try
				{
					tb.booking();
					break;
					
				}
				catch(Exception e)
				{
					System.out.println(e);					
				}
				
			case 3:
				System.out.println("exit program");
				break;
			default:
				System.out.println("invalid option");
				break;
				
			
			
			}
			
		}while(opt!=3);
	}
		
		

	

}
