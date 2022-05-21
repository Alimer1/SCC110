public class Player
{

    Ball ball;
    double x;
    double y;
    double r = 25;
    int score = 0;

    public Player(int number)
    {
        ball = new Ball(250+(500*number), 250,50, "White");    
    }

    Ball getBall()
    {
        return(ball);
    }
    double getX()
    {
        x = ball.getXPosition();
        return(x);
    }
    double getY()
    {
        y = ball.getYPosition();
        return(y);
    }
    void setX(double nx)
    {
        x = nx;
        ball.setXPosition(x);
    }
    void setY(double ny)
    {
        y = ny;
        ball.setYPosition(y);
    }
}