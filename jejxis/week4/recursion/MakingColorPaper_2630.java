package week4.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 색종이 만들기 / 실버2 _완
public class MakingColorPaper_2630 {
    static int zero = 0;//white
    static int one = 0;//blue
    static int[][] paper;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        paper = new int[n][n];
        int num;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                num = Integer.parseInt(st.nextToken());
                paper[i][j] = num;//종이에 숫자 저장
            }
        }

        func(n, 0, 0);//재귀 시작

        System.out.println(zero);//white
        System.out.println(one);//blue
    }

    public void func(int n, int x, int y){//n: 종이 크기, x: 원래 종이에서의 현재 열,y: 원래 종이에서의 현재 행
        int num = paper[x][y];//시작위치 숫자 저장
        boolean flag = true;//종이를 그대로 사용할 것인가?
        if(n == 0) return;//크기가 1일 때도 -1,0,1 인지 숫자는 알아야 한다.
        for(int i = x; i < x+n; i++){
            for(int j = y; j < y+n; j++){
                if(num != paper[i][j]) {//비교해서 다르면
                    flag = false;//사용 못함
                    break;
                }
            }
        }
        if(flag){//그대로 사용할 수 있다면 맨 처음 숫자에 따라서 개수 증가
            if(num == 0) zero++;
            else if(num == 1) one++;

            return;//재귀 종료
        }

        //그대로 사용할 수 없다면 4등분
        //1 2
        //3 4
        int part = n/2;//1/2씩 종이를 자르므로.
        func(part, x, y);//1번째 종이
        func(part, x + part, y);//2번째 종이

        func(part, x, y+part);//3
        func(part, x+part, y+part);//4
    }

    public static void main(String[] args) throws Exception{
        new MakingColorPaper_2630().solution();
    }
}
