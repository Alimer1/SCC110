#include <stdio.h>
#include <stdlib.h>
#include <time.h> 
void jackpotCal(int rc,int s1,int s2,int s3,int s4)
{
    int array[4]={s1,s2,s3,s4},i;
    for(i = 0;i<4;i++)
    {
        if(array[i]>rc/2)
        {
            if(array[i]==rc)
            {
                printf("Jackpot");
            }
            else
            {
                printf("You Win");
            }
        }
        else
        {
            printf("You Lose");
        }
    }
}

void reelArray(int reelNumber,int actualArrayPointer)
{
    int Array[reelNumber];
    Array = actualArrayPointer;
    int i;
    srand(time(NULL));
    for(i = 0;i<reelNumber;i++)
    {
        *Array[i] = rand() % 4;
    }
}

int main()
{
    int symbol1,symbol2,symbol3,symbol4,reelCount,i;
    printf("How many reels do you want?\n");
    scanf("%d",&reelCount);
    int results[reelCount];
    reelArray(reelCount,results);
    printf("Results are:\n[ ");
    for(i = 0;i<reelCount;i++)
    {
        if(results[i] == 0)
        {
            printf("Bell ");
            symbol1++;
        }
        if(results[i] == 1)
        {
            printf("Orange ");
            symbol2++;
        }
        if(results[i] == 2)
        {
            printf("Cherry ");
            symbol3++;
        }
        if(results[i] == 3)
        {
            printf("Horseshoe ");
            symbol4++;
        }
    }
    printf("]\n");
    jackpotCal(reelCount,symbol1,symbol2,symbol3,symbol4);
}