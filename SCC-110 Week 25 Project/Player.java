public class Player
{

    private Ball ball;
    private Coordinates position;
    private Coordinates velocity;
    private double r = 25;
    private int score = 0;

    public Player(int number)
    {
        ball = new Ball(250+(500*number), 250,50, "White");    
        position = new Coordinates(ball.getXPosition(), ball.getYPosition());
        velocity = new Coordinates(0,0);
    }

    Ball getBall()
    {
        return(ball);
    }

    double getR()
    {
        return(r);
    }

    //Position functions

    double getPositionX()
    {
        position.setX(ball.getXPosition());
        return(position.getX());
    }
    double getPositionY()
    {
        position.setY(ball.getYPosition());
        return(position.getY());
    }
    Coordinates getPosition()
    {
        position.setX(ball.getXPosition());
        position.setY(ball.getYPosition());
        return(position);
    }
    void setPositionX(double nx)
    {
        position.setX(nx);
        ball.setXPosition(nx);
    }
    void setPositionY(double ny)
    {
        position.setY(ny);
        ball.setYPosition(ny);
    }
    void setPosition(Coordinates np)
    {
        position = np;
        ball.setXPosition(np.getX());
        ball.setYPosition(np.getY());
    }

    //Velocity functions

    double getVelocityX()
    {
        return(velocity.getX());
    }
    double getVelocityY()
    {
        return(velocity.getY());
    }
    Coordinates getVelocity()
    {
        return(velocity);
    }
    void setVelocityX(double nx)
    {
        velocity.setX(nx);
    }
    void setVelocityY(double ny)
    {
        velocity.setY(ny);
    }
    void setVelocity(Coordinates np)
    {
        velocity = np;
    }
    void move()
    {
        setPositionX(getPositionX()+getVelocityX());
        setPositionY(getPositionY()+getVelocityY());
    }
}