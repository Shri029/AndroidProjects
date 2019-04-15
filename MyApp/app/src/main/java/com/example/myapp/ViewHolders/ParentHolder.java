package com.example.myapp.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.myapp.R;

public class ParentHolder extends ParentViewHolder {

    public TextView textView;
//    public ImageButton imageButton;


    public ParentHolder(View itemView) {
        super(itemView);

        textView = (TextView)itemView.findViewById(R.id.Parent_title);
//        imageButton = (ImageButton) itemView. findViewById(R.id.expandable_arrow);
    }
}
