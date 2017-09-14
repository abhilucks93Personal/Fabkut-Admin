package com.example.siddharth.fabkutadmin.Inventory.View;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.siddharth.fabkutadmin.Inventory.Controller.InventoryPagerAdapter;
import com.example.siddharth.fabkutadmin.R;

/**
 * Created by Udit on 17-Jul-17 at 5:56 PM.
 */

public class InventoryTab extends AppCompatActivity implements View.OnClickListener {

    View actionBarView;
    private TabLayout tabLayout;
    ImageView iconLeft, ivProfilePic;
    RelativeLayout tabBar1;
    private ViewPager viewPager;
    TextView tvTitle;
    private InventoryPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        setActionBarView();
        findViewById();
        initData();
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.actionbar_view_icon_left:
                finish();
                break;
        }

    }

    private void setActionBarView() {

        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        View customView = getLayoutInflater().inflate(R.layout.actionbar_view_custom, null);
        getSupportActionBar().setCustomView(customView);
        Toolbar parent =(Toolbar) customView.getParent();
        parent.setPadding(0,0,0,0);//for tab otherwise give space in tab
        parent.setContentInsetsAbsolute(0,0);

        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar_view_custom);*/
        actionBarView = getSupportActionBar().getCustomView();
    }



    public void findViewById() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabBar1 = (RelativeLayout) actionBarView.findViewById(R.id.tabBar);
        tabBar1.setBackgroundColor(getResources().getColor(R.color.colorBlue2));
        viewPager =(ViewPager) findViewById(R.id.pager);
        tvTitle = (TextView) actionBarView.findViewById(R.id.actionbar_view_title);
        iconLeft = (ImageView) actionBarView.findViewById(R.id.actionbar_view_icon_left);
        iconLeft.setImageDrawable(getResources().getDrawable(R.drawable.rectangle4));
        iconLeft.setVisibility(View.VISIBLE);
        iconLeft.setOnClickListener(this);
    }


    private void initData() {
        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Service Costing"));
        tabLayout.addTab(tabLayout.newTab().setText("Fragment sample"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        adapter = new InventoryPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);

    }

}
