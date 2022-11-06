import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int arr[][];
	public static int count[] = new int[2];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		paper(0,0,n);
		sb.append(count[0]).append("\n").append(count[1]);
		System.out.print(sb);
	}
	
	public static void paper(int r, int c, int n) {
		if(check(r,c,n)) {
			count[arr[r][c]]++;
			return;
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				paper(r+i*(n/2), c+j*(n/2), n/2);
			}
		}
	}
	
	public static boolean check(int r, int c, int n) {
		for(int i=r;i<r+n;i++) {
			for(int j=c;j<c+n;j++) {
				if(arr[r][c]!=arr[i][j])
					return false;
			}
		}
		return true;
	}
}
