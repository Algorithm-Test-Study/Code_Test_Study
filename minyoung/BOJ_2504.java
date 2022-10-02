import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		Stack <Character> stack = new Stack<>();
		
		String str = br.readLine();
		
		int result = 0;
		int value=1;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				stack.push(str.charAt(i));
				value = value*2;
			}
			else if(str.charAt(i)=='[') {
				stack.push(str.charAt(i));
				value = value*3;
			}
			else if(str.charAt(i)==')') {
				if(stack.empty()||stack.peek()!='(') {
					result =0;
					break;
				}
				if(str.charAt(i-1)=='(') {
					result = result+value;
					
				}
				stack.pop();
				value = value/2;
			}
			else if(str.charAt(i)==']') {
				if(stack.empty()||stack.peek()!='[') {
					result =0;
					break;
				}
				if(str.charAt(i-1)=='[') {
					result = result+value;
					
				}
				stack.pop();
				value = value/3;
			}
		}
		
		if(!stack.empty()) result=0;
		System.out.print(result);
	}
	

	
}
