package com.wu.dlsample.one_pulgin4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ryg.dynamicload.DLBasePluginActivity;
import java.util.ArrayList;
import java.util.List;


public class Main2Activity extends DLBasePluginActivity {

    public  static final List<Bitmap> bitMaps = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        initView();
//        ListenCloudConfigBuilder.createBuilder()
//                .build(getApplicationContext(),"");
    }

    private void initView() {

         findViewById (R.id.button).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                throw new NullPointerException("Null test");
             }
         });

         findViewById (R.id.button2).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 ImageView imageView = (ImageView) findViewById(R.id.imageView);

                 for (int i = 0; i < 1000; i++) {
                     bitMaps.add(BitmapFactory.decodeResource(getResources(),R.mipmap.timg));
                 }
                 Toast.makeText(Main2Activity.this,bitMaps.size() + "",Toast.LENGTH_LONG).show();
             }
         });

         findViewById (R.id.button3).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
             }
         });

    }
}
