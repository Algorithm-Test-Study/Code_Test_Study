package week5.sorting1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// [BOJ] 좌표 정렬하기 / 실버5
public class SortingCoordinate_11650 {
    int[] arrx;
    int[] arry;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int x;
        int y;

        int n = Integer.parseInt(st.nextToken());
        arrx = new int[n];
        arry = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arrx[i] = x;
            arry[i] = y;
        }

        mergeSort(0, n-1);
        for(int j = 0; j < n; j++){
            sb.append(arrx[j]);//StringBuilder로 시간초과 방지
            sb.append(' ');
            sb.append(arry[j]);
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
        int[] xleftArray = new int[leftSize+1];
        int[] yleftArray = new int[leftSize+1];
        int[] xrightArray = new int[rightSize+1];
        int[] yrightArray = new int[rightSize+1];

        for(int i = 0; i < leftSize; i++){
            xleftArray[i] = arrx[left+i];
            yleftArray[i] = arry[left+i];
        }

        for(int j = 0; j < rightSize; j++){
            xrightArray[j] = arrx[middle+j+1];
            yrightArray[j] = arry[middle+j+1];
        }


        xleftArray[leftSize] = Integer.MAX_VALUE;
        yleftArray[leftSize] = Integer.MAX_VALUE;
        xrightArray[rightSize] = Integer.MAX_VALUE;
        yrightArray[rightSize] = Integer.MAX_VALUE;


        int i = 0;
        int j = 0;

        while(i < leftSize || j < rightSize) {
            if(xleftArray[i] < xrightArray[j]){
                arrx[left+i+j] = xleftArray[i];
                arry[left+i+j] = yleftArray[i];
                i++;
            }
            else if(xleftArray[i] == xrightArray[j]){//x 좌표 값이 같을 때
                if(yleftArray[i] < yrightArray[j]){//y좌표 값 비교
                    arrx[left+i+j] = xleftArray[i];
                    arry[left+i+j] = yleftArray[i];
                    i++;
                }
                else{
                    arrx[left+i+j] = xrightArray[j];
                    arry[left+i+j] = yrightArray[j];
                    j++;
                }
            }
            else{
                arrx[left+i+j] = xrightArray[j];
                arry[left+i+j] = yrightArray[j];
                j++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new SortingCoordinate_11650().solution();
    }
}
