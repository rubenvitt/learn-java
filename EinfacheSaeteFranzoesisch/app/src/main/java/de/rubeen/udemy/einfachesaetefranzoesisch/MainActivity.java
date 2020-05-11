package de.rubeen.udemy.einfachesaetefranzoesisch;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void btnClickHandler(View view) {
        Button clicker = (Button) view;
        switch (clicker.getText().toString()) {
            case "Hallo":
                play(R.raw.hello);
                break;
            case "Sprichst du Englisch?":
                play(R.raw.doyouspeakenglish);
                break;
            case "Guten Abend":
                play(R.raw.goodevening);
                break;
            case "Wie geht es Dir?":
                play(R.raw.howareyou);
                break;
            case "Ich lebe in":
                play(R.raw.ilivein);
                break;
            case "Mein Name ist":
                play(R.raw.mynameis);
                break;
            case "Bitte":
                play(R.raw.please);
                break;
            case "Gern geschehen":
                play(R.raw.welcome);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void play(int id) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
    }
}
