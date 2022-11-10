package week5.sorting2;

import week5.sorting1.SortingNumber_2750;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 시리얼 번호 / 실버3
public class SerialNumber_1431 {
    String[] numbers;
    String endSerial = "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^";//맨 뒤에 올 수 밖에 없는 문자열
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String num;

        int n = Integer.parseInt(st.nextToken());
        numbers = new String[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            num = st.nextToken();
            numbers[i] = num;
        }

        mergeSort(0, n-1);
        for(int j = 0; j < n; j++){
            sb.append(numbers[j]);
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
        String[] leftArray = new String[leftSize+1];
        String[] rightArray = new String[rightSize+1];

        for(int i = 0; i < leftSize; i++){
            leftArray[i] = numbers[left+i];
        }

        for(int j = 0; j < rightSize; j++){
            rightArray[j] = numbers[middle+j+1];
        }


        leftArray[leftSize] = endSerial;
        rightArray[rightSize] = endSerial;

        int sumleft, sumright;


        int i = 0;
        int j = 0;

        while(i < leftSize || j < rightSize) {
            sumleft = 0;
            sumright = 0;
            if(leftArray[i].length() < rightArray[j].length()){//길이비교
                numbers[left+i+j] = leftArray[i];
                i++;
            }
            else if(leftArray[i].length() > rightArray[j].length()){//길이비교
                numbers[left+i+j] = rightArray[j];
                j++;
            }
            else if(leftArray[i].length() == rightArray[j].length()){//길이가 같으면
                for(int k = 0; k < leftArray[i].length(); k++){
                    if(leftArray[i].charAt(k) >= '0' && leftArray[i].charAt(k) <= '9'){
                        sumleft += leftArray[i].charAt(k)-'0';
                    }
                }
                for(int k = 0; k < rightArray[j].length(); k++){
                    if(rightArray[j].charAt(k) >= '0' && rightArray[j].charAt(k) <= '9'){
                        sumright += rightArray[j].charAt(k)-'0';
                    }
                }
                if(sumleft < sumright){//숫자합 비교
                    numbers[left+i+j] = leftArray[i];
                    i++;
                }
                else if(sumleft > sumright){
                    numbers[left+i+j] = rightArray[j];
                    j++;
                }
                else{//숫자 합도 같으면 사전순 비교
                    if(leftArray[i].compareTo(rightArray[j]) < 0){
                        numbers[left+i+j] = leftArray[i];
                        i++;
                    }
                    else{
                        numbers[left+i+j] = rightArray[j];
                        j++;
                    }
                }
            }
            else{//위의 어떠한 경우에도 해당하지 않으면 사전순 비교
                if(leftArray[i].compareTo(rightArray[j]) < 0){
                    numbers[left+i+j] = leftArray[i];
                    i++;
                }
                else{
                    numbers[left+i+j] = rightArray[j];
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new SerialNumber_1431().solution();
    }
}
