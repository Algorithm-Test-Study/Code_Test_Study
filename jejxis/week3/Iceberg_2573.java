package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// [BOJ] 빙산 / 골드4 _완
public class Iceberg_2573 {
    int[][] sea = new int[300][300];//현재 바다 상황
    int[][] zero = new int[300][300];//각 빙산 칸을 녹일 수 있는 주변 바다 칸의 수
    int[][] visited = new int[300][300];//빙산 덩어리 셀 때 사용
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int n, m, nx, ny;

    int sum = -1;//남아 있는 빙산 칸 수

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//행 -> x
        m = Integer.parseInt(st.nextToken());//열 -> y

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                sea[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;//덩어리 수
        int loop = 0;//녹인 횟수(해)
        while(count <= 1 && sum != 0){//덩어리가 한 개 이고 남은 빙산 칸 수가 0이 아닐 때 반복
            loop++;
            checkZero();//각 빙산 칸의 주변 바다 칸 개수 세기
            melt();//녹이기
            count = countLump();//덩어리 세기
        }
        if(sum == 0) System.out.println(0);//덩어리 수는 1개인데 빙산은 다 녹음
        else System.out.println(loop);//빙산이 두 덩어리 이상이 된 경우
    }

    void checkZero(){//한번 녹을 때 얼마나 녹는지 확인
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < m-1; j++){
                visited[i][j] = 0;//처음을 제외하고는 countLump()에서 visited를 쓰고 난 후 이므로 값 다시 저장
                if(sea[i][j] < 1) continue;//빙산칸이 아니므로 넘어가기
                int count = 0;//주변 바다 칸 세기
                for(int d = 0; d < 4; d++){
                    nx = i+dx[d];
                    ny = j +dy[d];
                    if(sea[nx][ny] == 0) count++;
                }
                zero[i][j] = count;//빙산 칸 주변의 바다 칸 개수 저장
            }
        }
    }

    void melt(){//녹이기
        sum = 0;//남아있는 빙산 칸수
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < m-1; j++){
                sea[i][j] -= zero[i][j];//해당 빙산 칸의 주변 바다 칸만큼 녹이기
                if(sea[i][j] < 0) sea[i][j] = 0;//0보다 작아지면 0으로!
                zero[i][j] = 0;//다음 while 루프에서 사용할 것이므로 0으로 초기화
                sum += sea[i][j];//남아있는 빙산 칸수
            }
        }
    }

    int countLump(){//덩어리 세기
        int count = 0;
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < m-1; j++){
                if(sea[i][j] < 1 || visited[i][j] == 1) continue;//바다거나 이미 방문했을 때
                count++;
                Queue<Pair> q= new LinkedList<>();
                visited[i][j] = 1;
                q.add(new Pair(i,j));
                while(!q.isEmpty()){
                    Pair cur = q.poll();
                    for(int d= 0; d < 4; d++){
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];
                        if(nx < 1 || nx >= n-1 || ny < 1 || ny >= m-1) continue;//빙하 범위를 벗어났을 때
                        if(visited[nx][ny] == 1 || sea[nx][ny] < 1) continue;//바다거나 이미 방문했을 때
                        visited[nx][ny] = 1;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        new Iceberg_2573().solution();
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
