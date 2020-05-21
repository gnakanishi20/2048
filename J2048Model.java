// Model for Java 2048
// Author: Your Name Here
// This class initializes the pieces and also
// spawns a new piece every time the board is moved.
// The Model also moves the pieces on the board and
// determines if the game has been won.

public class J2048Model {
	// Instance variables
	private int score = 0;
	int DIM = 0;
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int spawnSpaceRow = 0;
	int spawnSpaceCol = 0;
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
	public void init(int[][] board)
	{
		while(a == b) 
		{
			a = (int)(Math.random() * DIM);
			b = (int)(Math.random() * DIM);
		}
		
		c = (int)(Math.random() * DIM);
		d = (int)(Math.random() * DIM);
	
		board[a][c] = 2;
		board[b][d] = 2;
		
	}

	// Spawn a new value in an empty location in the board.
	// 90% of the time, it should be a 2.
	// 10% of the time, it should be a 4.
	public void spawn(int[][] board)
	{
		spawnSpaceRow = (int)(Math.random() * DIM);
		spawnSpaceCol = (int)(Math.random() * DIM);
		
		while(board[spawnSpaceRow][spawnSpaceCol] != 0)
		{
			spawnSpaceRow = (int)(Math.random() * DIM);
			spawnSpaceCol = (int)(Math.random() * DIM);
		}
		spawnVal = (int)(Math.random() * 10);
		
		if(spawnVal == 9)
		{
			board[spawnSpaceRow][spawnSpaceCol] = 4;
		}
		else
		{
			board[spawnSpaceRow][spawnSpaceCol] = 2;
		}
		
	}
	
	//controls the movement of the pieces using w, s, a, d
	//where I write what happens when they combine pieces
	public void move(int[][] board, String dirrection)
	{
		int counter = 0;
		int shift = 0;
		int repeat = 0;
		int repeat2 = 0;
		int movement = 0;
		int movement2 = 0;
		// Scanner kb = new Scanner(System.in);
		// System.out.println("Move:");
		// String move = kb.nextLine();
		String move = dirrection;
		
		if(move.equals("a"))
		{
			for(int i = 1; i < DIM; i++)
			{
				for(int j = 0; j < DIM; j++)
				{
					if(board[j][i] != 0)
					{
						counter = 0;
						while((i - 1 - counter) >= 0 && board[j][i - 1 - counter] == 0)
						{
							board[j][i - 1 - counter] = board[j][i - counter];
							board[j][i - counter] = 0;
							counter++;
						}
					}
				}
			}
			for(int k = 1; k < DIM; k++)
			{
				for(int l = 0; l < DIM; l++)
				{
					if(board[l][k] == board[l][k - 1])
					{
						board[l][k - 1] *= 2;
						board[l][k] = 0;
						score += board[l][k - 1];
					}	
				}

			}
			for(int i = 1; i < DIM; i++)
			{
				for(int j = 0; j < DIM; j++)
				{
						if(board[j][i] != 0)
					{
						counter = 0;
						while((i - 1 - counter) >= 0 && board[j][i - 1 - counter] == 0)
						{
							board[j][i - 1 - counter] = board[j][i - counter];
							board[j][i - counter] = 0;
							counter++;
						}
					}
				}
			}
		}
		
		if(move.equals("w"))
		{
			for(int i = 1; i < DIM; i++)
			{
				for(int j = 0; j < DIM; j++)
				{
					if(board[i][j] != 0)
					{
						counter = 0;
						while((i - 1 - counter) >= 0 && board[i - 1 - counter][j] == 0)
						{
							board[i - 1 - counter][j] = board[i - counter][j];
							board[i - counter][j] = 0;
							counter++;
						}
					}
				}
			}
			for(int k = 1; k < DIM; k++)
			{
				for(int l = 0; l < DIM; l++)
				{
					if(board[k][l] == board[k - 1][l])
					{
						board[k - 1][l] *= 2;
						board[k][l] = 0;
						score += board[k - 1][l];
					}	
				}

			}
			for(int i = 1; i < DIM; i++)
			{
				for(int j = 0; j < DIM; j++)
				{
						if(board[i][j] != 0)
					{
						counter = 0;
						while((i - 1 - counter) >= 0 && board[i - 1 - counter][j] == 0)
						{
							board[i - 1 - counter][j] = board[i - counter][j];
							board[i - counter][j] = 0;
							counter++;
						}
					}
				}
			}
		}
		else if(move.equals("d"))
		{
			for(int j = DIM - 2; j >= 0; j--)
			{
				for(int i = DIM - 1; i >= 0; i--)
				{
					if(board[i][j] != 0)
					{
						shift = 0;
						while((j + 1 + shift) < DIM && board[i][j + 1 + shift] == 0)
						{
							board[i][j + 1 + shift] = board[i][j + shift];
							board[i][j + shift] = 0;
							shift++;
						}
					}
				}
			}
			for(int k = DIM - 2; k >= 0; k--)
			{
				for(int l = DIM - 1; l >= 0; l--)
				{
					if(board[l][k] == board[l][k + 1])
					{
						board[l][k + 1] *= 2;
						board[l][k] = 0;
						score += board[l][k + 1];
					}
				}
			}
			for(int j = DIM - 2; j >= 0; j--)
			{
				for(int i = DIM - 1; i >= 0; i--)
				{
					if(board[i][j] != 0)
					{
						shift = 0;
						while((j + 1 + shift) < DIM && board[i][j + 1 + shift] == 0)
						{
							board[i][j + 1 + shift] = board[i][j + shift];
							board[i][j + shift] = 0;
							shift++;
						}
					}
				}
			}
		}
		else if(move.equals("s"))
		{
			for(int j = DIM - 2; j >= 0; j--)
			{
				for(int i = DIM - 1; i >= 0; i--)
				{
					if(board[j][i] != 0)
					{
						shift = 0;
						while((j + 1 + shift) < DIM && board[j + 1 + shift][i] == 0)
						{
							board[j + 1 + shift][i] = board[j + shift][i];
							board[j + shift][i] = 0;
							shift++;
						}
					}
				}
			}
			for(int k = DIM - 2; k >= 0; k--)
			{
				for(int l = DIM - 1; l >= 0; l--)
				{
					if(board[k][l] == board[k + 1][l])
					{
						board[k + 1][l] *= 2;
						board[k][l] = 0;
						score += board[k + 1][l];
					}
				}
			}
			for(int j = DIM - 2; j >= 0; j--)
			{
				for(int i = DIM - 1; i >= 0; i--)
				{
					if(board[j][i] != 0)
					{
						shift = 0;
						while((j + 1 + shift) < DIM && board[j + 1 + shift][i] == 0)
						{
							board[j + 1 + shift][i] = board[j + shift][i];
							board[j + shift][i] = 0;
							shift++;
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
	public boolean getWin(int[][] board)
	{
		for(int i = 0; i < DIM; i++)
		{
			for(int j = 0; j < DIM; j++)
			{
				if(board[i][j] == 2048)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	//if no more moves return a boolean false
	public boolean getLose(int[][] board)
	{
		int track = 0;
		int equal = 0;
		
		for(int i = 0; i < DIM; i++)
		{
			for(int j = 0; j < DIM; j++)
			{
				if(board[i][j] == 0)
				{
					return false;
				}
			}
		}
		
		for(int k = 0; k < DIM - 1; k++)
		{
			for(int l = 0; l < DIM - 1; l++)
			{
				if(board[l][k] == board[l + 1][k])
				{
					return false;
				}
				
				if(board[k][l] == board[k][l + 1])
				{
					return false;
				}
			}
		}
		
		return true;
	}
}