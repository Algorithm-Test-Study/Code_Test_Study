import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
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
		
		Queue <Integer> queue = new LinkedList<>();
		
		
		n = Integer.parseInt(br.readLine());
			
		int last = 0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch(str) {
				case "push":
					last = Integer.parseInt(st.nextToken());
					queue.offer(last);
					break;
				case "pop":
					if(!queue.isEmpty())
						sb.append(queue.poll());
					else
						sb.append("-1");
					sb.append("\n");
					break;
				case "size":
					sb.append(queue.size());
					sb.append("\n");
					break;
				case "empty":
					if(queue.isEmpty())
						sb.append(1);
					else
						sb.append(0);
					sb.append("\n");
					break;
				case "front":
					if(!queue.isEmpty())
						sb.append(queue.peek());
					else
						sb.append("-1");
					sb.append("\n");
					break;
				case "back":
					if(!queue.isEmpty())
						sb.append(last);
					else
						sb.append("-1");
					sb.append("\n");
					break;
					
			}

		}
		
	
		System.out.println(sb);
	}
}
