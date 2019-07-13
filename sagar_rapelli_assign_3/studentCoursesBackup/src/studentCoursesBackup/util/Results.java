package studentCoursesBackup.util;

import java.io.FileWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	private FileWriter fileWriter;
	//data member for storing results.
	private String string;
	
	/**
	 * no arg constructor
	 *
	 */
	public Results() {
		string = "";
	}
	
	/**
	 * constructor
	 *
	 * @param String filename
	 */
	public Results(String name) {
		string = "";
		try {
		fileWriter = new FileWriter(name);
		}
		catch(Exception e) {
			
			System.err.println("Error in creating file");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	
	/**
	 * method to return the results stored in the private data member
	 *
	 * @param no arg
	 */
	public String getString() {
		return string;
	}
	
	
	/**
	 * method for storing results to the private data member of Results.
	 *
	 * @param String, bool
	 * 
	 */
	public void storeNewResult(String result) {
		string = string + result + "\n";
	}
	
	
	
	/**
	 * method for writing to file using FileWriter.
	 * ref = "https://docs.oracle.com/javase/8/docs/api/index.html?java/io/FileWriter.html"
	 *
	 * @param String
	 */
	public void writeToFile(String s) {
		try {
			fileWriter = new FileWriter(s);
			fileWriter.write(string);
			fileWriter.close();
		}
		catch(Exception e){
			System.err.println("Error: In writeToFile method");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	
	/**
	 * method for writing to console.
	 *
	 * @param String
	 */
	public void writeToStdOut(String s) {
		System.out.print(s);
	}
	
	
	/**
	 * toString method
	 * 
	 */
	public String toString() {
		return string;
	}
}

