public class TestProgram3
{
    public static void main( String[] args )
    {
        boolean isRaining = true;
        boolean isWindy = true;

        if (isRaining)
        {
            if (isWindy)
            {
                System.out.println("It's both raining and windy - time to stay indoors?");
            }
            else
            {
            }
        }
        else
        {
            if (isWindy==false)
            {
                System.out.println("It's neither windy or rainy - time for a game of frisbee?");
            }
            else
            {
            }
        }

    }
}