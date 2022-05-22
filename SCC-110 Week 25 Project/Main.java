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

        wall[0] = new Line(100, 100, 900, 100, 5, "RED");
        wall[1] = new Line(900, 100, 900, 400, 5, "RED");
        wall[2] = new Line(900, 400, 100, 400, 5, "RED");
        wall[3] = new Line(100, 400, 100, 100, 5, "RED");


        mainGame.addLine(wall[0]);
        mainGame.addLine(wall[1]);
        mainGame.addLine(wall[2]);
        mainGame.addLine(wall[3]);

        Coordinates velocity = new Coordinates(0, 0);

        boolean gameOver = false;

        while(gameOver == false)    //Main loop of the program that triggers every second until game over
        {

            velocity.setX(0);
            velocity.setY(0);

            if(mainGame.upPressed()==true)
            {
                velocity.setY(-3);
            }
            if(mainGame.downPressed()==true)
            {
                velocity.setY(3);
            }
            if(mainGame.rightPressed()==true)
            {
                velocity.setX(3);
            }
            if(mainGame.leftPressed()==true)
            {
                velocity.setX(-3);
            }


            boolean c = Coordinates.lineBallColision(player[0].getBall(), wall[0]);
            double d = Coordinates.lineBallDistance(player[0].getBall(), wall[0]);
            double cp[] = Coordinates.lineBallClosestPoint(player[0].getBall(), wall[0], d);
            Coordinates closePoint = new Coordinates(cp[0], cp[1]);
            Coordinates closePointFromPlayer = new Coordinates(closePoint.getX()-player[0].getX(),closePoint.getY()-player[0].getY());

            wall[1].setLinePosition(player[0].getX(),player[0].getY(), cp[0], cp[1]);

            if(c==true&&!(velocity.getX()==0&&velocity.getY()==0))
            {
                velocity = Coordinates.remainingVelocityVector(Coordinates.angleBetween(closePointFromPlayer,velocity), closePointFromPlayer, velocity);
            }

            player[0].setX(player[0].getX()+velocity.getX());
            player[0].setY(player[0].getY()+velocity.getY());
            System.out.println("Is c true:"+c);
            System.out.println("Velocity: X("+velocity.getX()+") Y("+velocity.getY()+")");
            Thread.sleep(100);
        }
    }
}