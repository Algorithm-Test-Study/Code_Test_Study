package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// [BOJ] 불 / 골드4 _완
public class Fire_5427 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] blank = new char[h][w];
            int[][] disf = new int[h][w];
            int[][] disg = new int[h][w];
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            Queue<Pair> qf = new LinkedList<>();
            Queue<Pair> qg = new LinkedList<>();

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for(int j = 0; j < w; j++){
                    blank[i][j] = s.charAt(j);
                    if(blank[i][j] == '*') {
                        disf[i][j] = 0;
                        qf.add(new Pair(i,j));
                    }
                    else disf[i][j] = -1;

                    if(blank[i][j] == '@') {
                        disg[i][j] = 0;
                        qg.add(new Pair(i,j));
                    }
                    else disg[i][j] = -1;
                }
            }

            while(!qf.isEmpty()){
                Pair cur = qf.poll();
                for(int d = 0; d< 4; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if(disf[nx][ny] >= 0 || blank[nx][ny] == '#') continue;
                    disf[nx][ny] = disf[cur.x][cur.y]+1;
                    qf.add(new Pair(nx, ny));
                }
            }
            Boolean success = false;
            while((!qg.isEmpty()) && (!success)){
                Pair cur = qg.poll();
                for(int d = 0; d< 4; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        System.out.println(disg[cur.x][cur.y]+1);
                        success = true;
                        break;
                    }
                    if(disg[nx][ny] >= 0 || blank[nx][ny] == '#') continue;
                    if(disf[nx][ny] != -1 && disf[nx][ny] <= disg[cur.x][cur.y]+1) continue;
                    disg[nx][ny] = disg[cur.x][cur.y]+1;
                    qg.add(new Pair(nx, ny));
                }
            }
            if(!success) System.out.println("IMPOSSIBLE");
        }
    }

    public static void main(String[] args) throws Exception{
        new Fire_5427().solution();
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
