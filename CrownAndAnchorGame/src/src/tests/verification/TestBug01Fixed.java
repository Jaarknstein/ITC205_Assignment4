package tests.verification;

/**
 * Please note, these tests are testing if the bugs are FIXED, therefore are true if the bug does not exist.
 * 
 * A separate group of tests will test if the bugs exist. Those tests will pass if a bug exists.
 */

// Import tests
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.*;

// Import for testing
import game.Dice;
import game.DiceValue;
import game.Game;
import game.Player;

public class TestBug01Fixed {

	// Declaration of variables
	private Player player;
	private Dice mockDice1, mockDice2, mockDice3;
	private Game game;
	
	// Will run before every test
	@Before
	public void setUp() throws Exception {
		
		// Initialization of variables
		player = new Player("John", 100);
		
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
	
	
	
	// Test to see if the bug exists (Note, only one match is used)
	@Test
	public void testIsNormal(){
		when(mockDice1.getValue()).thenReturn(DiceValue.SPADE);
		when(mockDice2.getValue()).thenReturn(DiceValue.HEART);
		when(mockDice3.getValue()).thenReturn(DiceValue.HEART);
		
		game = new Game(mockDice1, mockDice2, mockDice3);
		
		int expectedWinnings = 5; // Expected winnings if bug exists
		

		// Setup
		DiceValue pick = DiceValue.SPADE;
		int balance = player.getBalance();
		int bet = 5;
		
		// Execute
		int winning = game.playRound(player, pick, bet);
		
		// Assert
		assertNotEquals(expectedWinnings, winning);
		
		// Visual output for test
		System.out.println("\ntestBug01Exist()");
		System.out.println("===========================");
		System.out.println("Name = " + player.getName());
		System.out.println("Balance = " + balance);
		System.out.println("Bet = " + bet);
		System.out.println("Pick = " + pick);
		System.out.println("Dice Rolled = " + mockDice1.getValue() + ", " + mockDice2.getValue() + ", " + mockDice3.getValue()); 
		System.out.println("Expected Winnings (bug) = " + expectedWinnings);
		System.out.println("Winning = " + winning);
		System.out.println("===========================");
	}
	
	
	
	// Test to see if the bug exists (Note, 2 matches are used)
	@Test
	public void testIsNormal2Match(){
		when(mockDice1.getValue()).thenReturn(DiceValue.SPADE);
		when(mockDice2.getValue()).thenReturn(DiceValue.SPADE);
		when(mockDice3.getValue()).thenReturn(DiceValue.HEART);
		
		game = new Game(mockDice1, mockDice2, mockDice3);
		
		int expectedWinnings = 10; // Expected winnings if bug exists
		

		// Setup
		DiceValue pick = DiceValue.SPADE;
		int balance = player.getBalance();
		int bet = 5;
		
		// Execute
		int winning = game.playRound(player, pick, bet);
		
		// Assert
		assertNotEquals(expectedWinnings, winning);
		
		// Visual output for test
		System.out.println("\ntestBug01Exist2Match()");
		System.out.println("===========================");
		System.out.println("Name = " + player.getName());
		System.out.println("Balance = " + balance);
		System.out.println("Bet = " + bet);
		System.out.println("Pick = " + pick);
		System.out.println("Dice Rolled = " + mockDice1.getValue() + ", " + mockDice2.getValue() + ", " + mockDice3.getValue()); 
		System.out.println("Expected Winnings(bug) = " + expectedWinnings);
		System.out.println("Winning = " + winning);
		System.out.println("===========================");
	}
	
	
	
	// Test to see if the bug exists (Note, 3 matches are used)
	@Test
	public void testIsNormal3Match(){
		when(mockDice1.getValue()).thenReturn(DiceValue.SPADE);
		when(mockDice2.getValue()).thenReturn(DiceValue.SPADE);
		when(mockDice3.getValue()).thenReturn(DiceValue.SPADE);
		
		game = new Game(mockDice1, mockDice2, mockDice3);
		
		int expectedWinnings = 15; // Expected winnings if bug exists
		

		// Setup
		DiceValue pick = DiceValue.SPADE;
		int balance = player.getBalance();
		int bet = 5;
		
		// Execute
		int winning = game.playRound(player, pick, bet);
		
		// Assert
		assertNotEquals(expectedWinnings, winning);
		
		// Visual output for test
		System.out.println("\ntestBug01Exist3Match()");
		System.out.println("===========================");
		System.out.println("Name = " + player.getName());
		System.out.println("Balance = " + balance);
		System.out.println("Bet = " + bet);
		System.out.println("Pick = " + pick);
		System.out.println("Dice Rolled = " + mockDice1.getValue() + ", " + mockDice2.getValue() + ", " + mockDice3.getValue()); 
		System.out.println("Expected Winnings(bug) = " + expectedWinnings);
		System.out.println("Winning = " + winning);
		System.out.println("===========================");
	}
}
