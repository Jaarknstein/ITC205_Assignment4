package tests.verification;

/**
 * Please note, these tests are testing if the bugs FIXED, therefore are true if the bug not exists
 * 
 * A separate group of tests will test if the bug exists. Those tests will pass if a bug exists.
 */

// Import tests
import static org.junit.Assert.*;
import org.junit.*;

// Import for testing
import game.DiceValue;

public class TestBug03Fixed {

	// Test to see if the bug exists
	@Test
	public void testBug03Fixed(){
		
		// Creates 24 rolls
		DiceValue[] rolls = new DiceValue[24];
		
		// Visual output for test
		System.out.println("\ntestBug01Fixed()");
		System.out.println("===========================");
		
		// Setup
		// Assigns the 24 rolls a random DiceValue using .getrandom
		int counter = 0;
		for (DiceValue d : rolls){
			rolls[counter] = DiceValue.getRandom();
			System.out.println(counter + " - " + rolls[counter]);
			counter++;
		}
		
		// Looks for any rolls == SPADES 
		 counter = 0;
		 int match = 1;
		 
		//Assert
		for (DiceValue d : rolls){
			
			if (d == DiceValue.SPADE){
				System.out.println("Spades- "+ match);
				match ++;
			}	
			counter++;
		}
		
		assertTrue(match > 1);
		System.out.println("===========================");
	}
}
