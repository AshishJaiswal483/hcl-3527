package com.abes.springlearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringLearningApplication {

    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(SpringLearningApplication.class, args);
        System.out.println("Hello World");

        student obj=context.getBean(student.class);
        obj.name();

        student obj1=context.getBean(student.class);
        obj1.name();

        Activity a1=context.getBean(Activity.class);
        a1.work();


    }


}
