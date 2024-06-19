package product;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProductsByName(String name) {
        ArrayList<Product> productsByName = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                productsByName.add(product);
            }
        }
        return productsByName;
    }

    public ArrayList<Product> getProductsByNameAndPrice(String name, double maxPrice) throws ProductNotFoundException{
        ArrayList<Product> productsByNameAndPrice = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name) && product.getPrice() <= maxPrice) {
                productsByNameAndPrice.add(product);
            }
        }
        if (productsByNameAndPrice.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return productsByNameAndPrice;
    }

    public ArrayList<Product> getProductsByShelfLife(int minShelfLife) throws ProductNotFoundException {
        ArrayList<Product> productsByShelfLife = new ArrayList<>();
        for (Product product : products) {
            if (product.getShelfLife() > minShelfLife) {
                productsByShelfLife.add(product);
            }
        }
        if (productsByShelfLife.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return productsByShelfLife;
    }
}
