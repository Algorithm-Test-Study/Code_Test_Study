package week4.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 계란으로 계란치기 / 실버1 _완
public class HittingEggWithEgg_16987 {
    static int n;
    static int[] duration;
    static int[] weight;
    static int max = Integer.MIN_VALUE;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        duration = new int[n];
        weight = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            duration[i] = Integer.parseInt(st.nextToken());//내구도 저장
            weight[i] = Integer.parseInt(st.nextToken());//무게 저장
        }

        func(0,0);//0번 계란 들기, 처음에 깨져 있는 계란은 0개

        System.out.println(max);
    }

    public void func(int index, int count){//index: 들고 있는 계란 번호, count: 깨진 계란 수
        if(index == n){//마지막 계란까지 다 들어본 경우
            max = Math.max(max, count);
            return;
        }

        if(duration[index] <= 0 || count == n-1){//현재 계란이 깨진 상태거나 모든 계란이 다 깨진 상태
            func(index+1, count);//다음 계란을 든다
            return;
        }

        //다른 계란들과 모두 부딪쳐본다
        int ncount = count;//깨진 개수 저장
        for(int i = 0; i < n; i++){
            if(i == index) continue;//손에 든 계란이거나
            if(duration[i] <= 0) continue;//이미 깨진 계란은 통과

            hitEgg(index, i);

            if(duration[index] <= 0){//손에 든 계란이 깨짐
                count++;
            }

            if(duration[i] <= 0){//타깃 계란이 깨짐
                count++;
            }

            func(index+1, count);//다음 계란 들어보기
            recoveryEgg(index, i);//다음 반복을 위해 원상복구
            count = ncount;//깨진 개수 복구
        }
    }

    public void hitEgg(int inHand, int target){//계란 부딪치기
        duration[target] -= weight[inHand];
        duration[inHand] -= weight[target];
    }

    public void recoveryEgg(int inHand, int target){//원상복구
        duration[target] += weight[inHand];
        duration[inHand] += weight[target];
    }

    public static void main(String[] args) throws Exception{
        new HittingEggWithEgg_16987().solution();
    }
}
