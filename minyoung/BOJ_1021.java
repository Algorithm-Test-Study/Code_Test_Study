import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main
{
	public static int n, m;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Deque <Integer> deque = new LinkedList<>();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=n;i++) {
			deque.offer(i);
		}
		
		int result=0;
		
		st =new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			int data = Integer.parseInt(st.nextToken());
			
			int count=0;
			
			while(data!=deque.getFirst()) {
				deque.offerLast(deque.pollFirst());
				count++;
			}
			result += count < deque.size()-count?count : deque.size()-count;
			
			deque.pollFirst();
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		
	}
}
