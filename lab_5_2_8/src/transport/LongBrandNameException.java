package transport;

public class LongBrandNameException extends Exception {
    public LongBrandNameException(String message) {
        super(message);
    }

    public LongBrandNameException() {
        super("Brand name is too long");
    }
}
