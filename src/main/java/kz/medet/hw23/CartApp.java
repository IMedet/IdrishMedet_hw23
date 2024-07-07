package kz.medet.hw23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CartApp {

    @Autowired
    private ApplicationContext context;

    public void run(){
        Scanner sc = new Scanner(System.in);
        Cart cart = context.getBean(Cart.class);

        while (true){
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart By Id");
            System.out.println("3. Display Cart");
            System.out.println("4. Exit");
            System.out.println("--------------------------------------");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter product id to add: ");
                    int addId = sc.nextInt();
                    cart.addProduct(addId);
                    break;
                case 2:
                    System.out.println("Enter product id to remove: ");
                    int removeId = sc.nextInt();
                    cart.removeProductById(removeId);
                    break;
                case 3:
                    System.out.println("Cart contains:");
                    System.out.println("--------------------------------------");
                    System.out.println(cart.getMyCart());
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        CartApp cartApp = context.getBean(CartApp.class);
        cartApp.run();
    }
}
