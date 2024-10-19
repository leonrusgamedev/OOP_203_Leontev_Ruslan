package lab3.src;

/**
 * Класс Vector представляет двумерный вектор в пространстве.
 */
public class Vector {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    /**
     * Конструктор с параметрами.
     *
     * @param x1 координата x начала вектора
     * @param y1 координата y начала вектора
     * @param x2 координата x конца вектора
     * @param y2 координата y конца вектора
     */
    public Vector(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Конструктор без параметров.
     * Инициализирует вектор с началом и концом в (0, 0).
     */
    public Vector() {
        this(0, 0, 0, 0);
    }

    /**
     * Возвращает координату x начала вектора.
     *
     * @return координата x начала вектора
     */
    public double getX1() {
        return x1;
    }

    /**
     * Возвращает координату y начала вектора.
     *
     * @return координата y начала вектора
     */
    public double getY1() {
        return y1;
    }

    /**
     * Возвращает координату x конца вектора.
     *
     * @return координата x конца вектора
     */
    public double getX2() {
        return x2;
    }

    /**
     * Возвращает координату y конца вектора.
     *
     * @return координата y конца вектора
     */
    public double getY2() {
        return y2;
    }

    /**
     * Устанавливает координату x начала вектора.
     *
     * @param x1 новая координата x начала вектора
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }

    /**
     * Устанавливает координату y начала вектора.
     *
     * @param y1 новая координата y начала вектора
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }

    /**
     * Устанавливает координату x конца вектора.
     *
     * @param x2 новая координата x конца вектора
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }

    /**
     * Устанавливает координату y конца вектора.
     *
     * @param y2 новая координата y конца вектора
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }

    /**
     * Вычисляет векторное произведение этого вектора и другого вектора.
     * Для двумерных векторов результатом является скаляр (z-компонента).
     *
     * @param v вектор, с которым выполняется векторное произведение
     * @return векторное произведение (z-компонента)
     */
    public double crossProduct(Vector v) {
        return (this.x2 - this.x1) * (v.y2 - v.y1) - (this.y2 - this.y1) * (v.x2 - v.x1);
    }

    /**
     * Вычисляет скалярное произведение этого вектора и другого вектора.
     *
     * @param v вектор, с которым выполняется скалярное произведение
     * @return скалярное произведение
     */
    public double dotProduct(Vector v) {
        return (this.x2 - this.x1) * (v.x2 - v.x1) + (this.y2 - this.y1) * (v.y2 - v.y1);
    }

    /**
     * Вычисляет длину вектора.
     *
     * @return длина вектора
     */
    public double length() {
        return Math.sqrt(Math.pow(this.x2 - this.x1, 2) + Math.pow(this.y2 - this.y1, 2));
    }

    /**
     * Умножает вектор на скаляр.
     *
     * @param scalar значение, на которое умножается вектор
     * @return новый вектор, полученный умножением на скаляр
     */
    public Vector multiply(double scalar) {
        double newX2 = this.x1 + scalar * (this.x2 - this.x1);
        double newY2 = this.y1 + scalar * (this.y2 - this.y1);
        return new Vector(this.x1, this.y1, newX2, newY2);
    }

    /**
     * Вычисляет сумму этого вектора и другого вектора.
     *
     * @param v вектор, с которым выполняется сложение
     * @return новый вектор, являющийся суммой двух векторов
     */
    public Vector add(Vector v) {
        double newX2 = this.x2 + (v.x2 - v.x1);
        double newY2 = this.y2 + (v.y2 - v.y1);
        return new Vector(this.x1, this.y1, newX2, newY2);
    }

    /**
     * Вычисляет разность этого вектора и другого вектора.
     *
     * @param v вектор, с которым выполняется вычитание
     * @return новый вектор, являющийся разностью двух векторов
     */
    public Vector subtract(Vector v) {
        double newX2 = this.x2 - (v.x2 - v.x1);
        double newY2 = this.y2 - (v.y2 - v.y1);
        return new Vector(this.x1, this.y1, newX2, newY2);
    }

    /**
     * Основной метод для тестирования работы класса Vector.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создать объект класса, вызвав конструктор с параметрами
        Vector v1 = new Vector(1, 2, 3, 4);

        // Создать объект класса, вызвав конструктор без параметров
        Vector v2 = new Vector();

        // Вызвать каждый из методов
        System.out.println("Векторное произведение: " + v1.crossProduct(v2));
        System.out.println("Скалярное произведение: " + v1.dotProduct(v2));
        System.out.println("Длина вектора v1: " + v1.length());

        Vector v3 = v1.multiply(2);
        System.out.println("Умножение v1 на 2: (" + v3.getX2() + ", " + v3.getY2() + ")");

        Vector v4 = v1.add(v2);
        System.out.println("Сумма v1 и v2: (" + v4.getX2() + ", " + v4.getY2() + ")");

        Vector v5 = v1.subtract(v2);
        System.out.println("Разность v1 и v2: (" + v5.getX2() + ", " + v5.getY2() + ")");
    }
}
