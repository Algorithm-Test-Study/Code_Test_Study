package week5.sorting2;

import java.util.Scanner;

// [BOJ] 역원소 정렬 / 실버4 _완
public class SortingReverseElement_5648 {
    long[] numbers;
    public void solution() throws Exception{
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        StringBuilder r;
        long num;

        int n = sc.nextInt();
        numbers = new long[n];

        for(int i = 0; i < n; i++){
            num = sc.nextLong();//long 입력 받기
            r = new StringBuilder();//스트링 빌더 생성
            r.append(num);//입력받은 숫자 넣고
            r.reverse();//뒤집기
            numbers[i] = Long.parseLong(r.toString());//다시 long 으로 변환
        }

        mergeSort(0, n-1);
        for(int k = 0; k < n; k++){
            sb.append(numbers[k]);
            sb.append('\n');
        }
        System.out.println(sb);
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
        long[] leftArray = new long[leftSize+1];
        long[] rightArray = new long[rightSize+1];

        for(int i = 0; i < leftSize; i++){
            leftArray[i] = numbers[left+i];
        }

        for(int j = 0; j < rightSize; j++){
            rightArray[j] = numbers[middle+j+1];
        }


        leftArray[leftSize] = Long.MAX_VALUE;
        rightArray[rightSize] = Long.MAX_VALUE;


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
        new SortingReverseElement_5648().solution();
    }
}
