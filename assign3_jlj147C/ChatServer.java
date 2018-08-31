package assign3_jlj147C;

import java.net.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

//Run this class before any other class and then run ClientGUI.java for correct operation
//Server Side Class that creates the server and ArrayLists for sockets and users, handles adding users
public class ChatServer 
{
	public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>(); //Array list that holds all of the connections
	public static ArrayList<String> CurrentUsers = new ArrayList<String>();    //Array list that holds all of the current users
	
	//Main method to start server 
	public static void main(String[] args) throws IOException
	{
		//Try block runs until a connection is made to the server
		try
		{
			final int port = 7111; //Designate a random port > 500
			ServerSocket Server = new ServerSocket(port); //Instantiate a new socket on designated port to begin listening
			System.out.println("Waiting for clients...");
			
			//While loop runs until a connection is made
			while(true)
			{
				Socket ServerSocket = Server.accept();
				ConnectionArray.add(ServerSocket);    //Add new socket connection to connection array when a connection is made
				
				System.out.println("Client connected from: " +ServerSocket.getLocalAddress().getHostName());
				
				AddUserName(ServerSocket); //Add user name to the list of users that are online
				
				GuestServer Chat = new GuestServer (ServerSocket); //Build a chat server return object where
																   //the socket gets passed to the constructor
				Thread t1 = new Thread (Chat);                    //Create a new thread
				t1.start();                                       //Call start on the thread
			}
			
		}catch (Exception e) {System.out.print(e);}
	}
	
	//Method that adds a username to the list of users that are online
	public static void AddUserName (Socket ServerSocket) throws IOException
	{
		Scanner Input = new Scanner(ServerSocket.getInputStream());
		String name = Input.nextLine();
		CurrentUsers.add(name);
	}
	
}
