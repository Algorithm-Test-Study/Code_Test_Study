package week4.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// [BOJ] 치킨 배달 / 골드5 _완
public class ChickenDelivery_15686 {
    static int n, m;
    static int[][] map;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static int ans;
    static boolean[] open;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        person = new ArrayList<>();
        chicken = new ArrayList<>();

        //집과 치킨집에 해당하는 좌표를 ArrayList에 저장
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){//가정집 저장
                    person.add(new Point(i,j));
                }else if(map[i][j] == 2){//치킨집 저장
                    chicken.add(new Point(i, j));
                }
            }
        }

        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        dfs(0,0);
        System.out.println(ans);
    }

    public void dfs(int start, int count){
        if(count == m){
            int res = 0;

            for(int i = 0; i < person.size(); i++){
                int temp = Integer.MAX_VALUE;

                //가정집과 오픈한 치킨집의 모든 거리 비교.. 최소거리 구하기
                for(int j = 0; j < chicken.size(); j++){
                    if(open[j]){
                        int distance = Math.abs(person.get(i).x - chicken.get(j).x)
                                +Math.abs(person.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp,distance);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans, res);
            return;
        }
        for(int i = start; i < chicken.size(); i++){//백트래킹
            open[i] = true;
            dfs(i+1, count+1);
            open[i] = false;
        }

    }

    public static void main(String[] args) throws Exception{
        new ChickenDelivery_15686().solution();
    }
}
class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
