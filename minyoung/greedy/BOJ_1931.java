import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList <int []> arr = new ArrayList<>();

		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new int [] { Integer.parseInt(st.nextToken()),  Integer.parseInt(st.nextToken())});
			
		}
		
		Collections.sort(arr, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}});
		
		Collections.sort(arr, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}});
		
		
		int max =0;
		int end = 0;
		for(int i=0;i<n;i++) {
			if(end <= arr.get(i)[0]) {
				end = arr.get(i)[1];
				max++;
			}
				
		}
		
		System.out.print(max);
		

	}
}
