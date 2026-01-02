import java.util.*;
class StudentResult
{

     static Scanner sc=new Scanner(System.in);

     static ArrayList<Student> store=new ArrayList<>();

    public static int total(int n1,int n2,int n3)
    {
        int t=n1+n2+n3;

        return t;

    }

     public static double avg(int b)
    {
        

        double avg=(double)b/3.0;
        return avg;

        
    }
    public  static char grade(double a)
    {

        if(a>=80)
        {
            return 'A';

        }
        else if(a>=55 && a<=79)
        {
            return 'B';
        }
        else
        {
            return 'C';
        }

       
    }

    public  static void AddStudent()
    {
        Student s=new Student();
         sc.nextLine();
        

        System.out.println("Enter Student name:");

        s.name=sc.nextLine();
        System.out.println("enter your rollnumber:");

        s.roll=sc.nextInt();
        System.out.println("enter your mark1:");
        int m1=sc.nextInt();
        System.out.println("enter your mark2:");
        int m2=sc.nextInt();

        System.out.println("enter your mark3:");
        int m3=sc.nextInt();

         

         s.tl=StudentResult.total(m1,m2,m3);
         s.avg=StudentResult.avg(s.tl);
         s.grade=StudentResult.grade(s.avg);

         store.add(s);
         System.out.println("--- successfully add student detail---");

         

    }

    public static  void ViewStudent()
    {
        for(Student s:store)
        {

        System.out.println("Student name detail");
        System.out.println("Student name:"+s.name);
        System.out.println("student rollnumber:"+s.roll);
        System.out.println("total:"+s.tl);
        System.out.printf("avg:  %.2f",s.avg);
        System.out.println();
        System.out.println("grade:"+s.grade);
         
       }
    }
      
        
     
   
    public static void main(String arg[])
    {
       

        

        StudentResult a=new StudentResult();

        char choice;

        do
         {

            System.out.println("enter your choice:");
            System.out.println("  1 → Add student / 2 → View students / 3 → Exit");
            choice=sc.next().charAt(0);
            
            if(choice == '1')
            {
                a.AddStudent();
            }

            else if(choice == '2')
            {
                a.ViewStudent();

            }
            else if(choice == '3')
            {
                System.out.println("Exit program");
            }
            else
            {
                System.out.println("invalid choice");
                
            }
            
                

 


         }while(choice != '3');
         
    
        

    }
}