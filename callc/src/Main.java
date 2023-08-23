import java.util.Scanner;
public class Main {
    private static String r;
    public static void main(String[] args) throws Exception {
        System.out.println(res(r));
    }
    public static String res (String expression) throws Exception {
        int x, y; // Целочисленные переменные для операндов
        boolean roman; // Логическая переменная
        String r; // Переменная для результата вычислений
        String operation; // Переменная для оператора
        System.out.println("Введите две операнда (от 1 до 10) и оператор (+, -, /, *)");
        Scanner scanner = new Scanner(System.in); // Ввод выражения пользователем
        String numb0 = scanner.nextLine().replaceAll(" ", ""); // Строка, которая содержит выражение введенное пользователем + убирает все пробелы
        String [] numb1 = numb0.split("[+\\-*/]"); // Массив, котрый будет содержать два операнда
        if (numb1.length != 2) throw new Exception("Должно быть 2 операнда и операторы: +, -, /, *"); // Проверка через длину массива
        operation = oprznak(numb0); // Оператор
        if (Roman.isRom(numb1[0]) && Roman.isRom(numb1[1])) { // конвертация чисел в арабские
            x = Roman.convertToArab(numb1[0]);
            y = Roman.convertToArab(numb1[1]);
            roman = true;
        }
        else if (!Roman.isRom(numb1[0]) && !Roman.isRom(numb1[1])) {
            x = Integer.parseInt(numb1[0]); // коневртируем числа для дальнейших вычислений
            y = Integer.parseInt(numb1[1]);
            roman = false;
        }
        else { // если одно римское, а второе арабское
            throw new Exception("Операнды должны быть в одном формате!");
        }
        if (x > 10 || y > 10) { // проверяем в необходимом ли диапазоне числа
            throw new Exception("Диапазон значений операндов от 1 до 10!");
        }
        int arab = calc(x, y, operation);
        if (roman) {
            if (arab <= 0) {
                throw new Exception("Диапазон значений операндов от 1 до 10!");
            }
            r = Roman.convertToRoman(arab); // конвертация из арабского в римское
        } else {
            r = String.valueOf(arab); // конвертируем арбское в стринг
        }
        return r;
    }
    static String oprznak (String numb0) { // Метод для определения оператора
        if (numb0.contains("+")) return "+";
        else if (numb0.contains("-")) return "-";
        else if (numb0.contains("*")) return "*";
        else if (numb0.contains("/")) return "/";
        else return null;
    }
    static int calc (int a, int b, String operation) { // Производим вычисления
        if (operation.equals("+")) return a + b;
        else if (operation.equals("-")) return a - b;
        else if (operation.equals("*")) return a * b;
        else return a / b;
    }
    class Roman {
        // Массив римских чисел
        static String[] romArr = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};

        public static boolean isRom(String val) {
            for (int i = 0; i < romArr.length; i++) // Цикл, чтобы проверить является ли число римским
                {
                if (val.equals(romArr[i])) {
                    return true;
                }
            }
            return false;
        }
        public static int convertToArab(String rom) { // Конвертируем римские числа в арабские (по индеску массива)
            for (int i = 0; i < romArr.length; i++)
                {
                if (rom.equals(romArr[i])) {
                    return i;
                }
            }
            return -1;
        }
        public static String convertToRoman(int arab) {
            return romArr[arab];
        } // Конвертация в римское число (по индеску массива)
    }
}