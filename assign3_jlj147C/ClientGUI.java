package assign3_jlj147C;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;

//Run this class ONLY after running ChatServer.java
//Run this class multiple times to connect as different users
//Client Side Class class that handles the Chatty user interface
public class ClientGUI 
{
	private static ChatClient Client;  //The client
	public static String UserName;    //A username
	
	public static void main(String[] args)
	{
		BuildMainWindow();
		ConfigureMainWindow();
		MainWindow_Action();
		Initialize();
	}
	
	//This method defines the properties of the main chat client window
	public static void BuildMainWindow()
	{
		GUIVariable.MainWindow.setTitle("Chatty");
		GUIVariable.MainWindow.setSize(450,500);
		GUIVariable.MainWindow.setLocation(220,180);
		GUIVariable.MainWindow.setResizable(false);
		GUIVariable.MainWindow.setVisible(true);
	}
	
	//This method defines details of the user interface inside the main window
	public static void ConfigureMainWindow()
	{
		//Add main window
		GUIVariable.MainWindow.setBackground(new java.awt.Color(255, 255, 255));
		GUIVariable.MainWindow.setSize(500,320);
		GUIVariable.MainWindow.getContentPane().setLayout(null);
			
		//Define properties for a connect button
		GUIVariable.ConnectButton.setBackground(new java.awt.Color(50,102,0));
		GUIVariable.ConnectButton.setForeground(new java.awt.Color(255,255,255));
		GUIVariable.ConnectButton.setText("Connect");
		GUIVariable.ConnectButton.setToolTipText("");
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.ConnectButton); //Call get content pane to add interface to client
		GUIVariable.ConnectButton.setBounds(130,40,110,25);
			
		///Define properties for a disconnect button
		GUIVariable.DisconnectButton.setBackground(new java.awt.Color(50,102,0));
		GUIVariable.DisconnectButton.setForeground(new java.awt.Color(255,255,255));
		GUIVariable.DisconnectButton.setText("Disconnect");
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.DisconnectButton); //Call get content pane to add interface to client
		GUIVariable.DisconnectButton.setBounds(10,40,110,25);
			
		///Define properties for a send button
		GUIVariable.SendButton.setBackground(new java.awt.Color(50,102,0));
		GUIVariable.SendButton.setForeground(new java.awt.Color(255,255,255));
		GUIVariable.SendButton.setText("Send");
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.SendButton); //Call get content pane to add interface to client
		GUIVariable.SendButton.setBounds(250,40,81,25);
			
		GUIVariable.TextBoxLabel.setText("Message:");
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.TextBoxLabel);
		GUIVariable.TextBoxLabel.setBounds(10,10,60,20);
			
		GUIVariable.TextFieldMessage.setForeground(new java.awt.Color(50,102,0));
		GUIVariable.TextFieldMessage.requestFocus();
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.TextFieldMessage);
		GUIVariable.TextFieldMessage.setBounds(70,4,260,30);
			
		///Define properties for text to go above conversation pane
		GUIVariable.ConversationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GUIVariable.ConversationLabel.setText("Conversation");
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.ConversationLabel);
		GUIVariable.ConversationLabel.setBounds(100,70,140,16);
			
		///Define properties for the conversation window
		GUIVariable.ConversationArea.setColumns(20);
		GUIVariable.ConversationArea.setRows(5);
		GUIVariable.ConversationArea.setFont(new java.awt.Font("Times New Roman",0,12));
		GUIVariable.ConversationArea.setForeground(new java.awt.Color(0,0,255));
		GUIVariable.ConversationArea.setLineWrap(true);
		GUIVariable.ConversationArea.setEditable(false);
			
		//Define properties for conversation window scroll bar
		GUIVariable.ConversationScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GUIVariable.ConversationScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GUIVariable.ConversationScroll.setViewportView(GUIVariable.ConversationArea);
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.ConversationScroll);
		GUIVariable.ConversationScroll.setBounds(10,90,330,180);
			
		//Define properties for text to go above the users online window
		GUIVariable.OnlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GUIVariable.OnlineLabel.setText("Currently Online");
		GUIVariable.OnlineLabel.setToolTipText("");
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.OnlineLabel);
		GUIVariable.OnlineLabel.setBounds(350,70,130,16);
			
		//List to display users that are online
		GUIVariable.OnlineList.setForeground(new java.awt.Color(50,102,0));
			
		//Define properties for scroll bar for users list
		GUIVariable.OnlineListScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GUIVariable.OnlineListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GUIVariable.OnlineListScroll.setViewportView(GUIVariable.OnlineList);
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.OnlineListScroll);
		GUIVariable.OnlineListScroll.setBounds(350,90,130,180);
			
		GUIVariable.LoginLabel.setFont(new java.awt.Font("Times New Roman",0,12));
		GUIVariable.LoginLabel.setText("Logged in as");
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.LoginLabel);
		GUIVariable.LoginLabel.setBounds(348,0,140,15);
			
		GUIVariable.LoginBoxLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GUIVariable.LoginBoxLabel.setFont(new java.awt.Font("Times New Roman",0,12));
		GUIVariable.LoginBoxLabel.setForeground(new java.awt.Color(50,102,0));
		GUIVariable.LoginBoxLabel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
		GUIVariable.MainWindow.getContentPane().add(GUIVariable.LoginBoxLabel);
		GUIVariable.LoginBoxLabel.setBounds(340,17,150,20);	
	}
	
	//This method maps action listener to the respective methods
	public static void MainWindow_Action()
	{
		//If send button is hit call the send method to send user message to other users
		GUIVariable.SendButton.addActionListener(
				new java.awt.event.ActionListener()
				{
					public void actionPerformed(java.awt.event.ActionEvent evt)
					{
						Action_SendButton();
					}
				}
	       );
		
		//If disconnect button is hit call the disconnect method to disconnect the user from the server
		GUIVariable.DisconnectButton.addActionListener(
				new java.awt.event.ActionListener()
				{
					public void actionPerformed(java.awt.event.ActionEvent evt)
					{
						Action_DisconnectButton();
					}
				}
			);
		
		//If connect button is hit call method that builds a user login window and prompts user to login
		GUIVariable.ConnectButton.addActionListener(
				new java.awt.event.ActionListener()
				{
					public void actionPerformed(java.awt.event.ActionEvent evt)
					{
						BuildLogInWindow();
					}
				}
		    );	
	}
	
	//This method defines properties for the client login window that popups when the connect button is selected
	public static void BuildLogInWindow()
	{
		GUIVariable.LogInWindow.setTitle("What is your name?");
		GUIVariable.LogInWindow.setSize(400,100);
		GUIVariable.LogInWindow.setLocation(250,200);
		GUIVariable.LogInWindow.setResizable(false);
		GUIVariable.LoginPanel=new JPanel();
		GUIVariable.LoginPanel.add(GUIVariable.UserNameLabel);
		GUIVariable.LoginPanel.add(GUIVariable.UserNameTextField);
		GUIVariable.LoginPanel.add(GUIVariable.EnterButton);
		GUIVariable.LogInWindow.add(GUIVariable.LoginPanel);
		
		Login_Action();
		GUIVariable.LogInWindow.setVisible(true);
	}
	
	//Method to make sure that the server is running before it is connected to by a user
	public static void Login_Action()
	{
		GUIVariable.EnterButton.addActionListener(
				new java.awt.event.ActionListener()
				{
					public void actionPerformed(java.awt.event.ActionEvent evt)
					{
						Action_EnterButton(); //Map action listener to enter button
					}
				}
			);
				
	}
	
	//This method sets the initial conditions for when the GUI window is first opened
	public static void Initialize()
	{
		GUIVariable.SendButton.setEnabled(false);        //Disable send button
		GUIVariable.DisconnectButton.setEnabled(false);  //Disable disconnect button
		GUIVariable.ConnectButton.setEnabled(true);     //Enable connect button
	}
	
	
	//This method defines action that are to be taken when the enter button is pressed 
	public static void Action_EnterButton()
	{
		if(!GUIVariable.UserNameTextField.getText().equals(""))
		{
			UserName=GUIVariable.UserNameTextField.getText().trim();
			GUIVariable.LoginBoxLabel.setText(UserName);
			ChatServer.CurrentUsers.add(UserName);        //Add user name into J_List object
			//MainWindow.setTitle(UserName + "'s Chat Box");
			GUIVariable.LogInWindow.setVisible(false);
			GUIVariable.SendButton.setEnabled(true);       //Enable the send button once a user in connected
			GUIVariable.DisconnectButton.setEnabled(true); //Enable the disconnect button once a user is connected
			GUIVariable.ConnectButton.setEnabled(false);
			Connect();                                     //Call connect method after user credentials have been defined
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Please enter your name");
		}
	}

	
	//This method notifies a user if they are connected or not
	public static void Connect()
	{
		try
		{
			final int port = 7111;
			final String host = "DESKTOP-95GQ56F";           //Host name of my PC
			Socket ConnectSocket = new Socket (host,port);   //Build a new socket on the client side
			System.out.println("Connected to: " + host);
			
			Client = new ChatClient(ConnectSocket); //Pass socket to constructor
			
			//Send user name to add to online list
			PrintWriter out = new PrintWriter(ConnectSocket.getOutputStream());
			out.println(UserName);
			out.flush();
			Thread t1 = new Thread(Client);
			t1.start();
		}catch(Exception t1)
		
		{
			System.out.print(t1);
			JOptionPane.showMessageDialog(null, "Server not responding");
			System.exit(0);		
		}
		
	}
	
	
	//This method is called when the send button is clicked, if there is something to send call send function in ChatClient class
	public static void Action_SendButton()
	{
		if (!GUIVariable.TextFieldMessage.getText().equals(""))
		{
			Client.Send(GUIVariable.TextFieldMessage.getText());
			GUIVariable.TextFieldMessage.requestFocus();
		}
	}
	
	//This method is called when the disconnect button is clicked and a call is sent to the Disconnect method in the ChatClient class
	public static void Action_DisconnectButton()
	{
		try
		{
			Client.Disconnect();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	

}
