package de.rubeen.udemy.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    public void clickHandler(View view) {
        ImageView counter = (ImageView) view;

        counter.setTranslationY(-1000);
        counter.setImageResource(R.drawable.player2);
        counter.animate().translationYBy(1000).rotation(369).setDuration(300);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
