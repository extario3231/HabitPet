package com.example.habittrackerprojectjavaversion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class habit extends AppCompatActivity {

    AlertDialog dialog;
    Button button;
    // arraylist should be declared outside the method
    ArrayList<NameMapping> showhabitlist = new ArrayList<NameMapping>();
    private habits habitlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);

        habitlist = new habits();
        habitlist.setSelection("All");


        HabitAdapter adapter = new HabitAdapter((Activity) this, (ArrayList<NameMapping>) habitlist.getSelectedhabitList());
        final ListView listView = findViewById(R.id.list);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(adapter);

    }
}