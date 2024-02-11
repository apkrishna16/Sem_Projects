import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
//Registeration class
class Registration{
    //Method to register
    Scanner sc=new Scanner(System.in);
    private void register(int ch1) throws FileNotFoundException{
        System.out.println("-----Register-----");
        System.out.print("Enter Username: ");
        String Username=sc.nextLine();
        System.out.print("Enter Password: ");
        String Password=sc.nextLine();
        System.out.print("Confirm Password: ");
        String ConPass=sc.nextLine();
        System.out.println("Username- " + Username);
        System.out.println("Password- " + Password);
        Username=Username.trim();
        Password=Password.trim();
        ConPass=ConPass.trim();
        if(Password.equals(ConPass)){         //checking whether password and confirmed-password are same
            File f = new File("Registration.txt");
            Scanner content = new Scanner(f);
            int flag=0;
            while (content.hasNextLine()){
                String data = content.nextLine();
                String[] dataList = data.split("\\|");
                String dataUserName = dataList[0];
                if(data.equals(dataUserName)){         //checking whether already register
                    System.out.println("Already registered user exists. Try again");
                    flag=1;
                    this.registration(ch1);
                    break;
                }
            }
            content.close();
            if(flag==0){         
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter("Registration.txt", true)); 
                    out.write(Username+"|"+Password+"\n");
                    out.close();
                }
                catch (IOException e) {
                    System.out.println("Exception--> ");
                    e.getStackTrace();
                }
                //Customer details  
                System.out.println("-----Customer Details-----");
                System.out.print("Name: ");
	            String name = sc.nextLine();
	            System.out.print("Contact number: ");
	            Long contactNumber = sc.nextLong();
	            System.out.print("Email ID: ");
	            String emialId = sc.next();  
                try {
                    BufferedWriter out1 = new BufferedWriter(new FileWriter("CustomerDetails.txt", true)); 
                    out1.write(Username+"|"+Password+"|"+name+"|"+contactNumber+"|"+emialId+"\n");
                    out1.close();
                    System.out.println("Customer details successfully saved.");
                }
                catch (IOException e) {
                    System.out.println("Exception--> ");
                    e.getStackTrace();
                }
	             
                System.out.println("Successfully Registered");
                System.out.println("Please Login");
                this.login(ch1);
            }
        } 
        else{
            System.out.println("Password confirmation was incorrect. Recheck");
            this.registration(ch1);
        }    
    }
    //Method for login
    private static int log = 0;
    private static String UserName;
    private static String PassWord;
    protected void login(int ch1){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Login-----");
        System.out.print("Enter Username: ");
        UserName=sc.nextLine();
        System.out.print("Enter Password: ");
        PassWord=sc.nextLine();
        System.out.println("Username- " + UserName);
        System.out.println("Password- " + PassWord); 
        UserName=UserName.trim();
        PassWord=PassWord.trim();
        String x= UserName+"|"+PassWord;  
        if(ch1==1){
            try {
                File f = new File("Registration.txt");
                Scanner content = new Scanner(f);
                int flag=0;
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    if(data.equals(x)){
                        System.out.println("Login Successful");
                        flag=1;
                        log=1;
                        break;
                    }
                }
                if(flag==0){
                    System.out.println("Login Failed!");
                    this.registration(ch1);
                }
                content.close();
            } 
            catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            }
        }  
        if(ch1==2){
            try {
                File f = new File("Admin.txt");
                Scanner content = new Scanner(f);
                int flag=0;
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    if(data.equals(x)){
                        System.out.println("Login Successful");
                        flag=1;
                        log=2;
                        break;
                    }
                }
                if(flag==0){
                    System.out.println("Login Failed!");
                    this.login(ch1);
                }
                content.close();
            } 
            catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            }
        }
           
    }

    static int getLog(){
        return log;
    }
    static String getUserName(){
        return UserName;
    }
    static String getPassWord(){
        return PassWord;
    }

    //Main method
    public void registration(int ch1) throws FileNotFoundException{
        //Creating Registration.txt file
        try {
            File obj = new File("Registration.txt");
            if (obj.createNewFile()){
                System.out.println("Registeration file is created.");
            } 
        } 
        catch (IOException e){
            System.out.println("Exception-->");
            e.printStackTrace();
        }
        //Creating Admin.txt file 
        try {
            File obj = new File("Admin.txt");
            if (obj.createNewFile()){
                System.out.println("Admin.txt file is created.");
            } 
        } 
        catch (IOException e){
            System.out.println("Exception-->");
            e.printStackTrace();
        }
        //Creating Customer.txt file 
        try {
            File obj = new File("CustomerDetails.txt");
            if (obj.createNewFile()){
                System.out.println("CustomerDetails.txt file is created.");
            } 
        }
        catch (IOException e){
            System.out.println("Exception-->");
            e.printStackTrace();
        } 
        int choice; 
        System.out.println("1. Registration ");
        System.out.println("2. Login ");
        System.out.print("Enter your choice: ");
        choice=sc.nextInt();
        sc.nextLine();
        if(choice==1){
            this.register(ch1);
        }
        else if(choice==2){
            this.login(ch1);
        }
        else{
            System.out.println("Invalid Choice!!");
        }     
    }
}