package com.example.siddharth.fabkutadmin.marketing.Modal;

/**
 * Created by Ashish on 6/17/2017.
 */

public class ModelPortfolio {

    String photo;
    public ModelPortfolio(){

    }

    public ModelPortfolio(String str) {
        photo = str;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
