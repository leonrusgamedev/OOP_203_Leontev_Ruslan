package lab2.src;

import lab2.src.colors.Color;
import lab2.src.service.ShapesService;
import lab2.src.service.impl.ShapesServiceImpl;
import lab2.src.shapes.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Triangle(new Point(0,0), new Point(0,4), new Point(4,0)).withColor(Color.RED));
        shapes.add(new Circle(new Point(3, 3), 2).withColor(Color.WHITE));
        shapes.add(new Circle(new Point(2, 5), 4).withColor(Color.YELLOW));
        shapes.add(new Rectangle(new Point(1, 1), new Point(5, 2)));
        shapes.add(new Point(100, 100));
        shapes.add(new Triangle(new Point(-2,3), new Point(4,3), new Point(2,5)).withColor(Color.BLUE));

        ShapesService service = new ShapesServiceImpl();
        System.out.println(service.getColors(shapes));
        System.out.println(service.getSquares(shapes));
        System.out.println(service.getMaxPerimeters(shapes));

        System.out.println();

        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw();
            System.out.println();
        }
    }
}