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

        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};//확인할 x 방향(세로) 순서
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};//확인할 y 방향(가로) 순서
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int[][] dis =  new int[l][l];

            for(int k = 0; k < l; k++){//횟수 초기화
                for(int j = 0; j < l; j++){
                    dis[k][j] = -1;
                }
            }

            st = new StringTokenizer(br.readLine());
            int curx = Integer.parseInt(st.nextToken());//현재 위치
            int cury = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goalx = Integer.parseInt(st.nextToken());//목표 위치
            int goaly = Integer.parseInt(st.nextToken());

            if(curx == goalx && cury == goaly) {//이미 목표 위치라면 끝내기
                System.out.println(0);
                continue;
            }
            Queue<Pair> q = new LinkedList<>();
            dis[curx][cury] = 0;//현재 위치에 횟수 저장
            q.add(new Pair(curx, cury));
            while(!q.isEmpty() && dis[goalx][goaly] == -1){//이동할 곳이 남아있고 도착하지 않았을 때
                Pair cur = q.poll();
                for(int d = 0; d < 8; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;//범위 밖
                    if(dis[nx][ny] >= 0) continue;//이미 방문
                    dis[nx][ny] = dis[cur.x][cur.y]+1;
                    if(nx == goalx && ny == goaly){//도착
                        break;
                    }
                    q.add(new Pair(nx, ny));
                }
            }
            System.out.println(dis[goalx][goaly]);//결과 출력
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
