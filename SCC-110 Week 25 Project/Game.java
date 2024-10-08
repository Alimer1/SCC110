public class Game
{

    private int width = 1200;
    private int height = 800;
    private int border = 100;

    private GameArena mainGame = new GameArena(width,height);
    private Puck puck[] = new Puck[4];
    private Player player[] = new Player[2];
    private Line wall[] = new Line[4];
    private Ball goal[] = new Ball[2];
    private Text text[] = new Text[6];  //0=left score,1=right score,2=countdown,3-5=gameover text
    private Rectangle background = new Rectangle(border, border, width-(2*border),height-(2*border),"DARKGREY",-3);

    private int playerLeftScore = 0;
    private int playerRightScore = 0;

    private boolean loop = true;


    public Game()
    {
        gameSetup();

        gameLoop();
    }

    private void countDownTimer()
    {
        text[2].setText("5");
        mainGame.pause(1000);
        text[2].setText("4");
        mainGame.pause(1000);
        text[2].setText("3");
        mainGame.pause(1000);
        text[2].setText("2");
        mainGame.pause(1000);
        text[2].setText("1");
        mainGame.pause(1000);
        text[2].setText("");
    }

    private void gameLoop()
    {
        while(true)    //Main loop of the program that triggers 60 times a second
        {
            if(loop==true)
            {
                player[0].setVelocity(new Coordinates(0,0));
                player[1].setVelocity(new Coordinates(0,0));
    
                playerMovement();
    
                puckPlayerCollision();
    
                puckPuckCollision();
                
                puckWallCollision();
    
                move();
    
                scoreCheck();
            }
            else
            {
                menuInput();
            }
            mainGame.pause(16);
        }
    }

    private void gameSetup()
    {
        if(playerRightScore>playerLeftScore)
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
        player[0] = new Player(((6*(width-(2*border)))/8)+border, height/2);
        player[1] = new Player(((2*(width-(2*border)))/8)+border, height/2);
        wall[0] = new Line(border, border, width-border, border, 5, "RED");
        wall[1] = new Line(width-border, border, width-border, height-border, 5, "RED");
        wall[2] = new Line(width-border, height-border, border, height-border, 5, "RED");
        wall[3] = new Line(border, height-border, border, border, 5, "RED");
        goal[0] = new Ball(((1*(width-(2*border)))/8)+border,height/2,100,"GREY",-1);
        goal[1] = new Ball(((7*(width-(2*border)))/8)+border,height/2,100,"GREY",-1);
        text[0] = new Text("Left Player Score is: "+playerLeftScore, border/2,border, border-5, "WHITE");
        text[1] = new Text("Right Player Score is: "+playerRightScore, border/2, border, (border/2)-5, "WHITE");
        text[2] = new Text("",200,(width/2)-60,height/2,"RED",2);
        text[3] = new Text("Left Player Wins",50,border,height-border-105,"WHITE",1);
        text[4] = new Text("Press SPACE to Restart",50,border,height-border-55,"WHITE",1);
        text[5] = new Text("Press ESC to Quit",50,border,height-border-5,"WHITE",1);


        mainGame.clearGameArena();
        mainGame.addBall(puck[0].getBall());
        mainGame.addBall(puck[1].getBall());
        mainGame.addBall(puck[2].getBall());
        mainGame.addBall(puck[3].getBall());
        mainGame.addBall(player[0].getBall());
        mainGame.addBall(player[1].getBall());
        mainGame.addLine(wall[0]);
        mainGame.addLine(wall[1]);
        mainGame.addLine(wall[2]);
        mainGame.addLine(wall[3]);
        mainGame.addBall(goal[0]);
        mainGame.addBall(goal[1]);
        mainGame.addText(text[0]);
        mainGame.addText(text[1]);
        mainGame.addText(text[2]);
        mainGame.addRectangle(background);
        countDownTimer();
    }

    private void scoreCheck()
    {
        boolean rW = goal[0].collides(puck[0].getBall())||goal[0].collides(player[1].getBall())||player[1].getScore()==2;
        boolean lW = goal[1].collides(puck[0].getBall())||goal[1].collides(player[0].getBall())||player[0].getScore()==2;
        if(rW)
        {
            playerRightScore++;
        }
        if(lW)
        {
            playerLeftScore++;
        }
        if(playerLeftScore>5||playerRightScore>5)
        {
            if(playerLeftScore>5)
            {
                text[3].setText("Left Player Wins");
            }
            if(playerRightScore>5)
            {
                text[3].setText("Right Player Wins");
            }
            mainGame.addText(text[3]);
            mainGame.addText(text[4]);
            mainGame.addText(text[5]);
            loop = false;
        }
        else
        {
            if(rW||lW)
            {
                gameSetup();
            }
        }
    }

    private void move()
    {
        puck[0].move(player[0].getPosition(),player[1].getPosition());
        puck[1].move(player[0].getPosition(),player[1].getPosition());
        puck[2].move(player[0].getPosition(),player[1].getPosition());
        puck[3].move(player[0].getPosition(),player[1].getPosition());

        player[0].move();
        player[1].move();
    }

    private void puckWallCollision()
    {
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
    }

    private void puckPuckCollision()
    {
        for(int i=0;i<4;i++)    //Puck colliding with puck
        {
            for(int j=0;j<4;j++)
            {
                if(puck[i].getBall().collides(puck[j].getBall())&&i>j&&puck[i].getAlive()&&puck[j].getAlive())
                {
                    double results[] = deflect(puck[i].getPositionX(), puck[i].getPositionY(), puck[j].getPositionX(), puck[j].getPositionY(), puck[i].getVelocityX(), puck[i].getVelocityY(), puck[j].getVelocityX(), puck[j].getVelocityY());
                    puck[i].setVelocity(new Coordinates(results[0],results[1]));
                    puck[j].setVelocity(new Coordinates(results[2],results[3]));
                }
            }
        }
    }

    private void puckPlayerCollision()
    {
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
                    else
                    {
                        double results[] = deflect(player[i].getPositionX(),player[i].getPositionY(),puck[j].getPositionX(),puck[j].getPositionY(),player[i].getVelocityX(),player[i].getVelocityY(),puck[j].getVelocityX(),puck[j].getVelocityY());
                        if(Double.isNaN(results[0])||Double.isNaN(results[1]))
                        {
                            System.out.println("Error Happened");
                        }
                        else
                        {
                            puck[j].setVelocity(new Coordinates(results[2],results[3]));
                        }

                    }
                }
            }
        }
    }

    private void playerMovement()
    {
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
    }

    private void menuInput()
    {
        if(mainGame.spacePressed())
        {
            playerLeftScore = 0;
            playerRightScore = 0;
            loop = true;
            mainGame.addText(text[3]);
            mainGame.addText(text[4]);
            mainGame.removeText(text[5]);
            gameSetup();
        }
        if(mainGame.escPressed())
        {
            mainGame.exit();
        }
    }

    private double[] deflect(double x1,double y1,double x2,double y2,double xv1,double yv1,double xv2,double yv2)
    {
    // The position and speed of each of the two balls in the x and y axis before collision.
    // Calculate initial momentum of the balls... We assume unit mass here.
    double p1InitialMomentum = Math.sqrt(xv1 * xv1 + yv1 * yv1);
    double p2InitialMomentum = Math.sqrt(xv2 * xv2 + yv2 * yv2);
    // calculate motion vectors
    double[] p1Trajectory = {xv1, yv1};
    double[] p2Trajectory = {xv2, yv2};
    // Calculate Impact Vector
    double[] impactVector = {x2 - x1, y2 - y1};
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
    xv1 = p1FinalTrajectory[0] * mag;
    yv1 = p1FinalTrajectory[1] * mag;
    xv2 = p2FinalTrajectory[0] * mag;
    yv2 = p2FinalTrajectory[1] * mag;
    double array[] = {xv1,yv1,xv2,yv2};
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