package Helper;

public class ParkingSpot {
    private String spotnumber;
    public ParkingSpot(String spotnumber)
    {
        this.spotnumber=spotnumber;
    }
    public void setspotnumber(String spotnumber)
    {
        this.spotnumber=spotnumber;
    }
    public String getspotnumber(){return spotnumber;}
}
