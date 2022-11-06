package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// [BOJ] Z / 실버1 _완
public class Z_1074 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(z(n,r,c));
    }

    public int z(int n, int r, int c){
        if(n == 0)  return 0;
        int half = (int) Math.pow(2, n-1);
        if(r < half && c < half)//1번 사각형
            return z(n-1, r, c);
        if(r < half && c >= half)//2번 사각형
            return half*half + z(n-1, r, c-half);
        if(r >= half && c < half)//3번 사각형
            return 2*half*half + z(n-1, r-half, c);
        return 3*half*half + z(n-1, r-half, c-half);
    }

    public static void main(String[] args) throws Exception{
        new Z_1074().solution();
    }
}
