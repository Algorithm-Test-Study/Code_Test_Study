package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [BOJ] 적록색약 / 골드5 _완
public class RedGreenColorWeakness_10026 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int weak = 0; int not = 0;//색약인 사람이 보는 영역 수/ 아닌 사림이 보는 영역 ㅅ수

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        char[][] picture = new char[n][n];
        int[][] visit = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j = 0; j < n; j++){
                picture[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visit[i][j] == 1) continue;
                not++;
                Queue<Pair> q = new LinkedList<>();
                char curc = picture[i][j];
                visit[i][j] = 1;
                q.add(new Pair(i,j));
                while(!q.isEmpty()){
                    Pair cur = q.poll();
                    for(int k = 0; k < 4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if(curc != picture[nx][ny] || visit[nx][ny] == 1) continue;//br, bg
                        visit[nx][ny] = 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visit[i][j] = 0;
                if(picture[i][j] == 'R') picture[i][j] = 'G';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visit[i][j] == 1) continue;
                weak++;
                Queue<Pair> q = new LinkedList<>();
                char curc = picture[i][j];
                visit[i][j] = 1;
                q.add(new Pair(i,j));
                while(!q.isEmpty()){
                    Pair cur = q.poll();
                    for(int k = 0; k < 4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if(curc != picture[nx][ny] || visit[nx][ny] == 1) continue;//br, bg
                        visit[nx][ny] = 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }

        System.out.println(not + " "+ weak);
    }

    public static void main(String[] args) throws Exception{
        new RedGreenColorWeakness_10026().solution();
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
