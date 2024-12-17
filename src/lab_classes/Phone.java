package lab_classes;

public class Phone {
    private String number;
    private String model;
    private double weight;

    // Конструктор без параметров
    public Phone() {
        this("Unknown", "Unknown");
    }

    // Конструктор с двумя параметрами
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    // Конструктор с тремя параметрами
    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + " с номера " + callerNumber);
    }

    public void sendMessage(String... numbers) {
        System.out.println("Сообщение отправлено на номера:");
        for (String num : numbers) {
            System.out.println(num);
        }
    }

    // Getters и Setters для JavaBean
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}