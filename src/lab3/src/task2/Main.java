package lab3.src.task2;

import lab3.src.task2.clothing.*;
import lab3.src.task2.models.Size;
import lab3.src.task2.services.Atelier;

public class Main {
    public static void main(String[] args) {
        Clothing[] clothes = {
                new TShirt(Size.M, 19.99, "синий"),
                new Pants(Size.L, 29.99, "черный"),
                new Skirt(Size.S, 24.99, "красный"),
                new Tie(Size.XS, 14.99, "зеленый")
        };

        Atelier atelier = new Atelier();

        atelier.dressWoman(clothes);
        System.out.println();
        atelier.dressMan(clothes);
    }
}

