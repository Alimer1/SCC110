// Test Program 5: Random Weights
// Once corrected you should be able to run this program multiple times and explore the results of the random method.
public class TestProgram5
{
    public static void main(String[] args)
    {
        double UPPER_WEIGHT = 0.999;
        double LOWER_WEIGHT = 0.00;
        double nextWeight = 0.5;
        int count = 0;
        while (nextWeight > LOWER_WEIGHT && nextWeight < UPPER_WEIGHT)
        {
            count++;
            nextWeight = Math.random();
        }
        System.out.println("You ended up with " + count + " consecutive items that were the required weight");
    }
}
