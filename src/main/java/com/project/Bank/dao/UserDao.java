package com.project.Bank.dao;


import com.project.Bank.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    //create
    void create(User user, Connection connection) throws SQLException;

    //read
    List<User> getAll(Connection connection) throws SQLException;

    Optional<User> getById(Long id, Connection connection) throws SQLException;

    //update
    void update(User user, Connection connection) throws SQLException;

    //delete
    void remove(User user, Connection connection) throws SQLException;
}
