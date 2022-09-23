import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int x,N;
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int Y =0;
		int M=0;
		
		for(int i=0;i<N;i++) {
			int data = Integer.parseInt(st.nextToken());
			
			Y+=10*(data/30+1);
			M+=15*(data/60+1);

		}
		
		if(Y<M) sb.append("Y ").append(Y);
		else if(Y>M) sb.append("M ").append(M);
		else sb.append("Y M ").append(Y);
		
		System.out.println(sb);

	}

}
