package com.abes.springlearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//ioc
@Component
public class Activity {

    //di
    @Autowired
    student s;

    public void work() {
        s.name();
        System.out.println("Love coding");
    }
}
