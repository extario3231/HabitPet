package com.example.habittrackerprojectjavaversion;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link habitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class habitFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // self-defined variables
    AlertDialog dialog;
    Button button;
    // arraylist should be declared outside the method
    ArrayList<NameMapping> showhabitlist = new ArrayList<NameMapping>();
    private habits habitlist;

    public habitFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment habitFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static habitFragment newInstance(String param1, String param2) {
        habitFragment fragment = new habitFragment();
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
        return inflater.inflate(R.layout.fragment_habit, container, false);
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        habitlist = new habits();
        habitlist.setSelection("All");

        HabitAdapter adapter = new HabitAdapter(getActivity(), (ArrayList<NameMapping>) habitlist.getSelectedhabitList());
        final ListView listView = getView().findViewById(R.id.list);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(adapter);
    }

}