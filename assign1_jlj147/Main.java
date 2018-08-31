package assign1_jlj147;

public class Main 
{
	public static void main (String[] args)
	{
		PizzaRecord APizza = new PizzaRecord(); //Assign name 'APizza' to pizza record reference, to be invoked when creating a new object
		APizza.first = null;
		enqueue (APizza, new Pizza ("pepperoni","1234 Bobact Trail"));       //Creating a new PizzaRecord to be sent to queue
		enqueue (APizza, new Pizza ("sausage","2345 University Drive"));
		deliver (APizza);												     //Deliver first pizza record sitting in queue
		enqueue (APizza, new Pizza ("extra cheese", "3456 Rickster Road"));
		enqueue (APizza, new Pizza ("everything", "4567 King Court"));
		enqueue (APizza, new Pizza ("coffee beans", "5678 Java Circle"));
		deliver (APizza);
		deliver (APizza);
		deliver (APizza);
		deliver (APizza);
		deliver (APizza);
	}
	
	/*Enqueue adds a new pizza to PizzaRecord,designates the new Pizza object attached to pizza record as thispizza
	 *If there is no pizza record, assign pizza object to be first in queue, else put pizza object in queue behind others
	 *Newest pizza in queue is always assigned to be the last pizza
	 */
	public static void enqueue (PizzaRecord APizza,Pizza thispizza)
	{
		if (APizza.first == null)
		{
			APizza.first = thispizza; 
		}
		else
		{
			APizza.last.next = thispizza;
		}
		
		APizza.last = thispizza;
		
		return;
	}
	
	//Displays delivery information,sends pizza record to be delivered to dequeue
	public static void deliver(PizzaRecord APizza)
	{
		Pizza thispizza = dequeue(APizza); 
		
		if (thispizza == null)
		{
			System.out.println ("No deliveries pending");
		}
		else
		{
			System.out.println ("Deliver a pizza with " + thispizza.ingredients + " to " + thispizza.address);
		}
				
	}
	
	/*Removes pizza record to be delivered from queue
	 *Creates a pizza object called 'pizzatodeliver' which has the pizza record to be delivered assigned to it
	 *If the queue contains a pizza record, the record is assigned to the new pizza object pizzatodeliver
	 *The record that is next in queue is moved to the next position once the record passed in has been assigned to an object
	 *If there are no records to move records in queue assign null to record and return
	 *Returns pizza object to be delivered back to deliver method
	 */
	public static Pizza dequeue(PizzaRecord APizza)
	{
		Pizza pizzatodeliver = null;
		
		if (APizza.first!=null)
		{
			pizzatodeliver = APizza.first;
			APizza.first = APizza.first.next;
		}
		
		if (APizza.first==null)
		{
			APizza.last=null;
		}
		
		return pizzatodeliver;
	}

}
