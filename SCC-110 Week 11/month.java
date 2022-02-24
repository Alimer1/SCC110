public class month
{
    public static void main(String[] args)
    {
        int month = 2;

        if(month == 4||month == 6||month == 9||month == 11)
        {
            System.out.println("This month has 30 days.");
        }
        else
        {
            if(month == 2)
            {
                System.out.println("This month has 28 (29 once 4 years) days.");
            }
            else
            {
                System.out.println("This month has 31 days.");
            }
        }
   }
}