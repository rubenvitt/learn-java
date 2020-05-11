package de.rubeen.android.derrechenmeister;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game game;
    TextView textTime, textStatus, textExercise, textSolved;
    Button buttonArray[];


    protected void ping() {
        textTime.setText(game.getTimer() + " " + getApplication().getString(R.string.seconds));
    }

    protected void ping(boolean status) {
        for (Button b : buttonArray)
            b.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.layoutGame).setVisibility(View.INVISIBLE);
                findViewById(R.id.buttonStart).setVisibility(View.VISIBLE);
            }
        }, 3000);
    }

    protected void startGame(View view) {
        view.setVisibility(View.INVISIBLE);
        game = new Game(this, 30);
        findViewById(R.id.layoutGame).setVisibility(View.VISIBLE);
        for(Button b : buttonArray)
            b.setEnabled(true);
        refreshTexts();
    }

    private void makeButtons() {
        for(int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].setText(Integer.toString(game.getAnswers()[i]));
        }
    }

    protected void onAnswerClick(View view) {
        int answer = Integer.parseInt(((Button) view).getText().toString());
        if (game.checkAnswer(answer))
            textStatus.setText(getApplication().getString(R.string.right));
        else
            textStatus.setText(getApplication().getString(R.string.wrong));
        refreshTexts();
    }

    protected void refreshTexts() {
        textSolved.setText(game.getSolved());
        textExercise.setText(game.toString());
        makeButtons();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTime = (TextView) findViewById(R.id.textTimer);
        textStatus = (TextView) findViewById(R.id.textStatus);
        textExercise = (TextView) findViewById(R.id.textExercise);
        textSolved = (TextView) findViewById(R.id.textSolved);

        Button b1 = (Button) findViewById(R.id.answer1);
        Button b2 = (Button) findViewById(R.id.answer2);
        Button b3 = (Button) findViewById(R.id.answer3);
        Button b4 = (Button) findViewById(R.id.answer4);
        buttonArray = new Button[]{b1, b2, b3, b4};
    }
}
