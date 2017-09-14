package com.example.siddharth.fabkutadmin.marketing.Modal;

/**
 * Created by Udit on 17-Jul-17 at 3:45 PM.
 */

public class ResponseSalonEmployeeData {
    private String Status;
    private String emp_id;
    private String Emp_name;
    private String emp_contact_No;
    private String spcst;
    private String adress1;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return Emp_name;
    }

    public void setEmp_name(String emp_name) {
        Emp_name = emp_name;
    }

    public String getEmp_contact_No() {
        return emp_contact_No;
    }

    public void setEmp_contact_No(String emp_contact_No) {
        this.emp_contact_No = emp_contact_No;
    }

    public String getSpcst() {
        return spcst;
    }

    public void setSpcst(String spcst) {
        this.spcst = spcst;
    }

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
    }
}
