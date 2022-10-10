package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// [BOJ] 토마토 / 골드5 _완
public class Tomato_7569 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());//z
        int n = Integer.parseInt(st.nextToken());//y
        int h = Integer.parseInt(st.nextToken());//x
        //x: 높이, y: 세로,z: 가로

        int[][][] dist= new int[h][n][m];//익는데 걸리는 시간
        int[][][] box= new int[h][n][m];//토마토 배치

        int[] dx = {-1, 0, 0, 0, 0, 1};
        int[] dy = {0, -1, 0, 1, 0, 0};
        int[] dz = {0, 0, -1, 0, 1, 0};

        Queue<XYZ> q = new LinkedList<>();
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1){//익은 토마토
                        q.add(new XYZ(i,j,k));//시작점 저장
                    }
                    if(box[i][j][k] == 0){//익지 않은 토마토
                        dist[i][j][k] = -1;//-1 저장
                    }
                }
            }
        }
        while(!q.isEmpty()){
            XYZ cur = q.poll();
            for(int d = 0; d < 6; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];
                if(nx < 0 || nx >= h || ny < 0 || ny >= n || nz < 0 || nz >= m) continue;//범위밖
                if(dist[nx][ny][nz] >= 0 ) continue;//이미 익음
                dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z] +1;
                q.add(new XYZ(nx, ny, nz));
            }
        }
        int ans = 0;//정답 찾기
        for(int i = 0; i < h; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(dist[i][j][k] == -1){//안 익은 토마토가 남아있으면
                        System.out.println(-1);//-1 출력후 종료
                        return;
                    }
                    if(dist[i][j][k] > ans) ans = dist[i][j][k];//비교해서 더 큰 값 저장
                }
            }
        }

        System.out.println(ans);

    }

    public static void main(String[] args) throws Exception{
        new Tomato_7569().solution();
    }
    class XYZ {
        int x;
        int y;
        int z;

        public XYZ(int x, int y, int z) {
            super();
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
