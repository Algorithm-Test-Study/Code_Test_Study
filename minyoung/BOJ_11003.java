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
	public static int n, l;
	

	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Deque <int []> deque = new LinkedList<>();
		
		n = Integer.parseInt(st.nextToken());
		l= Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		

		for(int i=0;i<n;i++) {
			int data = Integer.parseInt(st.nextToken());
			while(!deque.isEmpty()&&deque.peekLast()[0]>data) {
				deque.pollLast();
			}
			
			deque.offer(new int[] {data, i});
			if(deque.peekLast()[1]-deque.peekFirst()[1]>=l)
				deque.pollFirst();
			sb.append(deque.peekFirst()[0]).append(" ");
		}
		
		System.out.print(sb);
	}
	
