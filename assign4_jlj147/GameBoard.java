package assign4_jlj147;

import java.util.ArrayList;

//This method defines the game board as a 20x20 grid and the speed at which the game is to be played
public class GameBoard 
{
	static int columns = 20;    //Number of columns on the board (X-Axis)
	static int rows = 20;       //Number of rows on the board (Y-Axis)
	static int interval = 100;  // Time between iterations of game in milliseconds 
	static ArrayList <BoardCell> board = new ArrayList <BoardCell>(); //Define a 20X20 game board made up of cells
}
