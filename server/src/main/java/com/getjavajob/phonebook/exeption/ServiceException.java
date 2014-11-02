package com.getjavajob.phonebook.exeption;

/**
 * Created by Виталий on 23.10.2014.
 */
public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable reason) {
        super(reason);
    }

    public ServiceException(String message, Throwable reason) {
        super(message, reason);
    }

}
