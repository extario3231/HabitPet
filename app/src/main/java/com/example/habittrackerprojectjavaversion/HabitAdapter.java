package com.example.habittrackerprojectjavaversion;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class HabitAdapter extends ArrayAdapter<NameMapping> {


    public HabitAdapter(Activity context, ArrayList<NameMapping> showhabitlist){
        super(context,0, showhabitlist);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        final NameMapping currentName = getItem(position);


        TextView default_text_view = listItemView.findViewById(R.id.default_text_view);
        default_text_view.setText(currentName.getHabitname());

        ImageView image = listItemView.findViewById(R.id.image);
        image.setImageResource(currentName.getImageResId());

        CheckBox addToFavorite = listItemView.findViewById(R.id.favoritecheckbox);
        addToFavorite.setChecked(currentName.isFavorite());
        /*addToFavorite.setOnCheckedChangeListener(
                new CheckBox.OnCheckedChangeListener(){
                    public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                        currentName.toggleFavorite();
                    }
                }
        );*/


        return listItemView;
    }


}
