package assign3_jlj147C;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

//Client Side Class that handles messages between users and the server
public class ChatClient implements Runnable
{
	Socket NewClientSocket;
	Scanner input;
	Scanner send = new Scanner(System.in);
	PrintWriter out;
	
	//Constructor takes a socket as an argument or parameter
	public ChatClient(Socket ClientSocket)
	{
		this.NewClientSocket=ClientSocket;
	}
	
	
	//Run method that implements the runnable interface
	public void run()
	{
		try
		{
			try
			{
				input = new Scanner (NewClientSocket.getInputStream());
				out = new PrintWriter (NewClientSocket.getOutputStream());
				out.flush();
				CheckStream();  //Call to CheckStram method to see if a new message has been received on a connected socket
			}
			
			finally
			{
				NewClientSocket.close();
			}
			
		}catch (Exception e) {System.out.print(e);}
	}
	
	//Method to show the user that they have disconnected
	public void Disconnect() throws IOException
	{
		out.println(ClientGUI.UserName + " has disconnected");
		out.flush();
		NewClientSocket.close();
		JOptionPane.showMessageDialog(null, "You have disconnected");
		System.exit(0);
	}
	
	
	//This method is a buffer that uses a while true loop to call the receive method to continue checking for new messages from a user
	public void CheckStream()
	{
		while(true)
		{
			receive();
		}
	}
	
	//This method checks to see if a user has any message to send over the server to other clients
	public void receive()
	{
		if(input.hasNext())
		{
			String message = input.nextLine();
			GUIVariable.ConversationArea.append(message + "\n");
		}
	}
	
	//Sends a user message when the send button has been clicked
	public void Send (String userMessage)
	{
		out.println(ClientGUI.UserName + ": " + userMessage);
		out.flush();
		GUIVariable.TextFieldMessage.setText("");
	}

}
