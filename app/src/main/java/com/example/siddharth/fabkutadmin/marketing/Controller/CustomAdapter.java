package com.example.siddharth.fabkutadmin.marketing.Controller;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.Modal.modelFacility;

import static com.example.siddharth.fabkutadmin.R.layout.item_checkbox;


import java.util.ArrayList;

/**
 * Created by Ashish on 6/16/2017.
 */

public class CustomAdapter extends ArrayAdapter<modelFacility> {
    Context context;
    CheckBox cb;
    TextView tv;
    ArrayList<modelFacility> data;
    //ArrayList<char[]> data;

   // ArrayList<char[]> abc = new ArrayList<char[]>();



    public CustomAdapter(Context context, ArrayList<modelFacility> data) {
        super(context, R.layout.item_checkbox, data);

    }




    public  View getView ( int position, View convertView, ViewGroup parent) {


        //abc dataItem =(Str) getItem(position);
           modelFacility dataItem = (modelFacility) getItem(position);




                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(item_checkbox, parent, false);
                }
                CheckBox cb = (CheckBox) convertView.findViewById(R.id.cb_facility);

                 //cb.setText(dataItem.getData().get(1).getFacility_Name());
                cb.setText(dataItem.getFacility_name());


                return convertView;
            }

}





