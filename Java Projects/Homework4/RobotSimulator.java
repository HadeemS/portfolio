import java.util.List;

public class RobotSimulator {
    private Board board;
    private List<String> commands;
    private int x, y; // Robot's position

    public RobotSimulator(Board board, List<String> commands) {
        this.board = board;
        this.commands = commands;
        this.x = 0; // Start at top-left corner
        this.y = 0;
    }

    public void simulate() {
        char[][] grid = board.getGrid(); // Access the grid via getter method

        for (int i = 0; i < commands.size(); i++) {
            System.out.println("Command " + i);
            board.printBoard(x, y);

            String command = commands.get(i);
            switch (command.toLowerCase()) {
                case "move up":
                    if (x > 0 && grid[x - 1][y] != 'X') x--;
                    else crash();
                    break;
                case "move down":
                    if (x < grid.length - 1 && grid[x + 1][y] != 'X') x++;
                    else crash();
                    break;
                case "move left":
                    if (y > 0 && grid[x][y - 1] != 'X') y--;
                    else crash();
                    break;
                case "move right":
                    if (y < grid[0].length - 1 && grid[x][y + 1] != 'X') y++;
                    else crash();
                    break;
                default:
                    System.out.println("Invalid command: " + command);
            }
        }

        System.out.println("Simulation end");
    }

    private void crash() {
        System.out.println("CRASH");
        System.exit(0);
    }
}
