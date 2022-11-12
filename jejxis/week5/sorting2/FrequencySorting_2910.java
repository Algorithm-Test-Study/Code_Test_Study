package week5.sorting2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// [BOJ] 빈도 정렬 / 실버3
public class FrequencySorting_2910 {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> arr;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new LinkedHashMap<Integer, Integer>(n);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());//입력받은 숫자가
            if(map.containsKey(num)) map.replace(num, map.get(num)+1);//키에 존재하면 value 값을  1 증가시켜 대체한다
            else map.put(num, 1);//없으면 value를 1로 설정하여 해시맵에 넣는다
        }
        arr = new ArrayList<Integer>(map.keySet());

        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(map.get(o2), map.get(o1));//o1과 o2 위치를 바꾸면 오름차순이 된다고 한다.
            }
        });

        Iterator<Integer> it = arr.iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            for(int i=0; i < map.get(element); i++){
                System.out.print(element+" ");
            }

        }

    }

    public static void main(String[] args) throws Exception{
        new FrequencySorting_2910().solution();
    }
}
