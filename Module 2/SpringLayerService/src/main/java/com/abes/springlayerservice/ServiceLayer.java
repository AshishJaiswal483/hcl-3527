package com.abes.springlayerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {
  private String interest;

  @Autowired
    RepositoryLayer r1;
  public String getDetail(){
      System.out.println("Name:"+r1.getName());
      return r1.getName();
  }
}
