package tests.verification;

/**
 * Please note, these tests are testing if the bugs are FIXED, therefore are true if the bug not exists
 * 
 * A separate group of tests will test if the program is bugged. Those tests will pass if a bug exists.
 */

// Import tests
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Import for testing
import game.Dice;
import game.DiceValue;
import game.Game;
import game.Player;

public class TestBug02Fixed {

	// Declaration of variables
	private Player player;
	private Dice mockDice1, mockDice2, mockDice3;
	private Game game;
	
	// Will run before every test
	@Before
	public void setUp() throws Exception {
		
		// Initialization of variables
		player = new Player("John", 5);
		
		mockDice1 = mock(Dice.class);
		mockDice2 = mock(Dice.class);
		mockDice3 = mock(Dice.class);
	}
	
	
	
	// Will run after every test
	@After
	public void tearDown() throws Exception {
		player = null;
		game = null;
		mockDice1 = null;
		mockDice2 = null;
		mockDice3 = null;
	}
	
	
	
	// Test to see if the bug exists 
	@Test
	public void testLimitIsNormal(){
		when(mockDice1.getValue()).thenReturn(DiceValue.HEART);
		when(mockDice2.getValue()).thenReturn(DiceValue.HEART);
		when(mockDice3.getValue()).thenReturn(DiceValue.HEART);
		game = new Game(mockDice1, mockDice2, mockDice3);
		
		// Setup
		DiceValue pick = DiceValue.SPADE;
		int bet = 5;
		
		// Visual output for test
		System.out.println("\ntestBug02Fixed()");
		System.out.println("===========================");
		
		System.out.println("Balance Before = " + player.getBalance());
		
		// Execute
		game.playRound(player, pick, bet);
		
		System.out.println("Balance After = " + player.getBalance());
		
		//assert
		assert(true); // Will only assert if no exception is called (exception called if bug exists)
		
		System.out.println("Limit not reached when betting 5, on balance of 5");
		System.out.println("===========================");
	}
}
