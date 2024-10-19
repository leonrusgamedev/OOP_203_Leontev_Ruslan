package lab3.src.task2.clothing;

import lab3.src.task2.interfaces.MenClothing;
import lab3.src.task2.models.Size;

public class Tie extends Clothing implements MenClothing {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Мужчина одет в галстук. " + getInfo());
    }
}
