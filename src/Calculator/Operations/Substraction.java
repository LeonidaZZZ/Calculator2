package Calculator.Operations;


import Calculator.Converter.RomanNums;
//класс вычитания
public class Substraction extends Operation{
    //переопределение метода
    @Override
    public void action(String num, String num2) {
            int result;
            //если переданые строки имеют арабские числа
            if (num.matches("\\d+")&&num2.matches("\\d+"))
                System.out.println(Integer.parseInt(num) - Integer.parseInt(num2));
            //если переданые строки имеют римские числа
            else if (num.matches("[IVXLC]+")&&num2.matches("[IVXLC]+")) {
                result = RomanNums.convertToArabic(num) - RomanNums.convertToArabic(num2);
                if (result<0) {
                    result = result * -1;
                    System.out.println("-" + RomanNums.convertToRoman(result));
                }
                else
                    System.out.println(RomanNums.convertToRoman(result));
            }
            else
                throw new UnsupportedOperationException("Операция не поддерживается: формат чисел должен быть одинаковым");
    }
}

