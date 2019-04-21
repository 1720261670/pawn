package com.test;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Test {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456","admin",1024);
        String pass=md5Hash.toString();
        System.out.println(pass);

    }
}
