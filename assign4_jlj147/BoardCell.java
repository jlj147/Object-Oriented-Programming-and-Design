package assign4_jlj147;

import java.awt.Point;

//This class defines a cell on the board and contains methods that handle the cells
public class BoardCell 
{
	public static final char populated = 'X';    //Indicates that there is a populated cell on the board
	public static final char unpopulated = 'O';  //Indicates that there is an unpopulated cell on the board
	public boolean state;                        //Boolean variable for state of the cell, true if populated,
												 //false if unpopulated
	
	//Constructor for the state of a cell
	public BoardCell(boolean state)
	{
		this.state = state;
	}
	
	//This method uses the Java Point function to define an ordered pair (x,y) for each cell on the board
	//and give it state.
	//When this method is called an 'X' exists at a point that is passed in, the state passed in is always true
	//If the point passed in is a valid location in the 20x20 grid that is the board then set the state of the point 
	public static void SetState (Point Cell,boolean state)
	{
		if (Cell.x < GameBoard.columns && Cell.y < GameBoard.rows)
		{
			GameBoard.board.get(GameBoard.columns* Cell.y+Cell.x).state = state;
		}
	}  
	
	//This method updates cells for each iteration of the game, it keeps track of the state of each cell
	public static void UpdateCell()
	{
		System.out.println();
		System.out.println();
		System.out.println("Iteration:" + Iterations.currentIteration); //Print iteration of game above each board
		
		//Loop through each cell and print those that are populated and unpopulated after each iteration of the game
		for (int y=0;y<GameBoard.rows;y++)
		{
			for (int x=0;x<GameBoard.columns;x++)
			{
				if (GameBoard.board.get(GameBoard.columns*y+x).state == true)
				{
					System.out.print(BoardCell.populated);
				}
				else
				{
					System.out.print(BoardCell.unpopulated);
				}
			}
				System.out.println();
			
		}
		
	}
}
