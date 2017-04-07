package wuimmortalhalf.listencloud_lib;


import android.support.annotation.NonNull;
import android.util.Log;

import com.networkbench.agent.impl.NBSAppAgent;

/**
 * <p>Class : ListenCloudUtil
 * <p>Author : ImmortalHalfWu
 * <p>Time : 2017/4/6 14:02
 * <p>Todo : 听云帮助类，在MainActivity.onCreate()方法中通过{@link #newInstance(ListenCloudConfig)}方法初始化
*/
public class ListenCloudUtil {

    private static final String TAG = "ListenCloudUtil";
    private static ListenCloudUtil listenCloudUtil;

    private ListenCloudUtil(@NonNull ListenCloudConfig config) {
        if (config.getAppContext() == null || config.getLicenseKey() == null || config.getLicenseKey().trim().equals("")){
            throw new NullPointerException("ListenCloud need appContext and licenseKey,but you don't set..");
        }

        if(listenCloudUtil != null){
            Log.e(TAG, "don't repeat create instances" );
            return;
        }

        //appKey
        NBSAppAgent.setLicenseKey(config.getLicenseKey())
                //登录用户ID
                .setUserIdentifier(config.getUserID())
                //Crash日志
                .withCrashReportEnabled(config.isEnableCrashReport())
                //位置信息
                .withLocationServiceEnabled(config.isEnableServiceLocation())
                //log日志
                .enableLogging(config.isEnableLog())
                //开启
                .start(config.getAppContext());

    }

    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/6 13:41
     * <p>Todo : 初始化Lib，在MainActivity.onCreate()方法中调用
     * @param config 配置器，通过{@link ListenCloudConfigBuilder}获取
    */
    public static ListenCloudUtil newInstance(@NonNull ListenCloudConfig config){
        return listenCloudUtil == null ? listenCloudUtil = new ListenCloudUtil(config) : listenCloudUtil;
    }

    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/6 13:42
     * <p>Todo : 获取Util实例，必须先通过 {@link #newInstance(ListenCloudConfig)} 初始化
     * @return util实例
     * @throws NullPointerException，未调用{@link #newInstance(ListenCloudConfig)}初始化
    */
    public static ListenCloudUtil getInstance(){
        if (listenCloudUtil == null){
            throw new NullPointerException("can't get ListenCloudUtil instance , use ListenCloudUtil.newInstance(ListenCloudConfig config) in you MainActivity?");
        }
        return listenCloudUtil;
    }

    
    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/7 15:42
     * <p>Todo : 填充log数据
     * <p>
    */
    public static ListenCloudUtil leaveBreadcrumb(@NonNull String log){
        if (isInstance()) NBSAppAgent.leaveBreadcrumb(log);
        return listenCloudUtil;
    }

    public static ListenCloudUtil onEvent(@NonNull String eventInfo){
        if (isInstance()) NBSAppAgent.onEvent(eventInfo);
        return listenCloudUtil;
    }

    public static ListenCloudUtil beginTracer(@NonNull String beginTracer){
        if (isInstance()) NBSAppAgent.beginTracer(beginTracer);
        return listenCloudUtil;
    }

    public static ListenCloudUtil endTracer(@NonNull String endTracer){
        if (isInstance()) NBSAppAgent.endTracer(endTracer);
        return listenCloudUtil;
    }

    public static ListenCloudUtil setUserCrashMessage(@NonNull String key,@NonNull String value){
        if (isInstance()) NBSAppAgent.setUserCrashMessage(key, value);
        return listenCloudUtil;
    }

    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/7 15:41
     * <p>Todo : 是否已经初始化
     * <p>
    */
    private static boolean isInstance(){
        return listenCloudUtil != null;
    }

}
