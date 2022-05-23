public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Game game1 = new Game();
        while(true) //Check every 10 second if the game is finished If so start a new game
        {
            if(game1.returnGameState()==true)
            {
                game1 = new Game();
            }
            Thread.sleep(1000);
        }
    }
}