#include <stdio.h>
#include <string.h>
int main(){
    int i, j;
    int tc, len1 = 0, len2 = 0;
    char word1[1000], word2[1000];
    scanf("%d", &tc);
    for(i=0; i<tc; i++){
    	int a[26] = {0}, b[26] = {0};
    	scanf("%s", word1);
    	scanf("%s", word2);
    	len1 = strlen(word1), len2 = strlen(word2);
    	for(j=0; j<len1; j++){
    		a[word1[j]-97]++;
		}
    	for(j=0; j<len2; j++){
    		b[word2[j]-97]++;
		}
		int flag = 0;
    	for(j=0; j<26; j++){
    		if(a[j] != b[j]){
    			printf("Impossible\n");
    			flag = 1;
    			break;
			}
		}
		if(flag == 0)	printf("Possible\n");
    	//초기화 
    	word1[0] = '\n'; 
    	word2[0] = '\n';
	}
    return 0;
}
