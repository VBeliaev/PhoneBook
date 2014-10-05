package com.getjavajob.phonebook.webui;

public class Login {
    private String login;
    private String paswd;

    public Login(String login, String paswd) {
        this.login = login;
        this.paswd = paswd;      
    }
    
    public boolean check(){
        return (this.login).equals("root") && (this.paswd).equals("root");
    }
}