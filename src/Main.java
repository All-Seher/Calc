import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите математическое выражение в формате: \"a + b\" ");
        String input = scanner.nextLine();

        try {
            System.out.println((calc(input)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String calc(String input) throws Exception {
        String[] symbols = input.split(" ");
        int a;
        int b;
        if (symbols.length / 2.0 == 1.5) {
            a = convertToNumber(symbols[0]);
            b = convertToNumber(symbols[2]);
        } else {
            throw new Exception("Неправильное математическое выражение");
        }

        return String.valueOf(mathExpression(symbols[1], a, b));
    }

    static int mathExpression(String sign, int a, int b) throws Exception {
        return switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            case "*" -> a * b;
            default -> throw new Exception("Математический знак в вашем выражении был введён неверно");
        };
    }

    static int convertToNumber(String input) throws Exception {
        int a = Integer.parseInt(input);

        if (a > 10) {
            throw new Exception("Одно или более чисел, которое вы ввели, больше 10");
        }

        return a;
    }
}