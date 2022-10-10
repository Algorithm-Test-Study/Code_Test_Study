package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//[BOJ] 미로 탐색 / 실버1 _완
public class MazeSearch_2178 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dis = new int[n][m];//이동 횟수 저장
        int[][] blank = new int[n][m];//미로 정보 저장

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < m; j++){
                blank[i][j] = str.charAt(j) - '0';
                dis[i][j] = -1;
            }
        }
        Queue<Pair> queue = new LinkedList<>();//poll, add
        dis[0][0] = 1;//현재 위치
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;//범위 밖
                if(dis[nx][ny] >= 0 || blank[nx][ny] != 1) continue;//이미 방문했거나 이동할 수 없는 칸
                dis[nx][ny] = dis[cur.x][cur.y]+1;
                queue.add(new Pair(nx, ny));
            }
        }
        System.out.println(dis[n-1][m-1]);

    }

    public static void main(String[] args) throws Exception{
        new MazeSearch_2178().solution();
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

