/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */

/**
 *2016
 * @author RyanT
 */

import java.text.DecimalFormat;


public class Item {
    /**
     * sets out four parts of our class
     * qLIMIT is a constant
     */
    public double price;
    public int quantity;
    public String description;
    private final int qLIMIT = 12;
    /**
     * gets price from calling object
     * @return 
     */
    public double getPrice(){
        return price;
    }  
    /**
     * gets quantity from calling object
     * @return 
     */
    public int getQuantity(){
        return quantity;
    }        
    /**
     * gets name of item from calling object
     * @return 
     */
    public String getDescription(){
        return description;
    }
    /**
     * takes calling objects quantity and compares it to our limit
     * @return 
     */
    public boolean needToOrder(){
        boolean ans;
        if (this.getQuantity() < qLIMIT){
            ans = true;
        }else{
            ans = false;
        }
        return ans;
    }
    /**
     * takes item and returns in format "“Item: Fork   Qty: 12   Cost: $1.75”
     * @return 
     */
    public String toString(){
        String ans = "Item: " + this.getDescription() + " Qty: " + this.getQuantity() + " Cost: " + toDollar(this.getPrice());
        return ans;
    }
    /**
     * takes input double and converts to $0.00
     * @param priceIn
     * @return 
     */
    public String toDollar(double priceIn){
        DecimalFormat df = new DecimalFormat("$0.00");
        return df.format(priceIn);
    }
    /**
     * finds whole inventory item worth
     * @return 
     */
    public double itemWorth(){
        double ans = quantity * price;
        return ans;
    }
    /**
     * compares two items worth and returns if the calling object is larger than the passed argument
     * @param input
     * @return 
     */
    public boolean greaterThan(Item input){
        boolean ans;
        if(this.itemWorth() > input.itemWorth()){
            ans = true;
        }else
            ans = false;
        
        return ans;
    }
    /**
     * takes amount to lower quantity by
     * @param input 
     */
    public void sellSome(int input){
        toQuantity(this.quantity - input);
    }    
    /**
     * these next three set price quantity and description by passing new arguments
     * @param amount 
     */
    public void toPrice(double amount){
        price = amount;
    }
    public void toQuantity(int amount){
        quantity = amount;
    }    
    public void toDescription(String amount){
        description = amount;
    }
    
    
/**
 * sets up new item with all three inputs
 * also sets limit to 12
 * @param priceIn
 * @param quantityIn
 * @param descriptionIn 
 */    
public Item(double priceIn, int quantityIn, String descriptionIn) {
    price = priceIn;
    description = descriptionIn;
    quantity = quantityIn;
    }
/**
 * takes only price and name and sets quantity to 0
 * sets limit to 12
 * @param priceIn
 * @param descriptionIn 
 */
public Item(double priceIn, String descriptionIn){
    price = priceIn;
    description = descriptionIn;
    quantity = 0;
    }
}//end of program
