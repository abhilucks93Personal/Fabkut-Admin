package com.example.siddharth.fabkutadmin.marketing.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseLocation;
import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.Modal.ResponseSalonEmployee;
import com.example.siddharth.fabkutadmin.retrofit.RetrofitApi;

/**
 * Created by SIDDHARTH on 6/16/2017.
 */

public class SalonEmployee extends Fragment implements View.OnClickListener, RetrofitApi.ResponseListener{

    View v;
    TextView textView;
    EditText editText1,editText2,editText3,editText4;

    String emp_Name,emp_Contact, emp_Spec,emp_Addr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       //  Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_salonemployee, container, false);
        findViewById(v);
        return v;
    }

    private void findViewById(View v) {

        textView = (TextView)v.findViewById(R.id.tv_fragment_salonEmployee_submit);
        editText1 = (EditText)v.findViewById(R.id.fragment_salonEmployee_name);
        editText2 = (EditText)v.findViewById(R.id.fragment_salonEmployee_contact);
        editText3 = (EditText)v.findViewById(R.id.fragment_salonEmployee_spec);
        editText4 = (EditText)v.findViewById(R.id.fragment_salonEmployee_addr);



        textView.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_fragment_salonEmployee_submit:
                submitEmployee();
                break;

        }
    }

        public void submitEmployee(){

            emp_Name = editText1.getText().toString();
            emp_Contact = editText2.getText().toString();
            emp_Spec = editText3.getText().toString();
            emp_Addr = editText4.getText().toString();
            //Toast.makeText(getActivity(), "submitted...", Toast.LENGTH_SHORT).show();
            RetrofitApi.getInstance().salonEmployeeApiMethod(getActivity(),this,"1",emp_Name,emp_Contact,emp_Spec,emp_Addr);

    }




    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }

    @Override
    public void _onNext(Object obj) {
        ResponseSalonEmployee responseSalonEmployee = (ResponseSalonEmployee) obj;
        Log.d("abc","" + responseSalonEmployee);
        if(responseSalonEmployee.getSTATUS().equals("200")){
            Toast.makeText(getActivity(), "employee Added...", Toast.LENGTH_SHORT).show();
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
