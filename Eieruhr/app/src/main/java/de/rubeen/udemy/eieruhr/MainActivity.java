package de.rubeen.udemy.eieruhr;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int time = 0;

    void setTime(int value) {
        time = value;
        ((TextView) findViewById(R.id.textTime)).setText(String.format("%02d", (value / 60)) + ":" + String.format("%02d", (value % 60)));
    }

    public void onImageClick(View view) {0
        timerStarten(((SeekBar) findViewById(R.id.barTime)).getProgress());
    }

    private void timerStarten(int dauer) {
        findViewById(R.id.barTime).setEnabled(false);
        setTime(++time);
        new CountDownTimer((dauer + 2) * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                setTime(--time);
            }

            @Override
            public void onFinish() {
                SeekBar sb = (SeekBar)findViewById(R.id.barTime);
                sb.setEnabled(true);
                setTime(sb.getProgress());
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar sb = (SeekBar) findViewById(R.id.barTime);
        setTime(sb.getProgress());
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setTime(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
