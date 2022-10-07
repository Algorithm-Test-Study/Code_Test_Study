import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	static int n;


	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		
		char board [][] = new char[n][n];
		
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		int not_g = area(n, board);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if (board[i][j] == 'G')
			        board[i][j] = 'R';
			}
		}
		int is_g = area(n, board);
		
		System.out.println(not_g+" "+is_g);
		
	}
	
	static int area(int n, char[][] board) {
		Queue <int []> que = new LinkedList<>();;
		boolean visited [][]= new boolean[n][n];
		
		int dx [] = {0,1,0,-1};
		int dy [] = {1,0,-1,0};

		int result =0 ;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j]) continue;
				result++;
				
				visited[i][j] = true;
				que.offer(new int [] {i,j});
				
				while(!que.isEmpty()) {
					int pos [] = que.poll();
					
					for(int k=0;k<4;k++) {
						int nx = pos[0]+dx[k];
						int ny = pos[1]+dy[k];
						
						if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
						if(visited[nx][ny] || board[pos[0]][pos[1]]!=board[nx][ny]) continue;
						
						visited[nx][ny]=true;
						que.offer(new int [] {nx,ny});
					}
				}
				
			}
		}
		
		return result;
	}

	
}
