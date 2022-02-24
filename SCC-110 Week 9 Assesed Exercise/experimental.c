#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

struct lineData
{
    double value;
    int function,type;
};

//This is the part where we check if the line is either a number(double), function or error.
struct lineData compare(char line[50])
{

    //Initializing result
    struct lineData result;
    result.value = 0;
    result.function = 0;
    result.type = 0;


    printf("Comparing: %s",line);

    //First we check for every valid function.
    if(strncmp(line,"add\n",50) == 0)
    {
        printf("We need to Add\n");
        result.function = 1;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"subtract\n",50) == 0)
    {
        printf("We need to Subtract\n");
        result.function = 2;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"multiply\n",50) == 0)
    {
        printf("We need to Multiply\n");
        result.function = 3;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"divide\n",50) == 0)
    {
        printf("We need to Divide\n");
        result.function = 4;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"negate\n",50) == 0)
    {
        printf("We need to Negate\n");
        result.function = 5;
        result.type = 1;
        return(result);
    }
    if(strncmp(line,"square\n",50) == 0)
    {
        printf("We need to Square\n");
        result.function = 6;
        result.type = 1;
        return(result);
    }
    
    /*We seperate the double and the string (if both exist). Then check if the string part has any characters.
    If not then we proceed with the double*/
    char *stringPart;
    double doublePart = strtod(line,&stringPart);
    
    //If stringPart is longer than 1 we give an error message.
    if(strlen(stringPart)>1)
    {
        printf("ERROR:INVALID INPUT\n");
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
    FILE *pointerToFileCounter = pointerToFile;
    //Just in case something goes wrong if the pointer is null for some reason we give an error.
    if(pointerToFile == NULL)
    {
        printf("ERROR: CAN'T OPEN FILE");
        exit(0);
    }

    //We declare where we are going to store our current string.
    char line[50];
    int fileLineCount = 0;

    while(fgets(line,50,pointerToFileCounter)!=NULL)
    {
        fileLineCount++;
        printf("%d",fileLineCount);
    }
    
    fclose(pointerToFile);
}
    
    //Main, while loop that is goint to go trough all the lines until fgets returns a NULL.
    while(fgets(line,50,pointerToFile)!=NULL)
    {
        printf("Current input is:%s",line);
        struct lineData realResults = compare(line);
        






        
        printf("\n\n");
    
    
    
    
    
    
    
    
    
    }
}