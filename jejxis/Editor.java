package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Editor {
    LinkedList<Character> sentence = new LinkedList<Character>();

    int times;
    String cmd;
    String param;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        char[] characterArray = st.nextToken().toCharArray();
        for(char c : characterArray){
            sentence.add(c);
        }

        st = new StringTokenizer(br.readLine());
        times = Integer.parseInt(st.nextToken());

        ListIterator<Character> cursor = sentence.listIterator();
        while(cursor.hasNext()){
            cursor.next();
        }
        for(int i = 0; i < times; i++){
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            if(cmd.charAt(0) == 'P'){
                param = st.nextToken();
                cursor.add(param.charAt(0));
            }
            else if(cmd.charAt(0) == 'L'){
                if(cursor.hasPrevious()) cursor.previous();
            }
            else if(cmd.charAt(0) == 'D'){
                if(cursor.hasNext()) cursor.next();
            }
            else if(cmd.charAt(0) == 'B'){
                if(cursor.hasPrevious()){
                    cursor.previous();
                    cursor.remove();
                }
            }
        }
        for(char m : sentence){
            bw.write(m);
        }
        bw.flush();
    }

    public static void main(String[] args) throws Exception{
        new Editor().solution();
    }
}
