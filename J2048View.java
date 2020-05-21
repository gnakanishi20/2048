// View for Java 2048
// Author: Your Name Here
//This class interacts with the user by printing the board to
// the screen along with the current score. It is the only class
// that should System.out.print(). The View should not talk to the Model.
import java.util.Scanner;

public class J2048View {
	// Instance variables
	private int DIM = 0;
	
	// Constructors
	public J2048View(int dim)
	{
		DIM = dim;
	}
	
	public J2048View()
	{
		J2048View view = new J2048View(DIM);
	}
	
	
	// Iterate over each element of board and print its value to the screen.
	// If the value is 0, print a "–" instead.
	public void draw(int[][] board)
	{
		for(int i = 0; i < DIM; i++)
		{
			for(int j = 0; j < DIM; j++)
			{
				if(board[i][j] == 0)
				{
					System.out.printf("%4c", '-');
				}
				else
				{
					System.out.printf("%4d",board[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//prints the score (view.printScore(model.getScore());)
	public void printScore(int score)
	{
		System.out.println("your current score is:" + score);
	}
	
	public String askMove()
	{
		String bank = "a, s, d, w";
		Scanner kb = new Scanner(System.in);
		System.out.println("Move:");
		String move = kb.nextLine();
		while(!bank.contains(move))
		{
			System.out.println("Move entry must be either w, s, a, d:");
			move = kb.nextLine();
		}
		return move;
	}
	//prints if you win or not 
	public void win(boolean win)
	{
		if(win == true)
		{
			System.out.println("congratulations you reached 2048 would you like to continue?");
		}
	}
	
	//prints when you lose
	public void lose(boolean lose)
	{
		if(lose == true)
		{
			System.out.print("Game Over! Your score is: ");
		}
	}
	
	public void printFinalScore(int score)
	{
		System.out.println(score);
	}
}