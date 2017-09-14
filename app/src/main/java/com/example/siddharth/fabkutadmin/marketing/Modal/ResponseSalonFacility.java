package com.example.siddharth.fabkutadmin.marketing.Modal;

import com.example.siddharth.fabkutadmin.Admin.model.ResponseLoginData;

import java.util.ArrayList;

/**
 * Created by SIDDHARTH on 7/17/2017.
 */

public class ResponseSalonFacility {

    private String MESSAGE;
    private String STATUS;


    private ArrayList<ResponseSalonFacilityData> data;

    public ArrayList<ResponseSalonFacilityData> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseSalonFacilityData> data) {
        this.data = data;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }



    public String getMESSAGE() {
        return MESSAGE;
    }

    public String getSTATUS() {
        return STATUS;
    }


}
