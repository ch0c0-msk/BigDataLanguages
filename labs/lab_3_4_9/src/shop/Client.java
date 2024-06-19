package shop;

public class Client {
    private String name;
    private double balance;

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void placeOrder(Order order) {
        if (balance >= order.calculateTotalPrice()) {
            balance -= order.calculateTotalPrice();
            order.setPaid(true);
        } else {
            System.out.println("Недостаточно средств на счете для совершения покупки.");
        }
    }
}
