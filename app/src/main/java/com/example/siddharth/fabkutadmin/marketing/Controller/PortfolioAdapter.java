package com.example.siddharth.fabkutadmin.marketing.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.Modal.ModelPortfolio;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ashish on 6/17/2017.
 */

public class PortfolioAdapter extends ArrayAdapter<ModelPortfolio> {
    Context context;
    ImageView imageView;
   ArrayList<ModelPortfolio> data;


    public PortfolioAdapter(Context context, ArrayList<ModelPortfolio> data) {
        super(context, R.layout.item_add_photo, data);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ModelPortfolio dataItem = (ModelPortfolio) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_add_photo, parent, false);
        }

        imageView =(ImageView)convertView.findViewById(R.id.Iv_portfolio);
        Picasso.with(getContext()).load(dataItem.getPhoto()).into(imageView);

        return convertView;
    }

}
