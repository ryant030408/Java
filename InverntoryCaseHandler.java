/*
 * CSC 101 Monroe Community College
 * Spring Semester 2016
 * For education only
 */

package portfolio;

/**
 *2016
 * @author RyanT
 */

import java.util.*;


public class InverntoryCaseHandler {
    public static void main (String [] args){
        
        Item[] inventory = new Item[10];//sets array for inventory
        Scanner scan = new Scanner(System.in);//scanner for input
        int selection;//int for user selection
        boolean exit = false;//sets exit case for do while
        
        //////Test Array//// 
        /*
        inventory[0] = new Item(3, 3, "Fork");
        inventory[1] = new Item(3, 22, "Spoon");        
        inventory[2] = new Item(10, 14, "Knife");
        inventory[3] = new Item(.50, 70, "Napkin");
        inventory[4] = new Item(4.50, 9, "Ladel");
        inventory[5] = new Item(2.99, 32, "Sponge");
        inventory[6] = new Item(24, 2, "Cutting Board");
        inventory[7] = new Item(6.15, 150, "Garbage Bags");
        inventory[8] = new Item(4.99, 75, "Gloves");
        inventory[9] = new Item(3, 5, "Tongs");
         */
        //////Block To Exclude////////
        
        
        do{//loop for whole program
            System.out.println("\nWelcome to the inventory manager. Please select from the following:");
            System.out.println("1: List All Items\n2: Items That Need Ordering\n3: Add Item\n4: Report Total Inventory Cost\n5: Higest Cost Item\n6: Sell\n7: Remove An Item\n8: Clear Inventory\n9: Exit");
            selection = scan.nextInt();//gets selection
        switch (selection) {//switch for input argument
            /**
             * Case 1 lists all inventory
             */               
            case 1:  
                System.out.println(listAll(inventory));
                     break;
            /**
             * Case 2 checks for need to order items below limit currently at 12
             */         
            case 2:  
                for(int k = 0; k < 10; k++){
                    if(inventory[k] == null){
                    }else if(inventory[k].needToOrder() && inventory[k] != null){
                        System.out.println("Need to order " + inventory[k]);
                    }
                }        
                break;
                /**
                 * Case 3 adds a new item
                 */
            case 3: 
                Scanner adds = new Scanner(System.in);
                double price;
                int quantity;
                String description;
                int freeSpace = 0;
                                
                System.out.print("Item Name: ");
                description = adds.next();
                System.out.print("Item Price: ");
                price = adds.nextDouble();
                System.out.print("Item Quantity: ");
                quantity = adds.nextInt();
                
                for(int i = 0; i < 10; i++){
                    if(inventory[i] == null && freeSpace == 0){
                        inventory[i] = new Item(price, quantity, description);
                        freeSpace++;
                    }
                    
                }
                     break;
                /**
                 * Case 4 gathers total inventory cost
                 */     
            case 4:  
                double totalCost = 0;
                for(int i = 0; i < 10; i++){
                    if(inventory[i] != null){
                        totalCost = inventory[i].itemWorth() + totalCost;
                    }
                }
                System.out.println("Total inventory cost: " + totalCost);
                     break;
                /**
                 * Ges greatest costing inventory item and displays worth
                 */     
            case 5:
                //String highest = "";
                Item higher = new Item(0,0,"Basic");
                int counter = 0;
                for(int i = 0; i < 10; i++){
                    if(inventory[i] != null && inventory[i].greaterThan(higher)){
                        //highest = inventory[i].getDescription();
                        higher = inventory[i];     
                        counter++;
                    }
                }
                System.out.println(higher.getDescription() + " has the greatest cost at " + higher.toDollar(higher.itemWorth()));
                  break;
                /**
                 * Case 6 sells an item
                 */  
            case 6:   
                Scanner seller = new Scanner(System.in);
                String itemToSell = "";
                int sellAmount = 0;
                System.out.println("Which item would you like to sell?");
                itemToSell = seller.next();

                if(checkValue(itemToSell, inventory) != -1){
                    System.out.println("Found"); 
                    System.out.println("How many would you like to sell?");
                    sellAmount = seller.nextInt();
                    inventory[checkValue(itemToSell, inventory)].sellSome(sellAmount);
                    System.out.println("Done, there are " + inventory[checkValue(itemToSell, inventory)].getQuantity() + " left.");                    
                }else{
                    System.out.println("Not Found");
                }
                    break;
                /**
                 * Case 7 removes and item
                 */    
            case 7:
                Scanner remover = new Scanner(System.in);
                String itemToRemove = "";
                System.out.println("Which item would you like to remove?");
                itemToRemove = remover.next(); 
                
                if(checkValue(itemToRemove, inventory) > -1){
                    System.out.println("Found"); 
                    inventory[checkValue(itemToRemove, inventory)] = null;
                    shiftInv(inventory);
                    System.out.println("Done");  
                }else{
                    System.out.println("Not Found");
                }
                
                    break;
                /**
                 * Case 8 clears the inventory
                 */    
            case 8:
                clearInv(inventory);
                System.out.println("Done");
                    break;
                /**
                 * Case 9 exits the program
                 */    
            case 9:                
                exit = true;
                System.out.println("Thank you for using Inventory Manager");
                    break;
            default: ;
                     break;
        }
        
        }while(exit == false);
        
        

    }//end of class
    /**
     * Takes input of Item and changes all values to null
     * @param input 
     */
public static void clearInv(Item[] input){
    for(int i = 0; i < input.length; i++){
        input[i] = null;
    }
}
    /**
     * Takes input of Item and shifts all items to beginning of array
     * @param input 
     */
public static void shiftInv(Item[] input){
    for(int i = 0;i < 9; i++){
        if(input[i] == null){
            input[i] = input[i+1];
            input[i+1] = null;
        }
        
    }
}    
    /**
     * Takes input of Item and list all parts of array as a string
     * @param input
     * @return 
     */
public static String listAll(Item[] input){
    String ans = "";
    int tracker = 0;
    
    for(int i = 0; i < 10; i++){
        if(input[i] == null){
            tracker = i-1;
            
    }else{
            ans = ans + "\n" + (tracker+1) + ": " + input[i]; 
        }
        tracker++;
    }

    return ans;
    }
    /**
     * Takes input of a string and an array as a second and compares them to 
     * see if the string matches and of the arrays descriptions
     * @param input1
     * @param input2
     * @return 
     */
public static int checkValue(String input1, Item[] input2){
    int ans = -1;
    for(int i = 0; i < 10; i++){
        if(input2[i] == null){

        }else if(input1.equalsIgnoreCase(input2[i].getDescription())){
            ans = i;
        }
    }
           return ans; 
}

}//end of program
