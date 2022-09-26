package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JosephusProblem {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int index = k-1;

        LinkedList<Integer> circle = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            circle.add(i);
        }
        while(circle.size()>0){
            index %= circle.size();
            result.add(circle.get(index));
            circle.remove(index);
            index--;
            index += k;
        }
        bw.write("<");
        for(int j = 0; j < result.size(); j++){
            bw.write(String.valueOf(result.get(j)));
            if(j!=result.size()-1) bw.write(", ");
        }
        bw.write(">");
        bw.flush();
    }

    public static void main(String[] args) throws Exception{
        new JosephusProblem().solution();
    }
}
