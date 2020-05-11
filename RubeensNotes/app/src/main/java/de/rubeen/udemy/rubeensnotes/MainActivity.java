package de.rubeen.udemy.rubeensnotes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String splitter = "---3355995533---";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newNote();
            }
        });

        final ListView listView = (ListView) findViewById(R.id.listViewNotes);
        updateList(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeNote(listView.getItemAtPosition(position).toString());
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                removeNote(listView.getItemAtPosition(position).toString());
                return false;
            }
        });
    }

    private void updateList(ListView listView) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("de.rubeen.udemy.rubeensnotes", MODE_PRIVATE);
        String notesPlain = preferences.getString("notes", null);
        if (notesPlain != null && !notesPlain.equals("")) {
            if (notesPlain.equals(splitter))
                notesPlain = "";
            List<String> notes = Arrays.asList(notesPlain.split(splitter));
            //  String result = "";
            //  for (int i = 0; i < notes.size(); i++)
            //      if (notes.get(i) == "")
            //          notes.remove(i);
            //      else
            //          result += notes.get(i) + splitter;
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
            adapter.addAll(notes);
            listView.setAdapter(adapter);
            //  preferences.edit().putString("notes", result).apply();
        } else {
            preferences.edit().remove("notes");
            newNote();
        }
    }

    private void newNote() {
        startActivity(new Intent(getApplicationContext(), NewNoteActivity.class));
    }

    private void changeNote(String text) {

    }

    private void removeNote(String text) {
        final String myText = text;
        new AlertDialog.Builder(this)
                //.setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Notiz löschen")
                .setMessage("Soll die Notiz wirklich gelöscht werden?")
                .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("Bestätigen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = getApplicationContext().getSharedPreferences("de.rubeen.udemy.rubeensnotes", MODE_PRIVATE);
                        String s = preferences.getString("notes", null).replace(myText + splitter, "");
                        preferences.edit().putString("notes", s).apply();
                        updateList(((ListView) findViewById(R.id.listViewNotes)));
                    }
                }).show();

    }
}
