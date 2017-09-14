package com.example.siddharth.fabkutadmin.marketing.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.Controller.CustomAdapter;
import com.example.siddharth.fabkutadmin.marketing.Modal.ResponseSalonFacility;
import com.example.siddharth.fabkutadmin.marketing.Modal.modelFacility;
import com.example.siddharth.fabkutadmin.retrofit.RetrofitApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 6/16/2017.
 */

public class SalonFacility extends Fragment implements View.OnClickListener,RetrofitApi.ResponseListener {
    View v;

    CheckedTextView checkBox1;
    ListView listView;
    List<Integer> selectedItems = new ArrayList<>();
    List<Integer> facility_item = new ArrayList<>();
    TextView submit;
    int facility_id = 0;
    //ArrayList<ResponseSalonFacility> models = new ArrayList<>();

    ArrayList<modelFacility> modelq = new ArrayList<modelFacility>();

    //  ArrayList<SalonAddFacility> salonAddFacilities = new ArrayList<>();

    //SparseBooleanArray a = new SparseBooleanArray();
    CustomAdapter customAdapter;
    //ModelFacility modelFacility=new ModelFacility();

    public SalonFacility() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_salon_facility, container, false);


        findViewById();

        RetrofitApi.getInstance().salonfacilityShowApiMethod(getActivity(), this);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        CustomAdapter adapter = new CustomAdapter(getActivity(), modelq);
        listView.setAdapter(adapter);
//

        return v;

    }

    private void findViewById() {
        checkBox1 = (CheckedTextView) v.findViewById(R.id.checked_tv_facility);
        listView = (ListView) v.findViewById(R.id.list_checkbox);
        submit = (TextView) v.findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }


    @Override
    public void _onCompleted() {

    }

    @Override
    public void _onError(Throwable e) {

    }

    @Override
    public void _onNext(Object obj) {


        final ResponseSalonFacility responseSalonFacility = (ResponseSalonFacility) obj;
        Log.d("abc", "" + responseSalonFacility);


        //ResponseSalonFacility ab = new ResponseSalonFacility();

        for (int i = 0; i <= 2; i++) {
            modelq.add(new modelFacility(responseSalonFacility.getData().get(i).getFacility_Name(), responseSalonFacility.getData().get(i).getFacility_id()));

            //modelq.add(ab.getData().get(i).getFacility_Name());
        }
        CustomAdapter adapter = new CustomAdapter(getActivity(), modelq);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String selectedItem = ((TextView) view).getText().toString();
                for (int i = 0; i < 10; i++) {
                    if (selectedItem.equals(responseSalonFacility.getData().get(i).getFacility_Name())) {
                        facility_id = responseSalonFacility.getData().get(i).getFacility_id();
                        if (facility_item.contains(facility_id)) {
                            facility_item.remove(facility_id);
                        } else {//facility_id = responseSalonFacility.getData().get(i).getFacility_id();
                            facility_item.add(facility_id);
                        }
                    }
                }

                /*for (int i = 0; i < 2; i++){
                    if (responseSalonFacility.getData().get(i).getFacility_Name().equalsIgnoreCase(selectedItem)) {
                        facility_id = responseSalonFacility.getData().get(i).getFacility_id();

                    }
                }
*/
            }
        });
    }

    @Override
    public void _onNext1(Object obj) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                addFacility();
                break;
        }
    }

    private void addFacility() {
        //RetrofitApi.getInstance().salonfacilityInsertApiMethod(getActivity(), this, (ArrayList) selectedItems);
        Toast.makeText(getActivity(), " " + facility_item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

}