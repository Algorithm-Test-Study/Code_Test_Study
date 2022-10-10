import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int n,w, h;
	
	static StringBuilder sb = new StringBuilder();

	static int dx [] = {0,-1,0,1};
	static int dy [] = {1,0,-1,0};
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st ;

		n = Integer.parseInt(br.readLine());
		
		
		for(int k=0;k<n;k++) {
			
			st= new StringTokenizer(br.readLine());
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			char board [][] = new char [w][h];

//			BOARD 초기화
			
			for(int i=0;i<w;i++) {
				String str = br.readLine();
				for(int j=0;j<h;j++) {
					board[i][j] = str.charAt(j);
				}
			}
			
			
			escapeBuilding(board);

			
		}
		
		System.out.println(sb);

	
	}
	
	public static void escapeBuilding(char [][] board) {
		
	
		
		Queue <int [] > que1 = new LinkedList<>();
		Queue <int [] > que2 = new LinkedList<>();
		
	
		int dist1[][] = new int[w][h];
		int dist2[][] = new int[w][h];
		
		for(int i=0;i<w;i++) {
			Arrays.fill(dist1[i], -1);
			Arrays.fill(dist2[i], -1);
		}
		
//		dist 배열로 방문했는지 판단. 처음 시작할 위치 que와 dist에 설정
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(board[i][j] == '*') {
					dist1[i][j] = 0;
					que1.offer(new int [] {i,j});
				}
				else if(board[i][j] == '@') {
					dist2[i][j] = 0;
					que2.offer(new int [] {i,j});
				}
			}
		}
		
//		불에 대해서 bfs 시행
		while(!que1.isEmpty()) {
			int pos [] = que1.poll();
			
			for(int i=0;i<4;i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				
				if(nx<0||ny<0||nx>=w||ny>=h) continue;
				if(board[nx][ny] == '#' || dist1[nx][ny] != -1) continue;
				
				dist1[nx][ny] = dist1[pos[0]][ pos[1]]+1;
				que1.offer(new int [] {nx,ny});
			}
		}
		
//		상근이 대피 bfs 시행
		while(!que2.isEmpty()) {
			int pos [] = que2.poll();
			
			for(int i=0;i<4;i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				
				if(nx<0||ny<0||nx>=w||ny>=h) {
					sb.append(dist2[pos[0]][pos[1]]+1).append("\n");
					return;
				}
				if(board[nx][ny] == '#' || dist2[nx][ny] != -1) continue;
				if(dist1[nx][ny] != -1 && dist1[nx][ny]<=dist2[pos[0]][pos[1]]+1) continue;
				
				dist2[nx][ny] = dist2[pos[0]][ pos[1]]+1;
				que2.offer(new int [] {nx,ny});
			}
		}
		sb.append("IMPOSSIBLE").append("\n");
	}

}
