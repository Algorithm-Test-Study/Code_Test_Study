package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//[BOJ] 유기농 배추 / 실버2
public class OrganicBaechu_1012 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        //영역 개수 세기 -> 그림 문제와 비슷

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};


        for(int l = 0 ; l < T; l++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] field = new int[n][m];//배추밭
            int[][] visit = new int[n][m];//방문여부
            int count = 0;//영역 개수
            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(field[i][j] == 0 || visit[i][j] == 1) continue;//배추가 없거나 이미 방문
                    count++;//영역 개수 증가
                    Queue<Pair> q = new LinkedList<>();
                    visit[i][j] = 1;//현재 위치 방문표시
                    q.add(new Pair(i, j));
                    while(!q.isEmpty()){
                        Pair cur = q.poll();
                        for(int d = 0; d < 4; d++){
                            int nx = cur.x + dx[d];
                            int ny = cur.y + dy[d];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;//범위밖
                            if(visit[nx][ny] == 1 || field[nx][ny] != 1) continue;//방문했거나 배추가 없거나
                            visit[nx][ny] = 1;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void main(String[] args) throws Exception{
        new OrganicBaechu_1012().solution();
    }
    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}
