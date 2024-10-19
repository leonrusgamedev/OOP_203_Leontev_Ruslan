package lab3.src.task2.clothing;

import lab3.src.task2.interfaces.MenClothing;
import lab3.src.task2.interfaces.WomenClothing;
import lab3.src.task2.models.Size;

public class Pants extends Clothing implements MenClothing, WomenClothing {
    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина одет в брюки. " + getInfo());
    }

    @Override
    public void dressWoman() {
        System.out.println("Женщина одета в брюки. " + getInfo());
    }
}

