import java.util.StringTokenizer;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static int N;
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Stack <Integer> stack = new Stack<>();
		
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			
			switch(str){
				case "push" :
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if(!stack.empty()){
						sb.append(stack.pop());
					}
					else{
						sb.append("-1");
					}
					sb.append("\n");
					break;
				case "size":
					sb.append(stack.size());
					sb.append("\n");
					break;
				case "top":
					if(!stack.empty()){
						sb.append(stack.peek());
					}
					else{
						sb.append("-1");
					}
					sb.append("\n");
					break;
				case "empty":
					if(!stack.empty()){
						sb.append(0);
					}
					else{
						sb.append(1);
					}
					sb.append("\n");
					break;
			}
			
	
		}
		System.out.println(sb);
	}
}
