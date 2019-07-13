
package studentCoursesBackup.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
      DEBUG_VALUE=2 [Print to stdout everytime the observer nodes are updated]
      DEBUG_VALUE=1 [Print to stdout everytime the course exists in node]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, FROM_RESULTS, IN_RESULTS, IN_RUN, CONSTRUCTOR
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
		case 4: debugLevel = DebugLevel.CONSTRUCTOR; 
		  		writeMessage("Logger Value 4 :- Printing everytime constructor is called", debugLevel);
		  		break;
			
		case 3: debugLevel = DebugLevel.IN_RUN; 
				writeMessage("Logger Value 3 :- Printing everytime a node is searched in tree and its result", debugLevel);
				break;
		
		case 2: debugLevel = DebugLevel.IN_RESULTS; 
				writeMessage("Logger Value 2 :- Printing everytime the observer nodes are updated ( i.e notifyAll() is called )", debugLevel);
				break;
		
		case 1: debugLevel = DebugLevel.FROM_RESULTS;
				writeMessage("Logger Value 1 :- Printing every time the course already exists in node while building tree "
						+ "and when course doesn't exist in node during delete operation", debugLevel);
				break;
		
		case 0: debugLevel = DebugLevel.RELEASE; break;
		}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }
    
    public static DebugLevel getDebugValue () {
    	return debugLevel;
    }

    /**
	 * @return String
	 */
    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
