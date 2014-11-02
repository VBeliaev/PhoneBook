package com.getjavajob.phonebook.webui.controllers;

public class LoginController {
    private String login;
    private String paswd;

    public LoginController(String login, String paswd) {
        this.login = login;
        this.paswd = paswd;      
    }
    
    public boolean check(){
        return (this.login).equals("root") && (this.paswd).equals("root");
    }
}