#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

struct lineData
{
    double value;
    int function,type;
};

void stackCheck(int doublesLeft)
{
    if(doublesLeft == 0)
    {
        printf("ERROR: STACK EMPTY\n");
        exit(0);
    }
}

//This is the part where we check if the line is either a number(double), function or error.
struct lineData compare(char line[50])
{

    //Initializing result
    struct lineData result;
    result.value = 0;
    result.function = 0;
    result.type = 0;


    //First we check for every valid function.
    if(strncmp(line,"add\n",50) == 0)
    {
        result.function = 1;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"subtract\n",50) == 0)
    {
        result.function = 2;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"multiply\n",50) == 0)
    {
        result.function = 3;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"divide\n",50) == 0)
    {
        result.function = 4;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"negate\n",50) == 0)
    {
        result.function = 5;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"square\n",50) == 0)
    {
        result.function = 6;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"swap\n",50) == 0)
    {
        result.function = 7;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"drop\n",50) == 0)
    {
        result.function = 8;
        result.type = 1;
        return(result);
    }
    
    /*
    We seperate the double and the string (if both exist). Then check if the string part has any characters.
    If not then we proceed with the double
    */
    char *stringPart;
    double doublePart = strtod(line,&stringPart);
    
    //If stringPart is longer than 1 we give an error message.
    if(strlen(stringPart)>1)
    {
        printf("ERROR: INVALID INPUT\n");
        exit(0);
    }

    //If we get here that means we have a double so we just need to push that.
    result.value = doublePart;
    result.type = 2;
    return(result);
}

int main()
{
    //Opens the file and then points the "pointerToFile" to it.
    FILE *pointerToFile = fopen("sums.txt", "r");

    //Just in case something goes wrong if the pointer is null for some reason we give an error.
    if(pointerToFile == NULL)
    {
        printf("ERROR: CAN'T OPEN FILE\n");
        exit(0);
    }

    //We declare where we are going to store our current string.
    char line[50];

    /*
    Declaring the pointer for the memory we are going to use. We use malloc to make a space for the initial "0" value.
    Then we set the first value to 0 since thats what the documentation wants. Also I could use calloc for that but I don't wanna.
    */
    double *stack;
    stack = (double *) malloc(sizeof(double));
    stack[0] = 0;

    //Both gives us the number of characters and the location of the top double.
    int stackSize = 0;


    //Main, while loop that is goint to go trough all the lines until fgets returns a NULL.
    while(fgets(line,50,pointerToFile)!=NULL)
    {
        struct lineData realResults = compare(line);
        
        //Adds number to the stack and allocates space for it
        if(realResults.type == 2)
        {
            stackSize++;
            stack = (double *) realloc(stack,sizeof(double)*(stackSize+1));
            stack[stackSize] = realResults.value;
        }

        //Hopefully these do the calculations.
        if(realResults.type == 1)
        {
            if(realResults.function == 1)//ADD
            {
                stackCheck(stackSize);
                stack[stackSize - 1] += stack[stackSize];
                stackSize--;
                stack = (double *) realloc(stack,sizeof(double)*(stackSize+1));
            }
            if(realResults.function == 2)//SUBTRACT
            {
                stackCheck(stackSize);
                stack[stackSize-1] = stack[stackSize] - stack[stackSize-1];
                stackSize--;
                stack = (double *) realloc(stack,sizeof(double)*(stackSize+1));
            }
            if(realResults.function == 3)//MULTIPLY
            {
                stackCheck(stackSize);
                stack[stackSize-1] *= stack[stackSize];
                stackSize--;
                stack = (double *) realloc(stack,sizeof(double)*(stackSize+1));
            }
            if(realResults.function == 4)//DIVIDE
            {
                stackCheck(stackSize);
                //Divide by 0 check
                if(stack[stackSize-1] == 0)
                {
                    printf("ERROR: DIVIDE BY ZERO\n");
                    exit(0);
                }
                stack[stackSize-1] = stack[stackSize] / stack[stackSize];
                stackSize--;
                stack = (double *) realloc(stack,sizeof(double)*(stackSize+1));
            }
            if(realResults.function == 5)//NEGATE
            {
                stack[stackSize] = -1 * stack[stackSize];
            }
            if(realResults.function == 6)//SQUARE
            {
                stack[stackSize] = stack[stackSize] * stack[stackSize];
            }
            if(realResults.function == 7)//SWAP
            {
                double temp = 0;
                stackCheck(stackSize);
                temp = stack[stackSize];
                stack[stackSize] = stack[stackSize - 1];
                stack[stackSize -1] = temp;
            }
            if(realResults.function == 8)//DROP
            {
                stackCheck(stackSize);
                stackSize--;
                stack = (double *) realloc(stack,sizeof(double)*(stackSize+1));
            }
        }
    }

    printf("%f\n",stack[stackSize]);
    fclose(pointerToFile);
    free(stack);
    stack = NULL;
}