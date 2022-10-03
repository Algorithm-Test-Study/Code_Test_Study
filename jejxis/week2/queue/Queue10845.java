package week2.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//[BOJ] 큐 / 실버4
public class Queue10845 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] queue = new int[10000];
        int head = 0;
        int tail = 0;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                queue[tail++] = x;
            }
            else if(cmd.equals("pop")){
                if(head == tail){
                    System.out.println(-1);
                }
                else{
                    System.out.println(queue[head++]);
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
                    System.out.println(queue[tail-1]);
                }
            }
            else if(cmd.equals("front")){
                if(head == tail){
                    System.out.println(-1);
                }
                else{
                    System.out.println(queue[head]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new Queue10845().solution();
    }
}
