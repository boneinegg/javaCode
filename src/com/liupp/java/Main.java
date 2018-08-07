package com.liupp.java;

import java.util.*;
import java.time.LocalDate;
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("args = " + Arrays.toString(args));
        Object o = new Object();
        System.out.println(o.hashCode());
        java.time.LocalDate t = java.time.LocalDate.now();
        LocalDate ts = LocalDate.now();
    }
}
