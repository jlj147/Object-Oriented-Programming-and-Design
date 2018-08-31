package assign3_jlj147C;

import java.io.*;
import java.net.*;
import java.util.*;

//This class connects guests with other guests and the server
//Server Side Class that handles new guests connecting the server,server setup for new guests
public class GuestServer implements Runnable
{
	Socket NewGuestSocket;  
	private Scanner input;
	private PrintWriter output;
	String message = "";
	
	//Constructor accepts a socket object for chat
	public GuestServer(Socket NewSocket)
	{
		this.NewGuestSocket=NewSocket;
	}
	
	//This method notifies clients and the server if a new guest has connected,implements runnable interface
	public void run()
	{
		try
		{
			try
			{
				input = new Scanner(NewGuestSocket.getInputStream());
				output = new PrintWriter(NewGuestSocket.getOutputStream());
				
				while(true)
				{
					CheckConnection(); //Call to check connection
					
					//if user has disconnected leave function
					if(!input.hasNext())
					{
						return;
					}
					
					//else establish new connection and notify other clients and the server
					message = input.nextLine();
					System.out.println(message + "\n"); //Print client message
					
					//Connect all other users in the socket array list with a new user
					for (int i=1;i<=ChatServer.ConnectionArray.size();i++)
					{
						Socket ConnectdSocket = ChatServer.ConnectionArray.get(i-1);
						PrintWriter out = new PrintWriter(ConnectdSocket.getOutputStream());
						out.println(message);
						out.flush();
						System.out.print("Sent to: " +  ConnectdSocket.getLocalAddress().getHostName());
					}
				}
			}
			
			finally
			{
				NewGuestSocket.close();
			}
			
		}catch(Exception e) {System.out.print(e);}
		
	}
	
	
	//This method checks too see if a socket is connected
	public void CheckConnection() throws IOException
	{
		if (!NewGuestSocket.isConnected())  //If socket is connected skip; if it is not connected execute
		{
			//Iterate through connection array
			for (int i=1;i<=ChatServer.ConnectionArray.size();i++)
			{
				//If chat server connection array is equal to socket than remove that socket
				//Don't want disconnected socket to remain in array list
				if (ChatServer.ConnectionArray.get(i)==NewGuestSocket)
				{
					ChatServer.ConnectionArray.remove(i);
				}
			}
			
			//Show which user disconnected on the server
			for (int i=1;i <= ChatServer.ConnectionArray.size();i++)
			{
				Socket DisconnectdSocket = ChatServer.ConnectionArray.get(i-1);
				PrintWriter out = new PrintWriter (DisconnectdSocket.getOutputStream());
				out.println(DisconnectdSocket.getLocalAddress().getHostName()+"disconnected");  //Show disconnect at client
				out.flush();
				System.out.println(DisconnectdSocket.getLocalAddress().getHostName()+"disconnected"); //Show disconnect at server
			}
		}
	}

}
