
package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

/**
 * @author SagarRapelli
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
	    if ( (args.length != 6) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
		    
		    System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
		    System.exit(0);
	    } // end of if
	    
	    MyLogger.setDebugValue(Integer.parseInt(args[5]));
	    FileProcessor file = new FileProcessor();
	    file.openFile(args[0]);
	    TreeBuilder t = new TreeBuilder();
	    
	 	String s2 = "no";
		
		//loop for reading contents from the input file
		while(true) {
			String s1 = file.readLine();
			if(s1.equals(s2))
				break;
			else {
				String[] s = s1.split(":");
				int bNo = Integer.parseInt(s[0]);
				t.build(bNo, s[1]);
			}
		}
		
		file.openFile(args[1]);
		//loop for reading contents from the delete file
		while(true) {
			String s1 = file.readLine();
			if(s1.equals(s2))
				break;
			else {
				String[] s = s1.split(":");
				int bNo = Integer.parseInt(s[0]);
				t.delete(bNo, s[1]);
			}
		}
		
		Results[] result = new Results[3];
		for (int i = 0 ; i < result.length ; i++) {
			result[i] = new Results();
			t.printNodes(result[i], i+1);
			result[i].writeToFile(args[i+2]);
		}
		
		
		
	}  // end public static void main
}// end public class Driver
