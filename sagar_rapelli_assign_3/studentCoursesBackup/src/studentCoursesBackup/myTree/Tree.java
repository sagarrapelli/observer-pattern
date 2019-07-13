package studentCoursesBackup.myTree;

//import java.util.List;

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
			//System.out.println("here");
			Node temp = root;
			while (temp != null) {
				if (temp.bNo > n.bNo && temp.left == null) {
					temp.left = n;
					//System.out.println("left insertion");
					break;
				}
				else if (temp.bNo < n.bNo && temp.right == null) {
					temp.right = n;
					//System.out.println("right insertion");
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
		
		if(n.courses.contains(s))
			System.out.println("contains the same");
			
		else {
			n.courses.add(s);
			System.out.println("address of " + n);
			n.notifyAll(s, 0);
		}
	}
	
	public void deleteNodeContents (Node n, String s) {
		if(n.courses.contains(s));{
			n.courses.remove(s);
			n.notifyAll(s, 1);
		}
	}

	

}
