package Question1;
import java.util.*;

public class BalancedBrackets 
{
	public static boolean isBalanced(String brackets)
	{
		Stack<Character> stack=new Stack<Character>();
		for(int x=0;x<brackets.length();x++)
		{
			char ch=brackets.charAt(x);
			if(ch=='(' || ch=='{' || ch=='[')
			{
				stack.push(ch);
				continue;
			}
			char check;
			switch(ch)
			{
				case ')':
					check=stack.pop();
					if(check=='{' || check=='[')
						return false;
					break;
				
				case '}':
					check=stack.pop();
					if(check=='(' || check=='[')
						return false;
					break;
				
				case ']':
					check=stack.pop();
					if(check=='{' || check=='(')
						return false;
					break;
			}
							
		}
		return stack.isEmpty();
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the expression");
		String exp=sc.nextLine();
		
		if(isBalanced(exp))
			System.out.println("The entered String is balanced");
		
		else
			System.out.println("The entered String is not balanced");
	}
}
