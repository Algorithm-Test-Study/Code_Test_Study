import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String  res = "EABCD";
		
		for(int i=0;i<3;i++){
			int back = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<4;j++){
				int data = Integer.parseInt(st.nextToken());
				
				if(data ==0 ) back++;

			}

			sb.append(res.charAt(back)).append('\n');			
			
		}
		
		System.out.println(sb);
		
		
	}
}
