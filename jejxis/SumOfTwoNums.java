package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfTwoNums {
    int n;
    int[] an = new int[100000];
    int[] check = new int[2000000];
    int count = 0;
    int sum;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            an[i] = Integer.parseInt(st.nextToken());
            check[an[i]]++;
        }

        st = new StringTokenizer(br.readLine());
        sum = Integer.parseInt(st.nextToken());
        for(int j = 0; j < n; j++){
            if(sum - an[j] > 0 && check[sum-an[j]] != 0){
                count++;
            }
        }

        System.out.println(count/2);
    }

    public static void main(String[] args) throws Exception{
        new SumOfTwoNums().solution();
    }
}
