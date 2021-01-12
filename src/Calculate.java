public class Calculate {

    public double calcul (int firstNum, int secondNum, String operator) {

        if (operator.equals("+")) {
            return firstNum + secondNum;
        }
        if (operator.equals("-")) {
            return firstNum - secondNum;
        }
        if (operator.equals("/")) {
            if (secondNum == 0) {
                throw new NumberFormatException("Ошибка! На ноль делить нельзя.");
            } else {
                return firstNum / secondNum;
            }
        }
//        if (operator.equals("*")) {
            return firstNum * secondNum;
//        }
//     return 0;
    }
}
