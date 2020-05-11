package de.rubeen.udemy.komischemenschenerraten;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Game game;
    Button[] buttons;

    public void onButtonClick(View view) {
        for(Button b : buttons)
            b.setEnabled(false);
        Toast toast;
        if (game.getAnswer() == ((Button) view).getText())
            toast = Toast.makeText(this, "Richtig geraten!", Toast.LENGTH_SHORT);
        else
            toast = Toast.makeText(this, "Falsch.\nRichtig ist: " + game.getAnswer(), Toast.LENGTH_SHORT);
        toast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nextRound();
                for(Button b : buttons)
                    b.setEnabled(true);
            }
        }, 100);
    }

    private void nextRound() {
        ((ImageView) findViewById(R.id.imageExercise)).setImageBitmap(game.getNextImage());
        List<String> answers = game.getAnswers();
        for (int i = 0; i < 4; i++)
            buttons[i].setText(answers.get(i));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                game = new Game();
                findViewById(R.id.progressLoading).setVisibility(View.INVISIBLE);
                nextRound();
            }
        }, 100);
        buttons = new Button[4];
        buttons[0] = (Button) findViewById(R.id.btn1);
        buttons[1] = (Button) findViewById(R.id.btn2);
        buttons[2] = (Button) findViewById(R.id.btn3);
        buttons[3] = (Button) findViewById(R.id.btn4);
    }
}
