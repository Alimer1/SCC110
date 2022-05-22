public class Coordinates
{

    private double x;
    private double y;


    public Coordinates(double nx,double ny)
    {
        x = nx;
        y = ny;
    }

    double distanceFromOrigin()
    {
        return(Math.sqrt((x*x)+(y*y)));
    }

    void setX(double nx)
    {
        x = nx;
    }

    void setY(double ny)
    {
        y = ny;
    }

    double getX()
    {
        return(x);
    }

    double getY()
    {
        return(y);
    }

    static Coordinates ballToCoordinates(Ball ball)
    {
        Coordinates result = new Coordinates(ball.getXPosition(), ball.getYPosition());
        return(result);
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
        double x1 = line.getXStart();
        double y1 = line.getYStart();
        double x2 = line.getXEnd();
        double y2 = line.getYEnd();

        double a = Math.abs(((x2-x1)*(y1-y0))-((x1-x0)*(y2-y1)));
        double b = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
        
        return(a/b);
    }

    static double linePointDistance(double x0,double y0, double x1, double y1, double x2, double y2) // (0) = Point   (1,2) = Line
    {
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

    static double[] linePointClosestPoint(double x0,double y0, double x1, double y1, double x2, double y2,double d) // (0) = Point   (1,2) = Line
    {
        double a = Math.sqrt(((x1-x0)*(x1-x0))+((y1-y0)*(y1-y0))); //Distance from one corner of the line to the ball
        double b = Math.sqrt((a*a)-(d*d));                         //Distance from that corner to the closest point on the line
        double c = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))); //Distance from the two point of the line
        double ratio = b/c;                                        //Ratio of the part of the line to the whole of it
        double x3 = ((x2-x1)*ratio)+x1;
        double y3 = ((y2-y1)*ratio)+y1;
        
        double[] closestPoint = {x3,y3};

        return(closestPoint);
    }

    static double[] speedAfterCollision(double x0,double y0,double x1,double y1)   //x0,y0 = Speed Vector x1,y1 = Closest Point On the Line
    {
        double speedVector[] = {x0,y0};
        double distance = linePointDistance(x0, y0, x1, y1, 0, 0);
        double deletedVector[] = linePointClosestPoint(x0, y0, x1, y1, 0, 0, distance);
        speedVector[0] = deletedVector[0];
        speedVector[1] = deletedVector[1];
        return(speedVector);
    }

    static double angleBetween (Coordinates v0,Coordinates v1)  //Calculating the angle between two Vectors
    {
        double a = (v0.getX()*v1.getX())+(v0.getY()*v1.getY());
        double b = Math.sqrt((v0.getX()*v0.getX())+(v0.getY()*v0.getY()));
        double c = Math.sqrt((v1.getX()*v1.getX())+(v1.getY()*v1.getY()));
        double angle = Math.acos(a/(b*c));
        return(angle);
    }

    static Coordinates remainingVelocityVector(double angle,Coordinates v1,Coordinates v2)  //v1 = line v2 = speed
    {
        double Line = v1.distanceFromOrigin();
        //System.out.println("ugghhh:"+v1.getX()+"/"+v1.getY());
        //System.out.println(Line);
        double cos = Math.cos(angle);
        //System.out.println(cos);
        double sLine = cos * v2.distanceFromOrigin();
        //System.out.println(sLine);
        double ratio = sLine/Line;
        System.out.println("Ratio:"+ratio);
        Coordinates f0 = new Coordinates(v1.getX()*ratio,v1.getY()*ratio);
        Coordinates answer = new Coordinates(v2.getX()-f0.getX(),v2.getY()-f0.getY());
        System.out.println("X:"+answer.getX());
        System.out.println("Y:"+answer.getY());
        return(answer);
    }

    static Coordinates add(Coordinates v1, Coordinates v2)
    {
        v1.setX(v1.getX()+v2.getX());
        v1.setY(v1.getY()+v2.getY());
        return(v1);
    }

    static Coordinates sub(Coordinates v1, Coordinates v2)
    {
        v1.setX(v1.getX()-v2.getX());
        v1.setY(v1.getY()-v2.getY());
        return(v1);
    }

}