package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.util.List;

public class Node implements SubjectI, ObserverI{

	public Node left;
	public int bNo;
	public List<String> courses;
	public Node right;
	public Node[] backup;
	
	public Node() {
		
	}
	
	public Node(int bNo, String course) {
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
	
	public void update(String s) {
			courses.add(s);
	}
	
	public void removeCourse(String s) {
		courses.remove(s);
}
	
	public void notifyAll(String s, int flag) {
		for(int i = 0 ; i < backup.length ; i++ )
			if(flag == 0)
				backup[i].update(s);
			else
				backup[i].removeCourse(s);
	}
	
	public String toString() {
		return bNo + ":" + courses ;
	}
}