package com.example.siddharth.fabkutadmin.DataEntry.model;

/**
 * Created by Udit on 20-Jul-17 at 2:09 PM.
 */

public class ResponseLocationData {
    public int  city_Id;
    public int  Location_Id;
    public String location_name;
    public String Location_code;


    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public int getCity_Id() {
        return city_Id;
    }

    public void setCity_Id(int city_Id) {
        this.city_Id = city_Id;
    }

    public int getLocation_Id() {
        return Location_Id;
    }

    public void setLocation_Id(int location_Id) {
        Location_Id = location_Id;
    }

    public String getLocation_code() {
        return Location_code;
    }

    public void setLocation_code(String location_code) {
        Location_code = location_code;
    }
}
