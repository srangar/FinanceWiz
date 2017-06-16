package users;
import java.util.ArrayList;

/**
 * This class represents a Company. It has methods to manage its various properties.
 *
 */
public class Company {
	
	private String name;
	private ArrayList<Employee> employees;
	
	/**
	 * Constructs a Company with name and address
	 * @param name name of the company
	 */
	public Company(String name) {
		this.name = name;		
		employees = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	
	public void removeEmployee(Employee e) {
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getID() == e.getID())
				employees.remove(i);
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
