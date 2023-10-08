# Mars
# MarsRover
- The program uses an `enum` named `Direction` to represent the four cardinal directions (N for North, S for South, E for East, and W for West).
- It takes user input for the width and height of the grid, which represents the surface of Mars.
- The program prompts the user to enter the number of obstacles on the grid and their positions (x, y coordinates).
- It initializes a `Grid` object with the specified width and height and adds obstacles to it based on the user's input.
- The program then prompts the user to enter the starting position (x, y) and direction (N, S, E, or W) for the Mars rover.
- It initializes a `Rover` object with the specified starting position and direction.
- The program prompts the user to enter a sequence of commands (e.g., 'M' for move, 'L' for turn left, 'R' for turn right) for the rover.
- It processes the user's commands and updates the rover's position and direction accordingly.
- Finally, the program generates a status report, displaying the rover's final position and the sequence of commands executed.
- The program closes the scanner to release system resources.
# Grid
Instance Variables:
  - gridSizeX: An integer representing the width (number of columns) of the grid.
  - gridSizeY: An integer representing the height (number of rows) of the grid.
  - grid: A 2D array of `GridElement` objects representing the elements of the grid.
- The constructor takes the width (`sizeX`) and height (`sizeY`) of the grid as parameters.
- It initializes the `gridSizeX` and `gridSizeY` based on the provided size.
- It initializes the `grid` array as a 2D array of `GridElement` objects and fills it with `EmptySpace` objects to represent initially empty grid cells.
- addObstacle(int x, int y): This method is used to add an obstacle to the grid at the specified position `(x, y)`. It updates the corresponding element in the `grid` array to represent an obstacle.
- hasObstacleAt(int x, int y): This method checks if there is an obstacle at the specified position `(x, y)` on the grid. It also considers positions outside the grid bounds as obstacles to prevent the rover from moving outside the grid.
- getWidth(): This method returns the width (number of columns) of the grid.
- getHeight(): This method returns the height (number of rows) of the grid.
# Grid Element
- `GridElement` is the abstract base class for elements within the grid.
- It defines an abstract method `hasObstacle()` that concrete subclasses must implement.
- The purpose of this class is to provide a common interface for both obstacles and empty spaces in the grid.
- `Obstacle` is a concrete subclass of `GridElement`.
- It overrides the `hasObstacle()` method to return `true`, indicating that this grid element contains an obstacle.
- `EmptySpace` is another concrete subclass of `GridElement`.
- It overrides the `hasObstacle()` method to return `false`, indicating that this grid element is empty and does not contain an obstacle.
# Rover
. Fields:
   - `x` and `y`: These fields represent the current coordinates (position) of the rover on the grid.
   - `direction`: This field represents the current direction in which the rover is facing (north, east, south, or west).
   - `grid`: This field holds a reference to the grid on which the rover is operating.
- The constructor initializes the rover with the provided starting position (`startX` and `startY`) and initial direction (`initialDirection`).
- The `Direction` enum defines the possible directions the rover can face: North (N), East (E), South (S), and West (W).
- The `move` method is responsible for moving the rover one step forward in the current direction.
- It calculates the new coordinates (`newX` and `newY`) based on the current direction and checks if there is an obstacle at the new position using the `grid.hasObstacleAt(newX, newY)` method.
- If there is no obstacle at the new position, the rover's position (`x` and `y`) is updated to the new coordinates.
- These methods are used to change the direction of the rover.
- `turnLeft()` turns the rover 90 degrees counterclockwise, and `turnRight()` turns it 90 degrees clockwise.
- The rover's direction is updated accordingly.
- The `getStatusReport` method generates a status report for the rover, including its current position (x, y), the direction it's facing, and a message indicating that no obstacles are detected.
- The status report is returned as a string.
- Getter methods (`getX()`, `getY()`, `getDirection()`) are provided to access the rover's current position and direction.
