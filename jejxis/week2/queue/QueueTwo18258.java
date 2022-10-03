package week2.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[BOJ] 큐2 / 실버4
public class QueueTwo18258 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] queue = new int[2000000];
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
                    bw.write(String.valueOf(-1));
                    bw.newLine();
                }
                else{
                    bw.write(String.valueOf(queue[head++]));
                    bw.newLine();
                }
            }
            else if (cmd.equals("size")) {
                bw.write(String.valueOf(tail - head));
                bw.newLine();
            }
            else if (cmd.equals("empty")){
                if(head == tail){
                    bw.write(String.valueOf(1));
                    bw.newLine();
                }
                else{
                    bw.write(String.valueOf(0));
                    bw.newLine();
                }
            }
            else if(cmd.equals("back")){
                if(head == tail){
                    bw.write(String.valueOf(-1));
                    bw.newLine();
                }
                else{
                    bw.write(String.valueOf(queue[tail-1]));
                    bw.newLine();
                }
            }
            else if(cmd.equals("front")){
                if(head == tail){
                    bw.write(String.valueOf(-1));
                    bw.newLine();
                }
                else{
                    bw.write(String.valueOf(queue[head]));
                    bw.newLine();
                }
            }
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception{
        new QueueTwo18258().solution();
    }
}
