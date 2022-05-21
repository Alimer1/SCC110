import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        GameArena mainGame = new GameArena(1000,500);
        Ball ball = new Ball(500,250,10,"BLUE");

        Line topLine = new Line(100,100,900,100,5,"RED");
        Line rightLine = new Line(900,100,900,400,5,"RED");
        Line bottomLine = new Line(900,400,100,400,5,"RED");
        Line leftLine = new Line(100,400,100,100,5,"RED");
        Object test = new Object();
        TimeUnit help = new TimeUnit();

        mainGame.addBall(ball);
        mainGame.addLine(topLine);
        mainGame.addLine(rightLine);
        mainGame.addLine(bottomLine);
        mainGame.addLine(leftLine);

        double ballXSpeed = 0.01;
        double ballYSpeed = 0.01;

        boolean gameOver = false;

        while(gameOver == false)
        {
            ball.setXPosition(ball.getXPosition()+ballXSpeed);
            ball.setYPosition(ball.getYPosition()+ballYSpeed);
            help.SECONDS.sleep(1);
        }


    }

    void Update()
    {

    }
}