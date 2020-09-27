package FACTORY;

enum CoordinateSystem
{
    CARTESIAN,
    POLAR
}

public class Point {
    private double x, y;

    /**
     * UGLY :: not clear about what a & b are
     * @param a is x if cartesian or rho if polar
     * @param b is y if cartesian or theta if polar
     * @param cs
     */
    public Point(double a, double b, CoordinateSystem cs) {
        switch(cs) {
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                x = a * Math.cos(b);
                x = a * Math.sin(b);
                break;
        }
    }

    // One SOLUTION ::

    // notice the PRIVATE constructor here
    private Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    // we create two explicit STATIC factory methods,
    // calling the unexplicit private construction using (x,y)
    public static Point newCartesianPoint(double x, double y)
    {
        return new Point(x,y);
    }

    public static Point newPolarPoint(double rho, double theta){
        return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
    }

    // same solution within a factory class
    // the factory must be static (as we can have statics method inside)
    // and this factory class must within the class related.
    public static class PointFactory {
        public static Point newCartesianPoint(double x, double y)
        {

            return new Point(x,y);
        }

        public static Point newPolarPoint(double rho, double theta){
            return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
        }

    }

}



class Demo {
    public static  void main(String[] args) {

        Point point = Point.newPolarPoint(2,3); // one way

        //or another
        Point point1 = Point.PointFactory.newCartesianPoint(5,5);
        Point point2 = Point.PointFactory.newPolarPoint(6,7);
    }
}
