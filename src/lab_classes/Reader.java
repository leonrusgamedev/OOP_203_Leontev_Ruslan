package lab_classes;

import java.util.Date;

public class Reader {
    private String fullName;
    private String cardNumber;
    private String faculty;
    private Date birthDate;
    private String phone;

    public Reader(String fullName, String cardNumber, String faculty, Date birthDate, String phone) {
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public void takeBook(int count) {
        System.out.println(fullName + " взял " + count + " книги.");
    }

    public void takeBook(String... bookTitles) {
        System.out.println(fullName + " взял книги: " + String.join(", ", bookTitles));
    }

    public void takeBook(Book... books) {
        System.out.print(fullName + " взял книги: ");
        for (Book book : books) {
            System.out.print(book.getTitle() + " ");
        }
        System.out.println();
    }

    public void returnBook(int count) {
        System.out.println(fullName + " вернул " + count + " книги.");
    }

    public void returnBook(String... bookTitles) {
        System.out.println(fullName + " вернул книги: " + String.join(", ", bookTitles));
    }

    public void returnBook(Book... books) {
        System.out.print(fullName + " вернул книги: ");
        for (Book book : books) {
            System.out.print(book.getTitle() + " ");
        }
        System.out.println();
    }
}
