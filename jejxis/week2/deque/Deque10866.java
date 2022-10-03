package week2.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[BOJ] 덱 / 실버4
public class Deque10866 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] deque = new int[20000];
        int head = 10000;
        int tail = 10000;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                deque[--head] = x;
            }
            else if(cmd.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                deque[tail++] = x;
            }
            else if(cmd.equals("pop_front")){
                if(head == tail){
                    System.out.println(-1);
                }
                else{
                    System.out.println(deque[head++]);
                }
            }
            else if(cmd.equals("pop_back")){
                if(head == tail){
                    System.out.println(-1);
                }
                else{
                    System.out.println(deque[--tail]);
                }
            }
            else if (cmd.equals("size")) {
                System.out.println(tail - head);
            }
            else if (cmd.equals("empty")){
                if(head == tail){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if(cmd.equals("back")){
                if(head == tail){
                    System.out.println(-1);
                }
                else{
                    System.out.println(deque[tail-1]);
                }
            }
            else if(cmd.equals("front")){
                if(head == tail){
                    System.out.println(-1);
                }
                else{
                    System.out.println(deque[head]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new Deque10866().solution();
    }
}
