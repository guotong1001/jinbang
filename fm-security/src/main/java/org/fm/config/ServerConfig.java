package org.fm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ProjectName：fm
 * @ClassName：ServerConfig
 * @TODO：server 配置
 * @Auth：Mr.Zhang @Time：2020/9/22 10:34
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@Component
public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {

    @Value("${server.host}")
    private String ip;

    private int serverPort;

    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "http://" + ip + ":";
    }

//    public String getUrl() {
//        InetAddress address = null;
//        try {
//            address = InetAddress.getLocalHost();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        return "http://" + ip + ":" + this.serverPort;
//    }

    public String getUrl2() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "http://" + ip + ":" + 8802 + "/fmServer";
    }

    public int getPort() {
        return this.serverPort;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }

}
