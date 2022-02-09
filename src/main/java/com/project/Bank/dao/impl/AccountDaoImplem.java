package com.project.Bank.dao.impl;

import com.project.Bank.busnessLogic.ConnectionManager;
import com.project.Bank.dao.AccountDAO;
import com.project.Bank.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDaoImplem extends ConnectionManager implements AccountDAO {

    @Override
    public void create(Account account, Connection connection) throws SQLException {
        String sql =
                "insert into account (number, balance, userId, isActive)" +
                        "values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, account.getNumber());
            preparedStatement.setBigDecimal(2, account.getBalance());
            preparedStatement.setLong(3, account.getUserId());
            preparedStatement.setBoolean(4, account.isActive());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                account.setId(id);
            }
        }
    }


    @Override
    public List<Account> getAll(Connection connection) throws SQLException {
        String query = "select id, number, balance, userId, isActive " +
                "FROM account ";
        List<Account> accounts = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Account account = extractAccount(resultSet);
                accounts.add(account);

            }
        }
        return accounts;
    }

    @Override
    public Optional<Account> getById(int id, Connection connection) throws SQLException {
        String query = "select id, number, balance, userId, isActive " +
                "FROM account " +
                "WHERE id = ? ";

        Account account = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    account = extractAccount(resultSet);

                }
            }
        }

        return Optional.ofNullable(account);
    }

    public Account extractAccount(ResultSet resultSet) throws SQLException {
        Account account = new Account();

        account.setId(resultSet.getLong("id"));
        account.setNumber(resultSet.getString("number"));
        account.setBalance(resultSet.getBigDecimal("balance"));
        account.setActive(resultSet.getBoolean("isActive"));
        account.setUserId(resultSet.getLong("userId"));
        return account;
    }

    @Override
    public void update(Account account, Connection connection) throws SQLException {
        String sql = "update account " + "set " +
                "number =?" + "balance =? " + "isActive =?" + "userId =?" + "where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, account.getNumber());
            preparedStatement.setBigDecimal(2, account.getBalance());
            preparedStatement.setBoolean(3, account.isActive());
            preparedStatement.setLong(4, account.getUserId());
            preparedStatement.setLong(7, account.getId());
            preparedStatement.execute();
        }
    }

    @Override
    public void remove(Account account, Connection connection) throws SQLException {
        String query = "DELETE FROM ACCOUNT WHERE ID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, account.getId());
            preparedStatement.executeUpdate();

        }
    }
}
