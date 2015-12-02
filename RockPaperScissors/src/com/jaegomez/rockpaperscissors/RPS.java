package com.jaegomez.rockpaperscissors;

/**
 * Julio Gomez
 * December 1st, 2015
 *
 * Description: Built a full functional Rock Paper Scissors game in Java.
 *
 */

import java.util.Random;
import java.util.Scanner;

public class RPS {

    /**
     * determineWinner
     *
     * Check who wins the round
     * rock beats scissors
     *
     * @param playerMove: The choice the player made (rock, paper, scissors)
     * @param computersMove
     * @return playerWon: True if player wins false otherwise
     */
    // Here we are creating a function which will basicallly determine who is the winner
    public static Boolean determineWinner(String playerMove, String computersMove) {
        Boolean playerWon;
        System.out.println("Player Move: " + playerMove);

        if (playerMove.equals("rock") && computersMove.equals("scissors")) {
            playerWon = true;
        } else if (playerMove.equals("scissors") && computersMove.equals("paper")) {
            playerWon = true;
        } else if (playerMove.equals("paper") && computersMove.equals("rock")) {
            playerWon = true;
        } else {
            playerWon = false;
        }

        return playerWon;

    }

    public static String chooseComputerMove() {
        /**
         * created the chooseComputerMove function which will be where we use Random and determine what the computer
         * picked as their move which will be at a Random choice
         */
        String[] possibilities = {"rock", "paper", "scissors"};
        Random random = new Random();
        return possibilities[random.nextInt(possibilities.length)];
    }

    public static void main(String[] args) {
        /**
         * This is the main function where basically most of the work will get done.
         *
         */
        // Here I created some variables
        Integer totalWins = 0;
        Integer totalLoses = 0;
        // userChoice is null for now until it gets called
        String userChoice;
        Boolean playerWon;
        String computersChoice;
        //New scanner created
        Scanner scanner = new Scanner(System.in);
        // Determines when to stop the game if either totalWins or totalLoses exceeds 2
        while (totalWins < 2 && totalLoses < 2) {

            while (true) {
                //here we are asking rock paper scissors
                System.out.print("Pick: rock, paper, scissors");
                userChoice = scanner.nextLine();

                /** Here is basically all of the logic where it will keep prompting the user to type in a correct
                 * choice or if he chooses to exit the game.
                 */
                if (userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors")) {
                    break;
                } else if (userChoice.equals("exit")) {
                    System.exit(0);
                } else {
                    System.out.println("Not a valid choice");
                }
            }
            // called the chooseComputerMove function so it runs that code
            computersChoice = chooseComputerMove();

            // Here we call the determineWinner function so it runs that code and then we pass it the correct parameters
            playerWon = determineWinner(userChoice, computersChoice);

            if (playerWon == true) {
                System.out.println("You win! The Computer picked " + computersChoice + ", computer loses! ");
                totalWins++;
            } else if (playerWon == false && userChoice.equals(computersChoice)) {
                System.out.println("TIE TIE!!");
            } else {
                System.out.println("You lost! Computer picked " + computersChoice);
                totalLoses++;
            }
        }

        // This is basically what will just end the game, and tell the player if they won or lost.
        if (totalWins >= 2) {
            System.out.println("You beat the computer, Goodjob!");
        } else {
            System.out.println("You lose!");
        }
    }

}
