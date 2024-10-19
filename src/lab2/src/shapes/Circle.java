package lab2.src.shapes;

public class Circle extends Shape{
    private Point point;
    private double radius;

    private void validate() throws Exception {
        if (radius < 0) {
            radius = 0;
            throw new Exception("radius can't be lower than zero");
        }
    }

    public Circle() {
        this.radius = 0;
        this.point = new Point();
    }

    public Circle(Point point, double radius) throws Exception {
        this.radius = radius;
        this.point = point;
        validate();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws Exception {
        this.radius = radius;
        validate();
    }

    public void move(double moveX, double moveY) {
        point.move(moveX, moveY);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void draw() {
        System.out.println(String.format("Фигура: круг\nЦентр круга: %s\nРадиус круга: %.1f\nПлощадь круга: %.1f\nПериметр круга: %.1f\nЦвет круга: %s", point, getRadius(), getArea(), getPerimeter(), getColor()));
    }
}