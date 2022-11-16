package week6.dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 연속합 / 실버2
//10 -1 100 -100000 1 1 1 1 1... > 이전까지의 합과 현재 수의 합이 0보다 크면 된다
public class ContinuousSum_1912 {
    int[] num = new int[100010];//숫자배열
    int[] sum = new int[100010];//숫자 합
    boolean[] end = new boolean[100010];//연속해서 더하는 마지막 숫자인지 여부
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        sum[1] = num[1];//초기화
        int max = sum[1];
        if(sum[1] <= 0) end[1] = true;//0 이하면 끝
        else end[1] = false;

        for(int i = 2; i <= n; i++){
            if(end[i-1]) {//이전 수가 끝이었던 경우
                if(num[i] > 0){//현재 숫자가 양수면
                    sum[i] = num[i];//합 초기화
                    end[i] = false;//끝이 아니다
                }
                else{//0 이하
                    sum[i] = num[i];//합 초기화
                    end[i] = true;//끝
                }
            }
            else{//이전 수가 끝이 아니었을 때
                if(sum[i-1] + num[i] <= 0){//이전수까지의 합과 현재 수의 합이 0 이하
                    end[i] = true;//끝이다
                    sum[i] = num[i];//합 초기화
                }
                else{//이전수까지의 합과 현재수의 합이 양수
                    sum[i] = sum[i-1]+num[i];//합 구하기
                    end[i] = false;//끝이 아니다
                }
            }
            max = Integer.max(max, sum[i]);//더 큰 값 저장
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        new ContinuousSum_1912().solution();
    }
}
