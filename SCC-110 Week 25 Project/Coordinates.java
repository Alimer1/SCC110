public class Coordinates
{

    private double x;
    private double y;


    public Coordinates(double nx,double ny)
    {
        x = nx;
        y = ny;
    }

    double length()
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

    Coordinates add(Coordinates v1)
    {
        v1.setX(x+v1.getX());
        v1.setY(y+v1.getY());
        return(v1);
    }

    Coordinates div(Coordinates v1)
    {
        v1.setX(x/v1.getX());
        v1.setY(y/v1.getY());
        return(v1);
    }

    Coordinates mul(Coordinates v1)
    {
        v1.setX(x*v1.getX());
        v1.setY(y*v1.getY());
        return(v1);
    }

    Coordinates abs()
    {
        Coordinates abs = new Coordinates(Math.abs(x),Math.abs(y));
        return (abs);
    }

    static Coordinates add(Coordinates v1, Coordinates v2)
    {
        Coordinates v3 = new Coordinates(0,0);
        v3.setX(v1.getX()+v2.getX());
        v3.setY(v1.getY()+v2.getY());
        return(v3);
    }

    static Coordinates sub(Coordinates v1, Coordinates v2)
    {
        Coordinates v3 = new Coordinates(0,0);
        v3.setX(v1.getX()-v2.getX());
        v3.setY(v1.getY()-v2.getY());
        return(v3);
    }

    static Coordinates div(Coordinates v1, Coordinates v2)
    {
        Coordinates v3 = new Coordinates(0,0);
        v3.setX(v1.getX()/v2.getX());
        v3.setY(v1.getY()/v2.getY());
        return(v3);
    }

    static Coordinates mul(Coordinates v1, Coordinates v2)
    {
        Coordinates v3 = new Coordinates(0,0);
        v3.setX(v1.getX()*v2.getX());
        v3.setY(v1.getY()*v2.getY());
        return(v3);
    }

    static double distance(Coordinates v1, Coordinates v2)
    {
        double a = v1.getX()-v2.getX();
        double b = v1.getY()-v2.getY();
        double answer = Math.sqrt((a*a)+(b*b)); 
        return(answer);
    }

    static double angleBetween (Coordinates v0,Coordinates v1)  //Calculating the angle between two Vectors
    {
        double a = (v0.getX()*v1.getX())+(v0.getY()*v1.getY());
        double b = Math.sqrt((v0.getX()*v0.getX())+(v0.getY()*v0.getY()));
        double c = Math.sqrt((v1.getX()*v1.getX())+(v1.getY()*v1.getY()));
        double angle = Math.acos(a/(b*c));
        return(angle);
    }
}