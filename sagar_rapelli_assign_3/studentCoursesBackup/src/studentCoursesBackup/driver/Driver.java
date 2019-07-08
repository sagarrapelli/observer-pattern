
package studentCoursesBackup.driver;

import myArrayList.util.FileProcessor;    
/**
 * @author AuthorName
 *
 */
    
    public class Driver {
	
	public static void main(String[] args) {
	    
	    /*
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used
	     */

	    // FIXME: update this if statement for this assignment
	    if ( (args.length != 3) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
		    
		    System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
		    System.exit(0);
	    } // end of if
	    
	    FileProcessor file = new FileProcessor(args[0]);
	 	String s2 = "no";
		
		//loop for reading contents from the input file
		while(true) {
			String s1 = fp.readLine();
			if(s1.equals(s2))
				break;
			else
				// do required thing here
		}
	}  // end public static void main
    }  // end public class Driver
