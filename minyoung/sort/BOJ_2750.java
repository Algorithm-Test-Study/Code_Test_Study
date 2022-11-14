import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int arr [] = new int[1001];
    
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(0, n);
		
		for(int i=0;i<n;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}

	public static void mergeSort( int st, int en) {
		if(en == st+1) return;
		int mid = (st+en)/2;
		mergeSort(st, mid);
		mergeSort( mid, en);
		merge( st, en);
		
	}
	
	public static void merge( int st, int en) {
		int mid = (st+en)/2;
		int li = st;
		int ri = mid;
		int tmp [] = new int [1001];
		
		for(int i=st;i<en;i++) {
			if(li == mid) tmp[i] = arr[ri++];
			else if(ri == en) tmp[i] = arr[li++];
			else if(arr[li]<=arr[ri]) tmp[i] = arr[li++];
			else tmp[i] = arr[ri++];
		}
		for(int i = st;i<en;i++) {
			arr[i] = tmp[i];
		}
	}
}
