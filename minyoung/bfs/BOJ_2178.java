import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main
{
	static int n, m;

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue <int []> queue = new LinkedList<>();
		
		
		int dx [] = {0,1,0,-1};
		int dy [] = {1,0,-1,0};
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int board[][] = new int [n][m];
		boolean visit [][] = new boolean [n][m];
		int distance [][] = new int [n][m];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				board[i][j] = str.charAt(j)-'0';
			}
		}
		
		
		visit[0][0] = true;
		queue.offer(new int [] {0,0});
		
		while(!queue.isEmpty()) {
			int pos [] = queue.poll();
			for(int k=0;k<4;k++) {
				int nx = pos[0]+dx[k];
				int ny = pos[1]+dy[k];
				
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				if(board[nx][ny] == 0 || visit [nx][ny]) continue;
										
				visit[nx][ny] = true;
				distance[nx][ny] = distance[pos[0]][pos[1]]+1;
				queue.offer( new int [] {nx, ny});
			}
		}
		
		
		System.out.println(distance[n-1][m-1]+1);
		

	}
	

	
	
}
