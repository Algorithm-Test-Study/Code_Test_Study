package week2.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//[BOJ] 스택 / 실버4
public class Stack {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] stack = new int[10000];
        int pos = 0;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack[pos++] = x;
            }
            else if(cmd.equals("pop")){
                if(pos == 0){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack[--pos]);
                }
            }
            else if (cmd.equals("size")) {
                System.out.println(pos);
            }
            else if (cmd.equals("empty")){
                if(pos == 0){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if(cmd.equals("top")){
                if(pos == 0){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack[pos-1]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new Stack().solution();
    }
}
