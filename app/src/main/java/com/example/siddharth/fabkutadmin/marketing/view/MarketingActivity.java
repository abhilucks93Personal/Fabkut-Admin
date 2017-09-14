package com.example.siddharth.fabkutadmin.marketing.view;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.siddharth.fabkutadmin.Admin.model.ResponseLogin;
import com.example.siddharth.fabkutadmin.Admin.view.Login;
import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseLocation;
import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.Controller.PendingAdapter;
import com.example.siddharth.fabkutadmin.marketing.Modal.ResponseMarketinList;
import com.example.siddharth.fabkutadmin.marketing.Modal.ResponseMarketinListData;
import com.example.siddharth.fabkutadmin.marketing.Modal.ResponseSalonFacility;
import com.example.siddharth.fabkutadmin.marketing.Modal.SalonData;
import com.example.siddharth.fabkutadmin.marketing.Modal.modelFacility;
import com.example.siddharth.fabkutadmin.retrofit.RetrofitApi;

import java.util.ArrayList;

/**
 * Created by Udit on 16-Jun-17 at 3:30 PM.
 */

public class MarketingActivity extends AppCompatActivity implements View.OnClickListener,RetrofitApi.ResponseListener{

    View actionBarView;
    ListView listView;
    ImageView iconLeft;
    TextView tvTitle;
    ArrayList<SalonData> dataModelList = new ArrayList<SalonData>();
    //ArrayList<ResponseLogin> data_user = new ArrayList<>();
    PendingAdapter itemsAdapter;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_marketting);


        setActionBarView();
        findViewById();
        preferences = getSharedPreferences("CreateLogin",MODE_PRIVATE);
        String user_id = preferences.getString("UserId",null);
        String user_name = preferences.getString("UserName",null);
        tvTitle.setText(user_name);

        RetrofitApi.getInstance().marketinglistApiMethod(this,this,user_id);

//        Intent intent = getIntent();
//        ModelResponse data_user = (ModelResponse) intent.getSerializableExtra("user_id");
//
//        tvTitle.setText(data_user.getUser_name());


       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), DataEntry_Market.class);
                i.putExtra("item",dataModelList.get(position));
                startActivity(i);
            }
        });*/
    }

    public void findViewById(){
        tvTitle = (TextView) actionBarView.findViewById(R.id.actionbar_view_title);

        iconLeft = (ImageView) actionBarView.findViewById(R.id.actionbar_view_icon_left);
        iconLeft.setImageDrawable(getResources().getDrawable(R.drawable.rectangle4));
        iconLeft.setVisibility(View.VISIBLE);
        iconLeft.setOnClickListener(this);

    }


    private void setActionBarView() {

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar_view_custom);
        actionBarView = getSupportActionBar().getCustomView();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.actionbar_view_icon_left:
                finish();
                break;

//            case R.id.login_tvLogin:
//
//                login();
//
//                break;

        }
    }

    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }

    @Override
    public void _onNext(Object obj) {

        ResponseMarketinList responseMarketingList = (ResponseMarketinList) obj;
        Log.d("abc", "" + responseMarketingList);




        listView = (ListView) findViewById(R.id.list_billing);

        for (int i = 0; i < 4; i++) {
            //SalonData data = new SalonData();
            dataModelList.add(new SalonData((responseMarketingList).getData().get(i).getUser_name(),
                    responseMarketingList.getData().get(i).getBusiness_Name(),
                    responseMarketingList.getData().get(i).getContact_No(),
                    responseMarketingList.getData().get(i).getCity_Name(),
                    responseMarketingList.getData().get(i).getLocation_Name(),
                    responseMarketingList.getData().get(i).getAddress1()));
        }
        itemsAdapter = new PendingAdapter(this, dataModelList);
        listView.setAdapter(itemsAdapter);
            //modelq.add(ab.getData().get(i).getFacility_Name());


    }

    @Override
    public void _onNext1(Object obj) {

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
