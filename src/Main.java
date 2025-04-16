import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение через пробелы:");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    public static String calc(String input) throws Exception {
        String[] elements = input.trim().split(" ");
        if (elements.length < 3) {
            throw new Exception("т.к. строка не является математической операцией");
        }
        for (int i = 1; i < elements.length; i += 2) {
            if (!elements[i].matches("[+\\-*/]")) {
                throw new Exception("Недопустимая операция '" + elements[i] + "'. Допустимо: +, -, *, /");
            }
        }
        if (elements.length > 3) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        for (int i = 0; i < elements.length; i += 2) {
            try {
                int num = Integer.parseInt(elements[i]);
                if (num < 0 || num > 10) {
                    throw new Exception("Число " + num + " вне допустимого диапазона (0-10)");
                }
            } catch (NumberFormatException e) {
                throw new Exception("Элемент '" + elements[i] + "' не является целым числом");
            }
        }
        int result = Integer.parseInt(elements[0]);
        for (int i = 1; i < elements.length; i += 2) {
            String operator = elements[i];
            int nextNum = Integer.parseInt(elements[i+1]);
        switch (operator) {
            case "+":
                result += nextNum;
                break;
            case "-":
                result -= nextNum;
                break;
            case "*":
                result *= nextNum;
                break;
            case "/":
                if (nextNum == 0) throw new Exception("Деление на ноль");
                result /= nextNum;
                break;
        }}
        return String.valueOf(result);
    }
}
