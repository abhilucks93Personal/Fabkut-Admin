package com.example.siddharth.fabkutadmin.Admin.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.siddharth.fabkutadmin.Admin.model.ResponseLogin;
import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseLocation;
import com.example.siddharth.fabkutadmin.DataEntry.view.DataEntry;

//import com.example.siddharth.fabkutadmin.Inventory.View.InventoryTab;
import com.example.siddharth.fabkutadmin.Inventory.View.InventoryTab;
import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.view.MarketingActivity;
import com.example.siddharth.fabkutadmin.retrofit.RetrofitApi;

/**
 * Created by Udit on 6/16/2017.
 */

public class Login extends AppCompatActivity implements View.OnClickListener, RetrofitApi.ResponseListener {

    Spinner spinner_1;
    EditText et_user, et_pass;
    View actionBarView;
    TextView tvTitle;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private String type, user,pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
       // setTitle("Login");
         setActionBarView();
        findViewById();
    }

    private void findViewById() {
        TextView tvLogin = (TextView) findViewById(R.id.login_tvLogin);
        tvLogin.setOnClickListener(this);
        tvTitle = (TextView) actionBarView.findViewById(R.id.actionbar_view_title);
        tvTitle.setText("Login");
    }

    private void setActionBarView() {
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        View customView = getLayoutInflater().inflate(R.layout.actionbar_view_custom, null);
        getSupportActionBar().setCustomView(customView);
        Toolbar parent =(Toolbar) customView.getParent();
        parent.setPadding(0,0,0,0);//for tab otherwise give space in tab
        parent.setContentInsetsAbsolute(0,0);
       /* getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar_view_custom);*/
        actionBarView = getSupportActionBar().getCustomView();
    }

    public void login() {
        spinner_1 = (Spinner) findViewById(R.id.select_user);
        et_user = (EditText) findViewById(R.id.login_user);
        et_pass = (EditText) findViewById(R.id.login_etPassword);
        type = spinner_1.getSelectedItem().toString();
        user = et_user.getText().toString();
        pass = et_pass.getText().toString();

        if (type.equalsIgnoreCase("Data_Entry")) {
            RetrofitApi.getInstance().loginApiMethod(this,this,"2",user,pass);
        } else if (type.equalsIgnoreCase("Marketing")) {
            RetrofitApi.getInstance().loginApiMethod(this,this,"1",user,pass);
        }  /*
        else if (type.equalsIgnoreCase("Inventory")) {
*//*            Intent i = new Intent(getApplicationContext(), InventoryTab.class);
            startActivity(i);*//*
            RetrofitApi.getInstance().loginApiMethod(this,this,"3",user,pass);
        }*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_tvLogin:
                login();
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
        ResponseLogin responseLogin = (ResponseLogin) obj;
        Log.d("abc", "" + responseLogin);
        if (user.trim().length()==0 && pass.trim().length()==0){
            Toast.makeText(getApplicationContext(),"please enter username, password",Toast.LENGTH_SHORT).show();
        }
        else if (responseLogin.getSTATUS().equals("200"))    // email pass is correct
            if (type.equalsIgnoreCase("Data_Entry")) {
                preferences = getSharedPreferences("CreateLogin",MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("UserName",user);
                editor.commit();
                Intent i = new Intent(getApplicationContext(), DataEntry.class);
                startActivity(i);
            } else if (type.equalsIgnoreCase("Marketing")) {
                preferences = getSharedPreferences("CreateLogin",MODE_PRIVATE);
                editor = preferences.edit();
                editor.putString("UserId",responseLogin.getData().get(0).getUser_id());
                editor.putString("UserName",responseLogin.getData().get(0).getUser_name());
                editor.commit();
                Intent i = new Intent(getApplicationContext(), MarketingActivity.class);
                startActivity(i);
            } else if (type.equalsIgnoreCase("Inventory")) {    //web services of inventory are not available yet...
                Toast.makeText(getApplicationContext(),"inghjgk",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), InventoryTab.class);
                startActivity(i);
            }
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
