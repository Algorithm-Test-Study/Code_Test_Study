import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static int N;
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
				
		int arr[] = new int[11];
		
		
		N = Integer.parseInt(br.readLine());
		
		while(N>0) {
			arr[N%10]++;
			N=N/10;
		}
		
		int sum = arr[9]+arr[6];
		
		arr[9] = sum/2+sum%2;
		arr[6]=0;

		Arrays.sort(arr);
		
		bw.write(String.valueOf(arr[10]));
		
		bw.flush();
		
		

	}

}
