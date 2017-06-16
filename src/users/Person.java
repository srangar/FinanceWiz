package users;
/**
 * This class represents a Person. It has various methods to manage the person. 
 * 
 *
 */
public class Person {
	
	private String fname;
	private String lname;
	private int age;
	private String gender;
	private String username;
	private String password;
	/**
	 * Constructs a Person
	 * @param name name of the person
	 * @param age age of the person
	 * @param gender gender of the person
	 * @param username username of the person to enter the database
	 * @param password password of the person to enter the database
	 */
	public Person(String fname, String lname, int age, String gender , String username , String password) {
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	

	
	public int getAge() {
		return age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String toString()
	{
		return username + " " + password + " " + gender + " " + fname + " " + lname + " " + age;
	}
	
	public boolean hasUserName(String username)
	{
		if(this.username.equals(username))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasPassword(String password)
	{
		if(this.password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getFname()
	{
		return fname;
	}
	
	public String getLname()
	{
		return lname;
	}
}
