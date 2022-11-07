import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	public static int arr[];
	public static int n,s;
	static int count =0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int [n];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			 arr[i] = Integer.parseInt(st.nextToken());	 
		}
		
		partial(0, 0);
		if(s == 0)
			count--;
		System.out.print(count);
	}
	
	public static void partial(int idx, int sum) {
		if(idx == n) {
			if(sum==s) {
				count++;
			}
			return;
		}
		
		partial(idx+1, sum); // 안녛음
		partial(idx+1, arr[idx]+sum); //넣음
		
	}
	

}
