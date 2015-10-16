package tests.recreation;

/**
 * Please note, these tests are testing if the bugs EXIST, therefore are true if the bug exists
 * 
 * A separate group of tests will test if the program is fixed. Those tests will fail if a bug exists.
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

public class TestBug02Replicate {

	// Declaration of variables
	private Player player;
	private Dice mockDice1, mockDice2, mockDice3;
	private Game game;
	
	// Will run before every test
	@Before
	public void setUp() throws Exception {
		
		// Initialization of variables
		// Balance is 5 to test limit
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
	@Test(expected=IllegalArgumentException.class) // Will throw if bug exists
	public void testBug02Exist(){
		when(mockDice1.getValue()).thenReturn(DiceValue.HEART);
		when(mockDice2.getValue()).thenReturn(DiceValue.HEART);
		when(mockDice3.getValue()).thenReturn(DiceValue.HEART);
		
		game = new Game(mockDice1, mockDice2, mockDice3);
		
		// Setup
		DiceValue pick = DiceValue.SPADE;
		int bet = 5;
		
		// Execute
		game.playRound(player, pick, bet);
	}
}
