import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//User class
class User extends Registration{
    Scanner sc= new Scanner(System.in);
    public void display() {                  
        System.out.println("-----Display Details-----");
    	System.out.println("1. Customer Details \n"+"2. Event Details");
    	System.out.print("Enter your choice: ");
    	int choice=sc.nextInt();
    	switch(choice){
        case 1: 
        	System.out.println("-----Customer Details-----");
        	this.displayCustomer();
            break;
        case 2: 
            System.out.println("-----Event Details-----");	
            this.displayEvent();
            break;
        default:
            System.out.println("Invalid Choice!!");
        }
    }
     
    void displayCustomer() {                  //displaying all customer's details(admin)
        try {
            File f = new File("CustomerDetails.txt");
            Scanner content = new Scanner(f).useDelimiter(",");
            while (content.hasNextLine()) {
                String data = content.nextLine();
                String[] dataList = data.split("\\|");
                System.out.println("Username-"+dataList[0]+"  Password-"+dataList[1]+"  Name-"+
                dataList[2]+"  Contact Number-"+dataList[3]+"  Email Id-"+dataList[4]);
            }
            content.close(); 
        }
        catch (FileNotFoundException e){
            System.out.println("Exception-->");
            e.printStackTrace();
        }      
    }
    
    void displayCustomer(String name) {        //displaying customer's own details(customer)
        System.out.println("-----Profile-----");
        try {
            File f = new File("CustomerDetails.txt");
            Scanner content = new Scanner(f).useDelimiter(",");
            while (content.hasNextLine()) {
                String data = content.nextLine();
                String[] dataList = data.split("\\|");
                String dataName = dataList[0];
                if(dataName.equals(name)){
                    System.out.println("Username-"+dataList[0]+"  Password-"+dataList[1]+"  Name-"+
                    dataList[2]+"  Contact Number-"+dataList[3]+"  Email Id-"+dataList[4]);
                }
            }
            content.close(); 
        }
        catch (FileNotFoundException e){
            System.out.println("Exception-->");
            e.printStackTrace();
        }      
    }

    void displayEvent() {           //displaying all event details(admin)
        System.out.println("Display");
        System.out.println("1. Marriage Events \n"+"2. Party Events \n"+"3. School Events");
    	System.out.print("Enter your choice: ");
    	int choice=sc.nextInt();
    	switch(choice){
        case 1: 
        	System.out.println("-----Marriage Event-----");
        	try {
     		    File f = new File("MarriageDetails.txt");
                Scanner content = new Scanner(f);
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    String[] dataList = data.split("\\|");
                    System.out.println("Username-"+dataList[0]+"  Event Choice-"+dataList[1]+"  Date-"+dataList[2]+
                    "  Venue-"+dataList[3]+"  Theme-"+dataList[4]+"  Stage Settings-"+dataList[5]+
                    "  No of People-"+dataList[6]+"  Food Items-"+dataList[7]);
     	        }
                content.close(); 
     	    }
     	    catch (FileNotFoundException e) {
                 System.out.println("Exception-->");
     		    e.printStackTrace();
     	    }
            break;
        case 2: 
            System.out.println("-----Party Events-----");	
            try {
     		    File f = new File("PartyDetails.txt");
                Scanner content = new Scanner(f);
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    String[] dataList = data.split("\\|");
                    System.out.println("Username-"+dataList[0]+"  Event Choice-"+dataList[1]+"  Date-"+dataList[2]+
                    "  Venue-"+dataList[3]+"  Theme-"+dataList[4]+"  Stage Settings-"+dataList[5]+
                    "  No of People-"+dataList[6]+"  Food Items-"+dataList[7]);
     	        }
                content.close(); 
     	    }
     	    catch (FileNotFoundException e) {
                 System.out.println("Exception-->");
     		       e.printStackTrace();
     	        }   
                break;
        case 3:
        	System.out.println("-----School Events-----");	
    	    try {
		        File f = new File("SchoolDetails.txt");
                Scanner content = new Scanner(f);
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    String[] dataList = data.split("\\|");
                    System.out.println("Username-"+dataList[0]+"  Event Choice-"+dataList[1]+"  Date-"+dataList[2]+
                    "  Venue-"+dataList[3]+"  Theme-"+dataList[4]+"  Stage Settings-"+dataList[5]+
                    "  No of People-"+dataList[6]+"  Food Items-"+dataList[7]);
	            }
                content.close(); 
	        }
	        catch (FileNotFoundException e) {
                System.out.println("Exception-->");
		        e.printStackTrace();
	        }
    	    break;
        default:
            System.out.println("Invalid Choice!!");
        }
    }
}
