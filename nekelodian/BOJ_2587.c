#include <stdio.h>
int main(void){
	int arr[5] = {0}, temp = 0, sum = 0;
    for(int i=0; i<5; i++){
	    scanf("%d", &arr[i]);
    }
    for(int i=0; i<5; i++){
    	for(int j=i+1; j<5; j++){
        	if(arr[i] > arr[j]){
            	temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    for(int i=0; i<5; i++)
    	sum += arr[i];
    printf("%d\n%d", sum/5, arr[2]);
    return 0;
}
