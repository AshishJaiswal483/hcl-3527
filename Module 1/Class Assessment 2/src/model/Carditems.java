package model;

public class Carditems{
    private final Product product;
    private  int quantity;

    public Carditems(Product product,int quantity){
        if(product==null){
            throw new IllegalArgumentException("product cannot be null");
        }
        if(quantity<=0){
            throw new IllegalArgumentException("quantity cannot be 0 or negative");
        }
        this.product=product;
        this.quantity=quantity;
    }

    public void setQuantity(int quantity){
        if(quantity<=0){
           throw new IllegalArgumentException("quatity cannot be 0 or negative");
        }
        this.quantity=quantity;
    }

    public double getSubtotal(){
        return product.getPrice()*quantity;
    }

    public Product getProduct() {
    return product;
    }

     public int getQuantity() {
      return quantity;
     }

    public String toString(){
        return product.getName() +"|quantity:"+quantity+ "|subtotal:"+getSubtotal();
    }
}