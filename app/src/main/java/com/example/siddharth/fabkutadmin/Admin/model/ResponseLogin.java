package com.example.siddharth.fabkutadmin.Admin.model;

import java.util.ArrayList;

/**
 * Created by Udit on 16-Jul-17 at 11:35 PM.
 */

public class ResponseLogin {

    private String MESSAGE;
    private String STATUS;
    private ArrayList<ResponseLoginData> data;

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

    public ArrayList<ResponseLoginData> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseLoginData> data) {
        this.data = data;
    }


}
