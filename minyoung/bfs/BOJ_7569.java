import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	static int n, m, h;

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue <int []> queue = new LinkedList<>();
		
		int dx [] = {0,1,0,-1,0,0};
		int dy [] = {1,0,-1,0,0,0};
		int dz [] = {0,0,0,0,1,-1};
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int board[][][] = new int [n][m][h];
		int distance [][][] = new int [n][m][h];
		for(int k=0;k<h;k++) {
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());
					
					if(board[i][j][k]==1) {
						queue.offer(new int [] {i,j,k});
					}
					if(board[i][j][k]==0) {
						distance[i][j][k] = -1;
					}
				}
			}
		}
		
		
		while(!queue.isEmpty()) {
			int pos [] = queue.poll();
			for(int i=0;i<6;i++) {
				int nx = pos[0]+dx[i];
				int ny = pos[1]+dy[i];
				int nz = pos[2]+dz[i];
				if(nx<0||ny<0||nz<0||nx>=n||ny>=m||nz>=h) continue;			
				if(distance[nx][ny][nz]>=0) continue;
				
				distance[nx][ny][nz] = distance[pos[0]][pos[1]][pos[2]]+1;
				queue.offer( new int [] {nx, ny, nz});
			}
		}
		
		int result=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<h;k++) {
					if(distance[i][j][k]==-1) {
						System.out.println("-1");
						return;
					}
					result = Math.max(result, distance[i][j][k]);
				}
			}
		}
		
		System.out.println(result);

	}
	
/*
 * 3차원 배열로 설정
 * distance 배열을 이용하여 안익은 토마토에 -1 배정. visited 배열이 없어도 -1이 안익은 토마토라는 것을 알 수 있으며 방문하면됨
 * bfs를 이용. distance는 안익은 토마토를 offer 할때마다 1증가
 * 
 */

	
	
}
