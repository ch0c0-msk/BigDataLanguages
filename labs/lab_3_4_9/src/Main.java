import shop.*;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Product laptop = new Product("Laptop", 1000);
        admin.addProduct(laptop);

        Client client = new Client("Alice", 1500);
        Order order = new Order();
        order.addProduct(laptop);
        client.placeOrder(order);

        admin.registerSale(order, order.isPaid());
    }
}