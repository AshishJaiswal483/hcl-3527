package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import model.Product;
import model.Carditems;

public class ServiceCard{
     List<Carditems>items=new ArrayList<>();


     public void addProduct(Product product,int quantity){
        if(product==null){
            throw new IllegalArgumentException("product cannot be null");
        }
        if(quantity<=0){
            throw new IllegalArgumentException("quantity cannot be zero or negative");
        }
        for(Carditems item:items){
        if(item.getProduct().getId()==product.getId()){
            item.setQuantity(item.getQuantity()+quantity);
            System.out.println("quantity updated successfully");
            return;
        }
     }
     items.add(new Carditems(product,quantity));
     System.out.println("Product added to cart.");
     }   

    
public void removeProduct(int productId) {
    var iterator = items.iterator();

    while (iterator.hasNext()) {
        Carditems item = iterator.next();

        if (item.getProduct().getId() == productId) {
            iterator.remove();
            System.out.println("Product removed.");
            return;
        }
    }

    System.out.println("Product not found.");
}


public void updateQuantity(int productId, int newQuantity) {

    if (newQuantity <= 0) {
        throw new IllegalArgumentException(
            "Quantity must be greater than zero");
    }

    for (Carditems item : items) {
        if (item.getProduct().getId() == productId) {
            item.setQuantity(newQuantity);
            System.out.println("Quantity updated successfully.");
            return;
        }
    }

    System.out.println("Product not found in cart.");
}



public void displayCart() {
    if (items.isEmpty()) {
        System.out.println("Your shopping cart is empty.");
        return;
    }

    System.out.println("----- Shopping Cart -----");

    for (Carditems item : items) {
        System.out.println(item);
    }
}


public double getTotal() {
    double total = 0;

    for (Carditems item : items) {
        total += item.getSubtotal();
    }

    return total;
}


public void sortByPrice() {
    items.sort(
        Comparator.comparingDouble(
            item -> item.getProduct().getPrice()
        )
    );

    System.out.println("Cart sorted by price.");
}

  
}