package ua.nure.shopynskyi.Task2;

public class Circle {
    private double x;
    private double y;
    private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public static void main(String[] args) {

        System.out.println("~~~ c");
        Circle c = new Circle(0, 0, 1);
        c.print();

        System.out.println("~~~ c.move(1, 1)");
        c.move(1, 1);
        c.print();

        System.out.println("~~~ c.isInside(1, 1)");
        System.out.println(c.isInside(1, 1));

        System.out.println("~~~ c.isInside(10, 1)");
        System.out.println(c.isInside(10, 1));

        System.out.println("~~~ c2");
        Circle c2 = new Circle(1, 1, 2);
        c2.print();

        System.out.println("~~~ c.isInside(c2)");
        System.out.println(c.isInside(c2));

        System.out.println("~~~ c2.isInside(c)");
        System.out.println(c2.isInside(c));

    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public boolean isInside(double x, double y) {
        return getDistance(this.x, this.y, x, y) <= this.r;
    }

    public boolean isInside(Circle c) {
        return getDistance(this.x, this.y, c.x, c.y) <= this.r - c.r;
    }

    public void print() {
        System.out.println(this);
    }

    // Returns the distance between two points, having x and y coordinates
    private double getDistance(double x1, double y1,
                               double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) +
                (y2 - y1) * (y2 - y1));
    }

    @Override
    public String toString() {
        return "Circle (" + this.x + ", " +
                this.y + ", " + this.r + ")";
    }

}
