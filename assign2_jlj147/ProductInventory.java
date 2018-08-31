package assign2_jlj147;

import java.util.Scanner;

public class ProductInventory 
{
	
	static ProductInfo product1 = new ProductInfo("Apple",(float) 1.75,5);
	static ProductInfo product2 = new ProductInfo("Banana",(float) 0.25,10);
	static ProductInfo product3 = new ProductInfo("Orange",(float) 1.00,3);
	
	//Function to display product inventory
	public static void display()
	{
		System.out.println("---------------------------------------------------------------");
		System.out.println("Current Invnetory \n");
		
		System.out.println("Product 1:");
		ProductInventory.product1.CurrentInventory();
		
		System.out.println("Product 2:");
		ProductInventory.product2.CurrentInventory();
		
		System.out.println("Product 3:");
		ProductInventory.product3.CurrentInventory();
		System.out.println("---------------------------------------------------------------");
	}
	
	
	//Function to reduce quantity of an item when purchased
	public static void reduceQuantity(ProductInfo userChoice)
	{
		if (userChoice==product1)
		{
			int quantity=product1.getQuantity();
		
			quantity--;
			product1.setQuantity(quantity);
			System.out.println();
		}
		
		if (userChoice==product2)
		{
			int quantity=product2.getQuantity();
			quantity--;
			product2.setQuantity(quantity);
			System.out.println();
		}
		
		if (userChoice==product3)
		{
			int quantity=product3.getQuantity();
			quantity--;
			product3.setQuantity(quantity);
			System.out.println();
		}
		
	}
	
	
	//Function to restock the vending machine
	public static void replenishStock()
	{
		Scanner input4  = new Scanner (System.in);
		
		int productNumber = 0;
		int quantity;
		
		display();
	
		do
		{
			System.out.println ("\nOptions:");
			System.out.println ("Enter a prodcut number (1-3) to restock 1 unit");
			System.out.println ("Enter '4' to return to opeartions menu");
			System.out.println("Enter Product Number:  ");
			productNumber = input4.nextInt();
			
			if (productNumber == 1)
			{
				quantity=product1.getQuantity();
				quantity++;
				product1.setQuantity(quantity);
			}
			
			if (productNumber == 2)
			{
				quantity=product2.getQuantity();
				quantity++;
				product2.setQuantity(quantity);
			}
			
			if (productNumber == 3)
			{
				quantity=product3.getQuantity();
				quantity++;
				product3.setQuantity(quantity);
			}
			
			if (productNumber == 4)
			{
				break;
			}
			
			display();
			
		}while (productNumber !=4);
		
	}
	
}
