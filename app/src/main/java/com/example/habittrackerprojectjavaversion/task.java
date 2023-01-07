package com.example.habittrackerprojectjavaversion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class task extends AppCompatActivity {

    AlertDialog dialog;
    Button button;

    ArrayList<NameMapping> showhabitlist = new ArrayList<NameMapping>();
    private habits habitlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        habitlist = new habits();
        habitlist.setSelection("favourite");


        HabitAdapter adapter = new HabitAdapter((Activity) this, (ArrayList<NameMapping>) habitlist.getSelectedhabitList());
        ListView listView = findViewById(R.id.listtask);
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
                habitlist.addhabit(addHabitText.getText().toString());
                habitlist.setSelection("favourite");
                dialog.dismiss();
                HabitAdapter adapter = new HabitAdapter(task.this, (ArrayList<NameMapping>) habitlist.getSelectedhabitList());
                ListView listView = findViewById(R.id.listtask);
                listView.setTextFilterEnabled(true);
                listView.setAdapter(adapter);
            }
        });

        builder.setView(view);
        dialog = builder.create();
        // call a dialog when press the button on the habit screen
        button = findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.show();
            }
        });

    }
}