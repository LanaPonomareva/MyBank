package com.project.Bank;

import com.project.Bank.busnessLogic.ConnectionManager;

public class MainClass {
    public static void main(String[] args) {

        ConnectionManager cm = new ConnectionManager();
        cm.getConnection();


    }
        /*Class<Driver> driverClass = Driver.class;
        try (var connection = ConnectionManager.getConnection()) {
            System.out.println(connection.getTransactionIsolation());
        }
    }*/

}