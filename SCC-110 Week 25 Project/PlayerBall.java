import javax.lang.model.util.ElementScanner14;

public class PlayerBall
{

    private Ball ball; 
    private double mass = 1;
    private double frictionCo = 0;  //default value
    private static double gravity = 10; 
    private double xSpeed = 0;
    private double ySpeed = 0;

    public PlayerBall(int x,int y,int diameter,String col,double newMass)
    {
        ball = new Ball(x, y, diameter, col);
        mass = newMass;
    }
    public PlayerBall(int x,int y,int diameter,String col,double newMass,double newFrictionCo)
    {
        ball = new Ball(x, y, diameter, col);
        mass = newMass;
        frictionCo = newFrictionCo;
    }

    Ball getBall()
    {
        return(ball);
    }

    static boolean lineBallColision(Ball ball,Line line)
    {
        double x0 = ball.getXPosition();
        double y0 = ball.getYPosition();
        double r = ball.getSize()/2;
        double x1 = line.getXStart();
        double y1 = line.getYStart();
        double x2 = line.getXEnd();
        double y2 = line.getYEnd();

        y0 = -y0;
        y1 = -y1;
        y2 = -y2;

        double a = Math.abs(((x2-x1)*(y1-y0))-((x1-x0)*(y2-y1)));
        double b = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
        if((a/b)<r)
        {
            return(true);
        }
        else
        {
            return(false);
        }
    }

    static double lineBallDistance(Ball ball,Line line)
    {
        double x0 = ball.getXPosition();
        double y0 = ball.getYPosition();
        double r = ball.getSize()/2;
        double x1 = line.getXStart();
        double y1 = line.getYStart();
        double x2 = line.getXEnd();
        double y2 = line.getYEnd();

        double a = Math.abs(((x2-x1)*(y1-y0))-((x1-x0)*(y2-y1)));
        double b = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
        
        return(a/b);
    }

    static double[] lineBallClosestPoint(Ball ball,Line line,double d)
    {
        double x0 = ball.getXPosition();
        double y0 = ball.getYPosition();
        double x1 = line.getXStart();
        double y1 = line.getYStart();
        double x2 = line.getXEnd();
        double y2 = line.getYEnd();

        double a = Math.sqrt(((x1-x0)*(x1-x0))+((y1-y0)*(y1-y0))); //Distance from one corner of the line to the ball
        double b = Math.sqrt((a*a)-(d*d));                         //Distance from that corner to the closest point on the line
        double c = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))); //Distance from the two point of the line
        double ratio = b/c;                                        //Ratio of the part of the line to the whole of it
        double x3 = ((x2-x1)*ratio)+x1;
        double y3 = ((y2-y1)*ratio)+y1;
        
        double[] closestPoint = {x3,y3};
        
        return(closestPoint);
    }

}