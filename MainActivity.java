package com.raxlin4ik.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String poem = "У лукоморья дуб зелёный;\n" +
            "Златая цепь на дубе том:\n" +
            "И днём и ночью кот учёный\n" +
            "Всё ходит по цепи кругом;\n" +
            "Идёт направо — песнь заводит,\n" +
            "Налево — сказку говорит.\n" +
            "Там чудеса: там леший бродит,\n" +
            "Русалка на ветвях сидит;\n" +
            "Там на неведомых дорожках\n" +
            "Следы невиданных зверей;\n" +
            "Избушка там на курьих ножках\n" +
            "Стоит без окон, без дверей;\n" +
            "Там лес и дол видений полны;\n" +
            "Там о заре прихлынут волны\n" +
            "На брег песчаный и пустой,\n" +
            "И тридцать витязей прекрасных";


    private int numberOfCharacters;
    private int numberOfWords;
    private int numberOfCharactersL;
    private boolean isWordFiveLeter;
    private String wordCharactersA;

    private TextView infoApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfCharacters = numberOfCharacters(poem);
        numberOfWords = numberOfWords(poem);
        numberOfCharactersL = numberOfCharactersL(poem);
        wordCharactersA = wordCharactersA(poem);
        isWordFiveLeter = isWordFiveLeter(poem);

        infoApp = findViewById(R.id.infoApp);

        infoApp.setText("Число символов в строке " + numberOfCharacters + "\n"
                + "Число слов в строке " + numberOfWords + "\n"
                + "Число букв \"л\" в строке " + numberOfCharactersL + "\n"
                + "Число слов из \"5\" букв " + isWordFiveLeter + "\n"
                + "Строка из слов начинающихся на \"А\": " + wordCharactersA);
    }




    private boolean isWordFiveLeter(String stringPoem) {
        String stringWords = "";
        String stPoem = stringPoem.replace("\n", " ").trim();
        String[] words = stPoem.split(" ");
        boolean foundWord = false;

        for (String word : words) {
            if (word.length() == 5) {
                stringWords += word + " ";
                foundWord = true;
                break;
            }
        }

            if (foundWord) {
                return true;
            } else {
                return false;
            }

    }

    private String wordCharactersA(String stringPoem) {
        String stringL = "";
        String stPoem = stringPoem.replace("\n", " ").trim();
        String[] arrayPoem = stPoem.split(" ");

        for (String string : arrayPoem) {
            if (string.charAt(0) == 'а' | string.charAt(0) == 'А') {
                stringL += string + ' ';
            }
        }
        return stringL.trim();
    }


    private int numberOfWords(String stringPoem) {
        String stPoem = stringPoem.trim();
        int count = 0;

        for (int i = 0; i < stPoem.length(); i++) {
            if (stPoem.charAt(i) == ' ' | stPoem.charAt(i) == '\n') {
                count++;
            }
        }
        return count;
    }

    private int numberOfCharactersL(String stringPoem) {
        int count = 0;

        for (int i = 0; i < stringPoem.length(); i++) {
            if (stringPoem.charAt(i) == 'л' | stringPoem.charAt(i) == 'Л') {
                count++;
            }
        }
        return count++;
    }

    private int numberOfCharacters(String stringPoem){
        return stringPoem.length();
    }



}