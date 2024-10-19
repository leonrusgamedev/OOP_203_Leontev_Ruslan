package lab2.src.shapes;

import lab2.src.colors.Color;

public abstract class Shape {
    private Color color = Color.TRANSPARENT;
    private double area = 0;
    private double perimeter = 0;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void draw() {}

    public Shape withColor(Color color) {
        this.color = color;
        return this;
    }
}