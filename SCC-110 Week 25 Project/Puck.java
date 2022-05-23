import javax.swing.text.Position;

public class Puck
{
    private Ball ball;
    private Coordinates position;
    private Coordinates velocity;
    private double r = 10;
    private boolean type; // true = magnet, false = puck 
    private boolean alive = true;

    public Puck(double nx,double ny,boolean nType)
    {
        type = nType;
        if(type)
        {
            ball = new Ball(nx, ny, r*2, "WHITE");
        }
        else
        {
            ball = new Ball(nx, ny, r*2, "YELLOW");
        }
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

    boolean getAlive()
    {
        return(alive);
    }

    void setAlive(boolean newAlive)
    {
        alive = newAlive;
    }

    boolean getType()
    {
        return(type);
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
    void move(Coordinates p1,Coordinates p2)
    {
        if(type)
        {
            if(Coordinates.distance(position, p1)<100)
            {
                double distance = Coordinates.distance(position, p1);
                Coordinates test = Coordinates.sub(p1, position).div(new Coordinates(distance, distance)); // Unit vector from the magnet to the player
                setVelocityX(getVelocityX()+(test.getX()/distance));
                setVelocityY(getVelocityY()+(test.getY()/distance));
            }
            if(Coordinates.distance(position, p2)<100)
            {
                double distance = Coordinates.distance(position, p2);
                Coordinates test = Coordinates.sub(p2, position).div(new Coordinates(distance, distance)); // Unit vector from the magnet to the player
                setVelocityX(getVelocityX()+((test.getX()*10)/(distance)));
                setVelocityY(getVelocityY()+((test.getY()*10)/(distance)));
            }
        }


        setPositionX(getPositionX()+getVelocityX());
        setPositionY(getPositionY()+getVelocityY());
        if(Math.abs(getVelocityX())<0.001)
        {
            setVelocityX(0);
        }
        else
        {
            setVelocityX(getVelocityX()*0.99);
        }
        if(Math.abs(getVelocityY())<0.001)
        {
            setVelocityY(0);
        }
        else
        {
            setVelocityY(getVelocityY()*0.99);
        }
    }
}