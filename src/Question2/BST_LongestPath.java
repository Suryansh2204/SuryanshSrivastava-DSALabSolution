package Question2;
import java.util.*;	
public class BST_LongestPath 
{
	static class Node
	{
		int data;
		Node left;
		Node right;
	}
	static Node newNode(int data)
	{
		Node temp=new Node();
		temp.data=data;
		temp.left=null;
		temp.right=null;
		return temp;
	}
	
	public static ArrayList<Integer> longestPath(Node root)
	{
		if(root==null)
		{
			ArrayList<Integer> ar=new ArrayList<Integer>();
			return ar;
		}
		
		ArrayList<Integer> left=longestPath(root.left);
		ArrayList<Integer> right=longestPath(root.right);
		
		if(left.size()>right.size())
			left.add(root.data);
		else
			right.add(root.data);
		
		return left.size()>right.size()?left:right;
	}
	
	public static void main(String args[])
	{
//					100
//				   /   \
//				  20   130
//				 / \   /  \
//				10 50 110 140
//			   /
//			  5
		Node root=newNode(100);
		root.left=newNode(20);
		root.right=newNode(130);
		root.left.left=newNode(10);
		root.left.right=newNode(50);
		root.right.left=newNode(110);
		root.right.right=newNode(140);
		root.left.left.left=newNode(5);
		ArrayList<Integer> out=longestPath(root);
		for(int x=out.size()-1;x>=0;x--)
		{
			System.out.print(out.get(x));
			if(x!=0)
				System.out.print(" -> ");
		}
	}
}
