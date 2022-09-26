import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, X;
	
	public static void main(String[] args) throws Exception{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
        
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			
			int data = Integer.parseInt(st.nextToken());
			if(data<X) {
				sb.append(data).append(' ');
			}
		}
		
		System.out.println(sb);
		
		

	}

}
