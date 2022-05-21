
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        GameArena mainGame = new GameArena(1000,500);
        Ball ball = new Ball(500,250,50,"BLUE");

        Line topLine = new Line(100,100,900,100,5,"RED");
        Line rightLine = new Line(900,100,900,400,5,"RED");
        Line bottomLine = new Line(900,400,100,400,5,"RED");
        Line leftLine = new Line(100,400,100,100,5,"RED");
        Text text = new Text("Counter:",20,500,150,"ORANGE");
        int counter = 0;

        mainGame.addBall(ball);
        mainGame.addLine(topLine);
        mainGame.addLine(rightLine);
        mainGame.addLine(bottomLine);
        mainGame.addLine(leftLine);
        mainGame.addText(text);

        double ballXSpeed = 1;
        double ballYSpeed = 1;

        boolean gameOver = false;

        while(gameOver == false)
        {

            if(ball.getYPosition()>400-25||ball.getYPosition()<100+25)
            {
                ballYSpeed = ballYSpeed * -1;
            }
            if(ball.getXPosition()>900-25||ball.getXPosition()<100+25)
            {
                ballXSpeed = ballXSpeed * -1;
            }
            ball.setXPosition(ball.getXPosition()+ballXSpeed);
            ball.setYPosition(ball.getYPosition()+ballYSpeed);
            counter++;
            text.setText("Counter:"+counter);
            Thread.sleep(16);
        }
    }
}