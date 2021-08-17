package Helper;

public class Vehicle {
    String vehicleNumber;
    String modelname;

    public Vehicle(String vehicleNumber,String modelname) {
        this.vehicleNumber = vehicleNumber;
        this.modelname=modelname;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }   
    public String getmodelname()
    {
        return this.modelname;
    }
}
