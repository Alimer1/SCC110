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
        Text text = new Text("Frames:",20,500,150,"ORANGE");
        int counter = 0;

        mainGame.addBall(ball);
        mainGame.addLine(topLine);
        mainGame.addLine(rightLine);
        mainGame.addLine(bottomLine);
        mainGame.addLine(leftLine);
        mainGame.addText(text);

        double ballXSpeed = 0;
        double ballYSpeed = 0;

        boolean gameOver = false;

        while(gameOver == false)    //Main loop of the program that triggers every second until game over
        {

            ballXSpeed = 0;
            ballYSpeed = 0;

            if(mainGame.upPressed()==true)
            {
                ballYSpeed = -1;
            }
            if(mainGame.downPressed()==true)
            {
                ballYSpeed = 1;
            }
            if(mainGame.rightPressed()==true)
            {
                ballXSpeed = 1;
            }
            if(mainGame.leftPressed()==true)
            {
                ballXSpeed = -1;
            }
            if(ball.getYPosition()>400-25&&ballYSpeed>0)
            {
                ballYSpeed=0;
            }
            if(ball.getYPosition()<100+25&&ballYSpeed<0)
            {
                ballYSpeed=0;
            }
            if(ball.getXPosition()>900-25&&ballXSpeed>0)
            {
                ballXSpeed=0;
            }
            if(ball.getXPosition()<100+25&&ballXSpeed<0)
            {
                ballXSpeed=0;
            }





            ball.setXPosition(ball.getXPosition()+ballXSpeed);
            ball.setYPosition(ball.getYPosition()+ballYSpeed);
            counter++;
            text.setText("Frames:"+counter/60+"\nCollision:"+PlayerBall.lineBallColision(ball, topLine));
            Thread.sleep(16);
        }
    }
}