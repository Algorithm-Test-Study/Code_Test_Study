import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main
{
	public static int t;
	
	static StringBuilder sb = new StringBuilder();

	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Deque <Integer> deque ;
		
		t = Integer.parseInt(br.readLine());

		for(int i=0;i<t;i++) {
			deque = new LinkedList<>();
			
			String str = br.readLine();
			int len = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			
			for(int j=0;j<len;j++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			
			AC(str, deque);
			
		}
		
		System.out.print(sb);
	}
	
	public static void AC(String str,Deque<Integer> deque) {
		int dir = 0;

		for(int j=0;j<str.length();j++) {		
			if(str.charAt(j)=='R') {
				dir =(dir+1)%2;
			}
			else if(str.charAt(j)=='D') {
				if(deque.isEmpty()) {
					sb.append("error").append("\n");
					return;
				}
				if(dir == 0 )
					deque.pollFirst();
				else deque.pollLast();
			}
		}
		
		makeString(dir, deque);
	}
	
	public static void makeString(int dir, Deque<Integer> deque) {
		sb.append("[");
		while(deque.size()>0) {
			if(dir == 0)
				sb.append(deque.pollFirst());
			else
				sb.append(deque.pollLast());
			
			if(deque.isEmpty()) break;
			sb.append(",");
		}
		sb.append("]").append("\n");
	}
	
}
