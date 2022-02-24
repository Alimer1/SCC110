public class TestProgram4 
{
    public static void main(String[] args)
    {
        int TOP_NUMBER = 100;
        int i=0;
        int total=0;
        for (i=1; i<=TOP_NUMBER; i++)
        {
            total = total + i;
        }
        System.out.println("The sum of the numbers 1 to " + TOP_NUMBER + " was " + total);
    }
}