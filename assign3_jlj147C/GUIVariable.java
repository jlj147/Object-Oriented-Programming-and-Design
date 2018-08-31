package assign3_jlj147C;

import javax.swing.*;

//Client Side Class that defines variables to be used in creating the client GUI
public class GUIVariable 
{
	//Graphical interface for the main chat window
	public static JFrame MainWindow =  new JFrame();
	public static JButton ConnectButton = new JButton();
	public static JButton DisconnectButton = new JButton();
	public static JButton SendButton = new JButton();
	public static JLabel TextBoxLabel = new JLabel("Message: ");
	public static JLabel ConversationLabel = new JLabel();
	public static JLabel OnlineLabel = new JLabel();
	public static JLabel LoginLabel = new JLabel();
	public static JLabel LoginBoxLabel = new JLabel();
	public static JScrollPane ConversationScroll = new JScrollPane();
	public static JScrollPane OnlineListScroll = new JScrollPane();
	public static JTextField TextFieldMessage = new JTextField(20);
	public static JTextArea ConversationArea =  new JTextArea();
	public static JList OnlineList = new JList();
	
	//Graphical interface for the login window
	public static JFrame LogInWindow = new JFrame();
	public static JTextField UserNameTextField = new JTextField(20);
	public static JButton EnterButton = new JButton("Enter");
	public static JLabel UserNameLabel = new JLabel("Enter username: ");
	public static JPanel LoginPanel = new JPanel();
}
