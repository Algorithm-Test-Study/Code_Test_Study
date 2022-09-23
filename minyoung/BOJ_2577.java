import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static int A,B,C;
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
				
		int arr[] = new int[10];
		Arrays.fill(arr, 0);
		
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		
		int sum = A*B*C;
		String s = String.valueOf(sum);
		
		for(int i=0;i<s.length();i++) {
			
			arr[s.charAt(i)-'0']++;
		}
		
		
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb);
		
		

	}

}
