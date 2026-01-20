import java.util.*;
public class LibrarySystem {
    static Scanner sc=new Scanner(System.in);
    ArrayList<BookData> bookStore=new ArrayList<>();
    ArrayList<Student> stuData=new ArrayList<>();

    void addBook()
    {
        BookData bk=new BookData();  
       
        System.out.println("Enter bookId ");
        bk.bookId=sc.nextInt();
         sc.nextLine();
        
        System.out.println("Enter title ");
        bk.title=sc.nextLine();
        
        System.out.println("Enter author ");
        bk.author=sc.nextLine();
        
        bookStore.add(bk);
    }

        void viewAll()
        {
            System.out.println("BOOK LIST ");
            
            System.out.println("-------------------------------------------");
           
            for(BookData b:bookStore)
            {             
                System.out.println("bookId : "+b.bookId);
                System.out.println("title : "+b.title);
                System.out.println("author : "+b.author);
                System.out.println("isIssued: "+b.isIssued);
                System.out.println("-------------------------------------------");
                
            }
            
        }
        void issuedBook()
{
    System.out.println("Enter Student Id:");
    int si = sc.nextInt();

    Student s = null;

    // find student
    for (Student y : stuData)
    {
        if (y.StudentId == si)
        {
            s = y;
            break;
        }
    }

    if (s == null)
    {
        System.out.println("Invalid Student Id. Please register first.");
        return;
    }

    // student book limit check
    if (s.issuedBookCount >= 2)
    {
        System.out.println("Student has reached maximum book limit.");
        return;
    }

    System.out.println("Enter Book Id:");
    int bi = sc.nextInt();
    sc.nextLine(); // clear buffer

    BookData foundBook = null;

    // find book
    for (BookData b : bookStore)
    {
        if (b.bookId == bi)
        {
            foundBook = b;
            break;
        }
    }

    if (foundBook == null)
    {
        System.out.println("Invalid Book Id.");
        return;
    }

    if (foundBook.isIssued)
    {
        System.out.println("Book is already taken.");
        return;
    }

    System.out.println("Book is available. Do you want to take this book? (yes/no)");
    String c = sc.nextLine();

    if (c.equalsIgnoreCase("yes"))
    {
        foundBook.isIssued = true;
        s.issuedBookCount++;

        System.out.println("Book issued successfully.");
        System.out.println("Books taken by student: " + s.issuedBookCount);
    }
    else
    {
        System.out.println("Book issue cancelled.");
    }
}

void returnBook()
{
    System.out.println("Enter Student Id:");
    int si = sc.nextInt();

    Student s = null;

    // find student
    for (Student y : stuData)
    {
        if (y.StudentId == si)
        {
            s = y;
            break;
        }
    }

    if (s == null)
    {
        System.out.println("Invalid Student Id. Please register first.");
        return;
    }

     System.out.println("Enter Book Id:");
    int bi = sc.nextInt();
    sc.nextLine(); // clear buffer

    BookData foundBook = null;

    // find book
    for (BookData b : bookStore)
    {
        if (b.bookId == bi)
        {
            foundBook = b;
            break;
        }
    }

    if (foundBook == null)
    {
        System.out.println("Invalid Book Id.");
        return;
    }

    if(!foundBook.isIssued)
    {
        System.out.println("Book is already available in the library.");
        return;

    }

    if(foundBook.isIssued)
    {
        foundBook.isIssued=false;
        s.issuedBookCount=s.issuedBookCount-1;
        System.out.println("successfully return");
    }



}


     

        void studentDetail()
    {
        Student st=new Student();
        
        System.out.println("Enter StudentId ");
        st.StudentId=sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter Name ");
        st.name=sc.nextLine();

        st.issuedBookCount=0;
        
        
        
        stuData.add(st);
    }

    public static void main(String args[])
        {
            int c;
             LibrarySystem ab=new LibrarySystem();
            
            
            do{
                System.out.println("LOGIN MENU");
                System.out.println("1 -> ADMIN LOGIN ");
                System.out.println("2 -> STUDENT LOGIN");
                System.out.println("3 -> EXIT THE SYSTEM ");
                c=sc.nextInt();

                switch(c)
                {
                    case 1:
                        {
                           

                            int ac;//ADMIN CHOICE
                            do{
                                 System.out.println("ADMIN LOGIN ");
                                 System.out.println("1: Add Book ");
                                 System.out.println("2: View All Books");
                                 System.out.println("3: logout ");
                                 ac=sc.nextInt();

                                 switch(ac)
                                 {
                                    case 1:
                                        {
                                            ab.addBook();
                                            break;
                                        }
                                    case 2:
                                        {
                                            ab.viewAll();
                                            break;
                                        }
                                    case 3:
                                        {
                                            System.out.println("logout");
                                            break;
                                        }
                                 }
                                 System.out.println();


                                }while(ac!=3);
                           
                            break;
                            
                        }
                    case 2:
                        {
                           
                            int st;// STUDENT CHOICE
                             do{
                                 System.out.println("STUDENT LOGIN ");
                                 System.out.println("1: Enter student detail: ");
                                 System.out.println("2: View Available Books ");
                                 System.out.println("3: Issue Book");
                                 System.out.println("4: Return Book ");
                                 System.out.println("5: logout ");
                                 st=sc.nextInt();

                                 switch(st)
                                 {
                                    case 1:
                                        {
                                            ab.studentDetail();
                                            
                                            break;
                                        }
                                    case 2:
                                        {
                                            ab.viewAll();
                                            break;
                                        }
                                    case 3:
                                    {
                                        ab.issuedBook();
                                        break;

                                    }
                                    case 4:
                                    {
                                        ab.returnBook();
                                        break;

                                    }
                                    case 5:
                                        {
                                            System.out.println("logout");
                                            break;
                                        }
                                 }
                                 System.out.println();


                                }while(st!=4);
                            
                            break;
                            
                        }
                    case 3:
                        {
                            System.out.println("EXIT THE SYSTEM");
                            break;

                        }
                    default:
                        {
                            System.out.println("invalid choice ");
                            break;

                        }
                }
                System.out.println();
                
                

            }while(c!=3);


        }
    
}
