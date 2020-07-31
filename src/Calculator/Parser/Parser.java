package Calculator.Parser;

import Calculator.Converter.RomanNums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String firstValue;
    private String secondValue;
    private String operation;
    //конструктор на вход получает строку
    //и присваевает полям класса соответсвующие значения
    public Parser(String string) {
        //присваиваем значение operation
        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find())
            this.operation = matcher.group();

        //присваиваем значение firstValue и secondValue
        String[] arr = string.split("\\W");
        this.firstValue = arr[0];
        this.secondValue = arr[1];
        //проверка на правильность ввода
        try {
            if (Integer.parseInt(firstValue)>10||Integer.parseInt(secondValue)>10)
                throw new UnsupportedOperationException("Оперция не поддерживается: чисело(а) не может быть больше 10");
        } catch (NumberFormatException e) {
            if (RomanNums.convertToArabic(firstValue) > 10 || RomanNums.convertToArabic(secondValue) > 10)
                throw new UnsupportedOperationException("Оперция не поддерживается: чисело(а) не может быть больше 10");
        }
        if (arr.length>2)
            throw new UnsupportedOperationException("Оперция не поддерживается: чисел должно быть не больше 2-х");

    }
    //геттеры
    public String getFirstValue() {
        return firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public String getOperation() {
        return operation;
    }
}

