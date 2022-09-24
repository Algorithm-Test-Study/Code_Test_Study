package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class YutNori {//2490

    private int[][] nums = new int[3][4];
    private int sum = 0;
    private String result;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
            nums[i][3] = Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < 3; j++){
            sum = 0;
            sum += nums[j][0];
            sum += nums[j][1];
            sum += nums[j][2];
            sum += nums[j][3];

            switch (sum){
                case 0:
                    result = "D";
                    break;
                case 1:
                    result = "C";
                    break;
                case 2:
                    result = "B";
                    break;
                case 3:
                    result = "A";
                    break;
                case 4:
                    result = "E";
                    break;
            }
            bw.write(result);
            bw.newLine();

            bw.flush();
        }

    }

    public static void main(String[] args) throws Exception{
        new YutNori().solution();
    }
}
