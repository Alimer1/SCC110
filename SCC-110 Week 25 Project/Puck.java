public class Puck
{
    private Ball ball;
    private Coordinates position;
    private Coordinates velocity;
    private double r = 10;
    private boolean type; // true = magnet, false = puck 

    public Puck(double nx,double ny,boolean nType)
    {
        type = nType;
        ball = new Ball(nx, ny, r*2, "YELLOW");
        position = new Coordinates(nx, ny);
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