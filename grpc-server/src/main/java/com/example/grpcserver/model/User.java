package com.example.grpcserver.model;

public class User {
    private String name;
    private int age;
    private long aadhaar;
    private double salary;
    private boolean isDev;
    private String address;

    public User(String name, int age, long aadhaar, double salary, boolean isDev, String address) {
        this.name = name;
        this.age = age;
        this.aadhaar = aadhaar;
        this.salary = salary;
        this.isDev = isDev;
        this.address = address;
    }
}
