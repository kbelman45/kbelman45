package a6;

import java.util.Comparator;

/**
 * A comparator for sorting INode objects 
 */
public class Sorter implements Comparator<INode> {

    @Override
    public int compare(INode node1, INode node2) {
        int sum1 = sumCoordinates(node1);
        int sum2 = sumCoordinates(node2);
        return Integer.compare(sum1, sum2);
    }

    /**
     * @param node The node whose coordinates are to be summed.
     * @return The sum of the node's coordinates, or 0 if the node type is not recognized.
     */
    private int sumCoordinates(INode node) {
        if (node instanceof Node) {
            Node castedNode = (Node) node;
            int sum = castedNode.getX() + castedNode.getY();
            if (node instanceof ThreeDNode) {
                sum += ((ThreeDNode) node).getZ();
            }
            return sum;
        }
        return 0; // Return 0 for unrecognized types
    }
}