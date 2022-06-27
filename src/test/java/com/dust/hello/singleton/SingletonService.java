package com.dust.hello.singleton;

public class SingletonService {
    // 자기자신을 클래스
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출출");
    }
}


