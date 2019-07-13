package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.Tree;
import studentCoursesBackup.util.MyLogger.DebugLevel;

public class TreeBuilder{
	
	private Tree t, t1, t2;
	
	public TreeBuilder() {
		//MyLogger functionality
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("Constructor: TreeBuilder created\n");
		
		t = new Tree();
		t1 = new Tree();
		t2 = new Tree();
		
		//MyLogger functionality
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.println("\n");
	}
	
	public void build(int bNo, String course) {
		Node n = t.search(bNo);
		
		if(n == null) {
			//MyLogger functionality
			if(MyLogger.getDebugValue() == DebugLevel.IN_RUN)
				System.out.println("Node " + bNo + " does not exist in tree");
			
			createNode(bNo, course);
		}
		else {
			//MyLogger functionality
			if(MyLogger.getDebugValue() == DebugLevel.IN_RUN)
				System.out.println("~ Node " + n.bNo + " already exists in tree at "+n+ "\n");
			
			t.updateNode(n, course);
			
		}
	}
	
	public void createNode (int bNo, String course) {
		Node n = new Node(bNo, course);
		t.insert(n);
		if(MyLogger.getDebugValue() == DebugLevel.IN_RUN)
			System.out.println("Node "+ n.bNo + " created at address " + n +"\n");
		
		Node backup1 = new Node(bNo, course);
		n.add(backup1);
		t1.insert(backup1);
		
		Node backup2 = new Node(bNo, course);
		n.add(backup2);
		t2.insert(backup2);
		
		if(MyLogger.getDebugValue() == DebugLevel.CONSTRUCTOR)
			System.out.print("\n");
		
	}
	
	public void delete (int bNo, String course) {
		Node n = t.search(bNo);
		if(n == null);
		else
			t.deleteNodeContents(n, course);
		
	}
	
	public void printNodes(Results r, int no) {
		if(no == 1)
			t.printInOrder(r, t.root);
		if(no == 2)
			t1.printInOrder(r, t1.root);
		if(no == 3)
			t2.printInOrder(r, t2.root);
		
	}
	
	public String toString() {
		return "TreeBuilder";
	}

}