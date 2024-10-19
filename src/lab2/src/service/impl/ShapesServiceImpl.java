package lab2.src.service.impl;

import lab2.src.colors.Color;
import lab2.src.service.ShapesService;
import lab2.src.shapes.Shape;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShapesServiceImpl implements ShapesService {
    @Override
    public double getSquares(List<Shape> shapeList) {
        double sum = 0;
        for (int i = 0; i < shapeList.size(); i++) {
            sum += shapeList.get(i).getArea();
        }
        return sum;
    }
    @Override
    public double getMaxPerimeters(List<Shape> shapeList) {
        double max = 0;
        for (int i = 0; i < shapeList.size(); i++) {
            max = Math.max(max, shapeList.get(i).getPerimeter());
        }
        return max;
    }
    @Override
    public Set<Color> getColors(List<Shape> shapeList) {
        Set<Color> set = new HashSet<>();

        for (int i = 0; i < shapeList.size(); i++) {
            set.add(shapeList.get(i).getColor());
        }
        return set;
    }
}
