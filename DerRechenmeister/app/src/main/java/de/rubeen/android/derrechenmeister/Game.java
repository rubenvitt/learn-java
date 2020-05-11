package de.rubeen.android.derrechenmeister;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Ruben Vitt - 11.01.17.
 */
public class Game {
    private int number1, number2, solved, correct, timer;
    int[] answers = new int[4];
    private Random random = new Random();

    public Game(final MainActivity mainActivity, int lenght) {
        generateNumbers();
        timer = lenght;
        new CountDownTimer((timer + 3) * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (timer < 0) {
                    mainActivity.ping(true);
                    this.cancel();
                    return;
                }
                mainActivity.ping();
                timer--;
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }

    public boolean checkAnswer(int result) {
        boolean correct = number1 + number2 == result;

        generateNumbers();

        solved++;
        if (correct)
            this.correct++;
        return correct;
    }

    private void generateNumbers() {
        for (int i = 0; i < 2; i++) {
            int result = 0;
            while (result == 0) {
                result = random.nextInt(50);
            }
            if (i == 0)
                number1 = result;
            else
                number2 = result;
        }

        int rightPos = random.nextInt(4);
        boolean niedriger = false;
        for(int i = 0; i < answers.length; i++) {
            if(i == rightPos)
                answers[i] = number1 + number2;
            else if (niedriger)
                answers[i] = number1 + number2 - random.nextInt(5) - random.nextInt(2);
            else
                answers[i] = number1 + number2 + random.nextInt(5) + random.nextInt(2);
            niedriger = !niedriger;
        }
    }

    public int getTimer() {
        return timer;
    }

    public int[] getAnswers() {
        return answers;
    }

    public String getSolved() {
        return String.format("%s / %s", correct, solved);
    }

    @Override
    public String toString() {
        return number1 + " + " + number2;
    }
}
