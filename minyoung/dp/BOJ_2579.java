import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	
	static int n;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int d [] = new int [310];
		int score [] = new int [310];
		n = Integer.parseInt(br.readLine());
		
		int total = 0;
		for(int i=1;i<=n;i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		d[1] = score[1];
		d[2] = score[1]+score[2];
		
		if(n<=2) {
			System.out.print(d[n]);
			return;
		}
		
		for(int i=3;i<=n;i++) {
			d[i] = Math.max(d[i-2], d[i-3]+score[i-1])+score[i];
		}
		
		System.out.print(d[n]);

	}


}
