import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main
{
	public static int n;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		StringTokenizer st;
		
		Deque <Integer> deque = new LinkedList<>();
		
		
		n = Integer.parseInt(br.readLine());
			
		int result=0;
		for(int i=0;i<n;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			
			switch(str) {
				case "push_back":
					deque.offerLast(Integer.parseInt(st.nextToken()));
					break;
				case "push_front":
					deque.offerFirst(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					result = deque.isEmpty()? -1 : deque.pollFirst();
					sb.append(result).append("\n");
					break;
				case "pop_back":
					result = deque.isEmpty()? -1 : deque.pollLast();
					sb.append(result).append("\n");
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					result = deque.isEmpty()? 1 : 0;
					sb.append(result).append("\n");
					break;
				case "front":
					result = deque.isEmpty()? -1 : deque.getFirst();
					sb.append(result).append("\n");
					break;
				case "back":
					result = deque.isEmpty()? -1 : deque.getLast();
					sb.append(result).append("\n");
					break;
			}
			
		
		}
		
		System.out.println(sb);
	}
}
