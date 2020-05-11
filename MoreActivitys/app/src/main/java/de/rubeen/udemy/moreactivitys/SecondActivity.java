package de.rubeen.udemy.moreactivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if(intent != null)
            ((TextView)findViewById(R.id.textGreeting)).setText("Hey " + intent.getStringExtra("name"));
        else
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void onButtonClick(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
