package com.example.myapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;


import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.myapp.Models.Child;
import com.example.myapp.Models.Parent;
import com.example.myapp.R;
import com.example.myapp.ViewHolders.ChildHolder;
import com.example.myapp.ViewHolders.ParentHolder;

import java.util.List;

public class MyAdapter extends ExpandableRecyclerAdapter<ParentHolder, ChildHolder> {

    LayoutInflater inflator;

    public MyAdapter(Context context, List<ParentObject> parentItemList){
        super(context, parentItemList);

        inflator = LayoutInflater.from(context);
    }
    @Override
    public ParentHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflator.inflate(R.layout.parent, viewGroup, false);
        return new ParentHolder(view);
    }

    @Override
    public ChildHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflator.inflate(R.layout.child, viewGroup, false);
        return new ChildHolder(view);

    }

    @Override
    public void onBindParentViewHolder(ParentHolder parentHolder, int i, Object o) {

        Parent title = (Parent)o;
        parentHolder.textView.setText(title.getTitle());

    }

    @Override
    public void onBindChildViewHolder(ChildHolder childHolder, int i, Object o) {

        Child title = (Child)o;
        childHolder.option1.setText(title.getOption1());
        childHolder.option2.setText(title.getOption2());

    }
}
