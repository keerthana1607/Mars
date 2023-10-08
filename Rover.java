/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ei;

/**
 *
 * @author keerthana
 */
public class Rover {
    
    
    private int x;
    private int y;
    private Direction direction;
    private Grid grid;

    

    Rover(Grid grid, int startX, int startY, Direction initialDirection) {
    this.grid = grid;
    x = startX;
    y = startY;
    direction = initialDirection;
}


    // Direction enum
    enum Direction {
        N, E, S, W
    }

    public void move() {
    int newX = x;
    int newY = y;

    switch (direction) {
        case N:
            newY++;
            break;
        case E:
            newX++;
            break;
        case S:
            newY--;
            break;
        case W:
            newX--;
            break;
    }

    if (!grid.hasObstacleAt(newX, newY)) {
        x = newX;
        y = newY;
    }
}


    public void turnLeft() {
        // Turn the rover left.
        direction = Direction.values()[(direction.ordinal() + 3) % 4];
    }

    public void turnRight() {
        // Turn the rover right.
        direction = Direction.values()[(direction.ordinal() + 1) % 4];
    }

    public String getStatusReport() {
        // Generate the status report.
        String position = "(" + x + ", " + y + ")";
        return "Rover is at " + position + " facing " + direction + ". No Obstacles detected.";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
