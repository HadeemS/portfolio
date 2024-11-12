/*
 * Hadeem Secka
 */
import java.util.Scanner;

public class VideoGameDatabase {
    private static LinkedList<VideoGame> gameList = new LinkedList<>();
    private static LinkedList<VideoGame> searchResults = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Video Game Database!");

        while (running) {
            System.out.println("\nEnter 1 to load the video game database");
            System.out.println("Enter 2 to search the database");
            System.out.println("Enter 3 to print current results to the console");
            System.out.println("Enter 4 to print current results to file");
            System.out.println("Enter 0 to quit");
            System.out.print("\nYour choice: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter the file name: ");
                    String filename = scanner.nextLine();
                    gameList = FileManager.loadGamesFromFile(filename);
                    System.out.println("Game collection loaded.");
                    break;

                case 2:
                    System.out.print("Enter the name of the game or '*' for all: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the name of the console or '*' for all: ");
                    String console = scanner.nextLine();

                    searchResults = GameSearch.search(gameList, title, console);
                    if (searchResults != null) {
                        System.out.println("\nSearch Results:");
                        PrintManager.printToConsole(searchResults);
                    } else {
                        System.out.println("No games found.");
                    }
                    break;

                case 3:
                    if (searchResults != null) {
                        System.out.println("\nCurrent Search Results:");
                        PrintManager.printToConsole(searchResults);
                    } else {
                        System.out.println("No results to display. Please perform a search first.");
                    }
                    break;

                case 4:
                    if (searchResults != null) {
                        System.out.print("Enter the file name: ");
                        String outFile = scanner.nextLine();
                        System.out.print("Would you like to append? True or false? ");
                        boolean append = scanner.nextBoolean();
                        scanner.nextLine(); // consume newline

                        PrintManager.printToFile(searchResults, outFile, append);
                        System.out.println("Results printed to file.");
                    } else {
                        System.out.println("No results to save. Please perform a search first.");
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
