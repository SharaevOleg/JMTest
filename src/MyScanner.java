import java.util.regex.Pattern;

public class MyScanner {

    Calculate calculate = new Calculate();

    public void scan() {
        while (true) {

            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.println("Пожалуйста, введите латинское или арабское выражение для расчёта: ");
            String text = addSpacesInLine(scanner.nextLine());

            String[] tempStrings = text.split(" ");
            String regex = "^([1-9,10]|10)$";

            int firstNum, secondNum;
            String operator;

            if (checkForTheNumber(tempStrings[0]) && checkForTheNumber(tempStrings[2])) {

                if (tempStrings.length != 3) {
                    throw new NumberFormatException("Ошибка! Аргументов должно быть два!!!");

                } else if (tempStrings[0].matches(regex) && tempStrings[2].matches(regex)) {

                    firstNum = Integer.parseInt(tempStrings[0]);
                    secondNum = Integer.parseInt(tempStrings[2]);
                    operator = tempStrings[1];

                    System.out.println(calculate.calcul(firstNum, secondNum, operator));
                } else {
                    throw new NumberFormatException("Цифра не должна превышать 10!");
                }
            } else {

                if (replaceRoman(tempStrings[0]).matches(regex) && replaceRoman(tempStrings[2]).matches(regex)) {

                    firstNum = Integer.parseInt(replaceRoman(tempStrings[0]));
                    secondNum = Integer.parseInt(replaceRoman(tempStrings[2]));
                    operator = tempStrings[1];

                    int i = (int) calculate.calcul(firstNum, secondNum, operator);
                    RomanNumeral rm = new RomanNumeral(i);
                    System.out.println(rm.toString());
                } else {
                    throw new NumberFormatException("Цифра не должна превышать X!");
                }
            }
        }
    }

    //Добавлялка пробелов
    static String addSpacesInLine(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                builder.append(" ").append(ch).append(" ");
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    //Проверка номер или нет
    boolean checkForTheNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(strNum).matches();
    }

    // Замена римских цифр арабскими
    static String replaceRoman(String str) {
        StringBuilder builder = new StringBuilder();
        String[] stringsArray = str.split(" ");

        for (String data : stringsArray) {
            if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")) {
                builder.append(data);
            } else {
                builder.append(new RomanNumeral(data).toInt());
            }
        }
        return builder.toString();
    }

}