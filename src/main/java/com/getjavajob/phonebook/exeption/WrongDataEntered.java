/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.getjavajob.phonebook.exeption;

/**
 *
 * @author Виталий
 */
public class WrongDataEntered extends Throwable{

    public WrongDataEntered(String message) {
        super(message);
    }
    public WrongDataEntered(String message, Throwable reason) {
        super(message, reason);
    }
    
}
