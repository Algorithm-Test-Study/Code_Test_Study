import java.util.StringTokenizer;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Main
{
	public static int K;
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack <Integer> stack = new Stack<>();
		
		
		K = Integer.parseInt(br.readLine());
		
		for(int i=0;i<K;i++){

			String str = br.readLine();
			
			if(str.equals("0")){
				stack.pop();
			}
			else{
				stack.push(Integer.parseInt(str));
			}
			
		}
	
		int sum=0;
		while(!stack.empty()){
			sum=sum+stack.pop();
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}
