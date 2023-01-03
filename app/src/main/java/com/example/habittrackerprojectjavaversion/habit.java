package com.example.habittrackerprojectjavaversion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class habit extends AppCompatActivity {

    AlertDialog dialog;
    Button button;
    // arraylist should be declared outside the method
    ArrayList<NameMapping> showhabitlist = new ArrayList<NameMapping>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);

        showhabitlist.add(new NameMapping("Sleep and wake up early", R.mipmap.sleep));
        showhabitlist.add(new NameMapping("Sport regularly", R.mipmap.sport));
        showhabitlist.add(new NameMapping("Football", R.mipmap.football));
        showhabitlist.add(new NameMapping("Basketball", R.mipmap.basketball));
        showhabitlist.add(new NameMapping("badminton", R.mipmap.badminton));
        showhabitlist.add(new NameMapping("Tennis", R.mipmap.tennis));
        showhabitlist.add(new NameMapping("Table Tennis", R.mipmap.tabletennis));
        showhabitlist.add(new NameMapping("Golf", R.mipmap.golf));
        showhabitlist.add(new NameMapping("Baseball", R.mipmap.baseball));
        showhabitlist.add(new NameMapping("Gym",  R.mipmap.gym));
        showhabitlist.add(new NameMapping("Drinking more water", R.mipmap.water));
        showhabitlist.add(new NameMapping("Eating Healthy food", R.mipmap.food));
        showhabitlist.add(new NameMapping("Lazy",R.mipmap.lazy));
        showhabitlist.add(new NameMapping("No smoking",  R.mipmap.nosmoke));
        showhabitlist.add(new NameMapping("No alcohol",  R.mipmap.noalcohol));

        HabitAdapter adapter = new HabitAdapter(this, showhabitlist);
        ListView listView = findViewById(R.id.list);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(adapter);

        // create a alert dialog for entering new habit
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add a new habit");
        // specify the view we are going to access
        View view = getLayoutInflater().inflate(R.layout.add_new_habit, null);
        final EditText addHabitText;
        Button addButton;
        addHabitText = view.findViewById(R.id.addHabit);
        addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showhabitlist.add(new NameMapping(addHabitText.getText().toString(), R.mipmap.sleep));
                dialog.dismiss();
                HabitAdapter adapter = new HabitAdapter(habit.this, showhabitlist);
                ListView listView = findViewById(R.id.list);
                listView.setTextFilterEnabled(true);
                listView.setAdapter(adapter);
            }
        });

        builder.setView(view);
        dialog = builder.create();
        // call a dialog when press the button on the habit screen
        button = findViewById(R.id.addHabitButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.show();
            }
        });

    }
}