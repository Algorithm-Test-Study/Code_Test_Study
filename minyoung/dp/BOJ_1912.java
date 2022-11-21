import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int d[] = new int [100005];
		int arr[] = new int [100005];
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			d[i] = arr[i];
		}
		

		for(int i=2;i<=n;i++) {
			d[i] = Math.max(d[i], d[i-1]+arr[i]);
		}
		
		int max = -1000;
		for(int i=1;i<=n;i++) {
			max = Math.max(max,d[i]);
		}
		
		System.out.print(max);
		

	}
}
