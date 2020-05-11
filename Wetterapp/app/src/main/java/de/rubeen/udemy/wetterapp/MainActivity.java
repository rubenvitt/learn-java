package de.rubeen.udemy.wetterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weather = new Weather("dcbc97e9b31ccd1f6fb62937843cc0ef");
        findViewById(R.id.textCity).setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER)
                    wetterAktualisieren();
                return true;
            }
        });
    }

    private void wetterAktualisieren() {
        WeatherObject weatherObject = weather.getWeatherObject(((EditText)findViewById(R.id.textCity)).getText().toString());
        ((TextView)findViewById(R.id.textTitle)).setText(weatherObject.main);
        ((TextView)findViewById(R.id.textDescription)).setText(weatherObject.description + " | " + weatherObject.temperature + " °C");

        ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((findViewById(R.id.textCity).getWindowToken()), 0);
    }
}
