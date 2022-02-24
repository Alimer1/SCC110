#include <stdio.h>
#include <stdlib.h>
#include <time.h>//including this just so that if i need it later

int multByTwo(int x)
{
    x = x * 2;
    return(x);
}

int isFirstBigger(int x,int y)
{
    int z;
    z = x > y;
    return(z);
}

float addVat(float x)
{
    x = x * 1.2;
    return(x);
}





int main()
{
    int firstInteger;
    int secondInteger;
    float firstFloat;

    printf("Enter first integer:\n");
    scanf("%d",&firstInteger);
    printf("Enter second integer:\n");
    scanf("%d",&secondInteger);
    printf("Enter first float:\n");
    scanf("%f",&firstFloat);

    printf("Results are:\n[ %d , %d , %f ]",multByTwo(firstInteger),isFirstBigger(firstInteger,secondInteger),addVat(firstFloat));
} 