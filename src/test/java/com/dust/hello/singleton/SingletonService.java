package com.dust.hello.singleton;


public class SingletonService {

    //static으로 선언시 클래스레벨에 올라가기 때문에 딱 하나만 존재하게됨
    private static final SingletonService instance = new SingletonService();

    //조회할 때 사용
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
