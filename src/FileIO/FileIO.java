package FileIO;
/**
 * @version 01/23/15
 * Read and Writes from a text file
 *
 */
import java.io.*; 
import java.util.Scanner;

public class FileIO {
	private static String lineSeperator;
	
	/**
	 * @post sets lineSeperator
	 */
	public FileIO()
	{
		lineSeperator = System.getProperty("line.separator");
	}

	/**
	 * 
	 * @param filename the name of the file you want to read
	 * @return the contents of the file with filename
	 */
	public String readFile(String filename)
	{
		BufferedReader breader=null;
		FileReader reader;
		String fileData=null;
		Scanner in = null;
		
		try 
		{
			reader = new FileReader(filename);
			breader = new BufferedReader(reader);
			in = new Scanner(breader);
			
			StringBuffer changingFileData = new StringBuffer();
	
			while(in.hasNextLine())
			{
				String input = in.nextLine();
				changingFileData.append(input);
				changingFileData.append(lineSeperator);
			}
			
			fileData = changingFileData.toString();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(in!=null)
			{
				in.close();
			}
		}
		
		return fileData;	
	}
	
	/**
	 * 
	 * @param filename The name of the file you want to write to
	 * @param data What you want to add to the file
	 */
	public void writeFile(String filename, String data)
	{
		BufferedWriter bwriter = null;
		FileWriter writer=null;
		
		try 
		{
			writer = new FileWriter(filename);
			bwriter = new BufferedWriter(writer);
			bwriter.write(data);
			
			bwriter.flush();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("File Not Found!");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(writer!=null)
			{
				try
				{
					bwriter.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	 
	/**
	 * @return the line separator 
	 */
	public String getLineSeperator()
	{
		return lineSeperator;
	}
}
