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
		this.playerOne.setName(COMPUTER_ONE);
		this.playerTwo.setName(COMPUTER_TWO);
		
		//set players moves
		AIStrategy strategy = new RandomAIStrategy(); //compute the computer choices
		this.playerOne.setMove(strategy.computeChoice());
		this.playerTwo.setMove(strategy.computeChoice());	
	}

}
