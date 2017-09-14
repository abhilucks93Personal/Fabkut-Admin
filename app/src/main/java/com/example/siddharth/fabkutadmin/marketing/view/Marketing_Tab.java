package com.example.siddharth.fabkutadmin.marketing.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.siddharth.fabkutadmin.R;
import com.example.siddharth.fabkutadmin.marketing.Controller.AccountingPagerAdapter;
import com.example.siddharth.fabkutadmin.marketing.Modal.SalonData;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.R.attr.bitmap;
import static com.example.siddharth.fabkutadmin.R.color.colorAccent;
import static com.example.siddharth.fabkutadmin.R.color.colorBlue;
import static com.example.siddharth.fabkutadmin.R.color.colorPrimary;
import static com.example.siddharth.fabkutadmin.R.color.colorWhite;


/**
 * Created by abhi on 16/06/17.
 */

public class Marketing_Tab extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "hello";
    View actionBarView;
    TextView tvTitle,camera,gallery;
    ImageView iconLeft, ivProfilePic;
    RelativeLayout tabBar1;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    SalonData data;
    private AccountingPagerAdapter adapter;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    private String userChoosenTask;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab);

        setActionBarView();
        findViewById();
        initData();

        preferences = getSharedPreferences("CreateLogin",MODE_PRIVATE);
        String user_id = preferences.getString("UserId",null);
        String user_name = preferences.getString("UserName",null);
        tvTitle.setText(user_name);
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


    private void findViewById() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabBar1 = (RelativeLayout) actionBarView.findViewById(R.id.tabBar);
        tabBar1.setBackgroundColor(getResources().getColor(R.color.colorBlue2));
        viewPager =(ViewPager) findViewById(R.id.pager);
        tvTitle = (TextView) actionBarView.findViewById(R.id.actionbar_view_title);
        iconLeft = (ImageView) actionBarView.findViewById(R.id.actionbar_view_icon_left);
        iconLeft.setImageDrawable(getResources().getDrawable(R.drawable.rectangle4));
        iconLeft.setVisibility(View.VISIBLE);
        iconLeft.setOnClickListener(this);

        ivProfilePic = (ImageView) findViewById(R.id.activity_tab_profilePic);

    }



    private void initData() {
        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("CREATE SALON"));
        tabLayout.addTab(tabLayout.newTab().setText("SALON FACILITY"));
        tabLayout.addTab(tabLayout.newTab().setText("SALON EMPLOYEE"));
        tabLayout.addTab(tabLayout.newTab().setText("PORTFOLIO"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Creating our pager adapter
        adapter = new AccountingPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

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

//    public void chooseProfilePic(View view){
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialog_portfolio);
//        dialog.setTitle("Choose profile picture");
//        camera = (TextView) dialog.findViewById(R.id.tv_camera);
//        gallery= (TextView) dialog.findViewById(R.id.tv_gallery);
//        gallery.setText("camera");
//        camera.setText("gallery");
//        dialog.show();
//    }


// ------------------------code for profile pic selection--------------------------

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Utility.MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(userChoosenTask.equals("Take Photo"))
                        cameraIntent();
                    else if(userChoosenTask.equals("Choose from Library"))
                        galleryIntent();
                } else {
                    //code for deny
                }
                break;
        }
    }

    public void chooseProfilePic(View view) // replcae method name with chooseProfilePic
     {
        final CharSequence[] items = { "Camera", "Gallery"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Profile Picture");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result=Utility.checkPermission(Marketing_Tab.this);

                if (items[item].equals("Camera")) {
                    userChoosenTask="Camera";
                    if(result)
                        cameraIntent();

                } else if (items[item].equals("Gallery")) {
                    userChoosenTask="Gallery";
                    if(result)
                        galleryIntent();

                }
            }
        });
        builder.show();
    }


    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }


    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }


    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ivProfilePic.setImageBitmap(bm);

    }


    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ivProfilePic.setImageBitmap(thumbnail);
        String img=getStringImage(thumbnail);
        Log.v(TAG,"base64"+img);
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        byte[] imageBytes = baos.toByteArray();

        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);


       /*// if (requestCode == 1 && resultCode == RESULT_OK) {
            final Uri imageUri = data.getData();
			final InputStream imageStream = getContentResolver().openInputStream(imageUri);
			final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                String encodedImage = encodeImage(selectedImage);
        */ }

    }


    private String encodeImage(Bitmap bm)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encImage;
    }


   /* private String encodeImage(String path)
    {
        File imagefile = new File(path);
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(imagefile);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        Bitmap bm = BitmapFactory.decodeStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encImage;
    }*/

}
