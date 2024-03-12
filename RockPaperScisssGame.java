package m;
import java.util.Scanner;
import java.util.Random;

/*
 * Kevin Belman
 * Object Programming class
 * 2/26/2024
 * The purpose is to play a rock paper scissor game with the user of the programm.
 */
public class RockPaperScissorsGame {
	
	//Displays the intro banner
	private static void printWelcomeBanner() {
        System.out.println("Welcome to the Rock, Paper, Scissors Game! Lets enjoy this!!");
        System.out.println("The rules are of this game:");
        System.out.println("Use 1 for Rock, 2 for Paper, 3 for Scissors");
    }
	//Randomizes the comuter's answer in this programm
	private static int generateComputerChoice() {
        Random random = new Random();
        return random.nextInt(3) + 1; 
    }
	private static int getUserChoice(Scanner scanner) {
        System.out.println("Enter your choice (1 for Rock, 2 for Paper, 3 for Scissors):");
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.next());
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
	//Displays 
	 private static void displayComputerChoice(int computerChoice) {
	        switch (computerChoice) {
	            case 1 -> System.out.println("Computer chooses Rock");
	            case 2 -> System.out.println("Computer choses Paper");
	            case 3 -> System.out.println("Computer choses Scissors");
	        }
	    }
	 //Determines who won the game for ths programm
	 private static void determineWinner(int computerChoice, int userChoice) {
	        if (computerChoice == userChoice) {
	            System.out.println("It's a great tie! WOWWWW LETS PLAY AGAIN?.");
	        } else if ((computerChoice == 1 && userChoice == 3) ||
	                   (computerChoice == 2 && userChoice == 1) ||
	                   (computerChoice == 3 && userChoice == 2)) {
	            System.out.println("Computer wins the game!!!!");
	        } else {
	            System.out.println("You win the gameee great game player!");
	        }
	    }
	 // the loop to ask the player if they want to restart the game
	 private static boolean PlayAgain(Scanner scanner) {
	        System.out.println("Do you want to play again??? (Y/N):");
	        String input = scanner.next();
	     // Loop until the user inputs a valid response (y or n) 
	        while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
	            System.out.println("Invalid input. Please enter Y for yes or N for no.");
	            input = scanner.next();
	        }
	        return input.equalsIgnoreCase("Y");
	    }
	 //Main program 
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        printWelcomeBanner();
	        boolean keepPlaying = true;

	        while (keepPlaying) {
	            int computerChoice = generateComputerChoice();
	            int userChoice = getUserChoice(scanner);
	            displayComputerChoice(computerChoice);
	            determineWinner(computerChoice, userChoice);
	            keepPlaying = PlayAgain(scanner);
	        }

	        System.out.println("Thank you for playing, see you again!");
	        scanner.close();

	}

}
