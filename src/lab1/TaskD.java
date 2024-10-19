package lab1;

import java.util.Scanner;

public class TaskD {
    public void executeTaskD(Scanner scanner) {
        System.out.println("Введите предложение: ");
        String sentence = scanner.nextLine();

        int count = countLatinWords(sentence);
        System.out.println("Количество слов с латинскими буквами: " + count);
    }

    public int countLatinWords(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;

        for (String word : words) {
            if (word.matches("[a-zA-Z]+")) {
                count++;
            }
        }
        return count;
    }
}