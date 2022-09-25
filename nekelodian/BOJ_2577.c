#include <stdio.h>
int main(){
    int i, arr[10] = {0};
    int a, b, c, x, num = 0;
    scanf("%d%d%d", &a, &b, &c);
    x = a*b*c;
    for(i=0; i<10; i++){
    	if(x==0)	continue;
    	num = x%10;
    	arr[num]++;
    	x /= 10;
	}
	for(i=0; i<=9; i++)	printf("%d\n", arr[i]);
    return 0;
}
