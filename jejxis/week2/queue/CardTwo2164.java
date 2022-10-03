package week2.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[BOJ] 카드2 / 실버4
public class CardTwo2164 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cards = new int[1000000];
        int head = 0;
        int x;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            cards[i] = i+1;
        }
        int tail = n;

        while(true){
            if((tail - head) == 1) break;
            head++;
            if((tail - head) == 1) break;
            x = cards[head++];
            cards[tail++] = x;
        }

        System.out.println(cards[head]);
    }

    public static void main(String[] args) throws Exception{
        new CardTwo2164().solution();
    }
}
