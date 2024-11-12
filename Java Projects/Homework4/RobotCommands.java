import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class RobotCommands {
    private LinkedList<String> commands;

    public RobotCommands(String filename) throws IOException {
        this.commands = new LinkedList<>();

        // Read the file and populate the queue with valid commands
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            line = line.trim();
            if (line.equalsIgnoreCase("Move Up") || 
                line.equalsIgnoreCase("Move Down") || 
                line.equalsIgnoreCase("Move Left") || 
                line.equalsIgnoreCase("Move Right")) {
                commands.add(line);
            }
        }
    }

    // Get all commands in the queue
    public LinkedList<String> getCommands() {
        return commands;
    }
}
