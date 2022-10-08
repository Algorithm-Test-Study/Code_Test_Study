import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	static int n,m;
	
	static int dx [] = {0,1,0,-1};
	static int dy [] = {1,0,-1,0};

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());


		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		
		int board [][] = new int[n][m];
		
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count =0;
		while(true) {
			meltGlacier(board);
			count++;
			
			int result = bfs(board);
			
			if( result >= 2) {
				break;
			}
			else if( result == 0 ){
				System.out.println(0);
				return;
			}
			
		}
		System.out.println(count);
		
	}
	
//   빙산 녹이기
	static void meltGlacier(int [][] board ) {
		int area [][] = new int [n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(board[i][j] == 0 ) continue;
				
				for(int k=0;k<4;k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if(board[nx][ny] == 0) area[i][j]++;
				}
		
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				board[i][j] = Math.max(0, board[i][j]-area[i][j]); //0과 빙산 녹인 값 중에서 큰 걸 선택해야 됨. 왜냐하면 마이너스가 나올수 있으니깐
			}
		}
		
	}
	
//   bfs
//   1926 문제처럼 풀면된다
	static int bfs(int[][] board) {
		Queue <int []> que = new LinkedList<>();;
		boolean visited [][]= new boolean[n][m];

		int result =0 ;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visited[i][j]||board[i][j]==0) continue;
				
				result++;
				
				visited[i][j] = true;
				que.offer(new int [] {i,j});
				
				while(!que.isEmpty()) {
					int pos [] = que.poll();
					
					for(int k=0;k<4;k++) {
						int nx = pos[0]+dx[k];
						int ny = pos[1]+dy[k];
						
						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if(visited[nx][ny] || board[nx][ny]==0) continue;
						
						visited[nx][ny]=true;
						que.offer(new int [] {nx,ny});
					}
				}
				
			}
		}
		
		return result;
	}

	
}
