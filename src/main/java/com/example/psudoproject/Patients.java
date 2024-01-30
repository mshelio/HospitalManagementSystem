package com.example.psudoproject;

public class Patients extends People{
    private String diagnosis;
    public Patients(int id, String firstname, String lastname, String category, String phoneNumber, String email, String diagnosis) {
        super(id, firstname, lastname, category, phoneNumber, email);
        this.diagnosis = diagnosis;
    }

    public Patients() {

    }

    public Patients(int id, String firstName, String lastName, String phoneNumber, String email, String diagnosis) {
        super(id, firstName, lastName, phoneNumber, email);
    }


    public String getDiagnosis(){
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }


}
