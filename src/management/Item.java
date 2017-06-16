package management;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
	
	private String name;
	private double price;
	private String placeBought;
	private String date;
	private int id;
	
	public Item(String name, double price, String placeBought , String date , int id) {
		this.name = name;
		this.price = price;
		this.placeBought = placeBought;		
		this.date = date;
		this.id = id;
	}
	
	public void changePrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String showDate() {
		return date.toString();
	}
	
	public int getID() {
		return id;
	}
	
	public String toString() {
		return date + ", ID: " + id + ", Item: " + name + ", Price: $" + price + ", Place: " + placeBought;
	}
}	
