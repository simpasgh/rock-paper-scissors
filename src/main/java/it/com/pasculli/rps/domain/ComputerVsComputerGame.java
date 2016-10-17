package it.com.pasculli.rps.domain;

import it.com.pasculli.rps.domain.strategies.AIStrategy;
import it.com.pasculli.rps.domain.strategies.RandomAIStrategy;

/**
 * Represent a game of the computer against himself...
 * 
 * @author simone
 *
 */
public class ComputerVsComputerGame extends Game {
	
	private final static String COMPUTER_ONE = "Computer One";
	private final static String COMPUTER_TWO = "Computer Two";
	
	public ComputerVsComputerGame() {

		//set players names
		getPlayerOne().setName(COMPUTER_ONE);
		getPlayerTwo().setName(COMPUTER_TWO);
		
		//set players moves
		AIStrategy strategy = new RandomAIStrategy(); //compute the computer choices
		getPlayerOne().setMove(strategy.computeChoice());
		getPlayerTwo().setMove(strategy.computeChoice());	
	}

}
