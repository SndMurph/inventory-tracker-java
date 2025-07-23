package inventorymanage;

import java.util.Scanner;
import java.sql.SQLException;

public class InventoryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager db = new DatabaseManager();

        try {
            db.connect();
            System.out.println("Connected to database.");

            while (true) {
                System.out.println("\n1. View Items\n2. Add Item\n3. Delete Item\n4. Update Quantity\n5. Update Price\n0. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                if (choice == 1) {
                    for (InventoryItem item : db.getAllItems()) {
                        System.out.println(item);
                    }
                } else if (choice == 2) {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    db.addItem(name, quantity, price);
                    System.out.println("Item added.");
                } else if (choice == 3){
                	 for (InventoryItem item : db.getAllItems()) {
                         System.out.println(item);
                     }
                	 
                	System.out.print("Enter the ID of the item to delete: ");
                    int id = scanner.nextInt();
                    db.deleteItem(id);      
                    
                } else if (choice == 4){
               	 for (InventoryItem item : db.getAllItems()) {
                     System.out.println(item);
                 }
               	 
            	System.out.print("Enter the ID of the item to update quantity: ");
                int id = scanner.nextInt();
                System.out.print("Enter the new quantity of the item: ");
                int quantity = scanner.nextInt();
                if(quantity<0){
                	quantity=0;
                }
                db.updateQuantity(id, quantity);  
                
                
                
                InventoryItem updated = db.getItemById(id); // Displays updated item or not found message
                if (updated != null){
                    System.out.println("Updated item:");
                    System.out.println(updated);
                } else{
                    System.out.println("Item not found.");
                }
                
            } else if (choice == 5){       
               	 for (InventoryItem item : db.getAllItems()) {
                     System.out.println(item);
                 }
               	 
            	System.out.print("Enter the ID of the item to update price: ");
                int id = scanner.nextInt();
                System.out.print("Enter the new price of the item: ");
                double price = scanner.nextDouble();
                if(price<=0){
                	price=0.01;
                }
                db.updatePrice(id, price);  
                

                
                InventoryItem updated = db.getItemById(id);
                if (updated != null) {
                    System.out.println("Updated item:");
                    System.out.println(updated);
                } else {
                    System.out.println("Item not found.");
                }
                
            } else if (choice == 0) {
                    break;
                }
            }

            db.disconnect();
            System.out.println("Disconnected.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}