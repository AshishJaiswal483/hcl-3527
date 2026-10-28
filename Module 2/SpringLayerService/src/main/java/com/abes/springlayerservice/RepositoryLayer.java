package com.abes.springlayerservice;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryLayer {
    private String Name="Ashish Jaiswal";

    public String getName(){
        return Name;
    }
}
