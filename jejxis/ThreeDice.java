package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ThreeDice {
    private int min;
    private int max;
    private int mid;
    private int temp;
    private String result;
    public void solution() throws Exception{//2480
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        min = Integer.parseInt(st.nextToken());
        mid = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        if(min > mid){
            temp = min;
            min = mid;
            mid = temp;
        }

        if(min > max){
            temp = min;
            min = max;
            max = temp;
        }

        if(mid > max){
            temp = mid;
            mid = max;
            max = temp;
        }

        if(min == mid && mid == max) result = 10000 + mid * 1000 + "";
        else if(min == mid || mid == max) result = 1000 + mid * 100 + "";
        else result = max * 100 + "";

        bw.write(result);
        bw.flush();
    }


    public static void main(String[] args) throws Exception{
        new ThreeDice().solution();
    }
}
