package lab1;

public class TaskB {
    public void executeTaskB() {
        System.out.println("Task B");
        String result1 = getMiddle("string");  // Ожидается: "ri"
        String result2 = getMiddle("code");    // Ожидается: "od"
        String result3 = getMiddle("Practice");// Ожидается: "ct"

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public String getMiddle(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Длина строки должна быть чётной!");
        }
        int mid = str.length() / 2;
        return str.substring(mid - 1, mid + 1);
    }
}
