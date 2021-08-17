package Helper;

public class DisplayBoard {
    public String status;

    public DisplayBoard() {
        this.status = "AVAILABLE";
    }

    public void update(String newStatus){
        this.status = newStatus;
    }
    public String getstatus(){return status;}
}

