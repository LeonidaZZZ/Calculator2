package Calculator.Main;

import Calculator.Operations.*;
import Calculator.Parser.Parser;
import Calculator.Parser.Phrase;
//основной класс
public class Main {
    public static void calculate(){
        //создаем объект типа parser, в конструктор передется выражение
        Parser parser = new Parser(new Phrase().getPhrase());
        //создаем ссылку на объект operation
        Operation operation;
        switch (parser.getOperation()){
            //инициализируем operation в зависимости от полученой операции
            case "+": operation = new Addition();
                break;
            case "-": operation = new Substraction();
                break;
            case "/": operation = new Division();
                break;
            case "*": operation = new Multiplication();
                break;
            default:
                throw new UnsupportedOperationException("Операция не поддерживается");
        }
        //вывод результата в консоль
        operation.action(parser.getFirstValue(),parser.getSecondValue());
    }

    public static void main(String[] args) {
        calculate();
    }
}
