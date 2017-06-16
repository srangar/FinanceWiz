package users;

/**
 * This class represents an Employee with properties salary and id. It also extends from Person. 
 * 
 *
 */
public class Employee extends Person {
	
	private double salary;
	private int id;
	
	/**
	 * Constructs an Employee
	 * @param name name of the employee
	 * @param age age of the employee
	 * @param gender gender of the employee
	 * @param salary salary of the employee
	 * @param id id of the employee
	 * @param username username of the employee to enter into the database
	 * @param password password of the employee to enter into the database. 
	 */
	public Employee(String fname ,String lname, int age , String gender , double salary , int id , String username , String password) {
		super(fname,lname, age , gender , username , password);
		this.salary = salary;
		this.id = id;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public double getSalary() {
		return salary;
	}
}
