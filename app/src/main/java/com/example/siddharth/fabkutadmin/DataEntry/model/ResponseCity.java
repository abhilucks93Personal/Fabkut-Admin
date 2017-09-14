package com.example.siddharth.fabkutadmin.DataEntry.model;

import java.util.ArrayList;

/**
 * Created by Udit on 18-Jul-17 at 11:47 PM.
 */

public class ResponseCity {

    private String MESSAGE;
    private String STATUS;
    private ArrayList<ResponseCityData> data;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public ArrayList<ResponseCityData> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseCityData> data) {
        this.data = data;
    }
}
