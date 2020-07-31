package Calculator.Converter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Класс для римских цифр
public enum RomanNums {
    I(1),IV(4),V(5), IX(9),X(10), XL(40),L(50),XC(90),C(100);
    //арабское представление римской цифры
    private final int value;
    //словарь
    private static final List<RomanNums> list = Arrays.asList(RomanNums.values());

    RomanNums(int value){
        this.value = value;
    }
    //геттер
    public int getValue() {
        return value;
    }
    public static int convertToArabic(String num) {
        //проверяем если число соответсвует одному из значение словаря, просто возвращаем это значение
        int i = 0;
        for (RomanNums romanNums : list) {
            if (num.equals(romanNums.toString()))
                return romanNums.getValue();
        }
        int arabicNum = 0;
        //если нет сортируем лист
        Collections.sort(list);
        Collections.reverse(list);
        while ((num.length() > 0) && (i < list.size())) {
            RomanNums symbol = list.get(i);
            if (num.startsWith(symbol.name())) {
                //если num начинается с имени symbol
                //добавляем значение символа к результату
                //убираем значение symbol из начала
                arabicNum += symbol.getValue();
                num = num.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        return arabicNum;

    }
    //конвертирование int в римские цифры
    public static String convertToRoman(int num){
        //проверяем если число соответсвует одному из значение словаря, просто возвращаем это значение
        for (RomanNums romanNums : list) {
            if (num == romanNums.getValue())
                return romanNums.toString();
        }
        //если нет сортируем лист
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        Collections.reverse(list);
        int i = 0;
        while ((num > 0) && (i < list.size())) {
            //если значение символа <= num
            //добавляем результат с именем символа
            //вычитаем значение
            RomanNums symbol = list.get(i);
            if (symbol.getValue() <= num) {
                sb.append(symbol.name());
                num -= symbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}

