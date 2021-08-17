package Helper;

import java.util.ArrayList;
 

public class ParkingLot {
    private String name,location;
    private int capacity;
    private double parkingcharges;
    private Admin admin;

    private AutomatedSystem automatedSystem;
    private ArrayList<ParkingSpot> parkingSpots;
    private ArrayList<ParkingSpot> availableSpots;
    private DisplayBoard displayBoard;

    public ParkingLot(String name, int capacity, String location, double parkingCharges, AutomatedSystem automatedSystem, 
    DisplayBoard displayBoard) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
        this.parkingcharges = parkingCharges;
        this.automatedSystem = automatedSystem;
        this.automatedSystem.setParkingLot(this);
        this.displayBoard = displayBoard;
        this.parkingSpots = createParkingSpots(capacity);
        availableSpots = (ArrayList<ParkingSpot>) parkingSpots.clone();
    }
    private ArrayList<ParkingSpot> createParkingSpots(int capacity){
        ArrayList<ParkingSpot> tempList = new ArrayList<>();
        for (int i = 0; i <capacity ; i++) {
            ParkingSpot temp = new ParkingSpot("MPL "+i);
            tempList.add(temp);
        }
        return tempList;
    }
    public double getparkingcharges(){return this.parkingcharges;}

    public ParkingSpot getAvailableSpot() {
       
        return availableSpots.remove(0);
    }
    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }
 

    public int getAvailability(){
        if(availableSpots.size()==0){displayBoard.update("Not Avaiable");} 
        return availableSpots.size();
    }

    public void updateParkingCharges(double newCharges){
        this.parkingcharges = newCharges;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
     DisplayBoard displayBoard=new DisplayBoard();
     Customer rahul=new Customer("Rahul", "xx1234fds", "SUV");
     Customer raju=new Customer("Raju", "12QWusu", "Baleno");
     Customer rohan=new Customer("Roahn", "355faga", "RangeRover");
     AutomatedSystem automatedSystem=new AutomatedSystem();
     ParkingLot parkingLot=new ParkingLot("Hind sagar Parking Lot", 1000, "Azad Chowk, saharsa", 45.00, automatedSystem, displayBoard);
     // checking avaiabliity
     int avaiabliity=parkingLot.getAvailability();
     System.out.println("Available Spot = "+avaiabliity+" "+displayBoard.getstatus());
     //rahul getting ticket
     Ticket rahul_ticket=parkingLot.automatedSystem.generateTicket(rahul);
     //printing rahul ticket
     System.out.println(rahul_ticket.getcustomer().getname()+" "+rahul_ticket.getarrivalTimeDate()+" "+
     rahul_ticket.getcustomer().getVehicle().modelname);
    // checking availability
    System.out.println("Available Spot = "+parkingLot.getAvailability()+" "+displayBoard.getstatus());
    //calculating charges for rahul
    System.out.println(automatedSystem.caluclateCharges(rahul_ticket.getId()));

    }
}
