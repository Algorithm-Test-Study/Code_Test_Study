import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long val =square(a,b,c);
		
		System.out.println(val);
	
	}
	
	public static long square(int a,int b, int c) {
		if(b==1) return a % c;
		long val = square(a,b/2,c);
		val = val*val%c;
		if(b%2==0) 
			return val;
		else
			return val*a%c;
			
	}

}
