package wuimmortalhalf.listencloud_lib;

import android.content.Context;

/**
 * <p>Class : ListenCloudConfig
 * <p>Author : ImmortalHalfWu
 * <p>Time : 2017/4/6 14:04
 * <p>Todo : 听云配置器，包私有，通过{@link ListenCloudConfigBuilder}获取。
 * <p>配置信息有：
 * <P> * 1,Application Context，必须</P>
 * <P> * 2,AppKey，必须</P>
 * <P>3,userID,用户ID，默认""</P>
 * <P>4,enableServiceLocation,开启地址采集,默认开启</P>
 * <P>5,enableCrashReport,Crash日志采集，默认开启</P>
 * <P>6,enableLog,Log日志采集，默认开启</P>
*/
class ListenCloudConfig {

    private Context appContext;
    private String licenseKey;
    private String userID = "";
    private boolean enableCrashReport = true;
    private boolean enableServiceLocation = true;
    private boolean enableLog = true;

    Context getAppContext() {
        return appContext;
    }

    void setAppContext(Context appContext) {
        this.appContext = appContext;
    }

     String getLicenseKey() {
        return licenseKey;
    }

     void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

     String getUserID() {
        return userID;
    }

     void setUserID(String userID) {
        this.userID = userID;
    }

     boolean isEnableCrashReport() {
        return enableCrashReport;
    }

     void setEnableCrashReport(boolean enableCrashReport) {
        this.enableCrashReport = enableCrashReport;
    }

     boolean isEnableServiceLocation() {
        return enableServiceLocation;
    }

     void setEnableServiceLocation(boolean enableServiceLocation) {
        this.enableServiceLocation = enableServiceLocation;
    }

     boolean isEnableLog() {
        return enableLog;
    }

     void setEnableLog(boolean enableLog) {
        this.enableLog = enableLog;
    }


    @Override
    public String toString() {
        return "ListenCloudConfig{" +
                "appContext=" + appContext +
                ", licenseKey='" + licenseKey + '\'' +
                ", userID='" + userID + '\'' +
                ", enableCrashReport=" + enableCrashReport +
                ", enableServiceLocation=" + enableServiceLocation +
                ", enableLog=" + enableLog +
                '}';
    }
}
