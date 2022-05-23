public class Game
{

    private boolean gameOver = false;

    public Game() throws InterruptedException
    {
        int width = 1200;
        int height = 800;
        int border = 100;
        GameArena mainGame = new GameArena(width,height);
        Puck puck[] = new Puck[4];
        Player player[] = new Player[2];
        Line wall[] = new Line[4];
        Ball goal[] = new Ball[2];
        int player1Score = 0;
        int player2Score = 0;

        if(Math.random()>0.5)
        {
            puck[0] = new Puck(((3*(width-(2*border)))/8)+border, height/2, false);
        }
        else
        {
            puck[0] = new Puck(((5*(width-(2*border)))/8)+border, height/2, false);
        }

        puck[1] = new Puck(width/2, ((1*(height-(2*border)))/4)+border, true);
        puck[2] = new Puck(width/2, ((2*(height-(2*border)))/4)+border, true);
        puck[3] = new Puck(width/2, ((3*(height-(2*border)))/4)+border, true);

        mainGame.addBall(puck[0].getBall());
        mainGame.addBall(puck[1].getBall());
        mainGame.addBall(puck[2].getBall());
        mainGame.addBall(puck[3].getBall());

        player[0] = new Player(((6*(width-(2*border)))/8)+border, height/2);
        player[1] = new Player(((2*(width-(2*border)))/8)+border, height/2);

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

        goal[0] = new Ball(((1*(width-(2*border)))/8)+border,height/2,100,"GREY",-1);
        goal[1] = new Ball(((7*(width-(2*border)))/8)+border,height/2,100,"GREY",-1);

        mainGame.addBall(goal[0]);
        mainGame.addBall(goal[1]);

        Text text = new Text("TEXT HERE", border/2, width/2, border/2, "WHITE");

        mainGame.addText(text);

        while(gameOver == false)    //Main loop of the program that triggers every second until game over
        {

            player[0].setVelocityX(0);
            player[0].setVelocityY(0);
            player[1].setVelocityX(0);
            player[1].setVelocityY(0);

            if(mainGame.upPressed()&&!(player[0].getPositionY()<border+player[0].getR()))
            {
                player[0].setVelocityY(-5);
            }
            if(mainGame.downPressed()&&!(player[0].getPositionY()>(height-border)-player[0].getR()))
            {
                player[0].setVelocityY(5);
            }
            if(mainGame.rightPressed()&&!(player[0].getPositionX()>(width-border)-player[0].getR()))
            {
                player[0].setVelocityX(5);
            }
            if(mainGame.leftPressed()&&!(player[0].getPositionX()<(width/2)+player[0].getR()))
            {
                player[0].setVelocityX(-5);
            }
            if(mainGame.letterPressed('w')&&!(player[1].getPositionY()<border+player[1].getR()))
            {
                player[1].setVelocityY(-5);
            }
            if(mainGame.letterPressed('s')&&!(player[1].getPositionY()>(height-border)-player[1].getR()))
            {
                player[1].setVelocityY(5);
            }
            if(mainGame.letterPressed('d')&&!(player[1].getPositionX()>(width/2)-player[1].getR()))
            {
                player[1].setVelocityX(5);
            }
            if(mainGame.letterPressed('a')&&!(player[1].getPositionX()<border+player[1].getR()))
            {
                player[1].setVelocityX(-5);
            }

            for(int i=0;i<2;i++)    //Puck colliding with player
            {
                for(int j=0;j<4;j++)
                {
                    if(player[i].getBall().collides(puck[j].getBall())&&puck[j].getAlive())
                    {
                        if(puck[j].getType())
                        {
                            puck[j].setAlive(false);
                            mainGame.removeBall(puck[j].getBall());
                            player[i].addScore();
                        }
                        double results[] = deflect(player[i].getPositionX(), player[i].getPositionY(), puck[j].getPositionX(), puck[j].getPositionY(), player[i].getVelocityX(), player[i].getVelocityY(), puck[j].getVelocityX(), puck[j].getVelocityY());
                        puck[j].setVelocity(new Coordinates(results[2],results[3]));
                    }
                }
            }

            for(int i=0;i<4;i++)    //Puck colliding with puck
            {
                for(int j=0;j<4;j++)
                {
                    if(puck[i].getBall().collides(puck[j].getBall())&&i>j&&puck[i].getAlive())
                    {
                        double results[] = deflect(puck[i].getPositionX(), puck[i].getPositionY(), puck[j].getPositionX(), puck[j].getPositionY(), puck[i].getVelocityX(), puck[i].getVelocityY(), puck[j].getVelocityX(), puck[j].getVelocityY());
                        puck[i].setVelocity(new Coordinates(results[0],results[1]));
                        puck[j].setVelocity(new Coordinates(results[2],results[3]));
                    }
                }
            }



            for(int i=0;i<4;i++)
            {
                if(puck[i].getPositionX()<border+puck[i].getR()) //Left wall hit
                {
                    puck[i].setVelocityX(Math.abs(puck[i].getVelocityX()));
                }
                if(puck[i].getPositionX()>(width-border)-puck[i].getR()) //Right wall hit
                {
                    puck[i].setVelocityX(-Math.abs(puck[i].getVelocityX()));
                }
                if(puck[i].getPositionY()<border+puck[i].getR()) //Top wall hit
                {
                    puck[i].setVelocityY(Math.abs(puck[i].getVelocityY()));
                }
                if(puck[i].getPositionY()>(height-border)-puck[i].getR()) //Bottom wall hit
                {
                    puck[i].setVelocityY(-Math.abs(puck[i].getVelocityY()));
                }
            }




            puck[0].move(player[0].getPosition(),player[1].getPosition());
            puck[1].move(player[0].getPosition(),player[1].getPosition());
            puck[2].move(player[0].getPosition(),player[1].getPosition());
            puck[3].move(player[0].getPosition(),player[1].getPosition());

            player[0].move();
            player[1].move();

            if(goal[0].collides(puck[0].getBall())||goal[0].collides(player[1].getBall())||player[1].getScore()==2)
            {
                System.out.println("Right Player Wins!");
                text.setText("Right Player Wins!");
                Thread.sleep(5000);
                mainGame.exit();
                gameOver = true;
            }
            if(goal[0].collides(puck[0].getBall())||goal[0].collides(player[0].getBall())||player[0].getScore()==2)
            {
                System.out.println("Left Player Wins!");
                text.setText("Left Player Wins!");
                Thread.sleep(5000);
                mainGame.exit();
                gameOver = true;
            }

            Thread.sleep(16);
        }
    }

    boolean returnGameState()
    {
        return(gameOver);
    }

    private double[] deflect(double x1,double y1,double x2,double y2,double xv1,double yv1,double xv2,double yv2)
    {
    // The position and speed of each of the two balls in the x and y axis before collision.
    // YOU NEED TO FILL THESE VALUES IN AS APPROPRIATE...
    double xPosition1, xPosition2, yPosition1, yPosition2;
    double xSpeed1, xSpeed2, ySpeed1, ySpeed2;

    xPosition1 = x1;
    xPosition2 = x2;
    yPosition1 = y1;
    yPosition2 = y2;
    xSpeed1 = xv1;
    xSpeed2 = xv2;
    ySpeed1 = yv1;
    ySpeed2 = yv2;


    // Calculate initial momentum of the balls... We assume unit mass here.
    double p1InitialMomentum = Math.sqrt(xSpeed1 * xSpeed1 + ySpeed1 * ySpeed1);
    double p2InitialMomentum = Math.sqrt(xSpeed2 * xSpeed2 + ySpeed2 * ySpeed2);
    // calculate motion vectors
    double[] p1Trajectory = {xSpeed1, ySpeed1};
    double[] p2Trajectory = {xSpeed2, ySpeed2};
    // Calculate Impact Vector
    double[] impactVector = {xPosition2 - xPosition1, yPosition2 - yPosition1};
    double[] impactVectorNorm = normalizeVector(impactVector);
    // Calculate scalar product of each trajectory and impact vector
    double p1dotImpact = Math.abs(p1Trajectory[0] * impactVectorNorm[0] + p1Trajectory[1] * impactVectorNorm[1]);
    double p2dotImpact = Math.abs(p2Trajectory[0] * impactVectorNorm[0] + p2Trajectory[1] * impactVectorNorm[1]);
    // Calculate the deflection vectors - the amount of energy transferred from one ball to the other in each axis
    double[] p1Deflect = { -impactVectorNorm[0] * p2dotImpact, -impactVectorNorm[1] * p2dotImpact };
    double[] p2Deflect = { impactVectorNorm[0] * p1dotImpact, impactVectorNorm[1] * p1dotImpact };
    // Calculate the final trajectories
    double[] p1FinalTrajectory = {p1Trajectory[0] + p1Deflect[0] - p2Deflect[0], p1Trajectory[1] + p1Deflect[1] - p2Deflect[1]};
    double[] p2FinalTrajectory = {p2Trajectory[0] + p2Deflect[0] - p1Deflect[0], p2Trajectory[1] + p2Deflect[1] - p1Deflect[1]};
    // Calculate the final energy in the system.
    double p1FinalMomentum = Math.sqrt(p1FinalTrajectory[0] * p1FinalTrajectory[0] + p1FinalTrajectory[1] * p1FinalTrajectory[1]);
    double p2FinalMomentum = Math.sqrt(p2FinalTrajectory[0] * p2FinalTrajectory[0] + p2FinalTrajectory[1] * p2FinalTrajectory[1]);
   
    // Scale the resultant trajectories if we've accidentally broken the laws of physics.
    double mag = (p1InitialMomentum + p2InitialMomentum) / (p1FinalMomentum + p2FinalMomentum);
    // Calculate the final x and y speed settings for the two balls after collision.
    xSpeed1 = p1FinalTrajectory[0] * mag;
    ySpeed1 = p1FinalTrajectory[1] * mag;
    xSpeed2 = p2FinalTrajectory[0] * mag;
    ySpeed2 = p2FinalTrajectory[1] * mag;
    double array[] = {xSpeed1,ySpeed1,xSpeed2,ySpeed2};
    return(array);
    }
    /**
    * Converts a vector into a unit vector.
    * Used by the deflect() method to calculate the resultnt direction after a collision.
    */
    private double[] normalizeVector(double[] vec)
    {
    double mag = 0.0;
    int dimensions = vec.length;
    double[] result = new double[dimensions];
    for (int i=0; i < dimensions; i++)
    mag += vec[i] * vec[i];
    mag = Math.sqrt(mag);
    if (mag == 0.0)
    {
    result[0] = 1.0;
    for (int i=1; i < dimensions; i++)
    result[i] = 0.0;
    }
    else
    {
    for (int i=0; i < dimensions; i++)
    result[i] = vec[i] / mag;
    }
    return result;
    }

}