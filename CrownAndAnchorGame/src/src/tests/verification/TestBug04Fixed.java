package tests.verification;

import static org.junit.Assert.assertFalse;

/**
 * Please note, these tests are testing if the bugs are fixed, therefore are true if the bug does not exists
 * 
 * A separate group of tests will test if the program is bugged. Those tests will pass if a bug exists.
 */

// Import tests
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Import for testing
import game.Dice;
import game.DiceValue;
import game.Game;
import game.Player;

public class TestBug04Fixed {

	// Declaration of variables
	private Player player;
	private Dice dice1, dice2, dice3;
	private Game game;
	DiceValue[] round1 = new DiceValue[3];
	DiceValue[] round2 = new DiceValue[3];

	// Will run before every test
	@Before
	public void setUp() throws Exception {

		// Initialization of variables
		player = new Player("John", 100);

		dice1 = new Dice();
		dice2 = new Dice();
		dice3 = new Dice();
	}
	
	

	// Will run after every test
	@After
	public void tearDown() throws Exception {
		dice1 = null;
		dice2 = null;
		dice3 = null;
		game = null;
	}
	
	

	// Test to see if the bug is fixed
	@Test
	public void testRollingIsNormal() {

		DiceValue pick = DiceValue.SPADE;
		int bet = 5;

		game = new Game(dice1, dice2, dice3);

		// Execute
		game.playRound(player, pick, bet);
		round1[0] = dice1.getValue();
		round1[1] = dice2.getValue();
		round1[2] = dice3.getValue();

		game.playRound(player, pick, bet);
		round2[0] = dice1.getValue();
		round2[1] = dice2.getValue();
		round2[2] = dice3.getValue();

		assertFalse(Arrays.equals(round1, round2));

		// Visual output for test
		System.out.println("\ntestBug04Fixed()");
		System.out.println("===========================");

		for (DiceValue d : round1) {
			System.out.print(d + " ");
		}

		System.out.print("\n");

		for (DiceValue d : round2) {
			System.out.print(d + " ");
		}

		System.out.print("\n");
		System.out.println("===========================");
	}
}
