/*
 * Hadeem Secka
 */
import java.io.*;

class FileManager {
    public static LinkedList<VideoGame> loadGamesFromFile(String filename) {
        LinkedList<VideoGame> games = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    games.add(new VideoGame(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return games;
    }
}
