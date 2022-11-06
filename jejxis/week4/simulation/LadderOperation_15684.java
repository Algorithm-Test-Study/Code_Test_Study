package week4.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 사다리 조작 / 골드3 _완
public class LadderOperation_15684 {
    static int N, M, H;
    static int[][] ladder;
    static StringTokenizer st;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ladder[r][c] = 1;
        }

        for (int i = 0; i <= 3; i++) {
            comb(1, 0, i);
        }
        System.out.println(-1);
    }

    public void comb(int nr, int cnt, int size) {
        if (cnt == size) {
            if (check()) {//사다리를 옳게 놓았는지 확인
                System.out.println(size);
                System.exit(0);
            }
            return;
        }

        for (int r = nr; r <= H; r++) {
            for (int c = 1; c < N; c++) {
                if (ladder[r][c] == 1)//현재 위치가 사다리라면
                    continue;
                if (ladder[r][c - 1] == 1) {//현재 위치의 왼쪽이 사다리라면
                    continue;
                }
                if (ladder[r][c + 1] == 1) {//현재 위치의 다음이 사다리라면
                    continue;
                }
                ladder[r][c] = 1;//사다리 놓기
                comb(r, cnt + 1, size);//다음 사다리 놓을 위치 정하기
                ladder[r][c] = 0;//사다리 없애기

            }
        }
    }

    public boolean check() {
        for (int i = 1; i <= N; i++) {
            int currPosition = i;
            int start = 1;
            while (start <= H) {
                if (ladder[start][currPosition] == 1) {//현재 위치가 사다리면 오른쪽으로
                    currPosition++;
                    start++;
                } else if (ladder[start][currPosition - 1] == 1) {//왼쪽이 사다리면 왼쪽으로
                    currPosition--;
                    start++;
                } else {//양옆 다 아니면 아래로
                    start++;
                }
            }
            if (i != currPosition)//하나라도 제대로 되지 않을 경우
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception{
        new LadderOperation_15684().solution();
    }
}
