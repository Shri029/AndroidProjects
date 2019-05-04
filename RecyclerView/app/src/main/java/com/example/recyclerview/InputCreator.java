package com.example.recyclerview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class InputCreator {

    static InputCreator inputCreator;
    List<MyListData> listData;
    Boolean c1, c2, c3, c4;

    String[] names = new String[]{ "Ayush" ,  "Rana Ibrahimi", "Eva Choudhary", "Shivi" , "Laddu", "Bro",
                                   "Nehal Pandey", "Deepti", "Sandhya", "Utteya", "Manjari", "Nimisha",
                                    "Archana", "Sandu", "Deepu", "Anjali", "Ankit",
                                     "Kreena", "Morni", "Prerna", "Richa", "Uttara", "Dristi"};

    Boolean[] eligible = new Boolean[]{true, false, true, false, false, false, true, false, false, true, false,
                                       true, false, true, true, false, true, true, false, true, false, true, true};
    Boolean[] registered = new Boolean[]{true, true, true, false, true, true, false, true, false, true, false,
                                            false, true, false, false, true, true, false,false, true, true, false, true };
    Boolean[] attended = new Boolean[]{true, false, false, true, true, false, true, false,false, false, true, true,
                                        true, false, true, true, false, true, false, true,false, true, true };
    Boolean[] selected = new Boolean[]{true, true, false, false, false, true, true, false, true, true, false, true,
                                        false, true, true, false, true, true, true, false, true, false, false };

    public  InputCreator(Context context){

        listData = new ArrayList<>();
        for(int i=0; i<names.length; i++)
        {
            String str = (i+1)+". "+ names[i];
            c1 = eligible[i];
            c2 = registered[i];
            c3 = attended[i];
            c4 = selected[i];

            MyListData tile= new MyListData( String.format(str), c1, c2, c3, c4 );
            listData.add(tile);
        }
    }

    public static InputCreator get(Context context){

        if(inputCreator==null)
            inputCreator = new InputCreator(context);
        return inputCreator;
    }

    public List<MyListData> getAll(){

        return listData;
    }
}
