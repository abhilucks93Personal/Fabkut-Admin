package com.example.siddharth.fabkutadmin.marketing.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.Modal.ResponseMarketinList;
import com.example.siddharth.fabkutadmin.marketing.Modal.SalonData;
import com.example.siddharth.fabkutadmin.marketing.view.DataEntry_Market;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ashish on 6/15/2017.
 */

public class PendingAdapter extends ArrayAdapter<SalonData> {

    private SalonData dataItem;

    public PendingAdapter(Context context, ArrayList<SalonData> data) {
        super(context,R.layout.item_pendingwork, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        dataItem = getItem(position);



        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pendingwork, parent, false);
        }

        TextView tvSalon, tvContact, tvAddress, tvPerson, tvCity;
        tvSalon = (TextView) convertView.findViewById(R.id.salon_name);
        tvContact = (TextView) convertView.findViewById(R.id.contact);
        tvAddress = (TextView) convertView.findViewById(R.id.address);
        tvPerson = (TextView) convertView.findViewById(R.id.Contact_person);
        tvCity = (TextView) convertView.findViewById(R.id.city);
//
         tvSalon.setText(dataItem.getBusiness_Name());
        tvContact.setText(dataItem.getContact_No());
        tvAddress.setText(dataItem.getLocation_Name());
        tvPerson.setText(dataItem.getUser_name());
        tvCity.setText(dataItem.getCity_Name());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), DataEntry_Market.class);
                 //i.putExtra("item", (Seriali dataItem);
                ((Activity) getContext()).startActivity(i);
            }
        });

        return convertView;
    }
}
