package Calculator.Operations;

import Calculator.Converter.RomanNums;

public class Multiplication extends Operation {
    @Override
    public void action(String num, String num2) {
        int result;
        if (num.matches("\\d+")&&num2.matches("\\d+"))
            System.out.println(Integer.parseInt(num) * Integer.parseInt(num2));
        else if (num.matches("[IVXLC]+")&&num2.matches("[IVXLC]+")) {
            result = RomanNums.convertToArabic(num) * RomanNums.convertToArabic(num2);
            System.out.println(RomanNums.convertToRoman(result));
        }
        else
            throw new UnsupportedOperationException("Операция не поддерживается: формат чисел должен быть одинаковым");
    }
}