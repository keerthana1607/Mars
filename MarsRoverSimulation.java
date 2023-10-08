/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ei;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author keerthana
 */

    public class MarsRoverSimulation {
    
public enum Direction {
        N, S, E, W
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = 0;
        int height = 0;

        boolean validInput = false;

        while (!validInput) {
            try {
                // Prompt the user for grid size
                System.out.print("Enter the width of the grid: ");
                width = scanner.nextInt();

                System.out.print("Enter the height of the grid: ");
                height = scanner.nextInt();

                validInput = true; // Input is valid, exit the loop
            } catch (InputMismatchException e) {
                // Input is not an integer, clear the scanner buffer and try again
                System.out.println("Invalid input. Please enter integers for grid size.");
                scanner.nextLine(); // Clear the scanner buffer
            }
        }

        // Initialize the grid with the specified size
        Grid grid = new Grid(width, height);

        // Prompt the user for obstacle positions
        int numObstacles;
        do {
            System.out.print("Enter the number of obstacles: ");
            numObstacles = scanner.nextInt();
        } while (numObstacles < 0);

        for (int i = 1; i <= numObstacles; i++) {
            int obstacleX, obstacleY;
            do {
                System.out.print("Enter obstacle " + i + " 'x' position: ");
                obstacleX = scanner.nextInt();

                System.out.print("Enter obstacle " + i + " 'y' position: ");
                obstacleY = scanner.nextInt();
            } while (obstacleX < 0 || obstacleY < 0);

            if (obstacleX >= 0 && obstacleX < grid.getWidth() && obstacleY >= 0 && obstacleY < grid.getHeight()) {
    grid.addObstacle(obstacleX, obstacleY);
    System.out.println("obstacle is added");
} else {
    System.out.println("Invalid obstacle coordinates. Coordinates must be within the grid boundaries.");
}

        }

        // Prompt the user for the starting position of the rover
        int startX, startY;
        String startDirection;
        do {
            System.out.print("Enter starting position 'x': ");
            startX = scanner.nextInt();

            System.out.print("Enter starting position 'y': ");
            startY = scanner.nextInt();

            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter starting direction (N, S, E, W): ");
            startDirection = scanner.nextLine().toUpperCase();
        } while (startX < 0 || startY < 0 || !startDirection.matches("[NSWE]"));

        // Initialize the rover with the specified starting position and direction
        Direction initialDirection = Direction.valueOf(startDirection);
        Rover rover = new Rover(grid, startX, startY, Rover.Direction.N);

        // Initialize the rover
        
        // Get and execute commands from the user
        System.out.print("Enter commands (e.g., 'M', 'L', 'R'): ");
        String commandsStr = scanner.next();
        String[] commands = commandsStr.split("");

        for (String command : commands) {
            switch (command) {
                case "M":
                    rover.move();
                    break;
                case "L":
                    rover.turnLeft();
                    break;
                case "R":
                    rover.turnRight();
                    break;
            }
        }

        // Generate the status report
        String statusReport = rover.getStatusReport();
        System.out.println("Final Position: (" + rover.getX() + ", " + rover.getY() + ", " + rover.getDirection() + ")");
        System.out.println("Status Report: " + statusReport);

        // Close the scanner
        scanner.close();
    }
}
