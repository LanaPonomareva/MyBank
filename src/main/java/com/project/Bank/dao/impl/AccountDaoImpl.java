package com.project.Bank.dao.impl;

import com.project.Bank.busnessLogic.ConnectionManager;
import com.project.Bank.exception.DAOException;
import com.project.Bank.model.Account;
import com.project.Bank.dao.AccountDAO;
import org.slf4j.LoggerFactory;
/*
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class AccountDaoImpl extends ConnectionManager implements AccountDAO {
    Connection connection = getConnection();
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AccountDaoImpl.class);
    private static final String ID = "id";
    private static final String NUMBER = "number";
    private static final String BALANCE = "balance";
    private static final String IS_ACTIVE = "isActive";
    private static final String USER_ID = "user_id";
    @Override
    public void add(Account account) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ACCOUNT (ID, NUMBER, BALANCE, IS_ACTIVE, USER_ID) VALUES(?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, account.getId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setObject(3, account.getBalance());
            preparedStatement.setLong(4, account.getUserId());
            preparedStatement.setBoolean(5, account.isActive());

            preparedStatement.executeUpdate();
               throw new DAOException();
        } catch (DAOException e) {
            System.out.println(e.getMessage();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

    }

    @Override
    public List<Account> getAll() throws SQLException {
        List<Account> accountsList = new ArrayList<>();
        String sql = "SELECT ID, NUMBER, BALANCE, IS_ACTIVE, USER_ID FROM ACCOUNT ";
        Statement statement = null;
        try {
            statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Account account = new Account();
                account.setId(resultSet.getLong("COLUMN_ID"));
                account.setNumber(resultSet.getString("COLUMN_NUMBER"));
                account.setBalance(resultSet.getBigDecimal("COLUMN_BALANCE"));
                account.setActive(resultSet.getBoolean("COLUMN_IS_ACTIVE"));
                account.setUserId(resultSet.getLong("COLUMN_USER_ID"));

                accountsList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return accountsList;
    }

    @Override
    public Optional<Account> getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT ID, NUMBER, BALANCE, IS_ACTIVE, USER_ID FROM ACCOUNT WHERE ID = ? ";
        Account account = new Account();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            account.setId(resultSet.getLong("ID"));
            account.setNumber(resultSet.getString("NUMBER"));
            account.setBalance(resultSet.getBigDecimal("BALANCE"));
            account.setActive(resultSet.getBoolean("IS_ACTIVE"));
            account.setUserId(resultSet.getLong("USER_ID"));

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection !=  null){
                connection.close();
            }
        }
        return Optional.ofNullable(account);
    }

    @Override
    public void update(Account account) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ACCOUNT SET ID, NUMBER, BALANCE, IS_ACTIVE, USER_ID WHERE ID =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, account.getId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setObject(3, account.getBalance());
            preparedStatement.setBoolean(4, account.isActive());
            preparedStatement.setLong(5, account.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }if (connection != null){
                connection.close();
            }
        }

    }

    @Override
    public void remove(Account account) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ACCOUNT WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }


    }
}
*/