#include <stdio.h>
#include <stdlib.h>
#include <time.h>//including this just so that if i need it later


int main()
{
    int specialArray [10];//array we are goint to use
    int smallestNumber = 0;
    int smallestLocation = 0;
    int biggestNumber = 0;
    int biggestLocation = 0;
    float mean = 0;
    int i;

    for(i=0;i<10;i++)
    {
        printf("Please enter the %d. element of the array.\n",i+1);
        scanf("%d",&specialArray[i]);
    }

    /*
    This is the part where I get the input
    */

    printf("All the numbers in the array are =\n[ ");

    for(i=0;i<10;i++)
    {
        printf("%d ",specialArray[i]);
    }

    printf("]\n");

    /*
    This is the part where I list the array
    */

    printf("Smallet number in the array and its position is is =\n[ ");

    for(i=0;i<10;i++)
    {
        

        if(specialArray[i]<smallestNumber)
        {
            smallestNumber = specialArray[i];
            smallestLocation = i+1;
        }
        else
        {}

    }

    printf("%d,%d ]\n",smallestNumber,smallestLocation);

    /*
    This is the part where I find and print the smallest number and its location.
    */

    printf("Biggest number in the array and its position is is =\n[ ");

    for(i=0;i<10;i++)
    {
        
        if(specialArray[i]>biggestNumber)
        {
            biggestNumber = specialArray[i];
            biggestLocation = i+1;
        }
        else
        {}

    }

    printf("%d,%d ]\n",biggestNumber,biggestLocation);

    /*
    This is the part where I find and print the biggest number and its location.
    */

    printf("Mean of the array is =\n[ ");

    for(i=0;i<10;i++)
    {
        mean = mean + specialArray[i];// I use mean here as I don't want to define a new variable
    }

    mean = mean/10;

    printf("%f ]\n",mean);

}

