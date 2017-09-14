package com.example.siddharth.fabkutadmin.Inventory.Controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.example.siddharth.fabkutadmin.Inventory.View.FragmentSample;
import com.example.siddharth.fabkutadmin.Inventory.View.ServiceCosting;
import com.example.siddharth.fabkutadmin.marketing.view.SalonFacility;

/**
 * Created by Udit on 17-Jul-17 at 6:30 PM.
 */

public class InventoryPagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;
    private final SparseArray<Fragment> registeredFragments = new SparseArray<>();
    Fragment frag;

    public InventoryPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentSample();
            /*case 1:
                return new ServiceCosting();
            */
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Title 1";
            case 1:
                return "Title 2";
            default:
                return null;
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment)super.instantiateItem(container, position);
        registeredFragments.put(position,fragment);
        return fragment;
    }

    public Fragment getRegisteredFragment(int position){
        return registeredFragments.get(position);
    }

    public SparseArray<Fragment> getRegisteredFragments(){
        return registeredFragments;
    }
}