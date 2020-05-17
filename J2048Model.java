// Model for Java 2048
// Author: Your Name Here
// This class initializes the pieces and also
// spawns a new piece every time the board is moved.
// The Model also moves the pieces on the board and
// determines if the game has been won.
import java.util.Scanner;

public class J2048Model {
	// Instance variables
	private int score = 0;
	int DIM = 0;
	int a = 0;
	int b = 0;
	int spawnSpace = 0;
	int spawnVal = 0;
	// Constructors
	public J2048Model(int dim)
	{
		DIM = dim;
	}
	
	public J2048Model()
	{
		J2048Model model = new J2048Model(4);
	}
	// Methods
	// Fill board with two 2s in random locations.
	//initializes board
	public void init(int[] board)
	{
		while(a == b) 
		{
			a = (int)(Math.random() * DIM);
			b = (int)(Math.random() * DIM);
		}
		
		board[a] = 2;
		board[b] = 2;
		
	}

	// Spawn a new value in an empty location in the board.
	// 90% of the time, it should be a 2.
	// 10% of the time, it should be a 4.
	public void spawn(int[] board)
	{
		spawnSpace = (int)(Math.random() * DIM);
		
		while(board[spawnSpace] != 0)
		{
			spawnSpace = (int)(Math.random() * DIM);
		}
		spawnVal = (int)(Math.random() * 10);
		
		if(spawnVal == 9)
		{
			board[spawnSpace] = 4;
		}
		else
		{
			board[spawnSpace] = 2;
		}
		
	}
	
	//controls the movement of the pieces using w, s, a, d
	//where I write what happens when they combine pieces
	public void move(int[] board)
	{
		int counter = 0;
		int shift = 0;
		Scanner kb = new Scanner(System.in);
		System.out.println("Move:");
		String move = kb.nextLine();
		switch(move)
		{
			case "a":
			case "A":
				for(int i = 1; i < DIM; i++)
				{
					if(board[i] != 0)
					{
						for(int j = i - 1; j >= 0; j--)
						{
							if(board[j] == 0)
							{
								board[j] = board[i];
								board[i] = 0;
								i--;
							}
							else if(board[j] == board[i])
							{
								board[i] *= 2;
								board[j] = 0;
								score += board[i];
							}
						}
					}
				}
			
			case "d":
			case "D":
				for(int i = DIM - 1; i >= 0; i--)
				{
					if(board[i] != 0)
					{
						for(int j = i + 1; j <= DIM - 1; j++)
						{
							if(board[j] == 0)
							{
								board[j] = board[i];
								board[i] = 0;
								i--;
							}
							else if(board[j] == board[i])
							{
								board[i] *= 2;
								board[j] = 0;
								score += board[i];
							}
						}
					}
				}
		}
		
	}
	//tracks the score
	public int getScore()
	{
		return score;
	}
	
	//once a tile = 2048 return boolean true
	public boolean getWin(int[] board)
	{
		for(int i = 0; i < DIM; i++)
		{
			if(board[i] == 2048)
			{
				return true;
			}
		}
		return false;
	}
	
	//if no more moves return a boolean false
	public boolean getLose(int[] board)
	{
		int counter = 0;
		int secondCounter = 0;
		for(int i = 0; i < DIM; i++)
		{
			if(board[i] != 0)
			{
				counter++;
			}
		}
		for(int j = 0; j < DIM - 1; j++)
		{
			if(board[j] != board[j + 1])
			{
				secondCounter++;
			}
		}
		
		if(secondCounter == DIM && counter == DIM)
		{
			return true;
		}
		return false;
	}
}