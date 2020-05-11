package de.rubeen.udemy.dreieckszahlquadrat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;

    protected void calculate(View view) {
        textView.setText(new Number(Integer.parseInt(editText.getText().toString())).toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textResult);
        editText = (EditText) findViewById(R.id.textNumber);
    }
}
