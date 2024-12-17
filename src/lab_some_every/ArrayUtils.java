package lab_some_every;

import java.util.function.Predicate;

public class ArrayUtils {

    // Метод every: возвращает true, если все элементы соответствуют условию
    public static <T> boolean every(T[] array, Predicate<T> condition) {
        for (T element : array) {
            if (!condition.test(element)) {
                return false; // Если хоть один элемент не прошел проверку
            }
        }
        return true; // Все элементы соответствуют условию
    }

    // Метод some: возвращает true, если хотя бы один элемент соответствует условию
    public static <T> boolean some(T[] array, Predicate<T> condition) {
        for (T element : array) {
            if (condition.test(element)) {
                return true; // Если хотя бы один элемент прошел проверку
            }
        }
        return false; // Ни один элемент не соответствует условию
    }
}