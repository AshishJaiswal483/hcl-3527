package model;

public class Product{
    private final int id;
    private final double price;
    private final Productcategory category;
    private final String name;

     public Product(int id,double price,Productcategory category,String name){
        if(id<=0){
            throw new IllegalArgumentException("id cannot be negative or zero");
        }
        if(price<0||Double.isFinite(price)!=true){
            throw new IllegalArgumentException("price cannot be negative or zero");
        }
        if(category==null){
            throw new IllegalArgumentException("category cannot be null");
        }
        if(name==null||name.isBlank()==true){
            throw new IllegalArgumentException("name cannot be null");
        }
        this.id=id;
        this.price=price;
        this.category=category;
        this.name=name;
    }

    public int getId(){
        return id;
    }  
    public double getPrice(){
        return price;
    } 
    public Productcategory getCategory(){
        return category;
    } 
    public String getName(){
        return name;
    } 
    @Override
    public String toString() {
        return "id: " + id + " "
                + "price: " + price + " "
                + "category: " + category + " "
                + "name: " + name;
    }
}