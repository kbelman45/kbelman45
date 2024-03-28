package a5;

/**
 * Glaycon Cezarotto 
 * Object Programming 
 * Represents a node in the xy-coordinate system.
 * Ensures x and y values are within the range [-100, 100].
 * Provides functionalities to get and set x and y, add nodes, and check nodes equality.
 */
public class Node {
    private int x;
    private int y;
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;

    /**
     * Default constructor. Initializes the node at (0,0).
     */
    public Node() {
        this.x = 0;
        this.y = 0;
    } 

    /**
     * Copy constructor. Creates a new node with the same coordinates as the given node.
     * @param other The node to copy from.
     */
    public Node(Node other) {
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * Constructs a node with given x and y values.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @throws IllegalArgumentException if x or y are out of the valid range.
     */
    public Node(int x, int y) {
        validateRange(x, y);
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate.
     * @return The x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate.
     * @param x The new x-coordinate.
     * @throws IllegalArgumentException if x is out of the valid range.
     */
    public void setX(int x) {
        validateRange(x, this.y);
        this.x = x;
    }

    /**
     * Gets the y-coordinate.
     * @return The y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate.
     * @param y The new y-coordinate.
     * @throws IllegalArgumentException if y is out of the valid range.
     */
    public void setY(int y) {
        validateRange(this.x, y);
        this.y = y;
    }

    /**
     * Adds the given node to this node by adding their coordinates.
     * @param other The node to add.
     * @throws IllegalArgumentException if the result is out of the valid range.
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
     * @param obj The object to compare with.
     * @return true if obj is a Node with the same x and y values, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return x == node.x && y == node.y;
    }

    /**
     * Returns a string representation of the node.
     * @return A string in the format "(x, y)".
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Validates that the given x and y values are within the allowed range.
     * @param x The x-coordinate to validate.
     * @param y The y-coordinate to validate.
     * @throws IllegalArgumentException if x or y are out of the valid range.
     */
    private void validateRange(int x, int y) {
        if (x < MIN_VALUE || x > MAX_VALUE || y < MIN_VALUE || y > MAX_VALUE) {
            throw new IllegalArgumentException("x and y must be in the range [" + MIN_VALUE + ", " + MAX_VALUE + "]");
        }
    }
}
