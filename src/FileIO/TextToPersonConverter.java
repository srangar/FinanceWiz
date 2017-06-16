package FileIO;

import java.util.ArrayList; 

import users.Person;

/**
 * Turns File Data into Person objects
 *
 */
public class TextToPersonConverter {

	private String[] userData;
	private ArrayList<Person> accounts;
	public TextToPersonConverter()
	{
		FileIO reader = new FileIO();
		userData = reader.readFile("UserData.txt").split(reader.getLineSeperator());
		accounts = new  ArrayList<Person>();
	}
	
	private void lineToAccount()
	{
		for(String s : userData)
		{
			String[] data = s.split("\\|");
			String username = data[0];
			String password = data[1];
			String gender = data[2];
			String fname = data[3];
			String lname = data[4];
			int age = Integer.parseInt(data[5]);
			
			Person p = new Person(fname,lname, age, gender, username,password);
			accounts.add(p);
		}
	}
	
	/**
	 * 
	 * @return The ArrayList of person objects
	 */
	public ArrayList<Person> getAccount()
	{
		lineToAccount();
		return accounts;
	}
}
