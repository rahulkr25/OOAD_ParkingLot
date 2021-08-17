package Helper;

public class Customer {
    private String name;
    private Vehicle vehicle;

    public Customer(String name, String vehicleNumber,String vechiclemodel) {
        this.name = name;
        this.vehicle = new Vehicle(vehicleNumber,vechiclemodel);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public String getname(){return name;}
}