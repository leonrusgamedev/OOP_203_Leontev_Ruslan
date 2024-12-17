package lab_patterns;

public class Main {
    public static void main(String[] args) {
        // Singleton
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        singleton1.displayMessage();
        System.out.println("Are singleton1 and singleton2 the same instance? " + (singleton1 == singleton2));

        // Adapter
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);

        // Используем адаптер как целевой интерфейс
        adapter.request();
    }
}
