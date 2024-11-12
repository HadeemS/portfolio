/**
 *  Hadeem Secka
 */
public class Clothing {
    // Instance variables with private scope
    private String type; // Type of clothing
    private String color; // Color of the clothing
    
    // Default values
    private static final String DEFAULT_TYPE = "Socks";
    private static final String DEFAULT_COLOR = "Black";
    
    // Array of valid types
    private static final String[] VALID_TYPES = {"Undergarment", "Socks", "Stockings", "Top", "Bottom", "Cape"};
    // Array of valid colors
    private static final String[] VALID_COLORS = {"Brown", "Red", "Pink", "Black", "White", "Orange", "Green", "Blue", "Purple", "Grey"};
    
    /**
     * Default constructor - sets properties to default values.
     */
    public Clothing() {
        this.type = DEFAULT_TYPE;
        this.color = DEFAULT_COLOR;
    }
    
    /**
     * Parameterized constructor - sets properties based on given values if valid, else defaults.
     */
    public Clothing(String type, String color) {
        setType(type); // Checks and sets type, default if invalid
        setColor(color); // Checks and sets color, default if invalid
    }
    
    // Accessor methods
    public String getType() {
        return this.type;
    }
    
    public String getColor() {
        return this.color;
    }
    
    // Mutator methods
    public void setType(String type) {
        if (isValidValue(type, VALID_TYPES)) {
            this.type = type;
        } else {
            this.type = DEFAULT_TYPE; // Set to default if invalid
        }
    }
    
    public void setColor(String color) {
        if (isValidValue(color, VALID_COLORS)) {
            this.color = color;
        } else {
            this.color = DEFAULT_COLOR; // Set to default if invalid
        }
    }
    
    /**
     * Checks if the given value is in the array of valid values.
     */
    private boolean isValidValue(String value, String[] validValues) {
        for (String validValue : validValues) {
            if (value.equals(validValue)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns a string representation of the Clothing instance.
     */
    public String toString() {
        return "[Clothing] Type: " + this.type + " Color: " + this.color;
    }
    
    /**
     * Checks if this Clothing instance is equal to another based on type and color.
     */
    public boolean equals(Clothing other) {
        return this.type.equals(other.type) && this.color.equals(other.color);
    }
}
