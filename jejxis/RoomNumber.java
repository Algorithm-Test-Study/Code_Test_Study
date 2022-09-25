package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoomNumber {

    public void solution() throws Exception{
        int num;
        int[] count = {0,0,0,0,0,0,0,0,0};
        int max = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        while(num > 0){
            if(num % 10 == 6 || num % 10 == 9){
                count[6]++;
            }else{
                count[num%10]++;
            }
            num /= 10;
        }
        count[6] = count[6] / 2 + count[6] % 2;

        for(int i = 0; i < 9; i++){
            if(max < count[i]) max = count[i];
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        new RoomNumber().solution();
    }
}
