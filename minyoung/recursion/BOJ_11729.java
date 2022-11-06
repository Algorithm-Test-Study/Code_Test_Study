import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		sb.append((1<<n)-1).append("\n");
		hanoi(1, 3, n);
		
		System.out.println(sb);
	}
	
	public static void hanoi(int a, int b, int n) {
		if(n==1) {
			sb.append(a+" "+b).append("\n");
			return;
		}
		hanoi(a, 6-a-b, n-1);
		sb.append(a+" "+b).append("\n");
		hanoi(6-a-b, b, n-1);
	}
	
	

}
