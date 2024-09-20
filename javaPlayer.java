package javaplayer;

import java.util.ArrayList; // Imports
import java.util.Scanner;

// can use scanner in main method to ask user for the name 

public class Player {
    // Player attributes
    private String name;                  // Player name
    private int health;                   // Player health
    private ArrayList<String> inventory;  // Inventory to store items (sword, wood, etc.)
    private static final int MAX_INVENTORY_SIZE = 2;  // Max inventory size

    // Constructor
    public Player(String name) {
        this.name = name;
        this.health = 3;
        this.inventory = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    // Setter
    public void setHealth(int health) {
        this.health = health;
    }

    // Method to add item to inventory
    public void addItem(String item) {
        if (inventory.size() < MAX_INVENTORY_SIZE) {
            inventory.add(item);
            System.out.println(item + " added to inventory.");
        } else {
            System.out.println("Inventory is full. You need to drop an item to pick up " + item);
            dropItem(); // Prompt to drop an item
            inventory.add(item); // Add new item after dropping one
            System.out.println(item + " added to inventory.");
        }
    }

    // Method to remove an item from inventory
    public void removeItem(String item) {
        inventory.remove(item);
        System.out.println(item + " removed from inventory.");
    }

    // Method to pick up specific items (wood, sword) Scnerio 1 
    public void pickUpItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to pick up? (wood/sword): ");
        String item = scanner.nextLine();

        if (item.equalsIgnoreCase("wood") || item.equalsIgnoreCase("sword")) {
            addItem(item);
        } else {
            System.out.println("Invalid item. Only 'wood' or 'sword' can be picked up.");
        }
    }
    public void pickUpItem1() { // senerio 2 
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to pick up? (radio/boat): ");
        String item = scanner.nextLine();

        if (item.equalsIgnoreCase("radio") || item.equalsIgnoreCase("boat")) {
            addItem(item);
        } else {
            System.out.println("Invalid item. Only 'radio' or 'boat' can be picked up.");
        }
    }
    
    
    
    
    // Method to drop an item if inventory is full
    public void dropItem() {
        Scanner scanner = new Scanner(System.in);

        // Display current inventory
        System.out.println("Your inventory is full. Choose an item to drop:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }

        // Get user input for which item to drop
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= inventory.size()) {
            String droppedItem = inventory.remove(choice - 1);
            System.out.println(droppedItem + " has been dropped.");
        } else {
            System.out.println("Invalid choice. No item dropped.");
        }
    }
}

		public void takeDamage() {
			    if (health > 0) {
			        health -= 1;
			        System.out.println(name + " took damage! Health is now: " + health);
			    } 
			    if (health == 0) {
			        System.out.println(name + " has no health left! You are dead.");
			        // You can trigger game-over logic here
			        die();
			    }
			}
			
			// Method to handle player death
			private void die() {
			    System.out.println(name + " has died. Game Over!");
			   ( //*can maybe call to the start class to restart the game. )
			    
		    
	