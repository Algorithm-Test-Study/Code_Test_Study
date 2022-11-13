import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<String> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++) {
			list.add(br.readLine());
		}	
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length())
					return Integer.compare(o1.length(), o2.length());
				else {
					int sum1=0;
					int sum2=0;
					for(char c : o1.toCharArray()) {
						if(c>='1'&&c<='9') sum1 += c-'0';
					}
					for(char c : o2.toCharArray()) {
						if(c>='1'&&c<='9') sum2 += c-'0';
					}
					if(sum1==sum2) 
						return o1.compareTo(o2);
					return Integer.compare(sum1, sum2);
				}
			}
			
		});
		
		for(int i = 0; i < n; i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.print(sb);
	}

}
