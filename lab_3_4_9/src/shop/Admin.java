package shop;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Product> productList;
    private List<String> blacklist;

    public Admin() {
        productList = new ArrayList<>();
        blacklist = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void registerSale(Order order, boolean paymentStatus) {
        SalesRecord salesRecord = new SalesRecord(order, paymentStatus);
    }

    public void addToBlacklist(String customer) {
        blacklist.add(customer);
    }
}
