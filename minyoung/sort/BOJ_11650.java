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
		
		ArrayList<Point> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y- o2.y;
			}
			
		});
		
		Collections.sort(list, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.x - o2.x;
			}
			
		});	

		
		for(int i = 0; i < n; i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.print(sb);
	}

}

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return x + " " + y;
	}
	
	
}
