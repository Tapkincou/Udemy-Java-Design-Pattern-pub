package PROTOTYPE;

public class Exercice {

    public static void main(String[] args) {
        Point a = new Point(2,2);
        Point b = new Point(3,3);

        Line l1 = new Line(a,b);
        Line l2 = l1.deepCopy();
        l1.end = new Point(100,100);
        l2.start = new Point(50,50);

        System.out.println(l1);
        System.out.println(l2);


    }
}

class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point other){
        this(other.x, other.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }


    public Line deepCopy()
    {
        return new Line(new Point(start),new Point(end));
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}


