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
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		Stack <int []> stack = new Stack<>();
		
		
		n = Integer.parseInt(br.readLine());
				
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			int data = Integer.parseInt(st.nextToken());
			
			while(!stack.empty()) {
				
				if(stack.peek()[0]>data) {
									
					sb.append(stack.peek()[1]).append(" ");
					break;
				}
				
				stack.pop();
			}
			
			if(stack.empty()) {
				sb.append(0).append(" ");
			}
			
			stack.push(new int [] {data, i+1});

		}
		
	
		System.out.println(sb);
	}
}
