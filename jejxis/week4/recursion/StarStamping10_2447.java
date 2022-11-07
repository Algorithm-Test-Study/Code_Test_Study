package week4.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 별 찍기 - 10 / 골드5 _완
public class StarStamping10_2447 {
    static char[][] board;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();//System.out.print() 쓰면 시간 초과 발생

        int n = Integer.parseInt(st.nextToken());
        board = new char[n][n];
        for(int i = 0; i < n; i++){//다 빈칸으로 초기화
            for(int j = 0; j < n; j++){
                board[i][j] = ' ';
            }
        }

        func(n, 0, 0);

        for(int i = 0; i < n; i++){//스트링버퍼를 먼저 만들어서
            for(int j = 0; j < n; j++){
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);//출력
    }

    //1 2 3
    //4   6
    //7 8 9...가운데 5는 빼고 재귀 진행
    public void func(int n, int x, int y){//n: 보드에서 봐야할 칸의 크기, x: 원래 보드에서의 행, y: 원래 보드에서의 열
        if(n == 1) {
            board[x][y] = '*';
            return;
        }
        int part = n/3;//9등분

        func(part, x, y);
        func(part, x+part, y);
        func(part, x+2*part, y);

        func(part, x, y+part);
        func(part, x+2*part, y+part);

        func(part, x, y+2*part);
        func(part, x+part, y+2*part);
        func(part, x+2*part, y+2*part);
    }

    public static void main(String[] args) throws Exception{
        new StarStamping10_2447().solution();
    }
}
