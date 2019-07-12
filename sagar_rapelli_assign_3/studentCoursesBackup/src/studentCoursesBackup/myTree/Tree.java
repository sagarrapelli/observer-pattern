package studentCoursesBackup.myTree;

import studentCoursesBackup.util.Results;

public class Tree {
	
	public Node root;

	public Tree() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tree [toString()=" + super.toString() + "]";
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
					temp.left = n;
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
		
		if(root != null) {
			printInOrder(r, n.left);
			r.storeNewResult(n.toString());
			printInOrder(r, n.right);
		}
	}
	
	public void updateNode (Node n, String s) {
		if(n.courses.contains(s));
			
		else {
			n.courses.add(s);
			n.notifyAll(n.courses);
		}
	}
	
	public void deleteNodeContents (Node n, String s) {
		if(n.courses.contains(s));
		
		else {
			n.courses.remove(s);
			n.notifyAll(n.courses);
		}
	}

}
