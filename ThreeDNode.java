package a6;

/**
 *
 */
public class ThreeDNode extends Node {
    private int z;

    /**
     * Default constructor. Initializes the node at (0, 0, 0).
     * @throws Exception 
     */
    public ThreeDNode() throws Exception {
        super(); // Call Node's default constructor
        this.z = 0;
    }

    /**
     * @param other The ThreeDNode to copy from.
     * @throws Exception 
     */
    public ThreeDNode(ThreeDNode other) throws Exception {
        super(other.getX(), other.getY()); // Call Node's constructor with x and y
        this.z = other.z;
    }

    /**
     * Constructor with x, y, and z coordinates.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param z The z-coordinate.
     * @throws Exception If x, y, or z are out of the valid range.
     */
    public ThreeDNode(int x, int y, int z) throws Exception {
        super(x, y); // Attempt to set x and y via the Node constructor
        this.setZ(correctValue(z)); // Correct z if necessary and set it
    }

    private int correctValue(int value) {
        if (value > INode.UPPER_LIMIT) {
            return INode.UPPER_LIMIT;
        } else if (value < INode.LOWER_LIMIT) {
            return INode.LOWER_LIMIT;
        }
        return value;
    }


    // Getters and setters for z
    public int getZ() {
        return z;
    }

    public void setZ(int z) throws Exception {
        if (z < LOWER_LIMIT || z > UPPER_LIMIT) {
            throw new Exception("z coordinate out of valid range.");
        }
        this.z = z;
    }

    /**
     * @param other The ThreeDNode to add.
     * @throws Exception If the resulting coordinates are out of valid range.
     */
    public void add(ThreeDNode other) throws Exception {
        super.add(other); // Add x and y using Node's add method
        int newZ = this.z + other.z;
        if (newZ < LOWER_LIMIT || newZ > UPPER_LIMIT) {
            throw new Exception("Resulting z coordinate out of valid range.");
        }
        this.z = newZ;
    }

    @Override
    public String toString() {
        return String.format("ThreeDNode(%d, %d, %d)", getX(), getY(), this.z);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ThreeDNode)) return false;
        ThreeDNode other = (ThreeDNode) obj;
        return this.getX() == other.getX() && this.getY() == other.getY() && this.z == other.z;
    }
}