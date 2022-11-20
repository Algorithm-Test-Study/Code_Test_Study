import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			int max= arr[n-1];
			for(int j=2;j<=n;j++) {
				if(arr[n-j] >= max) {
					max = arr[n-j];
				}
				else {
					sum += max-arr[n-j];
				}
			}
			
			sb.append(sum).append("\n");
			
		}

		System.out.print(sb);

	}
}
