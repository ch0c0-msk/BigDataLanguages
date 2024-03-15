package shop;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private boolean paid;

    public Order() {
        products = new ArrayList<>();
        paid = false;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
