package com.wu.dlsample.one_pulgin4;

import android.app.Activity;
import android.os.Bundle;

import com.ryg.dynamicload.DLBasePluginActivity;


public class MainActivity extends DLBasePluginActivity {
//public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ListenCloudUtil.newInstance(ListenCloudConfigBuilder.createBuilder()
//            .build(getApplicationContext())
//        );

        throw new IllegalAccessError();

    }
}
