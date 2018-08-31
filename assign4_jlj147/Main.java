package assign4_jlj147;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

//The main class reads in the predefined game board from a file named "startinggrid.txt" that defines the board
//to be played on. User is also asked how many iterations they wish to run the game through in main
public class Main 
{
	//Define a new game board to be played on
	public static void main (String[] args) throws IOException
	{
		for (int i=0;i<GameBoard.rows*GameBoard.columns;i++)
		{
			GameBoard.board.add(new BoardCell(false));
		}
		
		int X = 0; //Variable that keeps track of row coordinate when reading in grid from file
		int Y = 0; //Variable that keeps track of column coordinate when reading in grid from file
		int c;     //Trace variable for reading in characters from the file
		
		//Read in characters from file using Java function Charset, the file is read in from left to right starting
		//at the top
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("startinggrid.txt"),
						Charset.forName("UTF-8")));
		
		//Stay in while loop until sentinel value is seen at the end of the input file
		while((c=reader.read()) != -1)
		{
			char character = (char) c;
			
			//If the character being read in is a populated cell ('X') then take the ordered pair at which the cell
			//cell lies and set its state in the game board to be true by passing it to the SetState method
			if (character == 'X')
			{
				BoardCell.SetState(new Point(X,Y),true);
				X++;
				
				//Once the end of the row is reached reset column coordinate X to 0 and a advanced row coordinate Y
				//to begin reading the next line of chars
				if (X==20)
				{
					X=0;
					Y++;
				}
			}
			
			//If the character being read in is an unpopulated cell ('O') advance to the next cell
			if (character == 'O')
			{
				X++;
				
				if (X==20)
				{
					X=0;
					Y++;
				}
			}

		}
		
		//Prompt user to enter the number of iterations they wish the game to go through
		System.out.println("Enter the number of game iterations: ");
		Scanner read = new Scanner(System.in);
		int last = read.nextInt();
		Iterations.endIteration = last;
		
		//Create a new timer once iterations have been defined by a user and define the condition for the timer
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(PlayGame.task,100,GameBoard.interval);
		
		//Close scanners
		reader.close();
		read.close();
	}
	
}
