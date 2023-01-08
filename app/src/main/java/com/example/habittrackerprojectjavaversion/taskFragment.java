package com.example.habittrackerprojectjavaversion;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link taskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class taskFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AlertDialog dialog;
    Button button;

    ArrayList<NameMapping> showhabitlist = new ArrayList<NameMapping>();
    private habits habitlist;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public taskFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment taskFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static taskFragment newInstance(String param1, String param2) {
        taskFragment fragment = new taskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        habitlist = new habits();
        habitlist.setSelection("favourite");


        HabitAdapter adapter = new HabitAdapter(getActivity(), (ArrayList<NameMapping>) habitlist.getSelectedhabitList());
        ListView listView = getView().findViewById(R.id.listtask);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(adapter);

        // create a alert dialog for entering new habit
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                HabitAdapter adapter = new HabitAdapter(getActivity(), (ArrayList<NameMapping>) habitlist.getSelectedhabitList());
                ListView listView = getView().findViewById(R.id.listtask);
                listView.setTextFilterEnabled(true);
                listView.setAdapter(adapter);
            }
        });

        builder.setView(view);
        dialog = builder.create();
        // call a dialog when press the button on the habit screen
        button = getView().findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.show();
            }
        });
    }
}