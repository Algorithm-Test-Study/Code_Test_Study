package week1;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class HelloWorld {//2557

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("Hello World!");

        bw.flush();
    }
}
