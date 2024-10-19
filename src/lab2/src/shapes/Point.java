package lab2.src.shapes;

public class Point extends Shape{
    public double X;
    public double Y;

    public Point(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public Point() {
        this.X = 0;
        this.Y = 0;
    }

    public void move(double moveX, double moveY) {
        X += moveX;
        Y += moveY;
    }

    public String toString() {
        return String.format("(X = %.1f, Y = %.1f)", X, Y);
    }
}