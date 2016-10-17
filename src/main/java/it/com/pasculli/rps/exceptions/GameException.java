package it.com.pasculli.rps.exceptions;

/**
 * Represents an exception for the game
 * @author simone
 *
 */
public class GameException extends Exception {

	private static final long serialVersionUID = -8504021793625411436L;

	public GameException(String message) {
		super(message);
	}

}
