package com.example.siddharth.fabkutadmin.marketing.Modal;

import java.io.Serializable;

import static android.R.attr.name;

/**
 * Created by SIDDHARTH on 7/18/2017.
 */

public class modelFacility {
    private String facility_name;
    private int facility_id;


    public modelFacility(String facility_name,int facility_id) {
        this.facility_name=facility_name;
        this.facility_id=facility_id;

    }



    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }
}
