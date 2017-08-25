package com.diamondlr;

/**
 * Created by zack.lr on 2017/7/30.
 */
import java.io.IOException;

import com.taobao.diamond.client.Diamond;
import com.taobao.diamond.manager.ManagerListenerAdapter;

/**
 * �������ģ��������ж�̬����;�����÷�
 *
 * @author ConfigCenter
 *
 */
public class ConfigCenter {
    // ����/����
    private static String config = "";

    private static void initConfig() {
        // ����ֻ��һ�γ�����ֱ��get��ȡ����ֵ
        try {
            String configInfo = Diamond.getConfig("yanlin", "yanlin", 1000);
            System.out.println("dataId+group:" + configInfo);
        } catch (IOException e1) {

        }

        // �����ã����ұ仯��Ҫ������������ֵ
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
        // ���ʹ��spring�������ͬ��init����
        initConfig();
        // ���������̲߳��˳�����Ϊ�����������ػ��̣߳����߳��˳��ػ��߳̾ͻ��˳���ʵ�ʴ����в���Ҫ��
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    // ͨ��get�ӿڰ�����ֵ��¶��ȥʹ��
    public static String getConfig() {
        return config;
    }
}