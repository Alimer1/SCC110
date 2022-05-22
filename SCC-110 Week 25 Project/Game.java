import java.awt.event.KeyEvent;

public class Game
{
    public Game() throws InterruptedException
    {
        int width = 1000;
        int height = 800;
        int border = 100;
        GameArena mainGame = new GameArena(width,height);
        Puck puck[] = new Puck[4];
        Player player[] = new Player[2];
        Line wall[] = new Line[4];

        puck[0] = new Puck((width/2)-border, height/2, false);
        puck[1] = new Puck(width/2, ((1*(height-(2*border)))/4)+border, true);
        puck[2] = new Puck(width/2, ((2*(height-(2*border)))/4)+border, true);
        puck[3] = new Puck(width/2, ((3*(height-(2*border)))/4)+border, true);

        mainGame.addBall(puck[0].getBall());
        mainGame.addBall(puck[1].getBall());
        mainGame.addBall(puck[2].getBall());
        mainGame.addBall(puck[3].getBall());

        player[0] = new Player(1);
        player[1] = new Player(0);

        mainGame.addBall(player[0].getBall());
        mainGame.addBall(player[1].getBall());

        wall[0] = new Line(border, border, width-border, border, 5, "RED");
        wall[1] = new Line(width-border, border, width-border, height-border, 5, "RED");
        wall[2] = new Line(width-border, height-border, border, height-border, 5, "RED");
        wall[3] = new Line(border, height-border, border, border, 5, "RED");


        mainGame.addLine(wall[0]);
        mainGame.addLine(wall[1]);
        mainGame.addLine(wall[2]);
        mainGame.addLine(wall[3]);

        boolean gameOver = false;

        while(gameOver == false)    //Main loop of the program that triggers every second until game over
        {

            player[0].setVelocityX(0);
            player[0].setVelocityY(0);
            player[1].setVelocityX(0);
            player[1].setVelocityY(0);

            if(mainGame.upPressed()&&!(player[0].getPositionY()<border+player[0].getR()))
            {
                player[0].setVelocityY(-3);
            }
            if(mainGame.downPressed()&&!(player[0].getPositionY()>(height-border)-player[0].getR()))
            {
                player[0].setVelocityY(3);
            }
            if(mainGame.rightPressed()&&!(player[0].getPositionX()>(width-border)-player[0].getR()))
            {
                player[0].setVelocityX(3);
            }
            if(mainGame.leftPressed()&&!(player[0].getPositionX()<(width/2)+player[0].getR()))
            {
                player[0].setVelocityX(-3);
            }
            if(mainGame.letterPressed('w')&&!(player[1].getPositionY()<border+player[1].getR()))
            {
                player[1].setVelocityY(-3);
            }
            if(mainGame.letterPressed('s')&&!(player[1].getPositionY()>(height-border)-player[1].getR()))
            {
                player[1].setVelocityY(3);
            }
            if(mainGame.letterPressed('d')&&!(player[1].getPositionX()>(width/2)-player[1].getR()))
            {
                player[1].setVelocityX(3);
            }
            if(mainGame.letterPressed('a')&&!(player[1].getPositionX()<border+player[1].getR()))
            {
                player[1].setVelocityX(-3);
            }

            for(int i=0;i<2;i++)
            {
                for(int j=0;j++<4;j++)
                {
                    if(player[i].getBall().collides(puck[j].getBall()))
                    {
                        System.out.print(obj);
                        puck[j].setVelocity(Coordinates.sub(puck[j].getPosition(),player[i].getPosition()));
                    }
                }
            }



            puck[0].move();
            puck[1].move();
            puck[2].move();
            puck[3].move();

            player[0].move();
            player[1].move();

            Thread.sleep(16);
        }
    }
}