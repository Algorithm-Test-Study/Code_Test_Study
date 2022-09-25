package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfNumbers {


    public void solution() throws Exception{
        int[] arr = {0,0,0};
        int[] count = {0,0,0,0,0,0,0,0,0,0};
        int mul;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mul = arr[0] * arr[1] * arr[2];

        while(mul > 0){
            count[mul % 10]++;
            mul /= 10;
        }

        for(int j = 0; j < 10; j++){
            System.out.println(count[j]);
        }
    }

    public static void main(String[] args) throws Exception{
        new NumberOfNumbers().solution();
    }
}
