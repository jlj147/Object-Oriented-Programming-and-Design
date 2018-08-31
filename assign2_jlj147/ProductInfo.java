package assign2_jlj147;

//Class containing a product object
public class ProductInfo
{
	private String name;
	private float cost;
	private int quantity;


	public ProductInfo(String newName, float newCost, int newQuantity)
	{
		name = newName;
		cost = newCost;
		quantity = newQuantity;
	}


	public String getName()
	{
		return name;
	}


	public float getCost()
	{
		return cost;
	}


	public int getQuantity()
	{
		return quantity;
	}


	public void setName(String newName)
	{
		name = newName;
	}


	public void setPrice(float newCost)
	{
		cost = newCost;
	}


	public void setQuantity(int newQuantity)
	{
		quantity = newQuantity;
	}


	public String info()
	{  
		return name + "$" +cost;
	}
	
	public void CurrentInventory()
	{
		System.out.printf ("%s %n",getName());
		System.out.printf ("Cost: $%1.2f %n",getCost());
		System.out.printf ("Product Quantity: %d \n \n",getQuantity());
	}
}

