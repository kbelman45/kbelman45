package a6;

import java.util.Scanner;

/**
 * A driver class for interacting with the Nodes 
 */
public class Driver {
    private static Nodes nodes = new Nodes();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Node Manager ---");
            System.out.println("1. Fill");
            System.out.println("2. Clear");
            System.out.println("3. Count Nodes");
            System.out.println("4. Count ThreeDNodes");
            System.out.println("5. Sort");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter the number of nodes to generate: ");
                    int size = scanner.nextInt();
                    nodes.fill(size);
                    System.out.println("Nodes filled.");
                    break;
                case 2:
                    nodes.clear();
                    System.out.println("Nodes cleared.");
                    break;
                case 3:
                    System.out.println("Number of Node objects: " + nodes.countNodes());
                    break;
                case 4:
                    System.out.println("Number of ThreeDNode objects: " + nodes.countThreeDNodes());
                    break;
                case 5:
                    nodes.sort();
                    System.out.println("Nodes sorted.");
                    break;
                case 6:
                    System.out.println("Nodes:\n" + nodes);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
            if (choice != 7) {
                promptEnterKey();
            }
        } while (choice != 7);
    }
    /**
     * Prompts the user 
     */
    private static void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        scanner.nextLine();
    }
}