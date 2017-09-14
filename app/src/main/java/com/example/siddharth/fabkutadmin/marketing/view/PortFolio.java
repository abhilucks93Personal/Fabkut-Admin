package com.example.siddharth.fabkutadmin.marketing.view;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.Controller.PortfolioAdapter;
import com.example.siddharth.fabkutadmin.marketing.Modal.ModelPortfolio;

import java.util.ArrayList;

/**
 * Created by Ashish on 6/17/2017.
 */

public class PortFolio extends Fragment  implements View.OnClickListener {
    View v;
    ListView lv;
    ImageView iv;
    TextView tv , camera,gallery;
    PortfolioAdapter portfolioAdapter;
    ArrayList<ModelPortfolio> models = new ArrayList<>();

    public PortFolio(){


    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



//
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_portfolio,container,false);
        lv= (ListView)v.findViewById(R.id.lv_portfolio);
        iv=(ImageView)v.findViewById(R.id.Iv_portfolio);
        models = new ArrayList<>();
        models.add(new ModelPortfolio());
        models.add(new ModelPortfolio("https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAA2YAAAAJDg3ZmIzNjYzLWFlYTEtNGJlZC04YzVlLTY3OWE1NmY4MDY2Yw.jpg"));
        findViewById(v);
        PortfolioAdapter portfolioAdapter=new PortfolioAdapter(getActivity(),models);
        lv.setAdapter(portfolioAdapter);

    return v;
    }

    private void findViewById(View v) {

        tv=(TextView)v.findViewById(R.id.tv_add_photo);
        tv.setOnClickListener(this);



    }

    public void addPhoto( ){


        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_portfolio);
        camera = (TextView) dialog.findViewById(R.id.tv_camera);
        gallery= (TextView) dialog.findViewById(R.id.tv_gallery);
        gallery.setText("camera");
        camera.setText("gallery");
        dialog.show();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tv_add_photo:

                addPhoto();

                break;

        }
    }







}
