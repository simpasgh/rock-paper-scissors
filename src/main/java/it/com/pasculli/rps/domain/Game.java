package it.com.pasculli.rps.domain;

import it.com.pasculli.rps.domain.enums.Result;
import it.com.pasculli.rps.exceptions.GameException;


/**
 * Represent a game
 * 
 * @author simone
 *
 */
public abstract class Game {

	private Player playerOne = new Player();
	private Player playerTwo = new Player();

	/**
	 * Play the game returning the winner
	 * @return the winner {@link it.com.pasculli.rps.domain.Player} or null for a tie
	 * @throws GameException 
	 */
	public Player play() throws GameException {
		
		Player winner = null;
		
		//check if the game is correctly initialized
		if(playerOne == null || playerOne.getMove() == null ||
			playerTwo == null || playerTwo.getMove() == null) {
			throw new GameException("Game not correctly initialized");
		}

		// compute the game result
		Result result = playerOne.getMove().challenge(playerTwo.getMove());
		switch (result) {
		case WIN:
			winner = playerOne;
			break;
		case LOSE:
			winner = playerTwo;
			break;
		case TIE:
			winner = null;
			break;
		default:
			break;
		}
		
		return winner;
	}

	/**
	 * Returns the {@link it.com.pasculli.rps.domain.Player} one
	 * 
	 * @return
	 */
	public Player getPlayerOne() {
		return playerOne;
	}

	/**
	 * Returns the {@link it.com.pasculli.rps.domain.Player} two
	 * 
	 * @return
	 */
	public Player getPlayerTwo() {
		return playerTwo;
	}



}
