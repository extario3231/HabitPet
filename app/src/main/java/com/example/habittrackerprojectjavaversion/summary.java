package com.example.habittrackerprojectjavaversion;

import java.util.ArrayList;
import java.util.List;

public class summary {
    private ArrayList<SummaryNameMapping> allhabits = new ArrayList<SummaryNameMapping>();
    // List of books for display in the items of gridview
    private ArrayList<SummaryNameMapping> selectedhabitList = new ArrayList<SummaryNameMapping>();

    public summary(){
        SummaryNameMapping summaryNameMapping;

        summaryNameMapping = new SummaryNameMapping("Sleep and wake up early");
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("Sport regularly");
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("Football");
        summaryNameMapping.toggleFavorite();
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("Basketball");
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("badminton");
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("Tennis");
        summaryNameMapping.toggleFavorite();
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("Table Tennis");
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("Golf");
        summaryNameMapping.toggleFavorite();
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("Baseball");
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("Gym");
        summaryNameMapping.toggleFavorite();
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("Drinking more water");
        allhabits.add(summaryNameMapping);

        summaryNameMapping= new SummaryNameMapping("Eating Healthy food");
        allhabits.add(summaryNameMapping);

        summaryNameMapping= new SummaryNameMapping("Lazy");
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("No smoking");
        allhabits.add(summaryNameMapping);

        summaryNameMapping = new SummaryNameMapping("No alcohol");
        allhabits.add(summaryNameMapping);

    }

    public void setSelection(String selection) {
        // Clear book list for display
        selectedhabitList.clear();

        // Add book to selected list according to spinner selection (either all or favorite)
        if (selection.equals("All")) {
            for (SummaryNameMapping nameMapping : allhabits) {
                selectedhabitList.add(nameMapping);
            }
        } else {
            for (SummaryNameMapping nameMapping : allhabits) {
                if (nameMapping.isFavorite())
                    selectedhabitList.add(nameMapping);
            }
        }
    }

    public List<SummaryNameMapping> getSelectedhabitList() {
        return selectedhabitList;
    }

    public void addhabit(String habit){
        SummaryNameMapping nameMapping;
        nameMapping = new SummaryNameMapping(habit);
        nameMapping.toggleFavorite();
        allhabits.add(nameMapping);
    }
}
