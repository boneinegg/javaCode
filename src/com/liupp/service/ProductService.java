package com.liupp.service;

import org.springframework.stereotype.Component;

@Component("service")
public class ProductService {
    public void doService() {
        System.out.println("doService.");
    }
}
