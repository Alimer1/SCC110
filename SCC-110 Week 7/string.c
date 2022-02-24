#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int main()
{
    char str[10] = "hellot";
    int count;
    int pos=0;

    while(str[pos]!='\0')
    {
        pos++;
    }
    printf("%d\n",pos);

}