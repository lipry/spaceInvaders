/*Instances of the Gun class (extending BattleFieldElement) represent a gun. There
cannot be more than one gun at a time in the configuration (an IllegalElementEx-ception should be raised upon attempting to create more than one gun). 
When a gun gets destroyed (either because it is hit by a shot or because it has collided with an alien), 
it gets replaced by another gun, whose initial position is the first entry on the left on the bottom line of the battlefield. At every step, the gun
moves, one cell at a time, in some direction (at the beginning, from the left to right) until reaching the border of the battlefield,
and then it inverts its direction. A gun can only exist on the bottom line, otherwise an IllegalPositionException should be thrown.*/


public class Gun extends BattleFieldElement{

	//FIELD
	private static int gunCounter=0;
	private int direction;
	
	//CONSTRUCTOR
	public Gun(int h,int v) throws IllegalElementException{
		gunCounter++;
		if(gunCounter!=1)
			throw new IllegalElementException("Only one Gun per BattleField");
		else 
			if(v != 0 /* battlefield's height */ )
				throw new IllegalPositionException("The Gun can only be placed in the bottom line of the BattleField");
			else{
				super( h,v );				
				direction=1;				//from left to right
			}	
	}
	
	//METHODS

	public int getXOffset(){
		return 0;
	}
	
	public int getYOffset(){
		return 0;
	}
	
	public void changeDirection(){
		this.direction *= -1;			//every call of this method change the direction	
										// -1= right to left		1= left to right
	}
	
	public String toString(){
		String info=""
					+super.toString()
					+"Type: Gun\n";		
		return info;
	}
	
	
	
}