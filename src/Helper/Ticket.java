package Helper;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket {
    private static int idcounter=0;
    private int id;
    private Customer customer;
    private LocalDateTime arrivalTimeDate;
    private ParkingSpot parkingSpot;
    
    public Ticket(Customer customer,LocalDateTime arrivalTimDate,ParkingSpot parkingSpot)
    {
        this.id=idcounter++;
        this.customer=customer;
        this.arrivalTimeDate=arrivalTimDate;
        this.parkingSpot=parkingSpot;
    }
    public int getId(){return id;}
    public Customer getcustomer(){return customer;}
    public LocalDateTime getarrivalTimeDate(){return arrivalTimeDate;}
    public ParkingSpot getparkingSpot(){return parkingSpot;}
    public void setcustomer(Customer customer){this.customer=customer;}
    public void setarrivaltime(LocalDateTime arrivalTimeDate){this.arrivalTimeDate=arrivalTimeDate;}
    public void setParkingSpot(ParkingSpot parkingSpot){this.parkingSpot=parkingSpot;}

}
