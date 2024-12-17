package lab_patterns;


// Адаптер, который делает Adaptee совместимым с Target
class Adapter implements Target {
    private Adaptee adaptee;

    // Передаем адаптируемый объект в конструктор
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // Перенаправляем вызов на метод Adaptee
        adaptee.specificRequest();
    }
}
