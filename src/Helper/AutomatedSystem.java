package Helper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class AutomatedSystem {
    private static int idcounter=0;
    private int id;
    private ParkingLot parkingLot;
    HashMap<Integer,Ticket>currentTickets;
    public AutomatedSystem()
    {
       this.id=idcounter++;
       currentTickets=new HashMap<>();
    } 
    public int getid(){return id;}
    public void setParkingLot(ParkingLot parkingLot){this.parkingLot=parkingLot;}
    public ParkingLot getparkingLot(){return this.parkingLot;}
    public ParkingSpot fetchAvailableParkingSpot()
    {
        return this.parkingLot.getAvailableSpot();
    }

    public Ticket generateTicket(Customer customer){
        ParkingSpot availableSpot = fetchAvailableParkingSpot();
        Vehicle vehicle = customer.getVehicle();
        Ticket ticket = new Ticket(customer, LocalDateTime.now(), availableSpot);
        currentTickets.put(ticket.getId(),ticket);
        
        return ticket;
    }
    public Ticket scanTicket(int id){
        // Code for scanning the ticket and return ticketId
        // Here we are assuming that scanned ticket id is 1234
        return currentTickets.get(id);
    }

    public double caluclateCharges(int id){
         Ticket ticket= scanTicket(id);
         long duration = Duration.between(LocalDateTime.now(),ticket.getarrivalTimeDate()).toHours();
         double charges = duration * parkingLot.getparkingcharges();
         return charges;
    }

    public void openEntryBarrier(){
        // Code for opening Entry Barrier
        this.parkingLot.getDisplayBoard().update("Status.FULL");
    }
    public void closeEntryBarrier(){
        // Code for closing Entry Barrier
    }
    public void openExitBarrier(){
        // Code for opening Entry Barrier
        this.parkingLot.getDisplayBoard().update("Status.AVAILABLE");
    }
    public void closeExitBarrier(){
        // Code for closing Entry Barrier
    }


}
