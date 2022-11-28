import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{

	static int n, m;

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		ArrayList <Long> arr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr.add(Long.parseLong(st.nextToken()));
		}
		
		for(int i=0;i<m;i++) {
			Collections.sort(arr);
			long sum = arr.get(0)+arr.get(1);
			arr.set(0, sum);
			arr.set(1, sum);
		}
		
		long result = 0;
		for(int i=0;i<n;i++) {
			result += arr.get(i);
		}
		
		System.out.print(result);
	}
	
	

	
}
