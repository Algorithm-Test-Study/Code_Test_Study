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
		Stack <Integer> stack = new Stack<>();
		
		String str = br.readLine();
		
		int result = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				stack.push(i);
			}
			else {
				int idx = stack.pop();
				if(idx == i-1) result = result + stack.size();
				else result= result+1;
			}
			
		}
		

		System.out.print(result);
	}
	
	
}
