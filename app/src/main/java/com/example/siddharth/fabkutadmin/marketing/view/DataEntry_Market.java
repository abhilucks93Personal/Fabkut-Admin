package com.example.siddharth.fabkutadmin.marketing.view;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseCity;
import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseLocation;
import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.Modal.SalonData;
import com.example.siddharth.fabkutadmin.retrofit.RetrofitApi;

import java.util.ArrayList;
import java.util.List;

import static com.example.siddharth.fabkutadmin.R.id.spinner_city;
import static com.example.siddharth.fabkutadmin.R.id.tv_submit;

/**
 * Created by SIDDHARTH on 6/16/2017.
 */

public class DataEntry_Market extends AppCompatActivity implements View.OnClickListener , RetrofitApi.ResponseListener{

    SalonData data;
    View actionBarView;
    TextView tvTitle;
    ImageView iconLeft;
    Spinner spinnerCity,spinnerLocation;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    LinearLayout password;

    String user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataentry);

        RetrofitApi.getInstance().cityApiMethod(this,this);

        setActionBarView();
        findViewById();

//        preferences = getSharedPreferences("CreateLogin",MODE_PRIVATE);
//        String user_id = preferences.getString("UserId",null);
//        user_name = preferences.getString("UserName",null);
    }

    private void findViewById(){

        TextView tvsubmit = (TextView) findViewById(tv_submit);
        tvsubmit.setOnClickListener(this);
        tvTitle = (TextView) actionBarView.findViewById(R.id.actionbar_view_title);
        tvTitle.setText(user_name);

        iconLeft = (ImageView) actionBarView.findViewById(R.id.actionbar_view_icon_left);
        iconLeft.setImageDrawable(getResources().getDrawable(R.drawable.rectangle4));
        iconLeft.setVisibility(View.VISIBLE);
        iconLeft.setOnClickListener(this);
        spinnerCity = (Spinner)findViewById(R.id.spinner_city);

        password = (LinearLayout) findViewById(R.id.data_linear_pass);
        password.setVisibility(View.VISIBLE);


    }



    private void setActionBarView() {

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar_view_custom);
        actionBarView = getSupportActionBar().getCustomView();
    }

    public void submit() {
        Intent i = new Intent(getApplicationContext(), Marketing_Tab.class);
        //i.putExtra("item", data);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case tv_submit:
                submit();
                break;
            case R.id.actionbar_view_icon_left:
                finish();
                break;
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
        ResponseCity responseCity = (ResponseCity) obj;
        Log.d("abc ", "" + responseCity);
        //responseCity.getMESSAGE();
        //ArrayAdapter<ResponseCity>
        //final ResponseCity responseCity1=new ResponseCity();
        //

        List<String> item = new ArrayList<String>();
        for (int i = 0; i<2; i++)
            item.add(responseCity.getData().get(i).getCity_Name());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, item);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(dataAdapter);
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
