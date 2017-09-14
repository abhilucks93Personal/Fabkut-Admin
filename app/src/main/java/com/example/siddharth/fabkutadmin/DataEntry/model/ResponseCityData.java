package com.example.siddharth.fabkutadmin.DataEntry.model;

/**
 * Created by Udit on 18-Jul-17 at 11:49 PM.
 */

public class ResponseCityData {

    private int city_Id;
    private String city_Name;
    private String active;

    public int getCity_Id() {
        return city_Id;
    }

    public void setCity_Id(int city_Id) {
        this.city_Id = city_Id;
    }

    public String getCity_Name() {
        return city_Name;
    }

    public void setCity_Name(String city_Name) {
        this.city_Name = city_Name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
