package week5.sorting1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 나이순 정렬 / 실버5
public class SortingInOrderByAge_10814 {
    int[] numbers;
    String[] names;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num;
        String name;

        int n = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        names = new String[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            numbers[i] = num;
            names[i] = name;
        }

        mergeSort(0, n-1);
        for(int j = 0; j < n; j++){
            sb.append(numbers[j]);//StringBuilder로 시간초과 방지
            sb.append(' ');
            sb.append(names[j]);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private void mergeSort(int left, int right) {
        int middle = 0;
        if (left < right) {
            middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;
        int[] leftArray = new int[leftSize+1];
        String[] leftNameArray = new String[leftSize+1];
        int[] rightArray = new int[rightSize+1];
        String[] rightNameArray = new String[rightSize+1];

        for(int i = 0; i < leftSize; i++){
            leftArray[i] = numbers[left+i];
            leftNameArray[i] = names[left+i];
        }

        for(int j = 0; j < rightSize; j++){
            rightArray[j] = numbers[middle+j+1];
            rightNameArray[j] = names[middle+j+1];
        }


        leftArray[leftSize] = Integer.MAX_VALUE;
        rightArray[rightSize] = Integer.MAX_VALUE;


        int i = 0;
        int j = 0;

        while(i < leftSize || j < rightSize) {
            if(leftArray[i] <= rightArray[j]){//stable한 정렬을 위해 <에서 <=으로 수정
                numbers[left+i+j] = leftArray[i];
                names[left+i+j] = leftNameArray[i];
                i++;
            }
            else{
                numbers[left+i+j] = rightArray[j];
                names[left+i+j] = rightNameArray[j];
                j++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new SortingInOrderByAge_10814().solution();
    }
}
