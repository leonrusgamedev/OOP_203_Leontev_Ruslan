package lab3.src.task2.clothing;

import lab3.src.task2.models.Size;

public abstract class Clothing {
    protected Size size;
    protected double price;
    protected String color;

    public Clothing(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    // Метод для получения информации об одежде
    public String getInfo() {
        return "Размер: " + size + " (евро размер: " + size.getEuroSize() + "), цена: " + price + ", цвет: " + color;
    }
}
