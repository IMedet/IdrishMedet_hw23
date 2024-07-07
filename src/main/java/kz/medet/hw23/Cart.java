package kz.medet.hw23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> myCart = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    public Cart() {
    }

    public void addProduct(int id){
        myCart.add(productRepository.getProductById(id));
    }

    public void removeProductById(int id){
        for (Product product : myCart) {
            if (product.getId()==id){
                myCart.remove(product);
            }
        }
    }

    public List<Product> getMyCart(){
        return myCart;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "myCart=" + myCart +
                '}';
    }
}
