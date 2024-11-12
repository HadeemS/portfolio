/**
 *  Hadeem Secka 
 */
public class Dresser {
    // A 2D array representing 5 drawers, each can hold up to 10 items of clothing
    private Clothing[][] clothes;
    
    /**
     * Default constructor - initializes the clothes array with the correct dimensions.
     */
    public Dresser() {
        clothes = new Clothing[5][10]; // 5 drawers, each with a capacity of 10
    }
    
    /**
     * Adds a piece of clothing to the correct drawer based on its type.
     */
    public void add(Clothing item) {
        int drawerIndex = getDrawerIndex(item.getType());
        if (drawerIndex == -1) {
            System.out.println("Invalid clothing type.");
            return;
        }
        
        // Find the first available spot in the correct drawer
        for (int i = 0; i < clothes[drawerIndex].length; i++) {
            if (clothes[drawerIndex][i] == null) {
                clothes[drawerIndex][i] = item;
                print(); // Print contents after adding
                return;
            }
        }
        
        System.out.println("Drawer is full. Cannot add more items.");
    }
    
    /**
     * Removes a piece of clothing from the dresser, if it exists.
     */
    public void remove(Clothing item) {
        for (int i = 0; i < clothes.length; i++) {
            for (int j = 0; j < clothes[i].length; j++) {
                if (clothes[i][j] != null && clothes[i][j].equals(item)) {
                    clothes[i][j] = null; // Remove the item
                    print(); // Print contents after removing
                    return;
                }
            }
        }
        System.out.println("Item not found in the dresser.");
    }
    
    /**
     * Prints out every piece of clothing's information in the dresser.
     */
    public void print() {
        for (int i = 0; i < clothes.length; i++) {
            for (int j = 0; j < clothes[i].length; j++) {
                if (clothes[i][j] != null) {
                    System.out.println(clothes[i][j]);
                }
            }
        }
    }
    
    /**
     * Determines the drawer index based on the type of clothing.
     */
    private int getDrawerIndex(String type) {
        switch (type) {
            case "Undergarment":
                return 0;
            case "Socks":
            case "Stockings":
                return 1;
            case "Top":
                return 2;
            case "Bottom":
                return 3;
            case "Cape":
                return 4;
            default:
                return -1; // Invalid type
        }
    }
}
