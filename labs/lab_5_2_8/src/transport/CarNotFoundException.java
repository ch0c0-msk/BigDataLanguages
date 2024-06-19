package transport;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(String message) {
        super(message);
    }
     public CarNotFoundException() {
        super("Car is not found");
     }
}
