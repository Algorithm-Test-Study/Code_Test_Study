import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int x,N;
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		int input [] = new int[N];
		int arr[] = new int [2000001];
		Arrays.fill(arr, 0);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());

		}
		
		x= Integer.parseInt(br.readLine());
		
		
		int sum =0;
		for(int i=0;i<N;i++) {
			int data= input[i];
			
			if(x-data>0&&arr[x-data]==1 ) sum++;
			arr[data]=1;
			
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
	
	}

}
