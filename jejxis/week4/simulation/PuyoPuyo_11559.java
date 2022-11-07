package week4.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// [BOJ] Puyo Puyo / 골드4 _완
public class PuyoPuyo_11559 {

    static char[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static ArrayList<Node> list;
    static int n = 12, m = 6;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[n][m];
        for(int i = 0; i < n; i++){
            board[i] = br.readLine().toCharArray();
        }

        int count = 0;
        //4개 이상 뭉쳐있는 노드 확인...
        while(true){
            boolean isFinished = true;
            visited = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] != '.'){
                        list = new ArrayList<>();
                        bfs(board[i][j], i, j);

                        if(list.size() >= 4){
                            isFinished = false;//연쇄 발생. 더 탐색해야함
                            for(int k = 0; k < list.size();k++){
                                board[list.get(k).x][list.get(k).y] = '.';//뿌요 없애기
                            }
                        }
                    }
                }
            }
            if(isFinished) break;
            fallPuyo();//뿌요 떨어뜨리기
            count++;
        }
        System.out.println(count);
    }

    public static void bfs(char c, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list.add(new Node(x, y));
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == false && board[nx][ny] == c) {
                    visited[nx][ny] = true;
                    list.add(new Node(nx, ny));
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public void fallPuyo() {
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j > 0; j--) {
                if (board[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[k][i] != '.') {
                            board[j][i] = board[k][i];
                            board[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new PuyoPuyo_11559().solution();
    }
}
class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
