package com.example.myapp.Models;

import android.content.Context;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class TitleCreator {

    static TitleCreator titleCreator;
    List<Parent> parent;

    public TitleCreator(Context context) {

        parent = new ArrayList<>();
        for(int i=1; i<=100; i++)
        {
            Parent title= new Parent( String.format("Caller #%d",i));
            parent.add(title);
        }
    }

    public static TitleCreator get(Context context){

        if(titleCreator==null)
            titleCreator = new TitleCreator(context);
        return titleCreator;
    }

    public List<Parent> getAll(){

        return parent;
    }
}
