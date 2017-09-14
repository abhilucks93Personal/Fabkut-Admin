package com.example.siddharth.fabkutadmin.Inventory.View;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.siddharth.fabkutadmin.R;

import java.util.Calendar;

//import com.example.siddharth.fabkutadmin.R;

/**
 * Created by SIDDHARTH on 6/16/2017.
 */

public class FragmentSample extends Fragment implements View.OnClickListener{

    private int hour, min;
    TextView timeOpen, timeClose;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_create__saloon, container, false);
        ImageView openTime = (ImageView) v.findViewById(R.id.create_ivOpenTime);
        ImageView closeTime = (ImageView) v.findViewById(R.id.create_ivCloseTime);
        timeOpen = (TextView) v.findViewById(R.id.create_salon_timeopen_tv);
        timeClose  = (TextView) v.findViewById(R.id.create_salon_timeclose_tv);

        openTime.setOnClickListener(this);
        closeTime.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.create_ivOpenTime:
                timeDialog(timeOpen);
                break;

            case R.id.create_ivCloseTime:
                timeDialog(timeClose);
                break;
        }
    }


    public void timeDialog(final TextView textView){

       Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        textView.setText(hourOfDay + ":" + minute);
                    }
                }, hour, min, false);
        timePickerDialog.show();
    }
}
