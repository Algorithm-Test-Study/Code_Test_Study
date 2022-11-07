import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static char arr[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		arr = new char [n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(arr[i], ' ');
		}
		
		star(0,0,n);

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void star(int r, int c, int n) {
		
		if(n==1) {
			arr[r][c] = '*';
			return;
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++ ) {
				if(i==1&&j==1)
					continue;
				star(r+i*(n/3), c+j*(n/3), n/3);
			}
		}
	}
	

}
