package wuimmortalhalf.listencloud_lib;


import android.content.Context;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * <p>Class : ListenCloudConfigBuilder
 * <p>Author : ImmortalHalfWu
 * <p>Time : 2017/4/6 14:11
 * <p>Todo : 听云配置信息构造器，通过{@link #createBuilder()}方法获取，之后链式添加配置，最后通过{@link #build(Context, String)}方法生成{@link ListenCloudConfig}
 * <p>
*/
public class ListenCloudConfigBuilder {

    private ListenCloudConfig mListenCloudConfig;

    private ListenCloudConfigBuilder() {

        this.mListenCloudConfig = new ListenCloudConfig();
    }

    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/6 14:13
     * <p>Todo : 生成{@link ListenCloudConfigBuilder}实例
     * <p>
    */
    public static ListenCloudConfigBuilder createBuilder(){
        return new ListenCloudConfigBuilder();
    }

    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/6 14:14
     * <p>Todo : 设置用户唯一标示
     * @param userId 不可为空
    */
    public ListenCloudConfigBuilder setUserId(@NonNull String userId){
        mListenCloudConfig.setUserID(userId);
        return this;
    }

    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/6 14:14
     * <p>Todo : 设置开启Crash日志采集
     * <p>
    */
    public ListenCloudConfigBuilder setEnableCrashReport( boolean enableCrashReport){
        mListenCloudConfig.setEnableCrashReport(enableCrashReport);
        return this;
    }

    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/6 14:15
     * <p>Todo : 设置地理信息采集
     * <p>
    */
    public ListenCloudConfigBuilder setEnableServiceLocation( boolean enableServiceLocation){
        mListenCloudConfig.setEnableServiceLocation(enableServiceLocation);
        return this;
    }

    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/6 14:15
     * <p>Todo : 设置Log日志采集
     * <p>
    */
    public ListenCloudConfigBuilder setEnableLog( boolean enableLog){
        mListenCloudConfig.setEnableLog(enableLog);
        return this;
    }
    
    
    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/6 14:24
     * <p>Todo : 生成{@link ListenCloudConfig}，默认项目AppKey，在根目录tingyun.properties文件夹中，适用于release版本
     * <p>
    */
    public ListenCloudConfig build(@NonNull Context appContext) {
        return build(appContext,"20282ec81db9419581a9bf4f172a824b");
    }

    /**
     * <p>Author : ImmortalHalfWu
     * <p>Time : 2017/4/6 14:15
     * <p>Todo : 生成{@link ListenCloudConfig}，外部传入AppKey，适用于Debug版本
     * @param appContext Application Context ,不可为空
     * @param licenseKey AppKey , 不可为空
     * @return {@link ListenCloudConfig} 实例
    */
    public ListenCloudConfig build(@NonNull Context appContext,@NonNull String licenseKey){
        mListenCloudConfig.setAppContext(appContext);
        mListenCloudConfig.setLicenseKey(licenseKey);
        return mListenCloudConfig;
    }

}
