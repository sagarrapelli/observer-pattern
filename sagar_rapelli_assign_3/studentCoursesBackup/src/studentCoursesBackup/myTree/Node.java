package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.List;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;

public class Node implements SubjectI, ObserverI{
	
	public Node left;
	public int bNo;
	public List<String> courses;
	public Node right;
	public Node[] backup;
	
	public Node() {
		
	}
	
	public Node(int bNo, String course) {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: Node created "+bNo);
		backup = new Node[2];
		courses = new ArrayList<String>();
		this.bNo = bNo;
		courses.add(course);
	}
	
	public void add(Node n) {
		for(int i = 0 ; i < backup.length ; i++ ) {
			if( backup[i] == null ) {
				backup[i] = n;
				break;
			}
		}
	}
	
	public void update(String s, Operation op) {
		if(op == Operation.add)
			courses.add(s);
		else
			courses.remove(s);
	}
	
	public void notifyAll(String s,  Operation op) {
		for(int i = 0 ; i < backup.length ; i++ ) {
				backup[i].update(s, op);
				if(MyLogger.getDebugValue() == DebugLevel.IN_RESULTS)
					System.out.println("Observer " +(i+1)+ " of node " +backup[i].bNo + " updated to " +backup[i].courses);
		}			
	}
	
	public String toString() {
		if(MyLogger.getDebugValue() == DebugLevel.IN_RUN)
			return super.toString();
			
		return bNo + ":" + courses ;
	}
}