package lab1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TaskC {
    public void executeTaskC(Scanner scanner) {
        System.out.println("Введите строку с несколькими словами: ");
        String sentence = scanner.nextLine();

        String result = findWordWithMinUniqueChars(sentence);
        System.out.println("Слово с минимальным количеством уникальных символов: " + result);
    }

    public String findWordWithMinUniqueChars(String sentence) {
        String[] words = sentence.split(" ");
        String minWord = "";
        int minUniqueChars = Integer.MAX_VALUE;

        for (String word : words) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
            if (uniqueChars.size() < minUniqueChars) {
                minUniqueChars = uniqueChars.size();
                minWord = word;
            }
        }
        return minWord;
    }
}