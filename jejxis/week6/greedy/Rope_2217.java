package week6.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// [BOJ] 로프 / 실버4
public class Rope_2217 {
    ArrayList<Integer> arr = new ArrayList<>();
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);//로프 정렬..가장 튼튼한 로프가 맨 뒤에 온다.

        int num = 1;//사용한 로프 수
        int rope = arr.get(n-1);//가장 약한 로프가 들수 있는 중량
        int w = rope * num;//들어올릴 수 있는 최대 중량
        int temp;
        for(int i = n-2; i >= 0; i--){
            num++;
            rope = arr.get(i);
            temp = rope * num;//현재까지의 로프들로 들어올릴 수 있는 중량
            if(temp > w)//비교해서 더 크면
                w = temp;//최대 중량 바꾸기
        }

        System.out.println(w);
    }

    public static void main(String[] args) throws Exception{
        new Rope_2217().solution();
    }
}
