package com.example.psudoproject;

public class Users extends People{
    private String username;
    private String password;
    public Users(int id, String firstname, String lastname, String category, String phoneNumber, String username, String password) {
        super(id, firstname, lastname, category, phoneNumber);
        this.username = username;
        this.password = password;
    }

    public Users() {
        super();
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
