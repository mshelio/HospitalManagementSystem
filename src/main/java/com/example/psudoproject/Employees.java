package com.example.psudoproject;


public class Employees extends People{
    private String gender;

    public Employees(){
        super();
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return this.gender;
    }
}
