package week6.dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] LCS / 골드5
public class LCS_9251 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] s1 = st.nextToken().toCharArray();
        st = new StringTokenizer(br.readLine());
        char[] s2 = st.nextToken().toCharArray();

        int[][] dp = new int[s1.length+1][s2.length+1];

        for(int i = 0; i <= s1.length; i++){//0번 열 0으로 채우기
            dp[i][0] = 0;
        }
        for(int j = 0; j <= s2.length; j++){//0번 행 0으로 채우기
            dp[0][j] = 0;
        }
        for(int i = 1; i <= s1.length; i++){//s1과
            for(int j = 1; j <= s2.length; j++){//s2의 문자 하나하나 비교하면서
                if(s1[i-1] == s2[j-1])//같은 문자면
                    dp[i][j] = dp[i-1][j-1] + 1;//s1과 s2의 이전문자끼리 비교하여 얻은 값에 1 더하여 저장
                else{//다른 문자면 s1의 이전문자와 s2의 현재문자, s1의 현재문자와 s2의 이전문자끼리 비교하여
                    dp[i][j] = Integer.max(dp[i-1][j], dp[i][j-1]);//더 큰 값을 저장
                }
            }
        }

        System.out.println(dp[s1.length][s2.length]);
    }

    public static void main(String[] args) throws Exception{
        new LCS_9251().solution();
    }
}
