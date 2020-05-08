// Model for Java 2048
// Author: Your Name Here
// This class initializes the pieces and also
// spawns a new piece every time the board is moved.
// The Model also moves the pieces on the board and
// determines if the game has been won.

public class J2040Model {
	// Instance variables
	
	// Constructors
	
	// Methods
	// Fill board with two 2s in random locations.
	//initializes board
	public void init(int[] board)

	// Spawn a new value in an empty location in the board.
	// 90% of the time, it should be a 2.
	// 10% of the time, it should be a 4.
	public void spawn(int[] board)
	
	//controls the movement of the pieces using w, s, a, d
	//where I write what happens when they combine pieces
	public void move(int[] board)
	
	//tracks the score
	public void getScore(int[] board)
	
	//once a tile = 2048 return boolean true
	public boolean getWin(int[] board)
	
	//if no more moves return a boolean false
	public boolean getLose(int[] board)
	
	
}