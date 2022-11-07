import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	public static int arr[];
	public static boolean isColvisited[];
	public static boolean isUpRightvisited[];
	public static boolean isDownLeftvisited[];	
	public static int n;
	static int count =0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int [n];
		isColvisited =  new boolean [n];
		isUpRightvisited =  new boolean [2*n-1];
		isDownLeftvisited =  new boolean [2*n-1];
		
		queen(0);
		
		System.out.print(count);
	}
	
	public static void queen(int row) {
		if(row==n) {
			count++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!isColvisited[i] && !isUpRightvisited[row+i] && !isDownLeftvisited[row-i+n-1]) {
				isColvisited[i] = true;
				isUpRightvisited[row+i] = true;
				isDownLeftvisited[row-i+n-1] = true;
				arr[row] = i;
				queen(row+1);
				
				isColvisited[i] = false;
				isUpRightvisited[row+i] = false;
				isDownLeftvisited[row-i+n-1] = false;
				
			}
			
		}
		
	}
	

}
