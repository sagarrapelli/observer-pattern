package studentCoursesBackup.myTree;

import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.MyLogger.DebugLevel;

public class Tree {
	
	public Node root;
	
	public Tree() {
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: Tree created");		
	}
	
	public void insert(Node n) {
		
		if(root == null)
			root = n;
		else { 
			Node temp = root;
			while (temp != null) {
				if (temp.bNo > n.bNo && temp.left == null) {
					temp.left = n;
					break;
				}
				else if (temp.bNo < n.bNo && temp.right == null) {
					temp.right = n;
					break;
				}
				else if (temp.bNo > n.bNo)
					temp = temp.left;
				else if (temp.bNo < n.bNo)
					temp = temp.right;
			}
		}
	}
	
	public Node search(int key) {
		
		Node n = root;
		
		while(n != null) {
		if(n.bNo == key)
			return n;
		else if (n.bNo > key)
			n = n.left;
		else if (n.bNo < key)
			n = n.right;
		}
		return null;
	}
	
	public void printInOrder(Results r, Node n) {
		
		if(n != null) {
			printInOrder(r, n.left);
			r.storeNewResult(n.toString());
			printInOrder(r, n.right);
		}
	}
	
	public void updateNode (Node n, String s) {
		
		if(n.courses.contains(s)) {
			if(MyLogger.getDebugValue() == DebugLevel.FROM_RESULTS)
				System.out.println("\nCurrent input " + n.bNo + ": " +s+ " .\nNode already contains the course "+s);
		}
			
		else {
			n.courses.add(s);
			if(MyLogger.getDebugValue() == DebugLevel.IN_RESULTS)
				System.out.println("\nNode "+ n.bNo + " updated: course added "+s);
			n.notifyAll(s, Operation.add);
		}
	}
	
	public void deleteNodeContents (Node n, String s) {
		
		if(n.courses.contains(s)){
			n.courses.remove(s);
			if(MyLogger.getDebugValue() == DebugLevel.IN_RESULTS)
				System.out.println("\nNode "+ n.bNo + " updated: course deleted "+s);
			n.notifyAll(s, Operation.delete);
		}
		
		else {
			if(MyLogger.getDebugValue() == DebugLevel.FROM_RESULTS)
				System.out.println("\nCurrent delete input " + n.bNo + ": " +s+ " .\nNode does not have the course "+s);
		}
	}

	@Override
	public String toString() {
		return "Tree ";
	}

}
