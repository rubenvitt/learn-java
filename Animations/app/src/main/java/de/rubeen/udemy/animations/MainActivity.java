package de.rubeen.udemy.animations;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void changePicture(View view) {
        ImageView homer = (ImageView) findViewById(R.id.homerImage);
        ImageView lisa = (ImageView) findViewById(R.id.lisaImage);
        if (homer.getAlpha() == 1) {
            homer.animate().alpha(0.1f).setDuration(2000);
            lisa.animate().alpha(1).setDuration(2000);
        }
        else {
            homer.animate().alpha(1);
            lisa.animate().alpha(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
