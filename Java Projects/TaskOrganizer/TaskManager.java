
/*
 * Hadeem Secka
 *
 */
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private List<Task> tasks;
    private Scanner scanner;

    public TaskManager() {
        tasks = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask() {
        System.out.print("Enter the task's priority: ");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter the task's action: ");
        String action = scanner.nextLine();
        tasks.add(new Task(priority, action));
        System.out.println("Task added successfully!");
    }

    public void removeTask() {
        System.out.print("Enter the task's priority to remove: ");
        int priority = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        tasks.removeIf(task -> task.getPriority() == priority);
        System.out.println("Task(s) with priority " + priority + " removed successfully!");
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void readTasksFromFile() {
        // Print the current working directory
        System.out.println("Current working directory: " + new File(".").getAbsolutePath());
        System.out.print("Enter the file name: ");
        String filename = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                int priority = Integer.parseInt(parts[0].trim());
                String action = parts[1].trim();
                tasks.add(new Task(priority, action));
            }
            System.out.println("Tasks read from file successfully!");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public void writeTasksToFile() {
        System.out.print("Enter the file name: ");
        String filename = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.getPriority() + "\t" + task.getAction());
                writer.newLine();
            }
            System.out.println("Tasks written to file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void run() {
        int choice;
        try {
            do {
                System.out.print("Welcome to the Task Organizer ");
                System.out.println("\nEnter 1. To Add a Task");
                System.out.println("Enter 2. To Remove a Task");
                System.out.println("Enter 3. To Print Tasks To Console");
                System.out.println("Enter 4. To Read from a Task File");
                System.out.println("Enter 5. To Write to a Task File");
                System.out.println("Enter 9. To Quit");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        removeTask();
                        break;
                    case 3:
                        printTasks();
                        break;
                    case 4:
                        readTasksFromFile();
                        break;
                    case 5:
                        writeTasksToFile();
                        break;
                    case 9:
                        System.out.println("Exiting the Task Organizer. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 9);
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.run();
    }
}
