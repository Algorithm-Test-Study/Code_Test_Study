package week2.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Tower2493 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] stack = new int[500000];
        int[] result = new int[500000];
        result[0] = -1;
        int top = 0;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            stack[top++] = Integer.parseInt(st.nextToken());
        }

        for(int j = top -1; j >= 1; j--){//시간초과
            result[j] = -1;
            for(int k = j-1; k >= 0; k--){
                if(stack[j] <= stack[k]){
                    result[j] = k;
                    break;
                }
            }
        }

        for(int l = 0; l < top; l++){
            System.out.print((result[l]+1)+" ");
        }
    }

    public static void main(String[] args) throws Exception{
        new Tower2493().solution();
    }
}
