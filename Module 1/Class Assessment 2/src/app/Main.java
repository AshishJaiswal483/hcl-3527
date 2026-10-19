
package app;

import model.Product;
import model.Productcategory;
import Service.ServiceCard;

public class Main {
    public static void main(String[] args) {

        // Create products
        Product p1 = new Product(
            101, 500.0, Productcategory.toys, "Teddy Bear"
        );

        Product p2 = new Product(
            102, 400.0, Productcategory.clothes, "T-Shirt"
        );

        Product p3 = new Product(
            103, 200.0, Productcategory.toys, "Toy Car"
        );

        // Create shopping cart service
        ServiceCard cart = new ServiceCard();

        // Add products
        cart.addProduct(p1, 2);
        cart.addProduct(p2, 1);
        cart.addProduct(p3, 3);

        // Display cart
        System.out.println("\n--- Cart Items ---");
        cart.displayCart();

        // Display total
        System.out.println("\nCart Total: " + cart.getTotal());

        // Sort by price
        cart.sortByPrice();

        System.out.println("\n--- Sorted Cart ---");
        cart.displayCart();

        // Update quantity
        cart.updateQuantity(102, 2);

        // Remove product
        cart.removeProduct(103);

        // Display final cart
        System.out.println("\n--- Final Cart ---");
        cart.displayCart();
        System.out.println("Final Total: " + cart.getTotal());
    }
}
