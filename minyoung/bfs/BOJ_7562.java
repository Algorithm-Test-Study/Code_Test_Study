import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	static int t;


	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		Queue <int []> que;
		t = Integer.parseInt(br.readLine());
		
		int dx [] = {2,1,-1,-2,2,1,-1,-2};
		int dy [] = {1,2,2,1,-1,-2,-2,-1};
		
		for(int k=0;k<t;k++) {
			
			int l = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());	
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());	
			int goalX = Integer.parseInt(st.nextToken());
			int goalY = Integer.parseInt(st.nextToken());
			
			que = new LinkedList<>();
			int [][] dist = new int[l][l];
			
			for(int i=0;i<l;i++)
				Arrays.fill(dist[i], -1);
			
			dist[x][y] = 0;
			que.offer(new int [] {x,y});
			
			while(dist[goalX][goalY] == -1) {
				int pos [] = que.poll();
				
				for(int i=0;i<8;i++) {
					int nx = pos[0]+dx[i];
					int ny = pos[1]+dy[i];
					
					if(nx<0||ny<0||nx>=l||ny>=l) continue;
					if(dist[nx][ny] != -1) continue;
					
					dist[nx][ny] = dist[pos[0]][pos[1]]+1;
					que.offer(new int [] {nx,ny});
				}
				
			}
			
			
			sb.append(dist[goalX][goalY]).append("\n");

		}
		
		System.out.println(sb);

	}

	
}
