package it.com.pasculli.rps.domain;

import it.com.pasculli.rps.domain.enums.Move;
import it.com.pasculli.rps.domain.strategies.AIStrategy;
import it.com.pasculli.rps.domain.strategies.RandomAIStrategy;
import it.com.pasculli.rps.exceptions.GameException;

/**
 * Represent a game of the player against the computer
 * 
 * @author simone
 *
 */
public class PlayerVsComputerGame extends Game {

	private static final String COMPUTER_NAME = "Computer";

	public PlayerVsComputerGame(String playerName, Move playerMove) throws GameException {
		
		if(playerName == null) {
			throw new GameException("Invalid player name");
		}
		if(playerMove == null) {
			throw new GameException("Invalid player move");
		}

		//set players names
		getPlayerOne().setName(playerName);
		getPlayerTwo().setName(COMPUTER_NAME);
		
		//set players moves
		getPlayerOne().setMove(playerMove);
		AIStrategy strategy = new RandomAIStrategy(); //compute the computer choice
		getPlayerTwo().setMove(strategy.computeChoice());
	}
}
