package week4.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 종이의 개수 / 실버2 _완
public class NumberOfSheetOfPaper_1780 {
    static int zero = 0;
    static int one = 0;
    static int mone = 0;
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

        System.out.println(mone);//답 출력
        System.out.println(zero);
        System.out.println(one);
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
        if(flag == true){//그대로 사용할 수 있다면 맨 처음 숫자에 따라서 개수 증가
            if(num == -1) mone++;
            else if(num == 0) zero++;
            else if(num == 1) one++;

            return;//재귀 종료
        }

        //그대로 사용할 수 없다면 9등분
        //1 2 3
        //4 5 6
        //7 8 9
        int part = n/3;//1/3씩 종이를 자르므로.
        func(part, x, y);//1번째 종이
        func(part, x + part, y);//2번째 종이
        func(part, x + 2*part, y);//3

        func(part, x, y+part);//4
        func(part, x+part, y+part);//5
        func(part, x+2*part, y+part);//6

        func(part, x, y+2*part);//7
        func(part, x+part, y+2*part);//8
        func(part, x+2*part, y+2*part);//9
    }

    public static void main(String[] args) throws Exception{
        new NumberOfSheetOfPaper_1780().solution();
    }
}
