/**
 * Judging if the input string is valid
 * Input string is considered valid if the brackets close in correct order (correct parenthesis)
 * Using stack to store the characters. If the input character is ), the peek of stack should be ( to confirm the valid parenthesis.
 * The same as [, and {
 * @author: Hengjin Tan
 */

import java.util.Stack;
import java.util.Scanner;

public class JudgeString {
	private boolean stringIsValid(String str){
		if(str==null||str.length()==0)
			return false;
		if(str.length()%2!=0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		for(char c:str.toCharArray()){
			if(c==')'){
				if(stack.peek()!='(') return false;
				stack.pop();
			}else if(c==']'){
				if(stack.peek()!='[') return false;
				stack.pop();		
			}else if(c=='}'){
				if(stack.peek()!='{') return false;
				stack.pop();
			}else{
				stack.push(c);
			}
		}
		
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keybroad=new Scanner(System.in);
		String input=keybroad.nextLine();
		JudgeString string=new JudgeString();
		while(!input.equals("quit")){
			System.out.print("The input is:");
			System.out.println(input);
			System.out.print("The result is:");
			System.out.println(string.stringIsValid(input));
			input=keybroad.nextLine();
		}

	}

}
