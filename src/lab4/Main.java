package lab4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое задание:");
        String task = scanner.nextLine();

        try {
            if (task.contains("квадратного уравнения")) {
                MathApiSolver.solveQuadraticEquation(task);
            } else if (task.contains("значение выражения")) {
                MathApiSolver.evaluateExpression(task);
            } else if (task.contains("уравнение")) {
                MathApiSolver.solveEquation(task);
            } else {
                System.out.println("Неизвестный тип задачи.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при обработке задачи: " + e.getMessage());
        }
    }
}
