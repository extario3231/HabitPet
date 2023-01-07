package com.example.habittrackerprojectjavaversion;

import java.util.ArrayList;
import java.util.List;

public class habits extends ArrayList<NameMapping> {

    private ArrayList<NameMapping> allhabits = new ArrayList<NameMapping>();
    // List of books for display in the items of gridview
    private ArrayList<NameMapping> selectedhabitList = new ArrayList<NameMapping>();

    public habits(){
        NameMapping nameMapping;

        nameMapping = new NameMapping("Sleep and wake up early", R.mipmap.sleep);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Sport regularly", R.mipmap.sport);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Football", R.mipmap.football);
        nameMapping.toggleFavorite();
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Basketball", R.mipmap.basketball);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("badminton", R.mipmap.badminton);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Tennis", R.mipmap.tennis);
        nameMapping.toggleFavorite();
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Table Tennis", R.mipmap.tabletennis);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Golf", R.mipmap.golf);
        nameMapping.toggleFavorite();
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Baseball", R.mipmap.baseball);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Gym",  R.mipmap.gym);
        nameMapping.toggleFavorite();
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Drinking more water", R.mipmap.water);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Eating Healthy food", R.mipmap.food);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("Lazy",R.mipmap.lazy);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("No smoking",  R.mipmap.nosmoke);
        allhabits.add(nameMapping);

        nameMapping = new NameMapping("No alcohol",  R.mipmap.noalcohol);
        allhabits.add(nameMapping);

    }

    public void setSelection(String selection) {
        // Clear book list for display
        selectedhabitList.clear();

        // Add book to selected list according to spinner selection (either all or favorite)
        if (selection.equals("All")) {
            for (NameMapping nameMapping : allhabits) {
                selectedhabitList.add(nameMapping);
            }
        } else {
            for (NameMapping nameMapping : allhabits) {
                if (nameMapping.isFavorite())
                    selectedhabitList.add(nameMapping);
            }
        }
    }

    public List<NameMapping> getSelectedhabitList() {
        return selectedhabitList;
    }

    public void addhabit(String habit){
        NameMapping nameMapping;
        nameMapping = new NameMapping(habit,  R.mipmap.noalcohol);
        nameMapping.toggleFavorite();
        allhabits.add(nameMapping);
    }
}



