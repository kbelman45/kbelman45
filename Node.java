package a5;

/**
 * Kevin Belman
 */
public class Node {
    private int x;
    private int y;
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;

    /**
     *  Initializes the node at (0,0).
     */
    public Node() {
        this.x = 0;
        this.y = 0;
    } 

    /**
     * Copy constructor
     */
    public Node(Node other) {
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * Work more on this 
     */
    public Node(int x, int y) {
        validateRange(x, y);
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-cord
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate.
     * param x The new x-coordinate.
     */
    public void setX(int x) {
        validateRange(x, this.y);
        this.x = x;
    }

    /**
     * Gets the y-coordinate.
     * return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate
     */
    public void setY(int y) {
        validateRange(this.x, y);
        this.y = y;
    }

    /**
     * Adds the given node to this node by adding their coordinates.
     */
    public void add(Node other) {
        int newX = this.x + other.x;
        int newY = this.y + other.y;
        validateRange(newX, newY);
        this.x = newX;
        this.y = newY;
    }

    /**
     * Checks if this node is equal to another object.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return x == node.x && y == node.y;
    }

    /**
     
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Validates that the given x and y values are within the allowed range.
     * x The x-coordinate to validate.
     * The y-coordinate to validate.
     *if x or y are out of the valid range.
     */
    private void validateRange(int x, int y) {
        if (x < MIN_VALUE || x > MAX_VALUE || y < MIN_VALUE || y > MAX_VALUE) {
            throw new IllegalArgumentException("x and y must be in the range [" + MIN_VALUE + ", " + MAX_VALUE + "]");
        }
    }
}
