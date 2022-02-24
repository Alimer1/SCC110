public class TestProgram2
{
    public static void main( String[] args )
    {
        int myMathsGrade = 88;
        int myEnglishGrade = 61;
        int myPhysicsGrade = 70;
        int myAverage;

        myAverage = ((myMathsGrade+myEnglishGrade+myPhysicsGrade)/3);

        if ( myAverage > 75 )
        {
            System.out.println("Congratulations - you're a genius!\n" + "You got an average over 75%");
        }
        else
        {
        }
        System.out.println("The average of your grades was: " + myAverage);
    }
}