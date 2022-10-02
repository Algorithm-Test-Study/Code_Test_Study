import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main
{
	public static int n;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue <Integer> queue = new LinkedList<>();
		
		
		n = Integer.parseInt(br.readLine());
			

		for(int i=0;i<n;i++) {
			
			queue.offer(i+1);

		}
		
		while(queue.size()!=1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		
		bw.write(String.valueOf(queue.poll()));
		bw.flush();
		
	
	}
}
