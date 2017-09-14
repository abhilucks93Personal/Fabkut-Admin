package com.example.siddharth.fabkutadmin.marketing.Modal;

/**
 * Created by SIDDHARTH on 7/17/2017.
 */

import java.util.ArrayList;

public class ResponseSalonFacilityData {

    public String facility_Name;
    public int facility_id;

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public String getFacility_Name() {
        return facility_Name;
    }

    public void setFacility_Name(String facility_Name) {
        this.facility_Name = facility_Name;
    }
}
