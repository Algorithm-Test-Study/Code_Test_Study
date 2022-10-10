package week3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//[BOJ] 그림 / 실버1 _완
public class Picture_1926 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = 0;//그림 개수
        int max = 0;//가장 넓은 그림의 너비

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] blank = new int[n][m];//그림배치
        int[][] visit = new int[n][m];//방문 여부



        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                blank[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(blank[i][j] == 0 || visit[i][j] == 1) continue;//그림이 없거나 이미 방문
                count++;//그림 개수 증가
                Queue<Pair> queue = new LinkedList<>();//poll, add
                visit[i][j] = 1;//현재 위치 방문 표시
                queue.add(new Pair(i,j));
                int area = 0;//현재 보는 그림의 너비
                while(!queue.isEmpty()){
                    area++;
                    Pair cur = queue.poll();
                    for(int d = 0; d < 4; d++){
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;//범위밖
                        if(visit[nx][ny] == 1 || blank[nx][ny] != 1) continue;//이미 방문했거나 그림이 아니거나
                        visit[nx][ny] = 1;
                        queue.add(new Pair(nx, ny));
                    }
                }
                if(area > max) max = area;//크기 비교해서 저장
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        new Picture_1926().solution();
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

