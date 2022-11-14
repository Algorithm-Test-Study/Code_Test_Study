import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		List<Freq> list = new ArrayList<>();

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			int val = Integer.parseInt(st.nextToken());
			boolean check = false;
			for(Freq freq : list) {
				if(freq.val == val) {
					freq.count++;
					check = true;
					break;
				}
			}
			if(!check)
				list.add(new Freq(val, 1));
		}
		
		Collections.sort(list, new Comparator<Freq>() {

			@Override
			public int compare(Freq o1, Freq o2) {
				return o2.count - o1.count;
			}
			
		});
		
		for(Freq freq : list) {
			for(int i = 0;i<freq.count;i++) {
				sb.append(freq.val+ " ");
			}
		}
		System.out.print(sb);
	}

}

class Freq{
	int val;
	int count;
	
	public Freq(int val, int count) {
		this.val = val;
		this.count = count;
	}
	
}
