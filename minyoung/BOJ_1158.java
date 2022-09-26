import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static int N, K;
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		LinkedList <Integer> list =new LinkedList<>();
		LinkedList <Integer> list2 = new LinkedList<>();
		
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		
		sb.append("<");
		
		for(int i=1;;i++) {
			
			int data = list.remove(0);
			
			
			if(i==K) {
				if(list.isEmpty()) {
					sb.append(data);
					break;
				}
				else {
					sb.append(data).append(", ");
					i=0;
				}
			}
			else {
				list.add(data);
			}
		}


		sb.append(">");
		System.out.println(sb);
	
	}

}
