package lab1;

public class TaskA {
    public void executeTaskA() {
        System.out.println("Task A");
        for (int i = 0; i <= 300; i++) {
            if (i % 4 == 0 && i % 6 != 0 && sumOfDigits(i) < 10) {
                System.out.println(i);
            }
        }
    }

    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

