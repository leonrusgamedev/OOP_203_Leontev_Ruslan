package lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MathApiSolver {

    private static final String API_URL = "https://api.mathjs.org/v4/";

    // Решение квадратного уравнения
    public static void solveQuadraticEquation(String task) throws Exception {
        String[] parts = task.replaceAll("[^0-9*x^=+-]", "").split("=");
        if (parts.length < 1) {
            throw new IllegalArgumentException("Некорректное квадратное уравнение.");
        }
        String expression = parts[0].replace("^", "^2");
        System.out.println("Решаем квадратное уравнение: " + expression + " = 0");

        String apiInput = "solve(" + expression + ", x)";
        String result = sendApiRequest(apiInput);
        System.out.println("Решение: " + result);
    }

    // Вычисление значения выражения
    public static void evaluateExpression(String task) throws Exception {
        String expression = task.replaceAll("[^0-9+\\-*/().]", "");
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Пустое выражение. Введите корректное выражение.");
        }
        System.out.println("Вычисляем значение выражения: " + expression);

        String result = sendApiRequest(expression);
        System.out.println("Результат: " + result);
    }

    // Решение линейного уравнения
    public static void solveEquation(String task) throws Exception {
        String expression = task.replaceAll("[^0-9a-zA-Z=+\\-*/()]+", "");
        if (!expression.contains("=")) {
            throw new IllegalArgumentException("Некорректное уравнение. Отсутствует знак '='.");
        }
        System.out.println("Решаем уравнение: " + expression);

        // Разделяем уравнение и преобразуем в уравнение вида "левая часть - правая часть = 0"
        String[] sides = expression.split("=");
        if (sides.length != 2) {
            throw new IllegalArgumentException("Некорректное уравнение.");
        }
        String rearrangedExpression = sides[0] + "- (" + sides[1] + ")";
        String apiInput = "solve(" + rearrangedExpression + ", x)";
        String result = sendApiRequest(apiInput);
        System.out.println("Решение: " + result);
    }

    // Отправка запроса на Math.js API
    private static String sendApiRequest(String expression) throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setDoOutput(true);

        String jsonInput = "{\"expr\":\"" + expression + "\"}";
        System.out.println("Отправляем запрос: " + jsonInput);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int status = connection.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Ошибка: HTTP " + status);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        return response.toString();
    }
}