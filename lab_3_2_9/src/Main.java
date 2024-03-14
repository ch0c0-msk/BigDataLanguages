import product.Product;
import product.ProductManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(new Product(1, "Milk", "123456789012", "Farmers Inc.", 2.50, 7, 10));
        productManager.addProduct(new Product(2, "Bread", "234567890123", "Bakery Ltd.", 1.50, 5, 20));
        productManager.addProduct(new Product(3, "Eggs", "345678901234", "Eggcellent Farms", 3.00, 10, 15));

        ArrayList<Product> milkProducts = productManager.getProductsByName("Milk");
        System.out.println("Products with name Milk:");
        for (Product product : milkProducts) {
            System.out.println(product);
        }

        ArrayList<Product> cheapBreadProducts = productManager.getProductsByNameAndPrice("Bread", 2.00);
        System.out.println("Cheap Bread products:");
        for (Product product : cheapBreadProducts) {
            System.out.println(product);
        }

        ArrayList<Product> longShelfLifeProducts = productManager.getProductsByShelfLife(6);
        System.out.println("Products with shelf life longer than 6 days:");
        for (Product product : longShelfLifeProducts) {
            System.out.println(product);
        }
    }
}