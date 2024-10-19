package lab3.src.task2.services;

import lab3.src.task2.clothing.Clothing;
import lab3.src.task2.interfaces.MenClothing;
import lab3.src.task2.interfaces.WomenClothing;

public class Atelier {
    // Метод для одевания женщин
    public void dressWoman(Clothing[] clothes) {
        System.out.println("Одеваем женщин:");
        for (Clothing clothing : clothes) {
            if (clothing instanceof WomenClothing) {
                ((WomenClothing) clothing).dressWoman();
            }
        }
    }

    // Метод для одевания мужчин
    public void dressMan(Clothing[] clothes) {
        System.out.println("Одеваем мужчин:");
        for (Clothing clothing : clothes) {
            if (clothing instanceof MenClothing) {
                ((MenClothing) clothing).dressMan();
            }
        }
    }
}

