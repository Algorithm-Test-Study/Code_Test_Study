package week6.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// [BOJ] 회의실 배정 / 실버1
public class MeetingRoomAssignment_1931 {
    ArrayList<Pair> arr = new ArrayList<>();
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x, y;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr.add(new Pair(x, y));
        }

        Collections.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.finish < o2.finish)//끝나는 시간으로 먼저 확인
                    return -1;
                else if(o1.finish > o2.finish)
                    return 1;
                else if(o1.finish == o2.finish){//끝나는 시간이 같을 때
                    if(o1.start < o2.start)//시작 시간 비교
                        return -1;
                    else if(o1.start == o2.start)
                        return 0;
                    else return 1;
                }
                return 0;
            }
        });
        int count = 1;
        Pair now = arr.get(0);//첫번째를 꺼내서
        for(int i = 1; i < arr.size(); i++){
            Pair next = arr.get(i);
            if(now.finish <= next.start){//현재 회의의 끝나는 시간과 다음 회의의 시작시간 비교
                now = next;//끝나는 시간이 더 빠르면 now에 next 저장하고
                count++;//개수 증가
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws Exception{
        new MeetingRoomAssignment_1931().solution();
    }

    class Pair{
        int start;//시작시간
        int finish;//끝나는 시간
        Pair(int start, int finish){
            this.start = start;
            this.finish = finish;
        }
    }
}
