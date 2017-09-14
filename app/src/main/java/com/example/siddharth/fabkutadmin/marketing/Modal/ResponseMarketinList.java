package com.example.siddharth.fabkutadmin.marketing.Modal;

import java.util.ArrayList;

/**
 * Created by SIDDHARTH on 7/19/2017.
 */

public class ResponseMarketinList {

    private String MESSAGE;
    private String STATUS;
    private ArrayList<ResponseMarketinListData> data;


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

    public void setData(ArrayList<ResponseMarketinListData> data) {
        this.data = data;
    }

    public ArrayList<ResponseMarketinListData> getData() {
        return data;
    }



}


