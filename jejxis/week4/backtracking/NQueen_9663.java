package week4.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] N-Queen / 골드4 _완
public class NQueen_9663 {
    static boolean[] isused1 = new boolean[40];
    static boolean[] isused2 = new boolean[40];
    static boolean[] isused3 = new boolean[40];
    static int count = 0;
    static int n;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        func(0);

        System.out.println(count);
    }

    public void func(int current){
        if(current == n){
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(isused1[i] || isused2[i+current] || isused3[current-i+n-1])
                continue;
            isused1[i] = true;
            isused2[i+current] = true;
            isused3[current-i+n-1] = true;

            func(current+1);

            isused1[i] = false;
            isused2[i+current] = false;
            isused3[current-i+n-1] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        new NQueen_9663().solution();
    }
}
