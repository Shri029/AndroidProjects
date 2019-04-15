package com.example.myapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.myapp.R;


public class ChildHolder extends ChildViewHolder{

    public TextView option1, option2;

    public ChildHolder(View itemView){
        super(itemView);

        option1 = (TextView)itemView.findViewById(R.id.option1);
        option2 = (TextView)itemView.findViewById(R.id.option2);
    }
}
