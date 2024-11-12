import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boardFile, commandFile;

        while (true) {
            System.out.println("Enter file for the Board");
            boardFile = scanner.nextLine();
            System.out.println("Enter file for the Robot Commands");
            commandFile = scanner.nextLine();

            try {
                Board board = new Board(boardFile);  // assuming Board.java is correct
                RobotCommands robotCommands = new RobotCommands(commandFile);  // ensure RobotCommands is defined
                RobotSimulator simulator = new RobotSimulator(board, robotCommands.getCommands());
                simulator.simulate();
            } catch (IOException e) {
                System.out.println("File reading error: " + e.getMessage());
            }

            System.out.println("Quit? Enter \"true\" to quit or hit enter to run another simulation");
            if (scanner.nextLine().equalsIgnoreCase("true")) {
                break;
            }
        }
        scanner.close();
    }
}
