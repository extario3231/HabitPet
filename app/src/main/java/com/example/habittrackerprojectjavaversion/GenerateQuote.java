package com.example.habittrackerprojectjavaversion;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GenerateQuote {
    private ArrayList<String> quoteList;
    private int arraySize;
    private int quoteIndex;
    private String quote;

    public GenerateQuote(ArrayList<String> aList){
        quoteList = aList;
        arraySize = quoteList.size();
        quoteIndex = new Random().nextInt(arraySize);
    }

    public String returnQuote(){
        quote = quoteList.get(quoteIndex);
        return quote;
    }
}
