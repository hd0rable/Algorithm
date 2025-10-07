#include <stdio.h>
int main(){
    int n;
    scanf("%d", &n);
    int count = n;
    char s[101];
    for (int i = 0; i < n; i++){
        scanf("%s", s);
        int a[26] = {0};
        for (int k = 0; s[k] != '\0'; k++){
            if (s[k] != s[k+1])
                a[s[k]-'a']++;
            if (a[s[k]-'a'] == 2) {
                count--;
                break;
            }
        }
    }
    printf("%d", count);
}
