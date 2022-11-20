import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList <Integer> arr = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(br.readLine()));
			
		}
		
		Collections.sort(arr);
		
		int max=0;
		for(int k=1;k<=n;k++) {
			max = Math.max(max, arr.get(n-k)*k);
		}
		System.out.print(max);

	}
}
