import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		ArrayList<String> list = new ArrayList<>();

		for(int i=0;i<str.length();i++) {
			list.add(str.substring(i));
		}
		
		Collections.sort(list);
		
		for(String s : list) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);
	}

}
