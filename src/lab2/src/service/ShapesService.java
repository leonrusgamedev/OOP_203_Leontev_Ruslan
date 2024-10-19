package lab2.src.service;

import lab2.src.colors.Color;
import lab2.src.shapes.Shape;

import java.util.List;
import java.util.Set;

public interface ShapesService {
    double getSquares(List<Shape> shapeList);
    double getMaxPerimeters(List<Shape> shapeList);
    Set<Color> getColors(List<Shape> shapeList);
}
