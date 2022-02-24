#include <stdio.h>

unsigned int rsh(char* str, unsigned int len)
{
   unsigned int b    = 378551;
   unsigned int a    = 63689;
   unsigned int hash = 0;
   unsigned int i    = 0;

   for(i = 0; i < len; str++, i++)
   {
      hash = hash * a + (*str);
      a    = a * b;
   }

   return hash;
}

unsigned int jsh(char* str, unsigned int len)
{
   unsigned int hash = 1315423911;
   unsigned int i    = 0;

   for(i = 0; i < len; str++, i++)
   {
      hash ^= ((hash << 5) + (*str) + (hash >> 2));
   }

   return hash;
}


int main()
{
   char *key = "abcdefghijklmnopqrstuvwxyz1234567890";

   printf("%u\n",rsh(key,36));
   printf("%u\n",jsh(key,36));
}
