package assign2_jlj147;

import java.util.Scanner;

public class Payment 
{
	static PaymentInfo runningTotal = new PaymentInfo (0);
	
	//Function that processes payment, ProcessPayment is not exited until sufficient funds are provided or until user exits 
	public static float ProcessPayment (float amountDue)
	{
		Scanner input5 = new Scanner (System.in);
		
		char coinage;
		float payment = 0; //Variable to keep track of total payment made by user
		float owe = 0;     //Variable to keep track of how much is still owed 
		double nickel = 0.05;
		double dime = 0.10;
		double quarter = 0.25;
		double dollar = 1.00;
		
		do
		{
			owe = amountDue - payment;
			System.out.printf ("\nYou have inserted a total of: $%.2f", payment);
			System.out.printf ("\nYour total amount still owed is: $%.2f", owe);
			
			System.out.println ("\n\nPayment Options:");
			System.out.println ("Enter N or n to insert a nickle");
			System.out.println ("Enter D or d to insert a dime");
			System.out.println ("Enter Q or q to insert a quarter");
			System.out.println ("Enter W or w to insert a dollar");
			System.out.println ("Enter E or e to exit if insufficeint funds are avaiblabe, payments will be returned");
			
			System.out.print ("Insert payment type: ");
			
			coinage = input5.next().charAt(0);
			
			//If cases depending on type of payment chosen
			if (coinage == 'N' || coinage == 'n')
			{
				payment += nickel;
			}
			
			if (coinage == 'D' || coinage == 'd')
			{
				payment += dime;
			}
			
			if (coinage == 'Q' || coinage == 'q')
			{
				payment += quarter;
			}
			
			if (coinage == 'W' || coinage == 'w')
			{
				payment += dollar; 
			}
			if (coinage == 'E' || coinage == 'e')
			{
				System.out.printf ("\nTotal change returned: $%.2f",payment);
				payment = 0;
				return (payment);
			}
			
		}while (payment < amountDue);
		
		return (payment);
		
	}
	
	//Display to user how much change is being returned to them
	public static void ProcessChange (float amountDue, float total)
	{
		float change = total-amountDue;
		System.out.printf ("\nTotal change returned:$%.2f",change);
	}

	//Accessor to keep a running total of cash in the vending machine
	public static void runningTotal(float newTotal) 
	{
		float runningtotal = runningTotal.getTotal();
		runningtotal += newTotal;
		runningTotal.setTotal(runningtotal);		
	}
	
	//Function to remove cash from the vending machine
	public static void removeCash()
	{
		Scanner input6 = new Scanner (System.in);
		float totalCash = runningTotal.getTotal();
		float remove;
		
		System.out.printf ("\nThe total amount of cash in the vendning machine is: $%.2f",totalCash);
		System.out.print ("\nEnter how much cash you would like to remove in the format 0.00: ");
		
		remove = input6.nextFloat();
		
		//If user tries to remove more cash than is in the machine or enters a negative amount of cash throw an error message
		//else remove cash and update the running total
		if (remove > totalCash)
		{
			System.out.println ("You cannot remove a negative amount of cash or more cash than there is in the machine");
		}
		else
		{
			totalCash = totalCash-remove;
			runningTotal.setTotal(totalCash);
			System.out.printf ("The new total amount of cash in the vendning machine is: $%.2f",totalCash);
		}
		
	}
	

}
