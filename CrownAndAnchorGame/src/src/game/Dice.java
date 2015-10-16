package game;
public class Dice {
			
	private DiceValue value;
	
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return value;
	}

	public void roll() {
		value = DiceValue.getRandom(); // Was bug04
	}		
	
	@Override
	public String toString() {
		return value.toString();
	}
}
