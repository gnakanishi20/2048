// Controller for Java 2048
// Author: Your Name Here
// This class initializes the pieces and also spawns
// a new piece every time the board is moved.
public class J2048Controller {
	public static void main(String[] args) 
	{
		int DIM = 4;
		int[] board = new int[DIM];
		J2048Model model = new J2048Model(DIM);
		J2048View view = new J2048View(DIM);
		boolean lose = false;
		
		model.init(board);
		
		while(lose == false)
		{
			view.draw(board);
			if(model.getLose(board) == true)
			{
				view.lose(model.getLose(board));
				lose = true;
				break;
			}
			model.move(board);
			model.spawn(board);
			view.printScore(model.getScore());
			view.win(model.getWin(board));
		}
	}
}