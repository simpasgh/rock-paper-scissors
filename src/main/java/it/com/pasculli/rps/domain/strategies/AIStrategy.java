package it.com.pasculli.rps.domain.strategies;

import it.com.pasculli.rps.domain.enums.Move;

/**
 * Represent a strategy for the Computer choices
 * @author simone
 *
 */
public interface AIStrategy {
	
	/**
	 * Compute the computer choice and return the chosen {@link it.com.pasculli.rps.domain.enums.Move} 
	 * @return
	 */
	public Move computeChoice();

}
