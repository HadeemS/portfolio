/**
 *  Hadeem Secka
 */
import java.util.Scanner;

public class DresserFrontEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dresser dresser = new Dresser();

        while (true) {
            System.out.println("Welcome to the dresser!");
            System.out.println("Enter 1: to add an item");
            System.out.println("Enter 2: to remove an item");
            System.out.println("Enter 3: to print out the dresser contents");
            System.out.println("Enter 9: to quit");
            System.out.print("\n");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after number

            switch (choice) {
                case 1: // Add clothes
                    System.out.println("Enter the type");
                    System.out.println("It may be undergarment, socks, stockings, top, bottom, or cape");
                    String type = scanner.nextLine().trim().toLowerCase();
                    System.out.println("Enter a color");
                    System.out.println("It may be brown, pink, orange, green, blue, purple, or grey");
                    String color = scanner.nextLine().trim().toLowerCase();
                    Clothing clothing = new Clothing(type.substring(0, 1).toUpperCase() + type.substring(1),
                                                     color.substring(0, 1).toUpperCase() + color.substring(1));
                    dresser.add(clothing);
                    break;
                case 2: // Remove clothes
                    System.out.println("Enter the type");
                    System.out.println("It may be undergarment, socks, stockings, top, bottom, or cape");
                    type = scanner.nextLine().trim().toLowerCase();
                    System.out.println("Enter a color");
                    System.out.println("It may be brown, pink, orange, green, blue, purple, or grey");
                    color = scanner.nextLine().trim().toLowerCase();
                    clothing = new Clothing(type.substring(0, 1).toUpperCase() + type.substring(1),
                                            color.substring(0, 1).toUpperCase() + color.substring(1));
                    dresser.remove(clothing);
                    break;
                case 3: // Print dresser contents
                    dresser.print();
                    break;
                case 9: // Quit
                    System.out.println("Goodbye");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

