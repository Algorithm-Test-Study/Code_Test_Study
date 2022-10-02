#include <bits/stdc++.h>
using namespace std;
int arr[7], sum;
int main(void){
	for(int i=0; i<7; i++)	cin >> arr[i];
	sort(arr, arr+7);
	int flag = 0, min = 0;
	for(int i=0; i<7; i++){
		if(arr[i] % 2 == 1){
			if(flag == 0)	min = arr[i];
			flag = 1;
			sum += arr[i];
		}
	}
	if(flag == 0)	printf("-1");
	else{
		printf("%d\n", sum);
		printf("%d", min);
	}
	return 0;
}
