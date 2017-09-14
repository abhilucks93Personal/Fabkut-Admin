package com.example.siddharth.fabkutadmin.DataEntry.model;

import java.util.ArrayList;

/**
 * Created by Udit on 20-Jul-17 at 2:06 PM.
 */

public class ResponseLocation {

    public String MESSAGE;
    public String STATUS;
    public ArrayList<ResponseLocationData> data;

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

    public ArrayList<ResponseLocationData> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseLocationData> data) {
        this.data = data;
    }
}
