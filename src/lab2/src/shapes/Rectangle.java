package lab2.src.shapes;

public class Rectangle extends Shape {
    private Point A;
    private Point B;

    private void validate() throws Exception {
        if (Math.abs(A.X - B.X) < 1e-7) {
            throw new Exception("can't create rectangle. X coordinates are same.");
        }
        if (Math.abs(A.Y - B.Y) < 1e-7) {
            throw new Exception("can't create rectangle. Y coordinates are same.");
        }
    }

    public Rectangle() {
        this.A = new Point(0, 0);
        this.B = new Point(0, 0);
    }

    public Rectangle(Point A, Point B) throws Exception {
        this.A = A;
        this.B = B;
        validate();
    }

    public Point getA() {
        return A;
    }

    public void setA(Point point) throws Exception {
        this.A = point;
        validate();
    }

    public Point getB() {
        return B;
    }

    public void setB(Point point) throws Exception {
        this.B = point;
        validate();
    }

    public void move(double moveX, double moveY) {
        A.move(moveX, moveY);
        B.move(moveX, moveY);
    }

    public double getArea() {
        return Math.abs((A.X - B.X) * (A.Y - B.Y));
    }

    public double getPerimeter() {
        return 2 * Math.abs((A.X - B.X) + (A.Y - B.Y));
    }

    public void draw() {
        System.out.printf("Фигура: прямоугольник\nA: %s\nB: %s\nПлощадь прямоугольника: %.1f\nПериметр прямоугольника: %.1f\nЦвет прямоугольника: %s%n", getA(), getB(), getArea(), getPerimeter(), getColor());
    }
}