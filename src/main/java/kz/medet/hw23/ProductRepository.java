package kz.medet.hw23;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Milk", 350));
        products.add(new Product(2, "Bread", 150));
        products.add(new Product(3, "Juice", 500));
        products.add(new Product(4, "Meat", 2500));
        products.add(new Product(5, "Apple", 600));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}