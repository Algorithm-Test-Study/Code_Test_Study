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
		
		int t[] = new int[n+1];
		int p[] = new int[n+1];
		int d[] = new int[n+2]; // i번째 일에 상담을 시작했을 때 얻을 수 있는 최대 수익
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			d[i] = p[i] = Integer.parseInt(st.nextToken());
		}
		

		for(int i=n;i>0;i--) {
			if(i+t[i]<=n+1)
				d[i] = Math.max(p[i]+ d[i+t[i]], d[i+1]);
			else
				d[i] = d[i+1];
		}		
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			max = Math.max(max, d[i]);
		}
		System.out.print(max);
	}
	
	

	
}
