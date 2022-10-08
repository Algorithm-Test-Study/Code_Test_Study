package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// [BOJ] 나이트의 이동 / 실버1 _완
public class KnightMovement_7562 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int[][] dis =  new int[l][l];

            for(int k = 0; k < l; k++){
                for(int j = 0; j < l; j++){
                    dis[k][j] = -1;
                }
            }

            st = new StringTokenizer(br.readLine());
            int curx = Integer.parseInt(st.nextToken());
            int cury = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goalx = Integer.parseInt(st.nextToken());
            int goaly = Integer.parseInt(st.nextToken());

            if(curx == goalx && cury == goaly) {
                System.out.println(0);
                continue;
            }
            Queue<Pair> q = new LinkedList<>();
            dis[curx][cury] = 0;
            q.add(new Pair(curx, cury));
            while(!q.isEmpty() && dis[goalx][goaly] == -1){
                Pair cur = q.poll();
                for(int d = 0; d < 8; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                    if(dis[nx][ny] >= 0) continue;
                    dis[nx][ny] = dis[cur.x][cur.y]+1;
                    if(nx == goalx && ny == goaly){
                        break;
                    }
                    q.add(new Pair(nx, ny));
                }
            }
            System.out.println(dis[goalx][goaly]);
        }
    }

    public static void main(String[] args) throws Exception{
        new KnightMovement_7562().solution();
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
