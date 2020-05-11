package de.rubeen.udemy.zahlenraten;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    Random zufall = new Random();
    EditText editText;
    TextView textView;

    public void onButtonClick(View view) {
        String s = editText.getText().toString();
        try {
            int value = Integer.parseInt(s);

            if (randomNumber < value) {
                textView.setText("Meine Zahl ist kleiner.");
            } else if (randomNumber > value) {
                textView.setText("Meine Zahl ist größer.");
            } else {
                textView.setText("Herzlichen Glückwunsch! Du hast meine Zahl erraten! Rate nochmal!");
                startGame();
            }
        } catch (NumberFormatException ex) {
            textView.setText("Nichts ist nichts.");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textInfo);
        startGame();
    }

    private void startGame() {
        do {
            randomNumber = zufall.nextInt(1000);
        } while (randomNumber >= 1000 || randomNumber < 0);
    }
}
