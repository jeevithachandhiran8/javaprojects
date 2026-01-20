import java.util.*;
public class BankSystem {

    static Scanner sc=new Scanner(System.in);
    static ArrayList<BankAccount> store=new ArrayList<>();
     
    
    

    public  void AccountDetail()
    {
         BankAccount ba=new BankAccount();
      
        System.out.println("Enter your Account Number");
        ba.AccountNumber=sc.nextLong();
        sc.nextLine();
        
        System.out.println("Enter your Name");
        ba.name=sc.nextLine();
        System.out.println("Enter your balance");
        ba.balance=sc.nextDouble();
        
        store.add(ba); 
        
    }
    public  void deposit()
    {
        System.out.println("Enter your account number:");
        long c=sc.nextLong(); //c-check
        
        double amt;
        boolean flag=false;
          
        for(BankAccount y:store)
        {
            if(y.AccountNumber==c)
            {
                System.out.println("Enter your amount");
                amt=sc.nextDouble();
                y.balance=y.balance+amt;
                flag =true;
               

            }         
        
        }
        if(!flag)
        {
            System.out.println("invalid Account");
        }

        
    
    }
    public  void WithdrawMoney()
    {

        System.out.println("Enter your account number:");
        long c=sc.nextLong(); //c-check
        boolean flag=false;
        for(BankAccount a:store)
        {
            if(a.AccountNumber == c)
            {
                System.out.println("Enter your amount");
                double wa=sc.nextDouble(); 
                a.balance=a.balance-wa;
                flag=true;

            }

        }
        if(!flag)
        {
             System.out.println("Invalid Account");
        

        }
         
          
        
    }
    public  void CheckBalance()
    {
        System.out.println("Enter your account number:");
        long s=sc.nextLong();
        boolean flag=false;

        for(BankAccount m:store)
        {
            if(m.AccountNumber==s)
            {
                System.out.println("AccountNumber: "+s);
                System.out.println("AccountName: "+m.name);
                System.out.println("Account balance: "+m.balance);
                flag=true;
                
            }
           
            
        }
         if(!flag)
            {
                System.out.println("Account not found");
                
            }


    }

    public  void  ShowAllAccount()
    {
        for(BankAccount a:store)
        {
             System.out.println("AccountNumber: "+a.AccountNumber);
                System.out.println("AccountName: "+a.name);
                System.out.println("Account balance: "+a.balance);
        }
    }

    public static void main(String arg[])
    {
        int c;
        BankSystem b=new BankSystem();
        
        do
        {
            System.out.println("Enter your choice");

            System.out.println("1:Create Account");
            System.out.println("2:Deposit Money");
            System.out.println("3:Withdraw Money");
            System.out.println("4:Check Balance");
            System.out.println("5:ShowAllAccount");
            System.out.println("6:Exit");

            c=sc.nextInt();
             
            switch(c)
            {
                case 1:
                    {
                        b.AccountDetail();
                        break;

                    }
                case 2:
                    {
                        b.deposit();
                        break;

                    }
                case 3:
                    {
                        b.WithdrawMoney();
                        break;
                    }
                case 4:
                    {
                        b.CheckBalance();
                        break;
                    } 
                case 5:
                    {
                        b.ShowAllAccount();
                        
                        break;
                    } 
                case 6:
                    {
                        System.out.println("exit the program");
                        break;
                    } 
                default:{
                    System.out.println("invalid choice");
                    break;
                }  
            }

        }while(c!=6);
        
    }
    
}
