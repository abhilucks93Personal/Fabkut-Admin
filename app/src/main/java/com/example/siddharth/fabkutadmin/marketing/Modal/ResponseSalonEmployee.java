package com.example.siddharth.fabkutadmin.marketing.Modal;

import java.util.ArrayList;

/**
 * Created by Udit on 17-Jul-17 at 3:20 PM.
 */

public class ResponseSalonEmployee {

    private String STATUS ;
    private String MESSAGE;
    private ArrayList<ResponseSalonEmployeeData> data;

    public ArrayList<ResponseSalonEmployeeData> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseSalonEmployeeData> data) {
        this.data = data;
    }

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
}
