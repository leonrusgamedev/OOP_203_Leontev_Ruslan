package lab4;

import java.io.*;
import java.util.*;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> tasks = Parser.parse("src/lab4/resource/tasks.txt");
            List<String> results = new ArrayList<>();

            int taskNumber = 1;
            for (String task : tasks) {
                results.add("===Task " + taskNumber++ + "===");
                results.add(task);

                if (task.startsWith("Решите уравнение")) {
                    results.add(solveEquation(task));
                } else if (task.startsWith("Найдите значение выражения")) {
                    results.add(solveExpression(task));
                } else if (task.startsWith("Найдите решение квадратного уравнения")) {
                    results.add(solveQuadratic(task));
                }
            }

            writeResults("src/lab4/resource/output.txt", results);
            System.out.println("Results saved to output.txt");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String solveEquation(String task) {
        try {
            // Получаем уравнение после двоеточия
            String[] parts = task.split(": ")[1].split(" = ");
            String left = parts[0].trim();
            String right = parts[1].trim();

            if (right.matches("[a-zA-Z]")) {
                // Если переменная находится справа (77 / s = 7)
                double result = Calculate.evaluate(left);
                return right + " = " + String.format("%.3f", result);
            } else if (left.matches("[a-zA-Z]")) {
                // Если переменная находится слева (s = 77 / 7)
                double result = Calculate.evaluate(right);
                return left + " = " + String.format("%.3f", result);
            } else {
                // Решаем уравнение с переменной внутри
                return solveComplexEquation(left, right);
            }
        } catch (Exception e) {
            return "Ошибка в решении уравнения: " + e.getMessage();
        }
    }

    // Решение сложного линейного уравнения
    private static String solveComplexEquation(String left, String right) {
        try {
            String variable = "";
            double constant = 0;
            double result = 0;

            // Если переменная находится в делении или умножении
            if (left.contains("/")) {
                String[] tokens = left.split("/");
                variable = tokens[1].trim();
                double lhsValue = Double.parseDouble(tokens[0].trim());
                double rhsValue = Double.parseDouble(right.trim());
                result = lhsValue / rhsValue;

            } else if (left.contains("*")) {
                String[] tokens = left.split("\\*");
                variable = tokens[1].trim();
                double lhsValue = Double.parseDouble(right.trim());
                double rhsValue = Double.parseDouble(tokens[0].trim());
                result = lhsValue / rhsValue;

            } else {
                throw new IllegalArgumentException("Уравнение не поддерживается");
            }

            return variable + " = " + String.format("%.3f", result);

        } catch (Exception e) {
            return "Ошибка в решении уравнения: " + e.getMessage();
        }
    }


    // Решение выражения
    public static String solveExpression(String task) {
        try {
            String expression = task.split(": ")[1];
            return expression + " = " + String.format("%.3f", Calculate.evaluate(expression));
        } catch (Exception e) {
            return "Ошибка в выражении";
        }
    }

    // Решение квадратного уравнения
    public static String solveQuadratic(String task) {
        try {
            // Получаем уравнение после двоеточия и удаляем все пробелы
            String equation = task.split(": ")[1].replace(" ", "");

            // Разделяем уравнение по символу "="
            String[] parts = equation.split("=");
            String leftPart = parts[0]; // Левая часть уравнения (правую не учитываем, т.к. = 0)

            // Извлекаем коэффициенты a, b и c с помощью регулярного выражения
            double a = 0, b = 0, c = 0;
            String regex = "([+-]?\\d*)\\*x\\^2|([+-]?\\d*)\\*x|([+-]?\\d+)";
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
            java.util.regex.Matcher matcher = pattern.matcher(leftPart);

            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    a = matcher.group(1).isEmpty() || matcher.group(1).equals("+") ? 1 : Double.parseDouble(matcher.group(1));
                } else if (matcher.group(2) != null) {
                    b = matcher.group(2).isEmpty() || matcher.group(2).equals("+") ? 1 : Double.parseDouble(matcher.group(2));
                } else if (matcher.group(3) != null) {
                    c = Double.parseDouble(matcher.group(3));
                }
            }

            // Проверка на корректность коэффициента a
            if (a == 0) throw new IllegalArgumentException("Коэффициент a не может быть равен 0");

            // Вычисление дискриминанта
            double finalC = c;
            BiFunction<Double, Double, Double> discriminant = (aa, bb) -> (bb * bb) - 4 * aa * finalC;
            double D = discriminant.apply(a, b);

            if (D < 0) {
                return "Корней нет, значение дискриминанта меньше нуля: " + String.format("%.3f", D);
            }

            // Вычисление корней
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);

            if (D == 0) return "x = " + String.format("%.3f", x1);
            return "x1 = " + String.format("%.3f", x1) + ", x2 = " + String.format("%.3f", x2);

        } catch (Exception e) {
            return "Ошибка в решении квадратного уравнения: " + e.getMessage();
        }
    }


    // Запись результатов
    public static void writeResults(String path, List<String> results) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (String line : results) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}

// Парсер файла
class Parser {
    public static List<String> parse(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) throw new FileNotFoundException("Файл " + path + " не найден");

        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        return lines;
    }
}

// Класс для вычислений
class Calculate {
    public static double evaluate(String expression) {
        Deque<Double> numbers = new ArrayDeque<>();
        Deque<Character> operations = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;
                numbers.push(Double.parseDouble(sb.toString()));
            } else if ("+-*/".indexOf(ch) != -1) {
                while (!operations.isEmpty() && precedence(operations.peek()) >= precedence(ch)) {
                    process(numbers, operations.pop());
                }
                operations.push(ch);
            }
        }
        while (!operations.isEmpty()) {
            process(numbers, operations.pop());
        }
        return numbers.pop();
    }

    private static void process(Deque<Double> numbers, char operation) {
        double b = numbers.pop();
        double a = numbers.pop();
        switch (operation) {
            case '+': numbers.push(a + b); break;
            case '-': numbers.push(a - b); break;
            case '*': numbers.push(a * b); break;
            case '/':
                if (b == 0) throw new ArithmeticException("Ошибка: деление на ноль");
                numbers.push(a / b);
                break;
        }
    }

    private static int precedence(char op) {
        return (op == '+' || op == '-') ? 1 : 2;
    }
}
