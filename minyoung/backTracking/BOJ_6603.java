import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static int arr[];
	static int result[];
	static boolean visited[];
	static int n;
	static int count =0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			arr = new int [n];
			result = new int [n];
			visited = new boolean [n];
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			lotto(0);
			System.out.println(sb);
		}
	}
	
	static void lotto(int k) {
        if (k == 6) {
        	boolean flag = true; //오름차순 여부를 알려주는 flag
        	int temp = -1;
        	
        	for(int i=0;i<6;i++) {
        		if(temp> arr[result[i]])
        			flag = false;
        		temp = arr[result[i]];
        	}
        	if(flag) {
	            for (int i=0;i<6;i++) {
	                sb.append(arr[result[i]]).append(" ");
	            }
	            sb.append("\n");
        	}
            return;
        }

        for (int i = 0; i < n; i++) {
        	if(!visited[i]) {
				result[k] = i;
				visited[i] = true;
				lotto(k+1);
				visited[i] = false;
			}
        }
    }
	
}
