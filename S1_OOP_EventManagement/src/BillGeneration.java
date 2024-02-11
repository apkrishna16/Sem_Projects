import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//BillGeneration class 
class BillGeneration extends Payment{
    static int amount, eventCh, eventNo;
    protected static int billGeneration(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String UserName = sc.next();
        System.out.print("Enter Event choice: ");
        eventCh = sc.nextInt();
        UserName=UserName.trim();
        if(eventCh==1){          //Bill for marriage event
            System.out.println("-----Marriage Events-----");
            System.out.print("Enter Event number: ");
            eventNo = sc.nextInt();
            try {
                File f = new File("MarriageDetails.txt");
                Scanner content = new Scanner(f);
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    String[] dataList = data.split("\\|");
                    String dataUserName = dataList[0];
                    int dataEventNumber = Integer.parseInt(dataList[1]);
                    if(dataUserName.equals(UserName) && dataEventNumber==eventNo){
                        int noOfPeople=Integer.parseInt(dataList[6]);
                        final int marriageBasic = 100000;
                        amount = marriageBasic + (1500*noOfPeople);
                    }
                }
                content.close(); 
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }  
        }  
        else if(eventCh==2){      //Bill for party event
            System.out.println("-----Party Events-----");
            System.out.print("Enter Event number: ");
            eventNo = sc.nextInt();
            try {
                File f = new File("PartyDetails.txt");
                Scanner content = new Scanner(f);
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    String[] dataList = data.split("\\|");
                    String dataUserName = dataList[0];
                    int dataEventNumber = Integer.parseInt(dataList[1]);
                    if(dataUserName.equals(UserName) && dataEventNumber==eventNo){
                        int noOfPeople=Integer.parseInt(dataList[6]);
                        final int partyBasic = 25000;
                        amount = partyBasic + (750*noOfPeople);
                    }
                }
                content.close(); 
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }  
        }
        else if(eventCh==3){        //Bill for school event
            System.out.println("-----School Events-----");
            System.out.print("Enter Event number: ");
            eventNo = sc.nextInt();
            try {
                File f = new File("SchoolDetails.txt");
                Scanner content = new Scanner(f);
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    String[] dataList = data.split("\\|");
                    String dataUserName = dataList[0];
                    int dataEventNumber = Integer.parseInt(dataList[1]);
                    if(dataUserName.equals(UserName) && dataEventNumber==eventNo){
                        int noOfPeople=Integer.parseInt(dataList[6]);
                        final int schoolBasic = 75000;
                        amount = schoolBasic + (100*noOfPeople);
                    }
                }
                content.close(); 
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }  
        }
        try {
            BufferedWriter out1 = new BufferedWriter(new FileWriter("Bill.txt", true)); 
            out1.write(UserName+"|"+eventCh+"|"+eventNo+"|"+amount +"\n");
            out1.close();
        }
        catch (IOException e) {
            System.out.println("Exception--> ");
            e.getStackTrace();
        }
        return amount;
    }  
}
//Payment class
abstract class Payment{
    static void payment(String name){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Event choice: ");
        int eventCh = sc.nextInt();
        System.out.print("Enter Event number: ");
        int eventNo = sc.nextInt();
        try {
            File f = new File("Bill.txt");
            Scanner content = new Scanner(f);
            while (content.hasNextLine()) {
                String data = content.nextLine();
                String[] dataList = data.split("\\|");
                String dataUserName = dataList[0];
                int dataEventChoice = Integer.parseInt(dataList[1]);
                int dataEventNo = Integer.parseInt(dataList[2]);
                if(dataUserName.equals(User.getUserName()) && dataEventChoice==eventCh && dataEventNo==eventNo){
                    int billAmount = Integer.parseInt(dataList[3]);
                    System.out.println("_________Bill________");
                    System.out.println("|Total Amount-"+billAmount+"|");
                    System.out.println("|___________________|");
                    System.out.print("Do you want to proceed with payment?(y/n)- ");
                    String quit = sc.next();
                    if(quit.equalsIgnoreCase("y")){
                        System.out.println("Payment successful!");
                        System.out.println("Your booking is confirmed.");
                    }
                }
            }
            content.close(); 
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }  
    }
}
