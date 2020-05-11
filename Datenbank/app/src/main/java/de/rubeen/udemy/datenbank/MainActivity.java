package de.rubeen.udemy.datenbank;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase database = openOrCreateDatabase("People", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS friends (name VARCHAR, age INT(3), description VARCHAR)");

        database.execSQL("INSERT INTO friends (name, age, description) VALUES " +
                "('Nelli', 18, 'war sie eine Freundin? Sie hat mich zumindest am meisten geprägt.')," +
                "('Lisa', 18, 'meine erste richtige Freundin. Ich glaube ich habe einiges falsch gemacht.')," +
                "('Jessica', 18, 'Amiras Tochter - ich hätte mit ihr gehen können und mein Leben wäre anders geworden.')," +
                "('Kira', 19, '...naja kein Kommentar')");

        Cursor cursor = database.rawQuery("SELECT * FROM friends WHERE age > 18", null);
        int nameIndex = cursor.getColumnIndex("name");
        int ageIndex = cursor.getColumnIndex("age");
        int descriptIndex = cursor.getColumnIndex("description");
        cursor.moveToFirst();
        Log.i(cursor.getString(nameIndex), ", " + Integer.toString(cursor.getInt(ageIndex)) + " - " +
                cursor.getString(descriptIndex));
        do {
            cursor.moveToNext();
            Log.i(cursor.getString(nameIndex), ", " + Integer.toString(cursor.getInt(ageIndex)) + " - " +
                    cursor.getString(descriptIndex));
        } while (!cursor.isLast());
    }
}
