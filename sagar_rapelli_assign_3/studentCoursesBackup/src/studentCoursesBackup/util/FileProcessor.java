package myArrayList.util;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Sagar Rapelli
 *
 */
public class FileProcessor {
	
	private File file;
	private Scanner sc;
	
	/**
	 * no arg constructor
	 * 
	 */
	public FileProcessor() {
		
	}
	
	/**
	 * constructor to set input file.
	 *
	 * @param String filename
	 */
	public FileProcessor(String filename) {
		try {
			file = new File(filename);
			sc = new Scanner(file);
			
		}
		catch(FileNotFoundException fn) {
			System.out.println("fnfe");
		}
	}
	
	/**
	 * method for reading one line from input file.
	 * ref = "https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html"
	 *
	 * @param no args
	 */
	public String readLine() {
		if(sc.hasNextLine())
			return sc.nextLine();
		else
			return "no";
	}
	
	/**
	 * toString method
	 * 
	 */
	public String toString() {
		return "File processor";
	}
	
}
