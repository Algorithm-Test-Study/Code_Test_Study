package week4.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 로또 / 실버2 _완
public class Lotto_6603 {
    static int[] arr = new int[12];
    static boolean[] isused = new boolean[12];
    static int k;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num;

        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            for(int i = 0; i < k; i++){
                num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                isused[i] = false;//초기화
            }
            func(0, 0);
            System.out.println();
        }
    }

    public void func(int count, int index){//count: 현재 방문한 칸 수, index: 탐색 시작할 인덱스 번호
        if(count == 6) {
            for(int i = 0; i < arr.length; i++){//숫자들 순회
                if(isused[i]) System.out.print(arr[i]+" ");//방문했으면 출력
            }
            System.out.println();
            return;
        }
        for(int i = index; i < k; i++){
            if(isused[i]) continue;
            isused[i] = true;
            func(count+1, i);
            isused[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        new Lotto_6603().solution();
    }
}
