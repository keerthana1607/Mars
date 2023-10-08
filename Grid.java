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

    // Grid class (Composite Pattern)
class Grid {
    
    private final int gridSizeX;
    private final int gridSizeY;
    private GridElement[][] grid;

    public Grid(int sizeX, int sizeY) {
        gridSizeX = sizeX;
        gridSizeY = sizeY;
        grid = new GridElement[sizeX][sizeY];
        // Initialize all grid elements as empty spaces.
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                grid[x][y] = new EmptySpace();
            }
        }
    }

    public void addObstacle(int x, int y) {
        // Add an obstacle to the grid.
        grid[x][y] = new Obstacle();
    }

    public boolean hasObstacleAt(int x, int y) {
    // Treat out-of-bounds positions as obstacles.
    return x < 0 || x >= gridSizeX || y < 0 || y >= gridSizeY || grid[x][y].hasObstacle();
}

    // Implement getWidth() method
    public int getWidth() {
        return gridSizeX;
    }

    // Implement getHeight() method
    public int getHeight() {
        return gridSizeY;
    }
}
