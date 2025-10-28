#pragma warning(disable:4996)
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main()
{
	int cpr = 0, n = 0, npr[100] = { 0 }, nn[100] = { 0 };
	int knpr = 0;
	scanf("%d", &cpr);
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d %d", &npr[i], &nn[i]);
		knpr += npr[i] * nn[i];
	}
	if (cpr == knpr)
		printf("Yes");
	else
		printf("No");



}