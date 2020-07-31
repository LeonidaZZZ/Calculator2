package Calculator.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//класс для чтения с консоли
public class Phrase {
    private String phrase;
    public Phrase() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            this.phrase = reader.readLine().toUpperCase();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public String getPhrase() {
        return phrase;
    }
}

