package com.example.habittrackerprojectjavaversion;

public class NameMapping {

    private String habitname;
    private int mImgResId;
    private boolean isFavorite;


    public NameMapping(String tohabitname,  int imgResId){
        habitname = tohabitname;
        mImgResId = imgResId;
        isFavorite = false;
    }


    public String getHabitname(){
        return habitname;
    }

    public int getImageResId(){
        return mImgResId;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void toggleFavorite() {
        isFavorite = !isFavorite;
    }


}