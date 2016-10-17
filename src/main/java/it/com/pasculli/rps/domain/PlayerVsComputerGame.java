package it.com.pasculli.rps.domain;

import it.com.pasculli.rps.domain.enums.Move;
import it.com.pasculli.rps.domain.strategies.AIStrategy;
import it.com.pasculli.rps.domain.strategies.RandomAIStrategy;

/**
 * Represent a game of the player against the computer
 * 
 * @author simone
 *
 */
public class PlayerVsComputerGame extends Game {

	private static final String COMPUTER_NAME = "Computer";

	public PlayerVsComputerGame(String playerName, Move playerMove) {

		//set players names
		this.playerOne.setName(playerName);
		this.playerTwo.setName(COMPUTER_NAME);
		
		//set players moves
		this.playerOne.setMove(playerMove);
		AIStrategy strategy = new RandomAIStrategy(); //compute the computer choice
		this.playerTwo.setMove(strategy.computeChoice());
	}
}
