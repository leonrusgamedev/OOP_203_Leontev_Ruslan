package lab3.src.task2.clothing;

import lab3.src.task2.interfaces.WomenClothing;
import lab3.src.task2.models.Size;

public class Skirt extends Clothing implements WomenClothing {
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWoman() {
        System.out.println("Женщина одета в юбку. " + getInfo());
    }
}

