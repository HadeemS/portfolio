import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Board {
    private char[][] grid; // Keep this private for encapsulation

    public Board(String filePath) throws IOException {
        grid = new char[10][10];
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int row = 0;
        while ((line = reader.readLine()) != null && row < 10) {
            for (int col = 0; col < line.length() && col < 10; col++) {
                grid[row][col] = line.charAt(col);
            }
            row++;
        }
        reader.close();
    }

    // Getter method to access the grid
    public char[][] getGrid() {
        return grid;
    }

    // Method to print the board
    public void printBoard(int robotX, int robotY) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == robotX && j == robotY) {
                    System.out.print('O'); // Robot representation
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
