import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
//Event class
class Event{
    static int eventChoice;
    public static void createEvent() {
		Scanner sc = new Scanner(System.in);
        System.out.println("-----Events-----");
        System.out.println("1. Marriage Events \n"+"2. Party Events \n"+"3. School Events");         
        System.out.print("Choose an Event: ");
		eventChoice = sc.nextInt();
        switch(eventChoice){
            case 1: 
                    MarriageEvents marriage = new MarriageEvents();
                    marriage.eventDetails();
                    break;
            case 2: 
                    PartyEvents party = new PartyEvents();
                    party.eventDetails();
                    break;
            case 3: 
                    SchoolEvents school = new SchoolEvents();
                    school.eventDetails();
                    break;
            default: 
                    System.out.println("Invalid Choice!!");
        }
    } 
    static int getEventChoice(){
        return eventChoice;
    }  
}
//MarriageEvents class
class MarriageEvents extends Event{
    public static int marriageEventCh;
    public void eventDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Marriage Events-----");
        System.out.println("11 - Engagement \n"+"12 - Wedding \n"+"13 - Reception");
        System.out.print("Choose the Marriage Event: ");
        marriageEventCh = sc.nextInt();
        switch(marriageEventCh){
            case 11: 
            	    MarriageEvents engagement = new MarriageEvents();
                    System.out.println("-----Engagement-----");
                    engagement.marriageDetails();
                    break;
            case 12: 
            	    MarriageEvents wedding = new MarriageEvents();                   
                    System.out.println("-----Wedding-----");	
                    wedding.marriageDetails();
                    break;
            case 13: 
            	    MarriageEvents reception = new MarriageEvents();
                    System.out.println("-----Reception-----");
                    reception.marriageDetails();
                    break;
            default:
                    System.out.println("Invalid Choice!!");
        }
    }
    
    public void marriageDetails() {         //entering marriage details
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Date: ");
        String date = sc.nextLine();
        System.out.print("Venue: ");
        String venue = sc.nextLine();
        System.out.print("Theme: ");
        String theme = sc.nextLine();
        System.out.print("Stage Settings: ");
        String stageSettings = sc.nextLine();
        System.out.print("Number of people: ");
        int marriagePeople = Integer.parseInt(sc.nextLine());
        System.out.print("Food items: ");
        String foodItems = sc.nextLine();
        try {
            BufferedWriter out1 = new BufferedWriter(new FileWriter("MarriageDetails.txt", true)); 
            out1.write(User.getUserName()+"|"+marriageEventCh+"|"+date+"|"+venue+"|"+theme+
            "|"+stageSettings+"|"+marriagePeople+"|"+foodItems+"\n");
            out1.close();
        }
        catch (IOException e) {
            System.out.println("Exception--> ");
            e.getStackTrace();
        }
    } 
}
//PartyEvents class
class PartyEvents extends Event{
    public static int partyEventCh;
    public void eventDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Party Events-----");
        System.out.println("21 - Office Party \n"+"22 - Birthday Party");
        System.out.print("Choose the Party Event: ");
        partyEventCh = sc.nextInt();
        switch(partyEventCh){
            case 21: 
            	    PartyEvents officeParty = new PartyEvents();
                    System.out.println("-----Office Party-----");
                    officeParty.partyDetails();
                    break;
            case 22: 
                    PartyEvents birthdayParty = new  PartyEvents();                   
                    System.out.println("-----Birthday Party-----");	
                    birthdayParty.partyDetails();
                    break;
            default:
                    System.out.println("Invalid Choice!!");
        }
    }

    public void  partyDetails() {            //entering party details
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Date: ");
        String date = sc.nextLine();
        System.out.print("Venue: ");
        String venue = sc.nextLine();
        System.out.print("Theme: ");
        String theme = sc.nextLine();
        System.out.print("Stage Settings: ");
        String stageSettings = sc.nextLine();
        System.out.print("Number of people: ");
        int partyPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Food items: ");
        String foodItems = sc.nextLine();
        try {
            BufferedWriter out1 = new BufferedWriter(new FileWriter("PartyDetails.txt", true)); 
            out1.write(User.getUserName()+"|"+partyEventCh+"|"+date+"|"+venue+"|"+theme+
            "|"+stageSettings+"|"+partyPeople+"|"+foodItems+"\n");
            out1.close();
        }
        catch (IOException e) {
            System.out.println("Exception--> ");
            e.getStackTrace();
        }
    }     
}
//SchoolEvents class
class SchoolEvents extends Event{
    public static int schoolEventCh;
    public void eventDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-----School Events-----");
        System.out.println("31 - Annual Day \n"+"32 - Sport Day");
        System.out.print("Choose the School Event: ");
        schoolEventCh = sc.nextInt();
        switch(schoolEventCh){
            case 31: 
            	    SchoolEvents annualDay = new SchoolEvents();
                    System.out.println("-----Annual Day-----");
                    annualDay.schoolDetails();
                    break;
            case 32: 
                    SchoolEvents sportsDay = new  SchoolEvents();                   
                    System.out.println("-----Sports Day-----");	
                    sportsDay.schoolDetails();
                    break;
            default:
                    System.out.println("Invalid Choice!!");
        }
    }

    public void  schoolDetails() {          //entering school details
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Date: ");
        String date = sc.nextLine();
        System.out.print("Venue: ");
        String venue = sc.nextLine();
        System.out.print("Theme: ");
        String theme = sc.nextLine();
        System.out.print("Stage Settings: ");
        String stageSettings = sc.nextLine();
        System.out.print("Number of people: ");
        int schoolPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Food items: ");
        String foodItems = sc.nextLine();
        try {
            BufferedWriter out1 = new BufferedWriter(new FileWriter("SchoolDetails.txt", true)); 
            out1.write(User.getUserName()+"|"+schoolEventCh+"|"+date+"|"+venue+"|"+theme+
            "|"+stageSettings+"|"+schoolPeople+"|"+foodItems+"\n");
            out1.close();
        }
        catch (IOException e){
            System.out.println("Exception--> ");
            e.getStackTrace();
        }
    }         
}
