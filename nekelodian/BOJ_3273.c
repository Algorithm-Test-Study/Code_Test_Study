#include <stdio.h>
int main(){
    int i, j, arr[100000] = {0};
    int n, x, cnt=0;
    scanf("%d", &n);
    for(i=0; i<n; i++)	scanf("%d", &arr[i]);
    scanf("%d", &x);
    for(i=0; i<n; i++){
    	if(arr[i] < x){
    		for(j=i+1; j<n; j++){
    			if(arr[j] == x - arr[i]){
    				cnt++;
    				break;
				}
			}
		}
	}
	printf("%d", cnt);
    return 0;
}
