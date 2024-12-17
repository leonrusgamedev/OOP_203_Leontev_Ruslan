package lab_classes;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        testPhone();
        testReader();
    }
    private static void testPhone() {
        Phone phone1 = new Phone("123-456", "iPhone", 150.5);
        Phone phone2 = new Phone("987-654", "Samsung");
        Phone phone3 = new Phone();

        System.out.println(phone1.getNumber() + " " + phone1.getModel() + " " + phone1.getWeight());
        System.out.println(phone2.getNumber() + " " + phone2.getModel() + " " + phone2.getWeight());
        System.out.println(phone3.getNumber() + " " + phone3.getModel() + " " + phone3.getWeight());

        phone1.receiveCall("Алексей");
        phone1.receiveCall("Алексей", "111-222");
        phone1.sendMessage("333-444", "555-666");
    }

    private static void testReader() {
        Reader reader = new Reader("Иванов Иван Иванович", "12345", "Филология", new Date(), "555-1234");
        reader.takeBook(3);
        reader.takeBook("Приключения", "Словарь", "Энциклопедия");

        Book book1 = new Book("Приключения", "Автор А");
        Book book2 = new Book("Словарь", "Автор Б");
        reader.takeBook(book1, book2);
        reader.returnBook(book1, book2);
    }
}
