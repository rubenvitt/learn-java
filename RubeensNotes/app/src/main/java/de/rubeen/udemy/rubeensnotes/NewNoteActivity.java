package de.rubeen.udemy.rubeensnotes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {

    String splitter = "---3355995533---";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!((EditText) findViewById(R.id.textNote)).getText().toString().equals("")) {
            SharedPreferences preferences = getApplicationContext().getSharedPreferences("de.rubeen.udemy.rubeensnotes", MODE_PRIVATE);
            String result = preferences.getString("notes", null);
            if (result == null)
                result = ((EditText) findViewById(R.id.textNote)).getText().toString();
            else
                result += ((EditText) findViewById(R.id.textNote)).getText().toString() + splitter;
            preferences.edit().putString("notes", result).apply();
        }
    }
}
