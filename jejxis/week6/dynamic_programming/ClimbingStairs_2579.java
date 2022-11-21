package week6.dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 계단 오르기 / 실버3
public class ClimbingStairs_2579 {
    int[] stairs = new int[310];//계단별 점수
    int[][] point = new int[310][3];//point[i][j]: j개의 계단을 연속으로 밟아 i번째 계단에 왔을 때의 최대 점수
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st.nextToken());
        }

        point[1][1] = stairs[1];//초기화
        point[1][2] = 0;
        point[2][1] = stairs[2];
        point[2][2] = stairs[1] + stairs[2];

        for(int i = 3; i <= n; i++){
            point[i][1] = Integer.max(point[i-2][1], point[i-2][2]) + stairs[i];//2칸 건너 왔을 때, 출발한 위치가 1개 연속일 때랑 2개 연속일 때 최대에 현재 계단 점수 더하기
            point[i][2] = point[i-1][1] + stairs[i];//1칸 건너왔을 때
        }

        System.out.println(Integer.max(point[n][1], point[n][2]));
    }

    public static void main(String[] args) throws Exception{
        new ClimbingStairs_2579().solution();
    }
}
