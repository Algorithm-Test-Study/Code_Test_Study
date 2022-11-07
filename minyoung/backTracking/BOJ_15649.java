import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	public static boolean isvisited[] = new boolean [11];
	public static int arr[] = new int [11];
	public static int n, m;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		nAndm(0);
		
		System.out.print(sb);
	}
	
	public static void nAndm(int k) {
		if(k==m) {
			for(int i=0; i<m;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!isvisited[i]) {
				arr[k] = i;
				isvisited[i] = true;
				nAndm(k+1);
				isvisited[i] = false;
			}
			
		}
	}
	

}
