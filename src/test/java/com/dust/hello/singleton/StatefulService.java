package com.dust.hello.singleton;

//싱글톤 방식의 문제점 -> 수정
public class StatefulService {

//    private int price; //상태를 유지하는 필드 10000 -> 20000

    public int order(String name, int price) {
//    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
