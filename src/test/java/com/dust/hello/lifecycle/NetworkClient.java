package com.dust.hello.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient(){
        System.out.println("생명자 호출, url = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("connect = " + url);
    }

    public void call(String message){
        System.out.println("call : " + url +  " message = " + message);
    }

    public void disconnect(){
        System.out.println("close : " + url);
    }

    //의존 관계 주입이 끝나면 호출하는 것!
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    //종료될 때 콜 백해주는 것!
    public void close(){
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
