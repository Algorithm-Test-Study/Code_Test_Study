package week2.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//[BOJ] 제로 / 실버4
public class Zero {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] num = new int[100000];
        int pos = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(x == 0){
                pos--;
            }else{
                num[pos++] = x;
            }
        }

        for(int j = 0; j < pos; j++){
            sum += num[j];
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Zero().solution();
    }
}
