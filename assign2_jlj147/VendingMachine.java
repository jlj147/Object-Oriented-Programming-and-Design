package assign2_jlj147;

import java.util.Scanner;

public class VendingMachine
{	
	
	//Vending machine welcome and directive
	public static void main (String args[])
	{
		Scanner input = new Scanner (System.in);
		
		int option;  //Variable to be used in the main menu for user input
		
		do
		{
			System.out.println ("\nWelcome to the vending machine!");
			System.out.println ("1. Vending");
			System.out.println ("2. Operations");
			System.out.println ("3. Exit \n");
			System.out.print ("Chose an option: ");
			option = input.nextInt();
			
			//if user chooses option 1 go to vending menu
			if (option==1)
			{
				Vending();
			}
			
			//if user chooses option 2 go to operations menu
			if (option==2)
			{
				Operations();
			}
			
			//if user chooses option 3 exit the program
			if (option==3)
			{
				System.out.println("\nThank you for your buisness!");
				break;
			}
			
		}while (option != 1 || option != 2 || option != 3);
		
		input.close();
	}
	
	
	//Function when user chooses vending option in main, closes only when user does not want to make another purchase
	public static void Vending ()
	{
		Scanner input1  = new Scanner (System.in);
		 
		int quantity=0;		//Variable to hold product quantity
		float payment = 0;  //Variable that tracks payment amount
		float amountDue= 0; //Variable that tracks amount due
		int another;
		
		do
		{
		//Call to display product inventory	
		ProductInventory.display();
		
		//Get the users product choice and display it back to them
		ProductInfo userChoice=choice();
		System.out.println ("Your Choice: ");
		userChoice.CurrentInventory();
		
		//Process payment
		amountDue=userChoice.getCost();
		quantity=userChoice.getQuantity();
		
			//If product is available continue with the purchasing process
			if (quantity != 0)
			{
				System.out.printf ("Please Insert $%.2f",amountDue);
				payment = Payment.ProcessPayment(amountDue);
				System.out.printf ("\n\nTotal product cost: $%.2f", amountDue);
				System.out.printf ("\nTotal payment amount: $%.2f", payment);
				
				//If user has full amount to purchase item continue with the purchasing process
				if (payment!=0.00)
				{
					//Return change to user
					Payment.ProcessChange (amountDue,payment);
				
					//Reduce the product quantity after the purchase has been made
					ProductInventory.reduceQuantity(userChoice);
					
					//Add the total payments to the runningtotal
					Payment.runningTotal(amountDue);
				}	
			}
			else
			{
				System.out.println ("This product is not available");
			}
				
			//Prompt user to make another purchase
			System.out.println("\n\nWould you like to make another purchase?");
			System.out.print("Enter 1 for Yes or 0 for No: ");
			another = input1.nextInt();
		
		}while (another==1);
		 
	}
	
	//Function when user chooses opeartions option in main, supports restock feature and removing money from the vending machine
	public static void Operations ()
	{
		Scanner input2 = new Scanner (System.in);
		
		int option1; //Variable to be used in the operations menu for user input
		
		do
		{	
			System.out.println("\n\nOpearitons Menu:");
			System.out.println ("1. Restock");
			System.out.println ("2. Remove Money");
			System.out.println ("3. Exit \n");
			System.out.print("Chose an option: ");
			option1 = input2.nextInt();
			
			if (option1==1)
			{
				ProductInventory.replenishStock();
			}
			
			if (option1==2)
			{
				Payment.removeCash();
			}
			
			if (option1==3)
			{
				break;
			}
			
		}while (option1 != 1 || option1 != 2 || option1 != 3);
		
	}
	
	
	//Function gets users choice of product and returns that choice to the vending machine function
	public static ProductInfo choice ()
	{
		ProductInfo choice = null; //ProductInfo variable to hold users product choice, this variable is returns back to the vending machine function
		int choiceNum;
		boolean flag = false; //Flag makes sure user selects a valid option
		Scanner input3 = new Scanner (System.in);
		
			do
			{
				System.out.print ("Please enter a product number: ");
				choiceNum = input3.nextInt();
		
				if (choiceNum == 1)
				{
					flag = true;
					choice = ProductInventory.product1;
					
				}
				else if (choiceNum == 2)
				{
					flag = true;
					choice = ProductInventory.product2;
				}
		
				else if (choiceNum == 3)
				{
					flag = true;
					choice = ProductInventory.product3;
				}
				else
				{
					System.out.println("Invalid Choice!\n");
					flag = false;
				}
			
			}while (flag!=true);
		
		System.out.println();
		return choice;
	}
}
