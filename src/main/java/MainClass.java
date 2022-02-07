import busnessLogic.ConnectionManager;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

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