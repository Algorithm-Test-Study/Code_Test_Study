package week6.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 주식 / 실버2
public class Stock_11501 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n;
        int max;
        long stock;
        for(int i = 0; i < t; i++){//테스트케이스 별로
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){//주가 입력 받기
                arr[j] = Integer.parseInt(st.nextToken());
            }
            max = arr[n-1];//마지막날부터 시작!
            stock = 0;//이익
            for(int k = n-2; k >= 0; k--){
                if(max == arr[k]) continue;//최댓값과 현재 값이 같으면 넘어가기
                else if(max < arr[k]){//현재 값이 더 크면
                    max = arr[k];//최댓값 바꾸기
                }
                else{//현재값이 더 작으면
                    stock += max - arr[k];//최댓값과의 차를 구해 이익 값에 더하기
                }
            }
            System.out.println(stock);
        }
    }

    public static void main(String[] args) throws Exception{
        new Stock_11501().solution();
    }
}
