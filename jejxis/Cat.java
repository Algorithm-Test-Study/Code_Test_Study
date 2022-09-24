package week1;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Cat {//10171
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("\\    /\\");
        bw.newLine();
        bw.write(" )  ( ')");
        bw.newLine();
        bw.write("(  /  )");
        bw.newLine();
        bw.write(" \\(__)|");
        bw.newLine();

        bw.flush();
    }
}
