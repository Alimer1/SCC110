#include <stdio.h>
#include <stdlib.h>
#include <time.h> 

int main()
{


    int realNumber;
    srand(time(NULL));
    realNumber = rand() % 10 + 1;

    printf("Secret Number Is %d\n",realNumber);
    
    int x;
    x = 0;

    int answer;

    while(x==0)
    {
        scanf("%d",&answer);

        printf("Your answer is %d and the realNumber is %d\n",answer,realNumber);

        if(answer==realNumber)
        {
            x = 1;
            printf("You are correct %d\n",realNumber);
        }
        else
        {
            if(answer<realNumber)
            {
                printf("HIGHER\n");
            }
            else
            {
                printf("LOWER\n");
            }
        }
    }
}