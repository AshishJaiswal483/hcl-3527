package com.abes.springlayerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLayer {
    @Autowired
    ServiceLayer s1;

    @GetMapping("/Student")
    public String get_name(){
        return s1.getDetail();
    }
}
