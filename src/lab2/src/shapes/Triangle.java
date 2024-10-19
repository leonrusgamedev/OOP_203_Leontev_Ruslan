package lab2.src.shapes;

public class Triangle extends Shape{
    private Point A;
    private Point B;
    private Point C;
    private void validate() throws Exception {
        if (getArea() <= 1e-7) {
            throw new Exception("can't create rectangle. Area is zero.");
        }
    }

    public Triangle() {
        this.A = new Point(0, 0);
        this.B = new Point(0, 0);
    }

    public Triangle(Point A, Point B, Point C) throws Exception {
        this.A = A;
        this.B = B;
        this.C = C;
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

    public Point getC() {
        return C;
    }

    public void setC(Point point) throws Exception {
        this.C = point;
        validate();
    }

    public void move(double moveX, double moveY) {
        A.move(moveX, moveY);
        B.move(moveX, moveY);
        C.move(moveX, moveY);
    }

    public double getArea() {
        Point vectorA = new Point(B.X - A.X, B.Y - A.Y);
        Point vectorB = new Point(C.X - A.X, C.Y - A.Y);
        return Math.abs(0.5 * (vectorA.X * vectorB.Y + vectorB.X * vectorA.Y));
    }

    public double getPerimeter() {
        Point vectorA = new Point(B.X - A.X, B.Y - A.Y);
        Point vectorB = new Point(C.X - A.X, C.Y - A.Y);
        Point vectorC = new Point(B.X - C.X, B.Y - C.Y);

        double perimeter = Math.sqrt(vectorA.X * vectorA.X + vectorA.Y * vectorA.Y)
                + Math.sqrt(vectorB.X * vectorB.X + vectorB.Y * vectorB.Y)
                + Math.sqrt(vectorC.X * vectorC.X + vectorC.Y * vectorC.Y);

        return perimeter;
    }

    public void draw() {
        System.out.println(String.format("Фигура: треугольник\nA: %s\nB: %s\nC: %s\nПлощадь треугольника: %.1f\nПериметр треугольника: %.1f\nЦвет треугольника: %s", getA(), getB(), getC(), getArea(), getPerimeter(), getColor()));
    }
}
