package week5.sorting1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 수 정렬하기 2 / 실버5
public class SortingNumber2_2751 {
    int[] numbers;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int num;

        int n = Integer.parseInt(st.nextToken());
        numbers = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
        }

        mergeSort(0, n-1);
        for(int j = 0; j < n; j++){
            sb.append(numbers[j]);//StringBuilder로 시간초과 방지
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
        int[] rightArray = new int[rightSize+1];

        for(int i = 0; i < leftSize; i++){
            leftArray[i] = numbers[left+i];
        }

        for(int j = 0; j < rightSize; j++){
            rightArray[j] = numbers[middle+j+1];
        }


        leftArray[leftSize] = Integer.MAX_VALUE;
        rightArray[rightSize] = Integer.MAX_VALUE;


        int i = 0;
        int j = 0;

        while(i < leftSize || j < rightSize) {
            if(leftArray[i] < rightArray[j]){
                numbers[left+i+j] = leftArray[i];
                i++;
            }
            else{
                numbers[left+i+j] = rightArray[j];
                j++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new SortingNumber2_2751().solution();
    }
}
