import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {

	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
				
		int arr[] = new int[26];
		Arrays.fill(arr, 0);
		
		for(int i=0;i<S.length();i++) {
			
			arr[S.charAt(i)-'a']++;
		}
		
		
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]).append(' ');
		}
		System.out.println(sb);
		
		

	}

}
