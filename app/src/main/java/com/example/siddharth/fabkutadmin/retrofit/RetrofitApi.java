package com.example.siddharth.fabkutadmin.retrofit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.siddharth.fabkutadmin.Admin.model.ResponseLogin;
import com.example.siddharth.fabkutadmin.DataEntry.model.ModelDataEntry;
import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseLocation;
import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseLocationData;
import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseModelDataEntry;
import com.example.siddharth.fabkutadmin.DataEntry.model.ResponseCity;
import com.example.siddharth.fabkutadmin.marketing.Modal.ResponseMarketinList;
import com.example.siddharth.fabkutadmin.marketing.Modal.ResponseSalonFacility;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by abhishekagarwal on 3/21/17.
 */

public class RetrofitApi {

    private ProgressDialog mProgressDialog;
    private static RetrofitApi retrofitApi = null;
   private ResponseListener mlistener_response;


    public static RetrofitApi getInstance() {

        if (retrofitApi != null)
            return retrofitApi;
        else
            return new RetrofitApi();
    }


    public interface ResponseListener extends AdapterView.OnItemSelectedListener {

        void _onCompleted();

        void _onError(Throwable e);

        void _onNext(Object obj);

        void _onNext1(Object obj);
    }


    // --------------------- Retrofit Api Methods ----------------------------------------------------------


    public void dataEntryApiMethod(final Activity activity, final ResponseListener _mlistener_response, int user_id, int city_id, int location_id,String business_name, String contact_persion, String contact_no, String business_email, String contact_no1, String address1, String landmark) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();

        RetrofitClient.getClient().dataEntryApiMethod(user_id,city_id,location_id,business_name,contact_persion,contact_no,business_email,contact_no1,address1,landmark).subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseModelDataEntry>() {
                    @Override
                    public void onCompleted() {
                        mProgressDialog.dismiss();
                        mlistener_response._onCompleted();
                    }


                    @Override
                    public void onError(Throwable e) {
                        mlistener_response._onError(e);
                    }

                    @Override
                    public void onNext(ResponseModelDataEntry responseModelDataEntry) {
                        mlistener_response._onNext(responseModelDataEntry);
                    }

                });
    }


    public void loginApiMethod(final Activity activity, final ResponseListener _mlistener_response, String type_id, String user, String pass) {    //remove final from string user
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();

        RetrofitClient.getClient().loginApiMethod(type_id, user, pass).subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseLogin>() {
                    @Override
                    public void onCompleted() {
                        mProgressDialog.dismiss();
                        mlistener_response._onCompleted();
                     //  user_name =user;

                    }

                    @Override
                    public void onError(Throwable e) {
                        mlistener_response._onError(e);
                    }

                    @Override
                    public void onNext(ResponseLogin responseLogin) {
                        mlistener_response._onNext(responseLogin);
                    }
                });
    }

    public void salonEmployeeApiMethod(final Activity activity,final ResponseListener _mlistener_response,String business_id, String emp_name, String emp_contact, String emp_spec, String emp_addr){
        this.mlistener_response = _mlistener_response;
//        mProgressDialog = new ProgressDialog(activity);
//        mProgressDialog.setMessage("Please Wait");
//        mProgressDialog.setCancelable(true);
//        mProgressDialog.show();

        Toast.makeText(activity, "Employee Added Successfully", Toast.LENGTH_SHORT).show();

        RetrofitClient.getClient().salonEmployeeApiMethod(business_id,emp_name,emp_contact,emp_spec,emp_addr).subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseLogin>() {
                    @Override
                    public void onCompleted() {
                        mProgressDialog.dismiss();
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mlistener_response._onError(e);
                    }

                    @Override
                    public void onNext(ResponseLogin responseLogin) {   // change parameter to ResponseModelDataEntry
                        mlistener_response._onNext(responseLogin);
                    }
                });
    }


    public void cityApiMethod(final Activity activity, final ResponseListener mlistener_response) {
        this.mlistener_response = mlistener_response;

        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();

        RetrofitClient.getClient().cityApiMethod().subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseCity>() {
                    @Override
                    public void onCompleted() {
                        mProgressDialog.dismiss();
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mlistener_response._onError(e);
                    }

                    @Override
                    public void onNext(ResponseCity responseCity) {
                        mlistener_response._onNext(responseCity);
                    }
                });
    }

    public void locationApiMethod(final Activity activity, final ResponseListener mlistener_response, int city_id) {
        this.mlistener_response = mlistener_response;

        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();

        RetrofitClient.getClient().locationApiMethod(city_id).subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ResponseLocation>() {
            @Override
            public void onCompleted() {
                mProgressDialog.dismiss();
                mlistener_response._onCompleted()
                ;
            }


            @Override
            public void onError(Throwable e) {
                mlistener_response._onError(e);
            }

            @Override
            public void onNext(ResponseLocation responseLocation) {
                mlistener_response._onNext(responseLocation);
            }



    });
    }


    public void salonfacilityShowApiMethod(final Activity activity, final ResponseListener _mlistener_response) {
        this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();

        RetrofitClient.getClient().salonfacilityShowApiMethod().subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseSalonFacility>() {
                    @Override
                    public void onCompleted() {
                        mProgressDialog.dismiss();
                        mlistener_response._onCompleted();

                    }
                    @Override
                    public void onError(Throwable e) {
                        mlistener_response._onError(e);
                    }

                    @Override
                    public void onNext(ResponseSalonFacility responseSalonFacilities) {
                        mlistener_response._onNext(responseSalonFacilities);

                    }
                });
    }


    public void marketinglistApiMethod(final Activity activity, final ResponseListener mlistener_response,String user_id){
        this.mlistener_response = mlistener_response;
        // this.mlistener_response = _mlistener_response;
        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();

        RetrofitClient.getClient().marketinglistApiMethod(user_id).subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseMarketinList>() {
                    @Override
                    public void onCompleted() {
                        mProgressDialog.dismiss();
                        mlistener_response._onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mlistener_response._onError(e);
                    }

                    @Override
                    public void onNext(ResponseMarketinList reponseMarketingList) {
                        mlistener_response._onNext(reponseMarketingList);
                    }
                });

    }



}