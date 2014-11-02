package com.getjavajob.phonebook.exeption;

/**
 * Created by Виталий on 23.10.2014.
 */
public class DAOException extends RuntimeException {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable reason) {
        super(reason);
    }

    public DAOException(String message, Throwable reason) {
        super(message, reason);
    }

}
