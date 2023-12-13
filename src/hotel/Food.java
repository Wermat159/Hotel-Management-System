package hotel;

public class Food {

	private String name;
	private int quantity;
	private double price;

	public Food() {
	}

	public Food(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Name: " + this.getName() + "   Quantity: " + this.getQuantity() + "   Price: " + this.getPrice() +"$";
	}

}
