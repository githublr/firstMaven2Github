package com.diamondlr;

/**
 * Created by zack.lr on 2017/7/30.
 */
import java.io.IOException;

import com.taobao.diamond.client.Diamond;
import com.taobao.diamond.manager.ManagerListenerAdapter;

/**
 * 配置中心，管理所有动态配置;基本用法
 *
 * @author ConfigCenter
 *
 */
public class ConfigCenter {
    // 属性/开关
    private static String config = "";

    private static void initConfig() {
        // 启动只用一次场景，直接get获取配置值
        try {
            String configInfo = Diamond.getConfig("yanlin", "yanlin", 1000);
            System.out.println("dataId+group:" + configInfo);
        } catch (IOException e1) {

        }

        // 启动用，并且变化需要立即推送最新值
        Diamond.addListener("yanlin", "yanlin",
                new ManagerListenerAdapter() {
                    public void receiveConfigInfo(String configInfo) {
                        try {
                            config = configInfo;
                            System.out.println(configInfo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public static void main(String[] args) throws IOException {
        // 如果使用spring，此类等同于init方法
        initConfig();
        // 测试让主线程不退出，因为订阅配置是守护线程，主线程退出守护线程就会退出，实际代码中不需要。
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    // 通过get接口把配置值暴露出去使用
    public static String getConfig() {
        return config;
    }
}