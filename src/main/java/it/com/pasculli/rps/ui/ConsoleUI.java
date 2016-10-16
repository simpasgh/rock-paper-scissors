package it.com.pasculli.rps.ui;

import java.util.Scanner;

import it.com.pasculli.games.rps.GameTest;
import it.com.pasculli.rps.domain.Game;

/**
 * Represent the game of Rock Paper Scissors
 * @author simone
 *
 */
public class ConsoleUI implements Runnable {
	
	private boolean endGame = false;
	
	private Game game;
	
	public static void main(String[] args) {
		new ConsoleUI().run();
	}

	public void run() {
		System.out.println("Welcome to the marvelous Rock - Paper - Scissor game!");
		Scanner scanner = new Scanner(System.in);

		try {
			while(!endGame) {
				System.out.println("Choose your game type (press 1, 2 or 3):");
				System.out.println("1- Player vs Computer");
				System.out.println("2- Computer vs Computer");
				System.out.println("3- Player vs Player");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					
					break;

				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

}
