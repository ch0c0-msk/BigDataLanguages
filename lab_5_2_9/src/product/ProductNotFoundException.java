package product;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
    public ProductNotFoundException() {
        super("Product not found");
    }
}
