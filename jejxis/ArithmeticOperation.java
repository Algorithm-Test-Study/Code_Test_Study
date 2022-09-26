package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ArithmeticOperation {//10869

    private int a;
    private int b;
    private int add;
    private int sub;
    private int mul;
    private int div;
    private int mod;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        add = a+b;
        sub = a-b;
        mul = a*b;
        div = a/b;
        mod = a%b;

        bw.write(String.valueOf(add));
        bw.newLine();

        bw.write(String.valueOf(sub));
        bw.newLine();

        bw.write(String.valueOf(mul));
        bw.newLine();

        bw.write(String.valueOf(div));
        bw.newLine();

        bw.write(String.valueOf(mod));
        bw.newLine();

        bw.flush();
    }

    public static void main(String[] args) throws Exception{
        new ArithmeticOperation().solution();
    }
}
