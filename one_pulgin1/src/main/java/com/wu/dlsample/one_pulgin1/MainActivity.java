package com.wu.dlsample.one_pulgin1;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;

import com.ryg.dynamicload.DLBasePluginActivity;

public class MainActivity extends DLBasePluginActivity{

    private static final String TAG = "Client-MainActivity";
    private ServiceConnection mConnecton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
    }

    private void initView(Bundle savedInstanceState) {

        that.setContentView(R.layout.activity_main);
         findViewById (R.id.button).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 that.finish();
             }
         });

//        that.setContentView(generateContentView(that));
    }
//
//    private View generateContentView(final Context context) {
//        LinearLayout layout = new LinearLayout(context);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        layout.setBackgroundColor(Color.parseColor("#F79AB5"));
//        Button button = new Button(context);
//        button.setText("Start TestActivity");
//        layout.addView(button, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                DLIntent intent = new DLIntent(getPackageName(), TestFragmentActivity.class);
////                // 传递Parcelable类型的数据
////                intent.putExtra("person", new Person("plugin-a", 22));
////                intent.putExtra("dl_extra", "from DL framework");
////                startPluginActivityForResult(intent, 0);
//            }
//        });
//
//        Button button2 = new Button(context);
//        button2.setText("Start Service");
//        layout.addView(button2, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        button2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
////                DLIntent intent = new DLIntent(getPackageName(), TestService.class);
////                startPluginService(intent);
//            }
//        });
//
//
//        Button button3 = new Button(context);
//        button3.setText("bind Service");
//        layout.addView(button3, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mConnecton == null) {
//                    mConnecton = new ServiceConnection() {
//                        public void onServiceDisconnected(ComponentName name) {
//                        }
//                        public void onServiceConnected(ComponentName name, IBinder binder) {
//                            int sum = ((ITestServiceInterface)binder).sum(5, 5);
//                            Log.e("MainActivity", "onServiceConnected sum(5 + 5) = " + sum);
//                        }
//                    };
//                }
////                DLIntent intent = new DLIntent(getPackageName(), TestService.class);
////                bindPluginService(intent, mConnecton, Context.BIND_AUTO_CREATE);
//            }
//        });
//
//        Button button4 = new Button(context);
//        button4.setText("unbind Service");
//        layout.addView(button4, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        button4.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (mConnecton != null) {
////                    DLIntent intent = new DLIntent(getPackageName(), TestService.class);
////                    unBindPluginService(intent, mConnecton);
////                    mConnecton = null;
//                }
//            }
//        });
//        return layout;
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Log.d(TAG, "onActivityResult resultCode=" + resultCode);
//        if (resultCode == RESULT_FIRST_USER) {
//            that.finish();
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    public static class Person implements Parcelable {
//
//        private String mName;
//        private int mAge;
//
//        public Person(String name, int age) {
//            mName = name;
//            mAge = age;
//        }
//
//        @Override
//        public int describeContents() {
//            // TODO Auto-generated method stub
//            return 0;
//        }
//
//        @Override
//        public void writeToParcel(Parcel dest, int flags) {
//            // TODO Auto-generated method stub
//            dest.writeString(mName);
//            dest.writeInt(mAge);
//        }
//
//        public Person(Parcel in) {
//            mName = in.readString();
//            mAge = in.readInt();
//        }
//
//        public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
//            public Person createFromParcel(Parcel in) {
//                return new Person(in);
//            }
//
//            public Person[] newArray(int size) {
//                return new Person[size];
//            }
//        };
//
//        @Override
//        public String toString() {
//            // TODO Auto-generated method stub
//            return "name = " + mName + " age = " + mAge;
//        }
//
//    }
}
