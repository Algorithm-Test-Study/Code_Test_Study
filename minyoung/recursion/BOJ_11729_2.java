import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{

	static int n, count =0;
	static StringBuilder sb = new StringBuilder();

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n= Integer.parseInt(br.readLine());
		
		hanoi(1, 3, n);		
		
		System.out.println((1<<n)-1);
		System.out.print(sb);
	}

	static void hanoi(int start, int end, int amount) {
		if(amount == 1) {
			sb.append(start+" "+end+"\n");
			return;
		}
		hanoi(start, 6-(start+end), amount-1);
		sb.append(start+" "+end+"\n");
		hanoi(6-(start+end), end, amount-1);
	}

	
}
