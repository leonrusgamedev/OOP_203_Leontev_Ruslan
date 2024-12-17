package lab_patterns;

class Singleton {
    private static Singleton instance;

    // Приватный конструктор для запрета создания объектов через new
    private Singleton() {
        System.out.println("Singleton Instance Created");
    }

    // Метод для получения единственного экземпляра
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void displayMessage() {
        System.out.println("Hello from Singleton!");
    }
}