package com.example.siddharth.fabkutadmin.DataEntry.view;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseCity;
import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseLocation;
import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseModelDataEntry;
import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.retrofit.RetrofitApi;
import com.squareup.picasso.Downloader;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_dropdown_item_1line;
import static android.R.layout.simple_spinner_item;

public class DataEntry extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener, RetrofitApi.ResponseListener {

    View actionBarView;
    TextView tvTitle;
    ImageView iconLeft;
    TextView tvSubmit;
    EditText etSalonName, etName,etContact, etEmail,etOffice,etLocation,etLandMark;
    Spinner spinnerCity,spinnerLocation;
  //  ModelDataEntry modelDataEntry = new ModelDataEntry();
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String salonName,name,contact,email,office,location,landmark, spCity;
    Integer city_id,location_id;
    int selected_cityId;
    RetrofitApi.ResponseListener responseListener;
    ResponseLocation response;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataentry);
        preferences = this.getApplicationContext().getSharedPreferences("CreateLogin", Context.MODE_PRIVATE);


//        RetrofitApi.getInstance().locationApiMethod(this,this,1);
      //  RetrofitApi.getInstance().locationApiMethod(this,this,selected_cityId);

        setActionBarView();
        findViewById();
        RetrofitApi.getInstance().cityApiMethod(this,this);

        preferences = getSharedPreferences("CreateLogin",MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString("flag","data");
        editor.commit();

        String getName = preferences.getString("UserName",null);
        etName.setText(getName);

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                String citySelected= String .valueOf(spinnerCity.getSelectedItem());
                selected_cityId = (int) (spinnerCity.getSelectedItemId() + 1);
                Toast.makeText(DataEntry.this, citySelected + selected_cityId, Toast.LENGTH_SHORT).show();
                Log.d(">>>>Selected item>>> : ", citySelected);
                RetrofitApi.getInstance().locationApiMethod(DataEntry.this,responseListener,selected_cityId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void findViewById()    {
        tvTitle = (TextView) actionBarView.findViewById(R.id.actionbar_view_title);
        tvTitle.setText("Data Entry");

        iconLeft = (ImageView) actionBarView.findViewById(R.id.actionbar_view_icon_left);
        iconLeft.setImageDrawable(getResources().getDrawable(R.drawable.rectangle4));
        iconLeft.setVisibility(View.VISIBLE);
        iconLeft.setOnClickListener(this);

        etSalonName = (EditText) findViewById(R.id.activity_dataentry_salon_name);
        etName = (EditText) findViewById(R.id.activity_dataentry_contact_name);
        etContact = (EditText) findViewById(R.id.activity_dataentry_contact_no);
        etEmail = (EditText) findViewById(R.id.activity_dataentry_email);
        etOffice = (EditText) findViewById(R.id.activity_dataentry_office_no);
        etLocation = (EditText) findViewById(R.id.activity_dataentry_street);
        etLandMark = (EditText) findViewById(R.id.activity_dataentry_landmark);

        spinnerCity = (Spinner) findViewById(R.id.spinner_city);
        spinnerLocation = (Spinner) findViewById(R.id.spinner_location);

        tvSubmit = (TextView) findViewById(R.id.tv_submit);
        tvSubmit.setOnClickListener(this);
       // spinnerCity.setOnItemClickListener(this);
       // spinnerLocation.setOnClickListener(this);
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
           /* case R.id.spinner_city:
                getCity();
            case R.id.spinner_location:
                 getLocation();
           */ case R.id.tv_submit:
                fetchData();
                break;
        }
    }

    private void fetchData() {
//        city_id = (Integer) spinnerCity.getSelectedItem();
//        location_id =(Integer) spinnerLocation.getSelectedItem();
        salonName = etSalonName.getText().toString();
        name = etName.getText().toString();
        contact = etContact.getText().toString();
        email = etEmail.getText().toString();
        office = etOffice.getText().toString();
        location = etLocation.getText().toString();
        landmark = etLandMark.getText().toString();


       // modelDataEntry.setBusiness_Name("Fabkut Saloon");
        RetrofitApi.getInstance().dataEntryApiMethod(this, this,1,city_id,location_id,salonName,name,contact,email,office,location,landmark);
  }

    @Override
    public void _onNext(Object obj) {
        if(obj instanceof ResponseCity){
            final ResponseCity responseCity = (ResponseCity) obj;
            Log.d("abc ", "" + responseCity);
            List<String> item = new ArrayList<String>();
            for (int i = 0; i < 2; i++)
                item.add(responseCity.getData().get(i).getCity_Name());
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, simple_spinner_item, item);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerCity.setAdapter(dataAdapter);
        }
        else if (obj instanceof ResponseLocation){
            final ResponseLocation responseLocation = (ResponseLocation) obj;
            List<String> locationArray = new ArrayList<String>();
            for (int i=0;i<3;i++)
                locationArray.add(responseLocation.getData().get(i).getLocation_name());
            ArrayAdapter<String> abc = new ArrayAdapter<>(this, simple_spinner_item, locationArray);
            abc.setDropDownViewResource(simple_dropdown_item_1line);
            spinnerLocation.setAdapter(abc);
        }

//        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
//                // TODO Auto-generated method stub
//                String citySelected= String .valueOf(spinnerCity.getSelectedItem());
//                Integer selected_cityId = (int) (spinnerCity.getSelectedItemId() + 1);
//                Toast.makeText(DataEntry.this, citySelected + selected_cityId, Toast.LENGTH_SHORT).show();
//                Log.d(">>>>Selected item>>> : ", citySelected);
//                RetrofitApi.getInstance().locationApiMethod(DataEntry.this,responseListener,selected_cityId);
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//            }
//        });



// if(responseLocation.getSTATUS().equals("200")) {
//           List<String> item_location = new ArrayList<String>();
//            for (int i = 0; i < 2; i++)
//                item_location.add(responseLocation.getData().get(i).getLocation_name());
//            ArrayAdapter<String> abc = new ArrayAdapter<String>(this, simple_spinner_item, item_location);
//            abc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            spinnerLocation.setAdapter(abc);
//    }

//        ResponseModelDataEntry responseModelDataEntry = (ResponseModelDataEntry) obj;
//        Log.d("Entered Data","" + responseModelDataEntry);
//        if(responseModelDataEntry.getSTATUS().equals("200")){
//            Toast.makeText(this, "Data entered successfully....", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public void _onNext1(Object obj) {
//        final ResponseLocation responseLocation = (ResponseLocation) obj;
//        // Log.d("abc ", "" + responseLocation);
//        List<String> locationArray = new ArrayList<String>();
//        for (int i=0;i<3;i++)
//            locationArray.add(responseLocation.getData().get(i).getLocation_name());
//        ArrayAdapter<String> abc = new ArrayAdapter<>(this, simple_spinner_item, locationArray);
//        abc.setDropDownViewResource(simple_dropdown_item_1line);
//        spinnerLocation.setAdapter(abc);
    }

    @Override
    public void _onCompleted() {

    }

     @Override
    public void _onError(Throwable e) {
        Log.e("tag", e.getMessage());
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}

//progress dialog
//        .getClient>>>RetroftApi
