package it.com.pasculli.rps.ui;

import java.io.ByteArrayInputStream;

import org.junit.Test;

/**
 * Class that test the flows of the {@link it.com.pasculli.rps.ui.ConsoleUI}
 * @author simone
 *
 */
public class ConsoleUITest {
	
	private final static String PLAYER_NAME = "Simone\n";
	private final static String PVC = "1\n";
	private final static String CVC = "2\n";
	private final static String ROCK = "1\n";
	private final static String PAPER = "2\n";
	private final static String SCISSORS = "3\n";
	private final static String QUIT = "q\n";

	@Test
	public void runPvCRockTest() {

		ConsoleUI ui = new ConsoleUI();
		
		String input = PVC+PLAYER_NAME+ROCK+QUIT;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ui.run();
	}
	
	@Test
	public void runPvCPaperTest() {

		ConsoleUI ui = new ConsoleUI();
		
		String input = PVC+PLAYER_NAME+PAPER+QUIT;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ui.run();
	}
	
	
	@Test
	public void runPvCScissorsTest() {

		ConsoleUI ui = new ConsoleUI();
		
		String input = PVC+PLAYER_NAME+SCISSORS+QUIT;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ui.run();
	}
	
	@Test
	public void runCvCTest() {

		ConsoleUI ui = new ConsoleUI();
		
		String input = CVC+QUIT;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ui.run();
	}
}
