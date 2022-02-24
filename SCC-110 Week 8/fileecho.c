#include <stdio.h>

int main()
{
    FILE *fileHandle;
    char filename[64];

    printf("Enter name of file: ");
    scanf("%s", filename);

    fileHandle = fopen(filename, "r");
    if(fileHandle == NULL)
    {
        printf("Unable to open file\n");
        return 1;   // end the main function with a non-zero value to indicate error
    }

    // as an example, just print the file out to the screen line by line

    char buffer[200];  // assume all lines are less than 199 characters
    char *result;
    result = fgets(buffer, 200, fileHandle);
    print("%s", buffer);
    while(result != NULL)
    {
        result = fgets(buffer, 200, fileHandle);
        printf("%s", buffer);
    }

    fclose(fileHandle);
    return 0; // end main function with a zero value to indicate program exited normally.
}
