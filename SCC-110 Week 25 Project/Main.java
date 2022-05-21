public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        GameArena mainGame = new GameArena(1000,500);
        Player player[] = new Player[2];
        Line wall[] = new Line[4];

        for(int i=0;i<2;i++)
        {
            player[i] = new Player(i);
            mainGame.addBall(player[i].getBall());
        }
        for(int i=0;i<4;i++)
        {
            wall[i] = new Line(100, 100+(i*50), 800, 150+(i*50), 5, "RED");
            mainGame.addLine(wall[i]);
        }


        double ballXSpeed = 0;
        double ballYSpeed = 0;

        boolean gameOver = false;

        while(gameOver == false)    //Main loop of the program that triggers every second until game over
        {

            ballXSpeed = 0;
            ballYSpeed = 0;

            if(mainGame.upPressed()==true)
            {
                ballYSpeed = -3;
            }
            if(mainGame.downPressed()==true)
            {
                ballYSpeed = 3;
            }
            if(mainGame.rightPressed()==true)
            {
                ballXSpeed = 3;
            }
            if(mainGame.leftPressed()==true)
            {
                ballXSpeed = -3;
            }


            boolean c = Coordinates.lineBallColision(player[0].getBall(), wall[0]);
            double d = Coordinates.lineBallDistance(player[0].getBall(), wall[0]);
            double cp[] = Coordinates.lineBallClosestPoint(player[0].getBall(), wall[0], d);

            wall[1].setLinePosition(player[0].getX(),player[0].getY(), cp[0], cp[1]);

            player[0].setX(player[0].getX()+ballXSpeed);
            player[0].setY(player[0].getY()+ballYSpeed);


            Thread.sleep(16);
        }
    }
}