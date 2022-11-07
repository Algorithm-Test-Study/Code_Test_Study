import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int val = z(n,r,c);
		
		System.out.println(val);
	}
	
	public static int z(int n, int r, int c) {
		int half = 1<<(n-1);
		if(n==0)
			return 0;
		if(r<half&&c<half)
			return z(n-1, r, c);
		if(r<half&&c>=half)
			return half*half+ z(n-1, r, c-half);
		if(r>=half&&c<half)
			return half*half*2+ z(n-1, r-half, c);
		return half*half*3+ z(n-1, r-half, c-half);
	}
}
