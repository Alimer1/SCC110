#include <stdio.h>
#include <stdlib.h>
#include <time.h> 

int main()
{

    int lowerLimit;
    int higherLimit;
    int count;
    int guess;
    int answer;
    int x;

    x = 0;
    
    lowerLimit = 0;
    higherLimit = 1000;

    while(x==0)
    {
        count = higherLimit - lowerLimit;
        guess = (count/2) + lowerLimit;
        printf("My guess is %d. If it is correct write 0. If it is too high write 1. If it is too low write 2\n",guess);
        scanf("%d",&answer);

        if(answer==0)
        {
            x = 1;
            printf("I win, you lose.\n");
        }
        else
        {
            if(answer==1)
            {
                higherLimit = guess;
            }
            else
            {
                lowerLimit = guess;
            }
        }
    }
}