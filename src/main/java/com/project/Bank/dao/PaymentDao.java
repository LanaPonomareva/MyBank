package com.project.Bank.dao;



import com.project.Bank.model.Payment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PaymentDao {
    //create
    void create(Payment payment, Connection connection) throws SQLException;

    //read
    List<Payment> getAll(Connection connection) throws SQLException ;

    Optional<Payment> getById(Long id, Connection connection) throws SQLException ;

    //update
    void update(Payment payment, Connection connection) throws SQLException ;

    //delete
    void remove(Payment payment, Connection connection) throws SQLException ;
}
