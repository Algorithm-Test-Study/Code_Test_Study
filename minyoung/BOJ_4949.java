import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	static StringBuilder sb = new StringBuilder();

	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack <Character> stack ;
		
		while(true) {
			stack = new Stack<>();
			String str = br.readLine();
			if(str.charAt(0)=='.') break;
			
			findPharallel(str, stack);
			
		}

		
		System.out.print(sb);
	}
	
	public static void findPharallel(String str, Stack<Character> stack) {
		for(int i=0;i<str.length();i++) {
			char data= str.charAt(i);
			if(data=='('||data=='[') {
				stack.push(data);
			}
			else if(data==')'||data==']') {
				if(!stack.empty()&&((stack.peek()=='('&&data==')')||(stack.peek()=='['&&data==']'))) {
					stack.pop();
				}
				else {
					sb.append("no").append("\n");
					return;
				}
			}
		}
		if(stack.empty()) sb.append("yes").append("\n");
		else sb.append("no").append("\n");
	}
	
	
}
