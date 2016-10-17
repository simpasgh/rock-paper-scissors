package it.com.pasculli.rps.ui;

import it.com.pasculli.rps.domain.ComputerVsComputerGame;
import it.com.pasculli.rps.domain.Game;
import it.com.pasculli.rps.domain.Player;
import it.com.pasculli.rps.domain.PlayerVsComputerGame;
import it.com.pasculli.rps.domain.enums.Move;
import it.com.pasculli.rps.exceptions.GameException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represent the Console UI of Rock Paper Scissors
 * 
 * @author simone
 *
 */
public class ConsoleUI implements Runnable {

	private boolean endGame = false;
	private Game game;

	public void run() {
		
		System.out.println("Welcome to the marvelous Rock - Paper - Scissor game!");
		Scanner scanner = new Scanner(System.in);

		try {
			while (!endGame) {
				System.out.println("Choose your game type (press 1 or 2):");
				System.out.println("1- Player vs Computer");
				System.out.println("2- Computer vs Computer");
				int choice = getIntegerChoice(scanner, 1, 2);
				switch (choice) {
				case 1: // player vs computer
					initPlayerVsComputerGame(scanner);
					break;
				case 2: // computer vs computer
					game = new ComputerVsComputerGame();
					break;
				default:
					break;
				}

				// play the game and print the result
				playTheGame();
				
				// check if the player wants to quit
				System.out.println("Type 'q' followed by return to quit the game");
				String reply = scanner.nextLine();
				endGame = reply.equalsIgnoreCase("q");
			}
		} catch (GameException e) {
			//print the error message
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}

	/*
	 * Get integer option from the keyboard, printing a message if the input is not valid
	 */
	private int getIntegerChoice(Scanner scanner, int min, int max) {
		
		boolean done = false;
		int choice = 0;
		while(!done) {
			try {
				choice = scanner.nextInt();
				if(choice < min || choice > max) {
					System.out.println("Choose one of the options provided");
				} else {
					done = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Please insert a valid numeric choice");
			} finally {
				scanner.nextLine();
			}
		}
		
		return choice;
	}
	
	/*
	 * Manage the UI for player vs computer
	 */
	private void initPlayerVsComputerGame(Scanner scanner) throws GameException {

		// get the player name
		System.out.println("Insert your name: ");
		String playerName = scanner.nextLine();

		// get the player move
		System.out.println("Choose your move (press 1, 2 or 3):");
		System.out.println("1- Rock");
		System.out.println("2- Paper");
		System.out.println("3- Scissors");
		int moveInput = getIntegerChoice(scanner, 1, 3);

		// initialize a new game
		game = new PlayerVsComputerGame(playerName, Move.valueOf(moveInput));
	}

	/*
	 * Play the game and print the result
	 */
	private void playTheGame() throws GameException {
		
		Player human = game.getPlayerOne();
		Player computer = game.getPlayerTwo();
		// play the game and get the result
		Player winner = game.play();
		System.out.println(human.getName() + " played: " + human.getMove());
		System.out.println(computer.getName() + " played: " + computer.getMove());
		
		if (winner != null) { 
			System.out.println("The winner is: " + winner.getName());
		} else { //is a tie
			System.out.println("There is no winner, we have a tie!");
		}
	}
}
