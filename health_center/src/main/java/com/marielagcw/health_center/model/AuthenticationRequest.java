package com.marielagcw.health_center.model;

public class AuthenticationRequest {

    // ATTRIBUTES
    private String username;
    private String password;

    // CONSTRUCTORS
    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // GETTERS AND SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}//Cierre
