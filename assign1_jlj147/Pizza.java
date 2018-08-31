package assign1_jlj147;

//Properties to be assigned to a pizza, this is the pizza class
public class Pizza 
{
	//Declare parameters that define a pizza object 
	public String ingredients;
	public String address;
	public Pizza next; 

	/*Sets the parameters that define a pizza object to those passed in from the main class when declaring a new
	 *pizza object*/ 
	public Pizza(String ingredients,String address)
	{
		this.address = address;
		this.ingredients = ingredients;
		this.next = null;
	}

}
