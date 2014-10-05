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
public class DataNotFound extends Throwable{

    public DataNotFound(String message) {
        super(message);
    }
    public DataNotFound(String message, Throwable reason) {
        super(message, reason);
    }
    
}
