package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class KeyLogger {
    int times;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        times = Integer.parseInt(st.nextToken());
        for(int j = 0; j < times; j++){
            st = new StringTokenizer(br.readLine());
            char[] characterArray = st.nextToken().toCharArray();

            LinkedList<Character> sentence = new LinkedList<>();
            ListIterator<Character> cursor = sentence.listIterator();

            for(Character cmd: characterArray){

                if(cmd == '<'){
                    if(cursor.hasPrevious()) cursor.previous();
                }
                else if(cmd == '>'){
                    if(cursor.hasNext()) cursor.next();
                }
                else if(cmd == '-'){
                    if(cursor.hasPrevious()){
                        cursor.previous();
                        cursor.remove();
                    }
                }
                else{
                    cursor.add(cmd);
                }
            }
            for(char m : sentence){
                bw.write(m);
            }
            bw.newLine();
            bw.flush();
        }

    }

    public static void main(String[] args) throws Exception{
        new KeyLogger().solution();
    }
}
