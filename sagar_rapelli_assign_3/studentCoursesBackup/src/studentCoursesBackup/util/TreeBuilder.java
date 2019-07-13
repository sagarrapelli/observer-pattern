package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.Tree;

public class TreeBuilder{
	
	private Tree t, t1, t2;
	
	public TreeBuilder() {
		t = new Tree();
		t1 = new Tree();
		t2 = new Tree();
	}
	
	public void build(int bNo, String course) {
		Node n = t.search(bNo);
		System.out.println(n);
		if(n == null) {
			createNode(bNo, course);
		}
		else {
			t.updateNode(n, course);
		}
	}
	
	public void createNode (int bNo, String course) {
		Node n = new Node(bNo, course);
		t.insert(n);
		
		
		Node backup1 = new Node(bNo, course);
		n.add(backup1);
		t1.insert(backup1);
		
		Node backup2 = new Node(bNo, course);
		n.add(backup2);
		t2.insert(backup2);
		
		System.out.println("Backups of n"+ n );
		System.out.println("Backups of n1"+ backup1);
		System.out.println("Backups of n2"+ backup2);
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

}