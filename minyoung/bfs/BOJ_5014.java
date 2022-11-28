import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		
		int f, s, g, u, d;
		StringTokenizer st = new StringTokenizer(br.readLine());
		f= Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		int dist[] = new int[f+1];
		Arrays.fill(dist, -1);
		
		int dir [] = {u, -d};
		
		Queue <Integer> queue = new LinkedList<>();
		
		dist[s] = 0;
		queue.offer(s);
		while(!queue.isEmpty()) {
			int pos = queue.poll();
			for(int i=0;i<2;i++) {
				int next = pos+dir[i];
				if(next<1||next>f||dist[next]!=-1) continue;
				queue.offer(next);
				dist[next] = dist[pos] + 1;
			}
		}
		
		if(dist[g] == -1) {
			System.out.print("use the stairs");
		}
		else System.out.print(dist[g]);
	}

	
}
