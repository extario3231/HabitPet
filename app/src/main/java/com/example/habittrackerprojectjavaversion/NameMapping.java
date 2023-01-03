package com.example.habittrackerprojectjavaversion;

public class NameMapping {

    private String habitname;


    private int mImgResId;


    public NameMapping(String tohabitname,  int imgResId){
        habitname = tohabitname;

        mImgResId = imgResId;
    }


    public String getHabitname(){
        return habitname;
    }


    public int getImageResId(){
        return mImgResId;
    }
}