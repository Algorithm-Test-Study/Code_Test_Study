package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class APlusB {//1000
    private int a;
    private int b;
    private int sum;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        sum = a+b;

        bw.write(String.valueOf(sum));

        bw.flush();
    }

    public static void main(String[] args) throws Exception{
        new APlusB().solution();
    }
}
