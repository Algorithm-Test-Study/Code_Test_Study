package week5.sorting2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// [BOJ] 접미사 배열 / 실버4
public class SuffixSorting_11656 {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = st.nextToken();//문자열 저장
        String[] arr = new String[s.length()];//접미사 저장할 배열

        for(int i = 0; i < s.length(); i++){
            arr[i] = s.substring(i);//접미사 저장
        }
        Arrays.sort(arr);//알파벳 순으로 정렬

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }
    public static void main(String[] args) throws Exception{
        new SuffixSorting_11656().solution();
    }
}


