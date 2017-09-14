package com.example.siddharth.fabkutadmin.Inventory.View;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.siddharth.fabkutadmin.R;

/**
 * Created by Udit on 17-Jul-17 at 6:53 PM.
 */

public class ServiceCosting extends Fragment implements View.OnClickListener {

    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_service_costing,container);

        return v;
    }

    @Override
    public void onClick(View view) {

    }
}
