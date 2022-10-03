import java.util.StringTokenizer;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main
{
	public static int n;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		Stack <Integer> stack = new Stack<>();
		
		n = Integer.parseInt(br.readLine());
		
		
		int count =1;
		for(int i=0;i<n;i++) {
		
			int data = Integer.parseInt(br.readLine());
			
			while(count<=data){
				stack.push(count++);
				sb.append("+").append("\n");
			}
			
			if(stack.peek()!=data) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-").append("\n");
				
			
		}
		
	
		System.out.println(sb);
	}
}
