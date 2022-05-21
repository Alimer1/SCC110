public class BallObject
{

    private Ball ball; 
    private double mass = 1;
    private double frictionCo = 0;  //default value
    private static double gravity = 10; 
    private double xSpeed = 0;
    private double ySpeed = 0;
    private double xAcceleration;
    private double yAcceleration;

    public BallObject(int x,int y,int diameter,String col,double newMass)
    {
        ball = new Ball(x, y, diameter, col);
        mass = newMass;
    }
    public BallObject(int x,int y,int diameter,String col,double newMass,double newFrictionCo)
    {
        ball = new Ball(x, y, diameter, col);
        mass = newMass;
        frictionCo = newFrictionCo;
    }


    void ApplyForce(double x,double y)
    {
        xAcceleration = x/mass;
        yAcceleration = y/mass;
    }


    void Update()
    {
        xSpeed = xSpeed + xAcceleration;
        ySpeed = ySpeed + yAcceleration;






    }

}