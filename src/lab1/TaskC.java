package lab1;

import java.util.HashSet;
import java.util.Set;

public class TaskC {
    public void executeTaskC() {
        System.out.println("Task C");
        String sentence = "fffff ab f 1234 jkjk";
        String result = findWordWithMinUniqueChars(sentence); // Ожидается: "fffff"
        System.out.println(result);
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
