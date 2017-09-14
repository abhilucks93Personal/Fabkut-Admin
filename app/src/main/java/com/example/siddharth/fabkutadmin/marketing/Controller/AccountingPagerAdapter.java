package com.example.siddharth.fabkutadmin.marketing.Controller;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.example.siddharth.fabkutadmin.marketing.view.Create_Salon;
import com.example.siddharth.fabkutadmin.marketing.view.PortFolio;
import com.example.siddharth.fabkutadmin.marketing.view.SalonEmployee;
import com.example.siddharth.fabkutadmin.marketing.view.SalonFacility;

/**
 * Created by Pawan on 3/9/2017.
 */

public class AccountingPagerAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;
    private final SparseArray<Fragment> registeredFragments = new SparseArray<>();

    Fragment frag;


    //Constructor to the class
    public AccountingPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;


    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs

        switch (position) {
            case 0:
                return new Create_Salon();
            case 1:
                return new SalonFacility();
            case 2:
                return new SalonEmployee();
            case 3:
                return new PortFolio();
            default:
                return null;
        }
    }

    //Overridden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
               return "CREATE SALON";
            case 1:
                return "SALON FACILITY";
            case 2:
                return "SALON EMPLOYEE";
            case 3:
                return "PORTFOLIO";
            default:
                return null;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    public SparseArray<Fragment> getRegisteredFragments() {
        return registeredFragments;
    }
}