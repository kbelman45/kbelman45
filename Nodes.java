package a6;

import java.util.ArrayList;
import java.util.Collections;

public class Nodes {
    private ArrayList<INode> nodes;

    public Nodes() {
        this.nodes = new ArrayList<>();
    }

    public void fill(int size) {
        nodes.clear(); // Ensure the list is empty
        for (int i = 0; i < size; i++) {
            try {
                if (Math.random() > 0.5) {
                    nodes.add(NodeFactory.getNode());
                } else {
                    nodes.add(NodeFactory.getThreeDNode());
                }
            } catch (Exception e) {
                // 
                System.out.println("Error creating a node: " + e.getMessage());
            }
        }
    }

    /**
     * Clears the collection of all nodes.
     */
    public void clear() {
        nodes.clear();
    }

    /**
     * Counts the number 
     * @return The count of Node objects.
     */
    public int countNodes() {
        int count = 0;
        for (INode node : nodes) {
            if (node instanceof Node && !(node instanceof ThreeDNode)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @return The count of ThreeDNode objects.
     */
    public int countThreeDNodes() {
        int count = 0;
        for (INode node : nodes) {
            if (node instanceof ThreeDNode) {
                count++;
            }
        }
        return count;
    }

    /**
     * Sorts the collection based on the sum
     */
    public void sort() {
        Collections.sort(nodes, new Sorter());
    }

    /**
     * @return A multi-line string, each representing a node.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (INode node : nodes) {
            sb.append(node.toString()).append("\n");
        }
        return sb.toString().trim(); // Trim to remove 
    }
}