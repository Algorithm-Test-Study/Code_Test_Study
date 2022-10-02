import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	static int n;

	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		Stack <Character> stack ;
		
		n = Integer.parseInt(br.readLine());
		
		int count =0;
		for(int i=0;i<n;i++) {
			stack = new Stack<>();
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				if(stack.empty()||stack.peek()!=str.charAt(j)) {
					stack.push(str.charAt(j));
				}
				else stack.pop();
			}
			if(stack.empty()) count++;
			
		}

		System.out.print(count);
	}
	
	
}
