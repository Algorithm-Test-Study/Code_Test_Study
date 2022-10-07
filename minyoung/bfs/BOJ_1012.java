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
		Queue <int []> que ;
		t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			que = new LinkedList<>();
			
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int board [][] = new int [n][m];
			
			for(int j=0;j<k;j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				board[x][y] = 1;
			}
			
			sb.append(bfs(n,m,board,que)).append("\n");

		}
		
		System.out.println(sb);

	}
	
	public static int bfs(int n, int m, int [][] board, Queue<int []> que) {
		
		boolean [][] visited = new boolean [n][m];
		int dx [] = {0,-1,0,1};
		int dy [] = {1,0,-1,0};
		
		int result = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(board[i][j] ==0 || visited[i][j] ) continue;
				visited[i][j] = true;
				que.offer(new int [] {i,j});
				result++;
				while(!que.isEmpty()) {
					int [] pos = que.poll();
					
					for(int k=0;k<4;k++) {
						int nx = pos[0]+dx[k];
						int ny = pos[1]+dy[k];
						
						if(nx<0||ny<0||nx>=n||ny>=m) continue;
						if(board[nx][ny] == 0 || visited[nx][ny]) continue;
						
						visited[nx][ny] = true;
						que.offer(new int[] {nx,ny});
						
					}
				}
				
				
			}
		}
		return result;
	}
	
}
