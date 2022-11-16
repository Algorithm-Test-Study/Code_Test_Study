package week6.dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 1로 만들기 / 실버3
public class MakingItOne_1463 {
    int[] d = new int[1000001];
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int divide3;//3으로 나눴을 때 횟수
        int divide2;//2로 나눴을 때 횟수
        int minus1;//1을 뺐을 때 횟수

        d[1] = 0;//1 그자체로 1
        d[2] = 1;//2를 2로 나누면 1
        d[3] = 1;//3을 3으로 나누면 1

        for(int i = 4; i <= n; i++){
            divide3 = Integer.MAX_VALUE;//min 함수 이용하기 위해 초기화
            divide2 = Integer.MAX_VALUE;
            minus1 = Integer.MAX_VALUE;//사실상 필요없음

            if(i % 3 == 0) divide3 = d[i/3] + 1;//3으로 나눠지면 3으로 나눈 인덱스의 값에 1 더한 값 저장
            if(i % 2 == 0) divide2 = d[i/2] + 1;//2로 나눠지면 2로 나눈 인덱스의 값에 1 더한 값 저장
            minus1 = d[i-1] + 1;//1뺀 인엑스의 값에 1 더한 값 저장

            int first = Integer.min(divide2, divide3);//최솟값 구하기
            int last = Integer.min(first, minus1);

            d[i] = last;//최솟값 저장
        }

        System.out.println(d[n]);
    }

    public static void main(String[] args) throws Exception{
        new MakingItOne_1463().solution();
    }
}
