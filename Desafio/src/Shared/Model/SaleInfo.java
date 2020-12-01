package Shared.Model;

public class SaleInfo {
    private String id ;
    private String quantity;
    private String price ;

    public SaleInfo(String id, String quantity, String price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }


    public double getValue(){
        return Double.parseDouble(quantity) * Double.parseDouble(price);
    }

    @Override
    public String toString(){
        return "\n Id: " + id + " Quantity: " + quantity + " Price: " + price;
    }
    
}
