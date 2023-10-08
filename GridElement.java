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
    // GridElement class hierarchy (Composite Pattern)
abstract class GridElement{
    abstract boolean hasObstacle();
}

class Obstacle extends GridElement {
    @Override
    boolean hasObstacle() {
        return true;
    }
}

class EmptySpace extends GridElement {
    @Override
    boolean hasObstacle() {
        return false;
    }
}


