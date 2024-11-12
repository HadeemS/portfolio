/*
 * Hadeem Secka
 */
import java.io.*;

class PrintManager {
    public static void printToConsole(LinkedList<VideoGame> games) {
        games.forEach(System.out::println);
    }

    public static void printToFile(LinkedList<VideoGame> games, String filename, boolean append) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, append))) {
            games.forEach(pw::println);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
