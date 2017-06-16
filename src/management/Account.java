package management;

public class Account {
	
	private String name; // name of the accnt
	private double balance;
	
	/**
	 * creates a new account object 
	 * @param name name of the account 
	 * @param balance how much balance the account has 
	 */
	public Account(String name , double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	/**
	 * adds an amount of money to the balance
	 * @param amount how much money is added 
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	
	/**
	 * takes away a certain amount of money from the balance
	 * @param amount amount of money taken away
	 */
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public String getName() {
		return name;
	}
}
