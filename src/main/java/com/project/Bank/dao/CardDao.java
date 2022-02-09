package com.project.Bank.dao;


import com.project.Bank.model.Card;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CardDao {
    //create
    void create(Card card, Connection connection) throws SQLException;

    //read
    List<Card> getAll(Connection connection) throws SQLException;

    Optional<Card> getById(long id, Connection connection ) throws SQLException;

    //update
    void update(Card card, Connection connection) throws SQLException;

    //delete
    void remove(Card card, Connection connection)  throws SQLException;
}
