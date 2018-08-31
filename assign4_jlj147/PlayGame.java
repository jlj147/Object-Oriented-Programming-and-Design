package assign4_jlj147;

import java.util.ArrayList;
import java.util.TimerTask;

//This class utilizes threading to play John Conway's Game of Life
//The function runs tests on individual cells that comprise the board using a search function
//and invokes the game rules on the cells to prepare for the next iteration of the game
public class PlayGame 
{
	static TimerTask task = new TimerTask()
	{
		public void run()
		{
			ArrayList<BoardCell> newCell = new ArrayList<BoardCell>(); //Create an ArrayList for the next iteration of the game
			
			 //Enhanced for loop iterates over the cells of the game board to see how many cells are touching and then applies game rules
			for (BoardCell Cell : GameBoard.board)										
			{
				int index = GameBoard.board.indexOf(Cell); //Define a cell index to keep track of location in ArrayList
				int CellsInContact = 0; //Variable that acts as a counter to count the number of touching cells
				
				//Test to see if initial index of cell is in bounds
				if (index + 1 < GameBoard.board.size() && GameBoard.board.get(index+1).state == true)
				{
					CellsInContact++;
				}
				
				//Test for contact with the cell directly above the current cell
				if (index-GameBoard.columns > -1 && GameBoard.board.get(index-GameBoard.columns).state == true)
				{
					CellsInContact++;
				}
				
				//Test for contact with the cell immediately to the left of the current cell
				if (index+GameBoard.columns < GameBoard.board.size() && GameBoard.board.get(index + GameBoard.columns).state == true)
				{
					CellsInContact++;
				}
				
				//Test for contact with the cell directly below the current cell
				if (index -1 > -1 && GameBoard.board.get(index-1).state == true)
				{
					CellsInContact++;
				}
				
				//Test for contact with the cell above and to the right of the current cell
				if (index+GameBoard.columns+1 < GameBoard.board.size() && GameBoard.board.get(index+GameBoard.columns+1).state == true)
				{
					CellsInContact++;
				}
				
				//Test for contact with the cell above and to the left of the current cell
				if (index+GameBoard.columns-1 < GameBoard.board.size() && GameBoard.board.get(index+GameBoard.columns-1).state == true)
				{
					CellsInContact++;
				}
				
				//Test for contact with the cell below and to the right of the current cell
				if (index - GameBoard.columns + 1 > -1 && GameBoard.board.get(index-GameBoard.columns+1).state == true)
				{
					CellsInContact++;
				}
				
				//Test for contact with the cell below and to the left of the current cell
				if (index - GameBoard.columns - 1 > -1 && GameBoard.board.get(index-GameBoard.columns-1).state == true)
				{
					CellsInContact++;
				}
				
				//After testing the current cell for contact, meaning that it is touching cells which contain X's, invoke the game rules on it
				if (Cell.state)
				{
					//If the current cell has less than two populated neighbors then the current cell becomes unpopulated
					if (CellsInContact < 2)
					{
						newCell.add(new BoardCell(false));
					}
					
					//If the current cell has exactly two or exactly three populated neighbors then the current cell stays populated
					else if (CellsInContact == 2 || CellsInContact == 3)
					{
						newCell.add(new BoardCell(true));
					}
					
					//If the current cell has more than three populated neighbors then the current cell becomes unpopulated
					else if (CellsInContact > 3)
					{
						newCell.add(new BoardCell(false));
					}
				}
				
				//If the current cell is unpopulated but it has exactly three populated neighbors then the current cell becomes populated
				else if (CellsInContact == 3)
				{
					newCell.add(new BoardCell(true));
				}
				else
				{
					newCell.add(new BoardCell(false));
				}
			}
			
			GameBoard.board = newCell; //Create a new cell for the next iteration of the game board after states have been set in the test cases
			BoardCell.UpdateCell();    //Update the cell to be used in the next iteration of the game board
			Iterations.currentIteration++;  //Move the current cell onto the next iteration
			
			//If the last iteration is being performed do not update the current cell for the next iteration
			if (Iterations.currentIteration == Iterations.endIteration)
			{
				this.cancel();
			}
		}	
	};
}

