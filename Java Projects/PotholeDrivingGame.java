/* Hadeem Secka
 * 
 */
import java.util.Random;
import java.util.Scanner;

public class PotholeDrivingGame {
    private static final int SIZE = 10;
    private static final char[][] board = new char[SIZE][SIZE];
    private static final Random random = new Random();
    private static int playerX = 0;
    private static int playerY = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            initializeGame();// Initializes the game board with '_' for empty spaces, 'X' for the player's starting position, and '^' for the home. It also randomly places 5 'O' as potholes on the board, ensuring they are in unique positions.

            boolean gameEnded = false;

            System.out.println("Welcome to Pothole Driving! Get home while avoiding potholes!\n");

            while (!gameEnded) {
                displayBoard(); // Displays the current state of the game board to the console, replacing the 'O' (potholes) with '_' to hide them from the player, revealing only the player's position 'X' and the home '^'.

                System.out.println("Enter either a -1, 0, or 1 in the X or 9 to quit");
                int moveX = scanner.nextInt();
                if (moveX == 9) {
                    System.out.println("Goodbye!");
                    return;
                }

                System.out.println("Enter either a -1, 0, or 1 in the Y");
                int moveY = scanner.nextInt();
                // Processes the player's move based on input directions. It checks for boundary conditions and pothole encounters. If the player reaches the home or hits a pothole, the game ends. Otherwise, updates the player's position on the board.

                gameEnded = movePlayer(moveX, moveY);
            }

            System.out.println("Would you like to play again?");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Goodbye!");
    }

    private static void initializeGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '_';
            }
        }

        board[0][0] = 'X';
        board[SIZE - 1][SIZE - 1] = '^';

        for (int i = 0; i < 5; i++) {
            int x, y;
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (board[x][y] == 'O' || (x == 0 && y == 0) || (x == SIZE - 1 && y == SIZE - 1));

            board[x][y] = 'O';
        }
    }

    private static void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 'O') {
                    System.out.print("_");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static boolean movePlayer(int moveX, int moveY) {
        int newX = playerX + moveX;
        int newY = playerY + moveY;
     // Validates the player's intended move to ensure it's within the board boundaries and not an illegal move. Updates the game state by moving the player or ending the game based on the move's outcome.

        if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE) {
            if (board[newX][newY] == 'O') {
                System.out.println("OH NO! POTHOLE!");
                return true;
            } else if (board[newX][newY] == '^') {
                System.out.println("Congratulations, you made it home!");
                return true;
            } else {
                board[playerX][playerY] = '_';
                playerX = newX;
                playerY = newY;
                board[playerX][playerY] = 'X';
            }
        } else {
            System.out.println("Invalid move, try again.");
        }
        return false;
    }
}
