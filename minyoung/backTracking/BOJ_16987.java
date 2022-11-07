import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static int s[], w[];
	static int result[];
	static boolean visited[];
	static int max =0;
	static int count =0;
	static int n;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		s = new int [n];
		w = new int [n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			w[i] = Integer.parseInt(st.nextToken());
		}
		
		egg(0);
		
		System.out.print(max);
	}
	
	static void egg(int k) { //k번째 달걀로 깨뜨림
        if (k == n) {
        	max = Math.max(max, count);
        	return;
        }  
        
        if(s[k]<=0 || count == n-1) {
        	egg(k+1);
        	return;
        }
        
        
        for (int i = 0; i < n; i++) {
        	if(i == k || s[i]<= 0)
        		continue;
        	s[k] = s[k] - w[i];
        	s[i] = s[i] - w[k];
        	
        	if(s[k]<=0) count++;
        	if(s[i]<=0) count++;
        	
        	egg(k+1);
        	
        	if(s[k]<=0) count--;
        	if(s[i]<=0) count--;
        	
        	s[k] = s[k] + w[i];
        	s[i] = s[i] + w[k];
        	
        }
    }
	
}
