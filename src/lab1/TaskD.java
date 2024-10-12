package lab1;

public class TaskD {
    public void executeTaskD() {
        System.out.println("Task D");
        String sentence = "One two three раз два три one1 two2 123";
        int count = countLatinWords(sentence); // Ожидается: 3 (One, two, three)
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
