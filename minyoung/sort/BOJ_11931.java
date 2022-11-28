import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		ArrayList <Integer> arr= new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr, Collections.reverseOrder());
		
		for(int i=0;i<n;i++) {
			sb.append(arr.get(i)).append("\n");
		}
		
		System.out.print(sb);
	}

	
}
