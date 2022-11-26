import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{

	static int n, count =0;
	static int board[][];
	static StringBuilder sb = new StringBuilder();

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n= Integer.parseInt(br.readLine());
		int arr[] = new int [n+1];
		int d[] = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			d[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(arr[i]>arr[j])
					d[i] = Math.max(d[i], arr[i]+d[j]);
			}
		}	
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			if(d[i]>max) {
				max = d[i];
			}
		}
		System.out.println(max);
	}
	
	

	
}
