package lab1;

import java.util.Scanner;

public class TaskB {
    public void executeTaskB(Scanner scanner) {
        System.out.println("Введите слова (для завершения введите пустую строку):");

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            }

            if (input.length() % 2 != 0) {
                System.out.println("Длина строки должна быть чётной!");
            } else {
                String result = getMiddle(input);
                System.out.println("Средние символы в строке '" + input + "': " + result);
            }
        }
    }

    public String getMiddle(String str) {
        int mid = str.length() / 2;
        return str.substring(mid - 1, mid + 1);
    }
}
