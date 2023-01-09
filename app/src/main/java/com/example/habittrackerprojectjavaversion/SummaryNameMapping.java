package com.example.habittrackerprojectjavaversion;

public class SummaryNameMapping {
    private String habitname;
    private boolean isFavorite;

    public SummaryNameMapping(String tohabitname){
        habitname = tohabitname;
        isFavorite = false;
    }

    public String getHabitname(){
        return habitname;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void toggleFavorite() {
        isFavorite = !isFavorite;
    }

}
