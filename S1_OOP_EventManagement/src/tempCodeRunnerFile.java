import java.util.Scanner;
import java.io.FileNotFoundException;
//EventManagement class
public class EventManagement{
    static int logValue, option;
    public static void main(String args[]){
        option=0; 
        while(option==0){
            Scanner sc = new Scanner(System.in);
            System.out.println("                  Celestia Inc");
            System.out.println("       Planning Guardian for Effortless Events");
            System.out.println("______________________________________________________");
            System.out.println();
            System.out.println("1.Customer");
            System.out.println("2.Admin");
            System.out.print("Enter your choice: ");
            int ch1 = sc.nextInt();    
            if (ch1==1){                       //Customer's page
                User customer = new User();
                try {
                    customer.registration(ch1);
                    logValue = User.getLog();
                } 
                catch (FileNotFoundException e) {
                    System.out.println("File not found");
                    e.printStackTrace();
                }
                if(logValue==1){               //after login
                    option=1;
                    while(option==1){
                        System.out.println("-----Customer's Zone-----");
                        System.out.println("1. View Profile \n"+"2. Create Event \n"+"3. Pay Bill");
                        System.out.print("Enter your choice: ");
                        int ch2 = sc.nextInt();
                        if (ch2==1) {
                            String name = User.getUserName();
                            customer.displayCustomer(name);
                        }
                        else if(ch2==2){
                            Event.createEvent();    
                        }
                        else if(ch2==3){
                            String name = User.getUserName();
                            Payment.payment(name);
                        }
                        else{
                            System.out.println("Invalid Choice!!");
                        }
                        System.out.println("0. Go back \n"+"1. Continue \n"+"2. Quit");
                        System.out.print("Enter your choice:");
                        option=sc.nextInt();
                        if(option==2){ 
                            System.out.println();
                            System.out.println("End of Program");
                            System.out.println("Thank You!!");
                            System.exit(0);      
                        }
                    } 
                }                                                         
            } 
            else if(ch1==2){                        //Admin's page
                User admin = new User();
                admin.login(ch1);
                logValue = User.getLog(); 
                if(logValue==2){                    //after login
                    option=1;
                    while(option==1){
                        System.out.println("-----Admin's Zone-----");
                        System.out.println("1. Display Details \n"+"2. Bill Generation");
                        System.out.print("Enter your choice: ");
                        int ch2 = sc.nextInt();
                        if (ch2==1) {
                            admin.display();
                        }
                        else if(ch2==2){
                            int totalAmount = BillGeneration.billGeneration();
                            System.out.println("_________Bill________");
                            System.out.println("|Total Amount-"+totalAmount+"|");
                            System.out.println("|___________________|");
                        } 
                        else{
                            System.out.println("Invalid Choice!!");
                        }
                        System.out.println("0. Go back \n"+"1. Continue \n"+"2. Quit");
                        System.out.print("Enter your choice: ");
                        option=sc.nextInt();
                        if(option==2){
                            System.out.println("End of Program");
                            System.out.println("Thank You!!"); 
                            System.exit(0);     
                        }
                    }   
                }
            }
            else{
                System.out.println("Invalid Choice!!");
                System.out.println("0. Continue \n"+"1. Quit");
                System.out.print("Enter your choice: ");
                option=sc.nextInt();
            }     
        } 
        System.out.println(); 
        System.out.println("End of Program");
        System.out.println("Thank You!!");     
    }
}
