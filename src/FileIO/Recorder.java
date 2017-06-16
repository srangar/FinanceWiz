package FileIO;

/**
 * Records account data
 *
 */
public class Recorder {

	public Recorder()
	{
		
	}
	
	/**
	 * 
	 * @param username Username of person
	 * @param password Password of person
	 * @param gender Gender of person
	 * @param fname First Name of person
	 * @param lname Last Name of person
	 * @param age Age of person
	 * @post Writes info to file UserData.txt
	 */
	public void recordUserData(String username, String password, String gender, String fname, String lname, String age)
	{
		FileIO f = new FileIO();
		String answer = f.readFile("UserData.txt") + username + "|" + password + "|" + gender + "|" + fname + "|" + lname + "|" + age;
		f.writeFile("UserData.txt", answer);
	}
}
