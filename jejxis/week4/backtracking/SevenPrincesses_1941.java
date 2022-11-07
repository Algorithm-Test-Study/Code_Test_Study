package week4.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// [BOJ] 소문난 칠공주 / 골드3 _완
public class SevenPrincesses_1941 {
    static char[][] chair = new char[5][5];//자리배치 저장

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] comx = new int[25];
    static int[] comy = new int[25];

    static int answer = 0;//경우의 수
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++){
            chair[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < 25; i++){//미리 좌표 구하기
            comx[i] = i%5;
            comy[i] = i/5;
        }

        func(new int[7], 0, 0, 7);
        System.out.println(answer);
    }

    public void func(int[] combination, int index, int count, int left){
        if(left == 0){
            bfs(combination);
            return;
        }

        if(count == 25) return;

        combination[index] = count;
        func(combination, index+1, count+1, left-1);
        func(combination, index, count+1, left);
    }

    public void bfs(int[] com){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[7];

        q.add(com[0]);
        int count = 1, countS = 0;

        while (!q.isEmpty()){
            int cur = q.poll();
            if(chair[comy[cur]][comx[cur]] == 'S') countS++;

            for(int i = 0; i < 4; i++){
                for(int a = 1; a <7; a++){
                    if(!visited[a] && comx[cur]+dx[i] == comx[com[a]] && comy[cur]+dy[i] == comy[com[a]]){
                        visited[a] = true;
                        q.add(com[a]);
                        count++;
                    }
                }
            }
        }
        if(count == 7){
            if(countS >= 4){
                answer++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new SevenPrincesses_1941().solution();
    }
}
