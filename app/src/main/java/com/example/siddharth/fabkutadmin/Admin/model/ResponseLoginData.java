package com.example.siddharth.fabkutadmin.Admin.model;

/**
 * Created by Udit on 16-Jul-17 at 11:39 PM.
 */

public class ResponseLoginData {

    private String Status;
    private String user_id;
    private String user_name;
    private String email;
    private String Contact_no;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_no() {
        return Contact_no;
    }

    public void setConatct_no(String conatct_no) {
        Contact_no = conatct_no;
    }
}
