package com.example.siddharth.fabkutadmin.marketing.Modal;

import java.io.Serializable;

/**
 * Created by Ashish on 6/15/2017.
 */

public class SalonData  {

    public int b_Target_id;
    public String user_name;
    public String business_Name;
    public String contact_No;
    public String city_Name;
    public String location_Name;
    public String address1;


    public SalonData(String user_name, String business_Name, String contact_No, String city_Name, String location_Name, String address1) {
        this.user_name = user_name;
        this.business_Name = business_Name;
        this.contact_No = contact_No;
        this.city_Name = city_Name;
        this.location_Name = location_Name;
        this.address1 = address1;
    }

    public int getB_Target_id() {
        return b_Target_id;
    }

    public void setB_Target_id(int b_Target_id) {
        this.b_Target_id = b_Target_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBusiness_Name() {
        return business_Name;
    }

    public void setBusiness_Name(String business_Name) {
        this.business_Name = business_Name;
    }

    public String getContact_No() {
        return contact_No;
    }

    public void setContact_No(String contact_No) {
        this.contact_No = contact_No;
    }

    public String getCity_Name() {
        return city_Name;
    }

    public void setCity_Name(String city_Name) {
        this.city_Name = city_Name;
    }

    public String getLocation_Name() {
        return location_Name;
    }

    public void setLocation_Name(String location_Name) {
        this.location_Name = location_Name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }
}
