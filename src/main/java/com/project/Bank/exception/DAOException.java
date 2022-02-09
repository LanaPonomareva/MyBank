package com.project.Bank.exception;

public class DAOException extends Exception{
    public DAOException () {
        super("Something went wrong");
    }

    public DAOException (String message) {
        super(message);

        }
    }

