package lab_some_every;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {1, -12, 8, -4, 25, 42};

        // Пример использования метода every
        boolean allPositive = ArrayUtils.every(numbers, n -> n > 0);
        System.out.println("Все элементы больше 0: " + allPositive); // false

        // Пример использования метода some
        boolean hasPositive = ArrayUtils.some(numbers, n -> n > 0);
        System.out.println("Есть хотя бы один элемент больше 0: " + hasPositive); // true
    }
}
