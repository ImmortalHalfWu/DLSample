package wuimmortalhalf.listencloud_lib;


import android.support.annotation.NonNull;

import com.networkbench.agent.impl.NBSAppAgent;

/**
 * <p>Class : ListenCloudUtil
 * <p>Author : ImmortalHalfWu
 * <p>Time : 2017/4/6 14:02
 * <p>Todo : 听云帮助类，在MainActivity.onCreate()方法中通过{@link #newInstance(ListenCloudConfig)}方法初始化
*/
public class ListenCloudUtil {

    private static ListenCloudUtil listenCloudUtil;

    private ListenCloudUtil(@NonNull ListenCloudConfig config) {
        if (config.getAppContext() == null || config.getLicenseKey() == null || config.getLicenseKey().trim().equals("")){
            throw new NullPointerException("ListenCloud need appContext and licenseKey,but you don't set..");
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

}
