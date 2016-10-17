package it.com.pasculli.rps.domain;

import it.com.pasculli.rps.domain.enums.Result;


/**
 * Represent an abstract game
 * 
 * @author simone
 *
 */
public abstract class Game {

	protected Player playerOne = new Player();
	protected Player playerTwo = new Player();

	/**
	 * Play the game returning the winner
	 * @return the winner {@link it.com.pasculli.rps.domain.Player} or null for a tie
	 */
	public Player play() {
		
		Player winner = null;

		// compute the game result
		Result result = playerOne.getMove().challenge(playerTwo.getMove());
		switch (result) {
		case WIN:
			winner = playerOne;
			break;
		case LOSE:
			winner = playerTwo;
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
