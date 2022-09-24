package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LeapYear {//2753

    private int year;
    private String result;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        year = Integer.parseInt(st.nextToken());

        if(year % 4 == 0 && year % 100 != 0) result = "1";
        else if (year % 400 == 0) result = "1";
        else result = "0";

        bw.write(result);
        bw.flush();
    }

    public static void main(String[] args) throws Exception{
        new LeapYear().solution();
    }
}
