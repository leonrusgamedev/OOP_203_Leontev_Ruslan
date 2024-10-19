package lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TaskA taskA = new TaskA();
        taskA.executeTaskA();

        TaskB taskB = new TaskB();
        taskB.executeTaskB(scanner);

        TaskC taskC = new TaskC();
        taskC.executeTaskC(scanner);

        TaskD taskD = new TaskD();
        taskD.executeTaskD(scanner);

        scanner.close();
    }
}
