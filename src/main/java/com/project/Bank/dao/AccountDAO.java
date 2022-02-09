package com.project.Bank.dao;

import com.project.Bank.model.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface AccountDAO {

    //create
    void create(Account account, Connection connection) throws SQLException;

    //read
    List<Account> getAll(Connection connection) throws SQLException;

    Optional<Account> getById(int id, Connection connection) throws SQLException;

    //update
    void update(Account account, Connection connection) throws SQLException;

    //delete
    void remove(Account account, Connection connection) throws SQLException;
}
