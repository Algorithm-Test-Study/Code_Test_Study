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
            int[][] disf = new int[h][w];//불의 시간당 위치
            int[][] disg = new int[h][w];//지훈이의 시간당 위치
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            Queue<Pair> qf = new LinkedList<>();//불
            Queue<Pair> qg = new LinkedList<>();//지훈

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                for(int j = 0; j < w; j++){
                    blank[i][j] = s.charAt(j);
                    if(blank[i][j] == '*') {//불이면
                        disf[i][j] = 0;//해당 위치 0으로
                        qf.add(new Pair(i,j));//시작점에 추가
                    }
                    else disf[i][j] = -1;

                    if(blank[i][j] == '@') {//지훈이면
                        disg[i][j] = 0;//해당 위치 0으로
                        qg.add(new Pair(i,j));//시작점에 추가
                    }
                    else disg[i][j] = -1;
                }
            }

            while(!qf.isEmpty()){
                Pair cur = qf.poll();
                for(int d = 0; d< 4; d++){//시간에 따른 불의 이동
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;//범위 밖이거나
                    if(disf[nx][ny] >= 0 || blank[nx][ny] == '#') continue;//이미 방문했거나 벽이면 넘어가기
                    disf[nx][ny] = disf[cur.x][cur.y]+1;
                    qf.add(new Pair(nx, ny));
                }
            }
            Boolean success = false;//지훈이의 탈출 여부
            while((!qg.isEmpty()) && (!success)){
                Pair cur = qg.poll();
                for(int d = 0; d< 4; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || nx >= h || ny < 0 || ny >= w) {//범위 밖이면 탈출 성공이므로
                        System.out.println(disg[cur.x][cur.y]+1);//출력
                        success = true;//성공했다고 표시
                        break;
                    }
                    if(disg[nx][ny] >= 0 || blank[nx][ny] == '#') continue;//벽이거나
                    if(disf[nx][ny] != -1 && disf[nx][ny] <= disg[cur.x][cur.y]+1) continue;//이미 방문했거나 더 빨리 도착할 수 있었으면 넘어가기
                    disg[nx][ny] = disg[cur.x][cur.y]+1;
                    qg.add(new Pair(nx, ny));
                }
            }
            if(!success) System.out.println("IMPOSSIBLE");//성공 못했을 때 IMPOSSIBLE 출력
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
