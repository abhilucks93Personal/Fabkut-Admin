package com.example.siddharth.fabkutadmin.DataEntry.model;

import java.util.ArrayList;

/**
 * Created by abhi on 26/06/17.
 */

public class ResponseModelDataEntry {
    private String STATUS;
    private String MESSAGE;
    private ArrayList<ResponseModelDataEntryData> data;

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }


    public ArrayList<ResponseModelDataEntryData> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseModelDataEntryData> data) {
        this.data = data;
    }
}