// View for Java 2048
// Author: Your Name Here
//This class interacts with the user by printing the board to
// the screen along with the current score. It is the only class
// that should System.out.print(). The View should not talk to the Model.

public class J2040View {
	// Instance variables
	
	// Constructors
	
	// Iterate over each element of board and print its value to the screen.
	// If the value is 0, print a "–" instead.
	public void draw(int[] board)
	
	//prints the score (view.printScore(model.getScore());)
	public void printScore(int score)
	
	//prints if you win or not 
	public void win(boolean win)
	
	//prints when you lose
	public void lose(boolean lose)
}