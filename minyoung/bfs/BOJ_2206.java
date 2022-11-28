import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	static int board[][];
	static int move[][][];
	static int n,m;

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		
		move = new int[n][m][2];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				move[i][j][0] = -1;
				move[i][j][1] = -1;
			}
		}
		
		
		
		System.out.print(bfs());
		
	}
	
	public static int bfs() {
	
		int dx[] = {-1,0,1,0};
		int dy[] = {0,-1,0,1};
		
		Queue <int[]> queue = new LinkedList<>();
		queue.offer(new int [] {0,0,0});
		move[0][0][0] = move[0][0][1] = 1;
		while(!queue.isEmpty()) {
			int pos[] = queue.poll();
			int x = pos[0];
			int y = pos[1];
			int broken = pos[2];
			if(x == n-1 && y == m-1) {
				return move[x][y][broken];
			}
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				if(board[nx][ny]== 0 && move[nx][ny][broken] == -1) {
					queue.offer(new int[] {nx, ny, broken});
					move[nx][ny][broken] = move[x][y][broken]+1;
				}
				if(broken == 0 && board[nx][ny] == 1 && move[nx][ny][1] == -1) {
					queue.offer(new int[] {nx, ny, 1});
					move[nx][ny][1] = move[x][y][broken]+1;
				}
				
			}
		}
		
		return -1;
	}

	
}
