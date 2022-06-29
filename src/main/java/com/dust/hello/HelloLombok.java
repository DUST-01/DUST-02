package com.dust.hello;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(413);
        int age1 = helloLombok.getAge();

        System.out.println("age1 = " + age1);
        System.out.println("helloLombok = " + helloLombok);
    }
}
