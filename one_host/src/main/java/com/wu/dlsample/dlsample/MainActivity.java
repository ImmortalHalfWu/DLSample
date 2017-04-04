package com.wu.dlsample.dlsample;

import android.content.pm.PackageInfo;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ryg.dynamicload.internal.DLIntent;
import com.ryg.dynamicload.internal.DLPluginManager;
import com.ryg.utils.DLUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private final List<ItemHold> sources = new ArrayList<>();
    private Adapter adapter;
    private File[] apkFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSources();
        initView();

    }

    private void initSources() {

        String filePath = Environment.getExternalStorageDirectory() + "/DLsample";
        File apkFile = new File(filePath);
        if (apkFile.exists()){
            apkFiles = apkFile.listFiles();
            showToast("apk 数量为" + apkFiles.length);
            for (File fi : apkFiles) {
                ItemHold hold = new ItemHold();
                hold.packageInfo = DLUtils.getPackageInfo(this,fi.getAbsolutePath());
                Log.i(TAG, "onClick: "+fi.getAbsolutePath());
                DLPluginManager.getInstance(MainActivity.this).loadApk(fi.getAbsolutePath());
                sources.add(hold);
            }
        }else {
            showToast(apkFile.mkdir()+"");
            showToast("未找到插件");
        }

    }

    private void initView() {

        adapter = new Adapter();
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DLPluginManager dlPluginManager = DLPluginManager.getInstance(view.getContext());
                dlPluginManager.startPluginActivity(view.getContext(),new DLIntent(sources.get(position).packageInfo.packageName,sources.get(position).packageInfo.activities[0].name));
            }
        });
        adapter.notifyDataSetChanged();

//        findViewById (R.id.button).setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 PackageInfo info = DLUtils.getPackageInfo(MainActivity.this,apkFiles[0].getAbsolutePath());
//                 if (info.activities == null || info.activities.length == 0) return;
//                 DLPluginManager dlPluginManager = DLPluginManager.getInstance(MainActivity.this);
//                 Log.i(TAG, "onClick: " + info.packageName + "__" + info.activities[0].name);
//                 dlPluginManager.startPluginActivity(MainActivity.this,new DLIntent(info.packageName,info.activities[0].name));
//             }
//         });
//
//         findViewById (R.id.button2).setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 PackageInfo info = DLUtils.getPackageInfo(v.getContext(),apkFiles[1].getAbsolutePath());
//                 if (info.activities == null || info.activities.length == 0) return;
//                 DLPluginManager dlPluginManager = DLPluginManager.getInstance(MainActivity.this);
//                 dlPluginManager.startPluginActivity(MainActivity.this,new DLIntent(info.packageName,info.activities[0].name));
//             }
//         });
//
//        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String filePath = Environment.getExternalStorageDirectory() + "/DLsample";
//                File apkFile = new File(filePath);
//                if (apkFile.exists()){
//                    apkFiles = apkFile.listFiles();
//                    showToast("apk 数量为" + apkFiles.length);
//                    for (File fi :
//                            apkFiles) {
//                        Log.i(TAG, "onClick: "+fi.getAbsolutePath());
////                        PackageInfo info = DLUtils.getPackageInfo(MainActivity.this,fi.getAbsolutePath());
//                        DLPluginManager.getInstance(MainActivity.this).loadApk(fi.getAbsolutePath());
////                        if (info != null && info.activities != null && info.activities.length > 0){
////
////                        }
//                    }
//                }else {
//                    showToast(apkFile.mkdir()+"");
//                    showToast("未找到插件");
//                }
//            }
//        });
    }


    private final class Adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return sources.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (convertView == null){
                textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_expandable_list_item_1,parent,false);
            }else {
                textView = (TextView) convertView;
            }
            textView.setText(sources.get(position).packageInfo.packageName);
            return textView;
        }

    }

    private final class ItemHold{
        private PackageInfo packageInfo;
    }


    private void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
}
